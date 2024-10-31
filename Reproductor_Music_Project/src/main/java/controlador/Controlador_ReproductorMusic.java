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
import java.io.IOException;
import javax.swing.JOptionPane;
import modelo.Cancion;
import modelo.Modelo_Reproductor;
import modelo.modelo_playList;
import vista.Vista_BuscarCancion;
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
    private Vista_BuscarCancion viewBuscar;

    private modelo_playList playlistFavoritas;
    private modelo_playList playlistFinDeAno;
    private modelo_playList playlistDespecho;

    public Controlador_ReproductorMusic(modelo_playList playlist, Vista_ReproductorMusica view) {
        this.playlist = playlist;
        this.view = view;
        this.reproductor = new Modelo_Reproductor(playlist, view.getSlider());
        this.view.addListener(this);
        this.view.addAbrirArchivoListener(new AbrirArchivoListener());
        this.viewBuscar = new Vista_BuscarCancion(this);

        this.playlistFavoritas = new modelo_playList();
        this.playlistFinDeAno = new modelo_playList();
        this.playlistDespecho = new modelo_playList();

    }

    public void iniciar() {
        view.setVisible(true);
        playlist.cargarCancionesDesdeArchivo();

    }

    public Cancion getCancionporId() {
        int id = view.getIdCancion(view.getCancionSeleccionadaTabla());

        Cancion cancion = playlist.buscarCancionPorId(id);
        return cancion;

    }

    public Cancion getCancionporId(int id) {
        return playlist.buscarCancionPorId(id);
    }

    public void reproducirCancion(int id) {
        playlist.cargarCancionesDesdeArchivo();
        Cancion cancion = getCancionporId(id);
        if (cancion != null) {
            reproductor.reproducir(cancion);
        } else {
            view.mostrartraMensaje("No se encontró la canción con el ID especificado.");
        }
    }

    public void agregarCancionAPlaylist(String nombrePlaylist, String artista, String titulo, String ruta) {
        switch (nombrePlaylist.toLowerCase()) {
            case "favoritas":
                playlistFavoritas.agregarCancion(artista, titulo, ruta);
                guardarCancionEnArchivo("favoritas", artista, titulo, ruta);
                view.mostrartraMensaje("Canción " + titulo + " agregada a la playlist Favoritas");
                break;
            case "fin de año":
                playlistFinDeAno.agregarCancion(artista, titulo, ruta);
                guardarCancionEnArchivo("fin_de_ano", artista, titulo, ruta);
                view.mostrartraMensaje("Canción " + titulo + " agregada a la playlist Fin de Año");
                break;
            case "despecho":
                playlistDespecho.agregarCancion(artista, titulo, ruta);
                guardarCancionEnArchivo("despecho", artista, titulo, ruta);
                view.mostrartraMensaje("Canción " + titulo + " agregada a la playlist Despecho");
                break;
            default:
                view.mostrartraMensaje("Nombre de playlist inválido");
                break;
        }
    }

    private void guardarCancionEnArchivo(String nombrePlaylist, String artista, String titulo, String ruta) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("src/main/resources/" + nombrePlaylist + ".txt", true))) {
            escritor.write(artista + "," + titulo + "," + ruta);
            escritor.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                reproductor.pausar();
                int id = view.getIdCancion(view.getCancionSeleccionadaTabla());
                if (id != -1) {
                    if (playlist.eliminarCancion(id)) {
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

            case "anadirPlayList":
               String nombrePlaylist = view.getNombrePlaylistSeleccionada();
                File[] archivosMp3 = view.abrirArchivoMp3();
                if (archivosMp3 != null) {
                    for (File archivoMp3Actual : archivosMp3) {
                        try {
                            Mp3File mp3file = new Mp3File(archivoMp3Actual);
                            String artista = view.getArtistaCancion(mp3file);
                            String titulo = view.getTituloCancion(mp3file);
                            String ruta = view.getRutaCancion(archivoMp3Actual);
                            agregarCancionAPlaylist(nombrePlaylist, artista, titulo, ruta);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                view.verContenidoTxtPlaylist();

                break;
            case "buscar":
                String nombre = view.getNombreCancionABuscar();
                Cancion[] canciones = playlist.buscarCancionPorNombre(nombre);
                if (canciones.length > 0) {
                    viewBuscar.mostrarResultadosBusqueda(canciones);
                    viewBuscar.setVisible(true);
                } else {
                    view.mostrartraMensaje("Canción no encontrada.");
                }
                break;

            case "eliminar lista cancion":
                reproductor.pausar();
                try {
                    playlist.eliminarListaCancion(); // Llamada al método que elimina todas las canciones
                    view.mostrartraMensaje("Todas las canciones han sido eliminadas.");
                } catch (RuntimeException ex) {
                    view.mostrartraMensaje(ex.getMessage()); // Muestra el mensaje de error si la lista está vacía
                }
                playlist.mostrarPlayList();
                view.verContenidoTxt();
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
