/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.mpatric.mp3agic.Mp3File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import modelo.modelo_playList;
import vista.Vista_ReproductorMusica;
import vista.vista_playList;

/**
 *
 * @author Yeison Romero
 */
public class Controlador_ReproductorMusic implements ActionListener {

    public static void ReproducirCanciones() {
        String ruta="\"C:\\Users\\Felipe\\Documents\\musica\"";
        modelo_playList.reproducirCancion(ruta);
    }

    private modelo_playList playlist;
    private Vista_ReproductorMusica view;

    public Controlador_ReproductorMusic(modelo_playList playlist, Vista_ReproductorMusica view) {
        this.playlist = playlist;
        this.view = view;
        this.view.addListener(this);
        this.view.addAbrirArchivoListener(new AbrirArchivoListener());

    }

    public void iniciar() {
        view.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //al finalisar se puede colocar esto en un try catch
        switch (e.getActionCommand()) {
            case "play":
                //colocar la logica del boton play
                break;
            case "siguiente":
                //colocar logica para la siguiente cancion
                break;
            case "anterior":
                //colocar logica para mostra la anterior cancion
                break;
            case "eliminar":
                //logica eliminar
                //traer id de la vista
                break;
            case "anadir":

                playlist.mostrarPlayList();
                view.verContenidoTxt();

                break;

            case "buscar":
                //anadir logica de buscar cancion por 
                // String
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
