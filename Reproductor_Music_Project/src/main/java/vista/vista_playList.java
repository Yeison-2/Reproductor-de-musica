/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Scanner;

/**
 *
 * @author Felipe
 */
public class vista_playList {
    //prueba de las clases---->buscar hacer una interfaz mas amigable
    
     private Scanner sc;

    public vista_playList() {
        sc=new Scanner(System.in);
    }
    
    
    
    public int mostrarMenu(){
        System.out.println("n/ Menu de la Lista");
        System.out.println("1. Agregar canciones a la lista de Reproduccion");
        System.out.println("2. Eliminar canciones de la lista de Reproduccion");
        System.out.println("3. Lista completa de reproduccion");
        System.out.println("4. Salir");
        System.out.println("ingrese una opcion valida");
        return sc.nextInt();
    }
    
    
    public int eleccion(){
        System.out.println("Seleccione");
        return sc.nextInt();
    }
    public void mostrarMensaje(String msj){
        System.out.println(msj);
    }
    public void msotrarNumero(int numero){
        System.out.println("Opcion selecccionada: "+ numero);
    }
}
