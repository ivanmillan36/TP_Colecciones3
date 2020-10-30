/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp_colecciones3;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author ivanmillan36
 */
public class ej_1 {
    public static void main(String[] args) {
        HashMap<String, Long>agenda = new  HashMap<String, Long>();
        int eleccion = 0;
        boolean salir = false;
        Scanner teclado = new Scanner(System.in);
        while (!salir) {      
            mostrarMenu();         
            eleccion = teclado.nextInt();
            switch(eleccion){
                case 1: 
                    cargarDatosEnAgenda(agenda);
                    break;              
                case 2:
                    buscarPersona(agenda);
                    break;
                case 3:
                    listarAgenda(agenda);
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Ingrese una opcion valida...\n\n");
                    break;
            }
        }
        
    }
    
    public static void mostrarMenu(){
        System.err.println("\n\n\n************* MENU ****************");
        System.out.println("1- Cargar datos en agenda");
        System.out.println("2- Buscar telefono por nombre");
        System.out.println("3- Listar agenda");
        System.out.println("4- Salir");
    }
    
    public static void cargarDatosEnAgenda(HashMap<String, Long> agenda){
  
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("\n\n\n**********CARGAR DATOS EN AGENDA**********");
            System.out.println("Ingrese el nombre completo de la persona a cargar, para salir escriba FIN: ");
            String nombreCompleto = sc.nextLine();
            if(nombreCompleto.equals("FIN")){
                break;
            }else if(agenda.containsKey(nombreCompleto)){
                System.out.println("Ya existe una persona con ese nombre en la agenda, presione ENTER para continuar...");
                sc.nextLine();
                continue;
            }
            System.out.println("Ingrese el telefono de " + nombreCompleto + " : ");
            long telefono = sc.nextLong();
            agenda.put(nombreCompleto, telefono);
        }
        
    }
    
    public static void buscarPersona(HashMap<String, Long> agenda){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la persona a buscar: ");
        String nombreABuscar = sc.nextLine();
        
        if(agenda.containsKey(nombreABuscar)){
            System.out.println("\nEl telefono de " + nombreABuscar + " es: " + agenda.get(nombreABuscar));
            System.out.println("\nPresione ENTER para volver al MENU...");
            sc.nextLine();
        }else{
            System.out.println("La persona buscada no se encuentra en la agenda.");
        }
        
    }
    
    public static void listarAgenda(HashMap<String, Long> agenda){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n--------Lista de contactos------------\n");
        for(String i : agenda.keySet()){
            System.out.printf("%-20s%-20s\n", i, agenda.get(i));
        }
        System.out.println("\nPresione ENTER para volver al MENU...");
        sc.nextLine();
    }
    
}
