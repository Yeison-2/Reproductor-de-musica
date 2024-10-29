/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.BufferedReader;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JSlider;
import javax.swing.Timer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

/**
 *
 * @author programador
 */
public class Modelo_Reproductor {

    private Cancion actual;
    private AdvancedPlayer reproductor;
    private Thread hiloReproduccion;
    private modelo_playList listaReproduccion;
    private JSlider barraProgreso;
    private Timer temporizador;
    private long tiempoInicio;

    public Modelo_Reproductor(modelo_playList listaReproduccion, JSlider barraProgreso) {
        this.listaReproduccion = listaReproduccion;
        this.barraProgreso = barraProgreso;
    }

     public void reproducir(Cancion cancion) {
        if (cancion != null) {
           pausar();
            actual = cancion;
            hiloReproduccion = new Thread(() -> {
                try {
                    FileInputStream fis = new FileInputStream(cancion.ruta);
                    reproductor = new AdvancedPlayer(fis);
                    reproductor.setPlayBackListener(new PlaybackListener() {
                        @Override
                        public void playbackFinished(PlaybackEvent evt) {
                            temporizador.stop();
                        }
                    });
                    iniciarActualizadorProgreso();
                    tiempoInicio = System.currentTimeMillis();
                    reproductor.play();
                    System.out.println("Reproduciendo: " + cancion.ruta);
                } catch (FileNotFoundException | JavaLayerException e) {
                    e.printStackTrace();
                }
            });
            hiloReproduccion.start();
        }
    }

    private void iniciarActualizadorProgreso() {
        temporizador = new Timer(1000, e -> actualizarProgreso());
        temporizador.start();
    }

    private void actualizarProgreso() {
        if (reproductor != null && actual != null) {
            long tiempoTranscurrido = System.currentTimeMillis() - tiempoInicio;
            long duracionTotal = actual.getDuracion();
            int progreso = (int) ((tiempoTranscurrido / (double) duracionTotal) * 100);
            barraProgreso.setValue(progreso);
        }
    }

    public void pausar() {
        if (reproductor != null && hiloReproduccion != null) {
            hiloReproduccion.interrupt();
            reproductor.close();
            temporizador.stop();
            System.out.println("Reproducción pausada.");
        }
    }

    

    public void siguiente() {
        if (actual != null) {
            Cancion siguienteCancion = listaReproduccion.getSiguiente(actual);
            if (siguienteCancion != null) {
                reproducir(siguienteCancion);
            } else {
                System.out.println("No hay más canciones.");
            }
        }
    }

    public void anterior() {
        if (actual != null) {
            Cancion anteriorCancion = listaReproduccion.getAnterior(actual);
            if (anteriorCancion != null) {
                reproducir(anteriorCancion);
            } else {
                System.out.println("No hay canciones anteriores.");
            }
        }
    }
    
}
