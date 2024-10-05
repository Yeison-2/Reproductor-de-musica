/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Felipe
 */
public class modelo_playList {

    //es una posible opcion para cada playList
    /*seria bueno implementar otra clase que cuando se 
    quiera crear una play list se cree una nueva clase
    con estos mismos metodos toca investigar.
     */
    private Cancion top;
    int size;
    private int idCounter = 0;

    public modelo_playList() {
        this.idCounter = getIdMaximoDelTxt() + 1;
        top = null;
        this.size = 0;
    }

    //metodo para verificar si la lista de canciones esta vacia
    public boolean playListVacio() {

        return top == null;
    }

    // metodo para agregar canciones
    public String agregarCancion(String artista, String titulo, String ruta) {
        if (esCancionDuplicada(titulo, artista, ruta)) {
            return "La canción ya existe";
        } else {
            int id = crearID();
            Cancion nuevoNodo = new Cancion(id, titulo, artista, ruta);
            if (playListVacio()) {
                top = nuevoNodo;
            } else {
                nuevoNodo.siguiente = top;
                top = nuevoNodo;
            }
            size++;
            guardarCambiosCancionTxt(id, titulo, artista, ruta);
            return "Canción agregada " + titulo + " - " + artista;
        }
    }

    // Método para eliminar canciones
    public boolean eliminarCancion(int id) {
        if (playListVacio()) {
            throw new RuntimeException("La playlist se encuentra vacia");
        }
        Cancion actual = top;
        Cancion anterior = null;
        while (actual != null) {
            if (actual.id == id) {
                if (anterior == null) {
                    top = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                size--;
                return true;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
        return false;
    }

    // Método para mostrar la playlist
    public void mostrarPlayList() {
        if (playListVacio()) {
            System.out.println("La playlist esta vacia");
            return;
        } else {
            // Step 1: Count the number of elements in the stack
            int count = 0;
            Cancion actual = top;
            while (actual != null) {
                count++;
                actual = actual.siguiente;
            }

            // Step 2: Create an array of Cancion with the size obtained
            Cancion[] canciones = new Cancion[count];

            // Step 3: Fill the array with elements from the stack
            actual = top;
            for (int i = 0; i < count; i++) {
                canciones[i] = actual;
                actual = actual.siguiente;
            }

            // Step 4: Write the array to the file in reverse order
            try (BufferedWriter escritor = new BufferedWriter(new FileWriter("src/main/resources/canciones.txt"))) {
                for (int i = count - 1; i >= 0; i--) {
                    Cancion cancion = canciones[i];
                    escritor.write(cancion.id + "," + cancion.titulo + "," + cancion.artista + "," + cancion.ruta);
                    escritor.newLine();
                }
                escritor.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para generar un ID único
    public int crearID() {
        return idCounter++;
    }

    public int getId() {
        return idCounter;
    }

    /**
     * Metodo que guarda la cancion en el txt y guarda los cambios realizados en
     * los metodos del modelo
     *
     * @param id tomado del modelo playList
     * @param nombre tomado del archivo mediante el metodo getNombreCancion
     * @param artista tomado del archivo mediante el metodo getNombreArtista
     * @param ruta toma del archivo actual
     */
    private void guardarCambiosCancionTxt(int id, String nombre, String artista, String ruta) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("src/main/resources/canciones.txt", true))) {
            escritor.write(id + "," + nombre + "," + artista + "," + ruta);
            escritor.newLine();
            escritor.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //el id generado siempre debe ser mayor al del txt
    private int getIdMaximoDelTxt() {
        int idMax = 0;
        try (BufferedReader lector = new BufferedReader(new FileReader("src/main/resources/canciones.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length > 0) {
                    int id = Integer.parseInt(datos[0]);
                    if (id > idMax) {
                        idMax = id;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return idMax;
    }

    private boolean esCancionDuplicada(String nombre, String artista, String ruta) {
        try (BufferedReader lector = new BufferedReader(new FileReader("src/main/resources/canciones.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4) {
                    String existeNombre = datos[1].strip();
                    String existeArtista = datos[2].strip();
                    String existeRuta = datos[3].strip();
                    if (existeNombre.equals(nombre) && existeArtista.equals(artista) && existeRuta.equals(ruta)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
