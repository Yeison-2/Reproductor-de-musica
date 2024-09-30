/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.modelo_playList;
import vista.vista_playList;

/**
 *
 * @author Felipe
 */
public class controlador_playList {
     private modelo_playList modelo;
    private vista_playList view;

    public controlador_playList(modelo_playList modelo, vista_playList view) {
        this.modelo = modelo;
        this.view = view;
    }

  

    public void iniciar() {
        boolean continuar = true;

        while (continuar) {
            int opcion = view.mostrarMenu();

            switch (opcion) {
                case 1:
                    int numero = view.eleccion();
                    modelo.agregarCancion(numero);
                    view.mostrarMensaje("numero aplicado correctamente");
                    break;
                case 2:
                    int quitar = modelo.eliminarCancion();
                    view.mostrarMensaje("numero desapilado" + quitar);
                    break;
               
                case 3:
                    modelo.mostrarPlayList();
                    break;
                case 4:
                    continuar = false;
                    view.mostrarMensaje("saliendo.......");
                    break;
                default:
                    view.mostrarMensaje("opcion invalida");
                    break;
            }
        }
    }
}
