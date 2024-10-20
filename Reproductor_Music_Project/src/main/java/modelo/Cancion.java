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

import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.io.IOException;

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
    long duracion; // Duración en milisegundos

    public Cancion(int id, String titulo, String artista, String ruta) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.siguiente = null;
        this.ruta = ruta;
        this.duracion = calcularDuracion(ruta);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public long getDuracion() {
        return duracion;
    }

    private long calcularDuracion(String ruta) {
        try {
            Mp3File mp3file = new Mp3File(ruta);
            return mp3file.getLengthInMilliseconds();
        } catch (IOException | UnsupportedTagException | InvalidDataException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
