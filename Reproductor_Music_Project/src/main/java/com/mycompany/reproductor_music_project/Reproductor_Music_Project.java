/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.reproductor_music_project;

import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGradiantoDeepOceanIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGradiantoMidnightBlueIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import controlador.Controlador_ReproductorMusic;
import vista.Vista_ReproductorMusica;
import modelo.Modelo_Reproductor;
import modelo.modelo_playList;
import vista.Vista_BuscarCancion;
import vista.vista_playList;

/**
 *
 * @author Yeison Romero Salinas
 */
public class Reproductor_Music_Project {

    public static void main(String[] args) {
        modelo_playList modelo = new modelo_playList();
        vista_playList view = new vista_playList();

        /*
         * se agrego la dependencia de FlatLab para cambiar el diseño de los iconos
         * antes de que se carge la vista ya sea aqui o en el controlador
         * 
         *  
         * 
         */
        //FlatGradiantoMidnightBlueIJTheme.setup(); //este es el tema oscuro con morado
        //
        FlatArcIJTheme.setup(); // tema claro

        Vista_ReproductorMusica view1 = new Vista_ReproductorMusica();
        Controlador_ReproductorMusic ctrl = new Controlador_ReproductorMusic(modelo, view1);
        Vista_BuscarCancion viewBuscar = new Vista_BuscarCancion(ctrl);
        ctrl.iniciar();
    }
}
