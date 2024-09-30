/**
 * Universidad juan de castellanos
 * Asignatura: Estructura de Datos
 * Descripción: Nodo llamado cancion
 * Fecha: 18/09/2024
 * Autor: Yeison Stiven Romero Salinas
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo;

/**
 *
 * @author Yeison Romero Salinas
 */
public class Cancion {
    // el id toca pensarlo
    // podriamos crear un metodo para agregar Canciones y se pide el id de la cancion
    int id;
    String titulo;
    String artista;
    Cancion siguiente;
    
    public Cancion(int id){
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.siguiente = null;
    }

   
    
}
