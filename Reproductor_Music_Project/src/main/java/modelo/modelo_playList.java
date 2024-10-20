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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        cargarCancionesDesdeArchivo(); // Cargar canciones desde el archivo
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
                mostrarPlayList();
                return true;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
        return false;
    }

    // Método para mostrar la playlist
    public void mostrarPlayList() {
        limpiarArchivoTxt();
        if (playListVacio()) {
            System.out.println("La playlist esta vacia");
            return;
        }
        Cancion actual = top;
        while (actual != null) {
            guardarCambiosCancionTxt(actual.id, actual.titulo, actual.artista, actual.ruta);
            actual = actual.siguiente;
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
     * @param ruta toma del archivo actual que se este leyendo
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

    /**
     * Hace que el id simpre se incremente en 1 al ultimo id mas grende que se
     * encuentre dentro del archivo txt
     *
     * @return
     */
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

    /**
     * Verifica que la cancion que se quiere añadir no este ya en el archivo txt
     * para evitar duplicados no pide id por que el id siempre sera distito por
     * que auto incrementa
     *
     * @param nombre
     * @param artista
     * @param ruta
     * @return true si se esocntro la cancion y es duplicada
     */
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

    /**
     * metodo para limpiar el archivo canciones.txt para que cade vez que
     * muestre en la viste muestre la estructura de datos correspondiente a
     * pilas
     */
    private void limpiarArchivoTxt() {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("src/main/resources/canciones.txt"))) {
            escritor.write(""); // deja limpio el archivo listo para mostrar la estructura de pilas
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarCancionesDesdeArchivo() {
        try (BufferedReader lector = new BufferedReader(new FileReader("src/main/resources/canciones.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4) {
                    int id = Integer.parseInt(datos[0]);
                    String titulo = datos[1].strip();
                    String artista = datos[2].strip();
                    String ruta = datos[3].strip();
                    Cancion nuevaCancion = new Cancion(id, titulo, artista, ruta);
                    nuevaCancion.siguiente = top;
                    top = nuevaCancion;
                    size++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que utiiza un
     *
     * @param nombre
     * @return
     */
    public Cancion[] buscarCancionPorNombre(String nombre) {
        int maxResults = 100; // Define a maximum number of results to avoid excessive memory usage
        Cancion[] resultados = new Cancion[maxResults];
        int count = 0;
        Cancion actual = top;
        Pattern pattern = Pattern.compile(".*" + Pattern.quote(nombre) + ".*", Pattern.CASE_INSENSITIVE);

        while (actual != null && count < maxResults) {
            Matcher matcher = pattern.matcher(actual.titulo);
            if (matcher.matches()) {
                resultados[count++] = actual;
            }
            actual = actual.siguiente;
        }

        // Resize the array to the actual number of results
        Cancion[] resultadosFinales = new Cancion[count];
        System.arraycopy(resultados, 0, resultadosFinales, 0, count);
        return resultadosFinales;
    }

    public Cancion buscarCancionPorId(int id) {
        Cancion actual = top;
        while (actual != null) {
            if (actual.id == id) {
                return actual;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public Cancion getSiguiente(Cancion cancion) {
        if (cancion != null) {
            return cancion.siguiente;
        }
        return null;
    }

    public Cancion getAnterior(Cancion cancion) {
        if (cancion != null && top != null) {
            Cancion actual = top;
            Cancion anterior = null;
            while (actual != null && actual != cancion) {
                anterior = actual;
                actual = actual.siguiente;
            }
            return anterior;
        }
        return null;
    }
}
