/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Scanner;
import modelo.modelo_playList;
import vista.vista_playList;

/**
 *
 * @author Felipe
 */
public class controlador_playList {

   private modelo_playList playlist;
   private vista_playList view;

    public controlador_playList(modelo_playList playlist, vista_playList view) {
        this.playlist = playlist;
        this.view = view;
    }

    
    public void ejecutarAccion() {
        boolean continuar=true;
        while (continuar) {            
            int opcion =view.mostrarMenu();
        
        switch (opcion) {
            case 1:
                agregarCancion();
                break;
            case 2:
                eliminarCancion();
                break;
            case 3:
                mostrarPlayList();
                break;
            case 4:
                salir();
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }
    }

    private void agregarCancion() {
        System.out.println("Ingrese el título de la canción:");
        String titulo = leerCadena();
        System.out.println("Ingrese el artista de la canción:");
        String artista = leerCadena();
        System.out.println("Ingrese el artista de la canción:");
        String ruta = leerCadena();
        playlist.agregarCancion(titulo, artista,ruta);
    }

    private void eliminarCancion() {
        System.out.println("Ingrese el ID de la canción que desea eliminar:");
        int id = leerEntero();
        if (playlist.eliminarCancion(id)) {
            System.out.println("Canción eliminada con éxito");
        } else {
            System.out.println("No se encontró la canción con el ID ingresado");
        }
    }

    private void mostrarPlayList() {
        playlist.mostrarPlayList();
    }

    private void salir() {
        System.out.println("Saliendo del programa...");
        System.exit(0);
    }

    private String leerCadena() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private int leerEntero() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    }

