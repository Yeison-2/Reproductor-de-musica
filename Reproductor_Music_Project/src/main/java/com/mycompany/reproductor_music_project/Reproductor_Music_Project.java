/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.reproductor_music_project;

import controlador.controlador_playList;
import modelo.modelo_playList;
import vista.vista_playList;

/**
 *
 * @author Yeison Romero Salinas
 */
public class Reproductor_Music_Project {

    public static void main(String[] args) {
         modelo_playList modelo = new modelo_playList();
        vista_playList view = new vista_playList();
        controlador_playList con = new controlador_playList( modelo, view);
        con.iniciar();
        
        
        
        // se crean los objetos del modelo
        //crear objeto de la vista
        //crear objeto del controlador
        //como es con formularios se hace view.setViseble True
    }
}
