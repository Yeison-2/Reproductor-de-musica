/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
    public void agregarCancion(int id) {
        Cancion nuevoNodo = new Cancion(id);
        if (playListVacio()) {
            top = nuevoNodo;
        } else {
            nuevoNodo.siguiente = top;
            top = nuevoNodo;
        }
        size++;
    }
//Metodo para eliminar canciones hh

    public int eliminarCancion(int id) {
        if (playListVacio()) {
            throw new RuntimeException("La playlist se encuentra vacia");
        }
        int num = top.id;
        String name = top.artista;
        String title = top.titulo;
        return ;

    }
    //Metodo para mostrar la playList

    public void mostrarPlayList() {
        Cancion nuevoNodo = new Cancion(size);
        if (playListVacio()) {
            System.out.println("La playList esta vacia");
            return;
        } else {
            Cancion actual = top;
            while (actual != null) {
                System.out.println(actual.id);
                actual = actual.siguiente;

            }
        }
    }

}
