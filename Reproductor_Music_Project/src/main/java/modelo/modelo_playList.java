/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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

    public modelo_playList() {
        top = null;
        this.size = 0;
    }

    //metodo para verificar si la lista de canciones esta vacia
    public boolean playListVacio() {

        return top == null;
    }

    // metodo para agregar canciones
    public void agregarCancion(String artista, String titulo) {
        int id = crearID();
        Cancion nuevoNodo = new Cancion(id, artista, titulo);
        if (playListVacio()) {
            top = nuevoNodo;
        } else {
            nuevoNodo.siguiente = top;
            top = nuevoNodo;
        }
        size++;
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
            Cancion actual = top;
            while (actual != null) {
                System.out.println(actual.id + " - " + actual.artista + " - " + actual.titulo);
                actual = actual.siguiente;
            }
        }
    }
    private int idCounter = 0;

    // Método para generar un ID único
    public int crearID() {
        return idCounter++;
    }

}
