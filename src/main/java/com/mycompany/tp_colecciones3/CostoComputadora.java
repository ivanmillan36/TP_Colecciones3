/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp_colecciones3;

import java.util.Scanner;

/**
 *
 * @author ivanmillan36
 */
public class CostoComputadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Computadora pc;
        boolean continuar = true;
        while (continuar) {            
            System.out.println("\nIngrese la marca de la computadora: ");
            String marca = sc.nextLine();
            System.out.println("Ingrese el modelo de la computadora: ");
            String modelo = sc.nextLine();
            pc = new Computadora(marca, modelo);
            
            pc.agregarComponentes();
            pc.mostrarInfo();
            System.out.println("\nDesea cotizar una nueva computadora? (Y/N)");
            if(sc.nextLine().equalsIgnoreCase("Y")){
                continuar = true;
            }else{
                continuar = false;
            }
            
        }
        
    }
    
}
