/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp_colecciones3;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author ivanmillan36
 */
public class Computadora {
    String marca;
    String modelo;
    double precioPC = 0;
    HashSet<ComponenteCPU> Componentes = new HashSet<ComponenteCPU>();
  
    public Computadora(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
    
    public void agregarComponentes(){
        boolean continuar = true;
        do{
           ComponenteCPU componente = new ComponenteCPU();
           Scanner sc = new Scanner(System.in);
           System.out.println("Ingresa nombre del componente: ");
           componente.setComponente(sc.nextLine());
           System.out.println("Ingresa la marca del componente " + componente.getComponente() + " : ");
           componente.setMarca(sc.nextLine());
           System.out.println("Ingresa la cantidad del componente " + componente.getComponente() + " : ");
           componente.setCantidad(sc.nextInt());
           System.out.println("Ingresa el precio del componente " + componente.getComponente() + " : ");
           componente.setPrecio(sc.nextDouble());
           
           this.Componentes.add(componente);
           
           System.out.println("\nDesea agregar otro componente a la pc? (Y/N)");
           Scanner teclado = new Scanner(System.in);
           String decision = teclado.nextLine();
           if(decision.equalsIgnoreCase("Y")){
               continuar = true;
           }else{
               continuar = false;
           }
           
        }while(continuar);
       
    }
    
    public void mostrarInfo(){
        System.out.println("---------------Computadora----------------");
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("\nComponentes:\n");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", "Componente", "Marca","Cantidad" , "Precio X Unidad", "SubTotal" );
        for (ComponenteCPU componente : this.Componentes){
            System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", componente.getComponente(), componente.getMarca(),String.valueOf(componente.getCantidad()) , String.valueOf(componente.getPrecio()), String.valueOf(componente.getSubtotal()) );
        }
        this.precioPC = this.calcularPrecioPC();
        System.out.printf("\n%-60s%-20s%-20s\n"," ","Costo Total",String.valueOf(this.precioPC) );
        
        if(this.precioPC < 50000){
            this.precioPC = this.precioPC + (0.4 * this.precioPC);
        }else{
            this.precioPC = this.precioPC + (0.3 * this.precioPC);
        }
        
        System.out.println("\nEl precio sugerido de venta es: " + this.precioPC);
    }
    
    public double calcularPrecioPC(){
        double precioPC = 0;
        for (ComponenteCPU componente : this.Componentes){
            precioPC += componente.getSubtotal();
        }
        return precioPC;
    }
    
}

