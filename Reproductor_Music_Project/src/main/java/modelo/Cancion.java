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
    int id;
    String titulo;
    String artista;
    Cancion siguiente;
    String ruta;

    public Cancion(int id, String titulo, String artista,String ruta) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.siguiente = null;
        this.ruta = ruta;
    }
    
   
    

   
    
}
