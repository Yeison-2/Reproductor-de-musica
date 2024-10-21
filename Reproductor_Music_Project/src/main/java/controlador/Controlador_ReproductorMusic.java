/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.mpatric.mp3agic.Mp3File;
import com.mycompany.reproductor_music_project.Reproductor_Music_Project;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import modelo.Cancion;
import modelo.Modelo_Reproductor;
import modelo.modelo_playList;
import vista.Vista_ReproductorMusica;
import vista.vista_playList;

/**
 *
 * @author Yeison Romero
 */
public class Controlador_ReproductorMusic implements ActionListener {

    private modelo_playList playlist;
    private Vista_ReproductorMusica view;
    private Modelo_Reproductor reproductor;

    public Controlador_ReproductorMusic(modelo_playList playlist, Vista_ReproductorMusica view) {
        this.playlist = playlist;
        this.view = view;
        this.reproductor = new Modelo_Reproductor(playlist,view.getSlider());
        this.view.addListener(this);
        this.view.addAbrirArchivoListener(new AbrirArchivoListener());

    }

    public void iniciar() {
        view.setVisible(true);

    }

    public Cancion getCancionporId() {
        int id = view.getIdCancion(view.getCancionSeleccionadaTabla());

        Cancion cancion = playlist.buscarCancionPorId(id);
        return cancion;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //al finalisar se puede colocar esto en un try catch
        switch (e.getActionCommand()) {
            case "play":
                 playlist.cargarCancionesDesdeArchivo();
                reproductor.reproducir(getCancionporId());
                break;
            case "siguiente":
                reproductor.siguiente();
                
                break;
            case "anterior":
                reproductor.anterior();
                break;
            case "pausa":
                reproductor.pausar();
                break;
            case "eliminar":
                reproductor.detener();
                int id = view.getIdCancion(view.getCancionSeleccionadaTabla());
                if (id != -1) {
                    if (playlist.eliminarCancion(id)) 
                    {
                        view.mostrartraMensaje("Canción eliminada con éxito.");

                    } else {
                        view.mostrartraMensaje("No se pudo eliminar la canción.");

                    }
                }
                playlist.mostrarPlayList();
                view.verContenidoTxt();

                break;
            case "anadir":

                playlist.mostrarPlayList();
                view.verContenidoTxt();

                break;

            case "buscar":
                String nombre = view.getNombreImagenABuscar();
                Cancion[] canciones = playlist.buscarCancionPorNombre(nombre);
                if (canciones.length > 0) {
                    for (Cancion cancion : canciones) {
                        view.mostrartraMensaje("Canción encontrada: " + cancion.getTitulo() + " - " + cancion.getArtista());
                    }
                } else {
                    view.mostrartraMensaje("Canción no encontrada.");
                }
                break;
            default:
                throw new AssertionError("Comando no reconocido: " + e.getActionCommand());

        }

    }

    /**
     * Clase anidad que saca los datos del archivo mp3 nombre,artista y ruta
     * usando la dependencia mp3agic
     */
    class AbrirArchivoListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            File[] archivosMp3 = view.abrirArchivoMp3();
            if (archivosMp3 != null) {
                for (File archivoMp3Actual : archivosMp3) {
                    try {
                        Mp3File mp3file = new Mp3File(archivoMp3Actual);
                        String artista = getNombreArtista(mp3file);
                        String titulo = getNombreCancion(mp3file);
                        String ruta = archivoMp3Actual.getAbsolutePath();
                        String respuesta = playlist.agregarCancion(artista, titulo, ruta);
                        view.mostrartraMensaje(respuesta);
                        //Toca mirar que el id se este guardando bien
                        int id = playlist.getId();

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        /**
         * Recibe el archivo mp3 actual y saca el nombre de la cancion
         *
         * @param mp3file
         * @return String nombre de la cancion
         */
        private String getNombreCancion(Mp3File mp3file) {
            if (mp3file.hasId3v1Tag()) {
                return mp3file.getId3v1Tag().getTitle();
            } else if (mp3file.hasId3v2Tag()) {
                return mp3file.getId3v2Tag().getTitle();
            }
            return "Titulo desconocido";
        }

        /**
         * Recibe el archivo mp3 actual y saca el nombre del artista
         *
         * @param mp3file
         * @return String nombreArtista
         */
        private String getNombreArtista(Mp3File mp3file) {
            if (mp3file.hasId3v1Tag()) {
                return mp3file.getId3v1Tag().getArtist();
            } else if (mp3file.hasId3v2Tag()) {
                return mp3file.getId3v2Tag().getArtist();
            }
            return "Artista desconocido";
        }

    }

}
