/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

import intento1.Producto;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodri
 */
public class Impresora extends Thread{
    ColaImpresiones cola;
    String nombre;
    
   public Impresora(ColaImpresiones cola){
       super();
        this.cola = cola;
        this.nombre = "";
   }
   
   public void run(){
       while(1 == 1){
       Impresion c = cola.imprimir();
        for(int i = 0;i<c.getCantidad();i++){
            System.out.println(nombre +"  Imprimiendo del equipo "+ c.getEquipo() + " hoja "+(i+1)+"/"+c.getCantidad());
         try{  
           Thread.sleep(2500);
         }catch(InterruptedException e){}
            
        }
       }
   }
   
   public void setNombre(String nombre){
       this.nombre = nombre;
   }
}
