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
    
   public Impresora(ColaImpresiones cola){
        this.cola = cola;
   }
   
   public void run(){
       while(1 == 1){
       Producto c = cola.imprimir();
       System.out.println();
       for(int i = 0; i < c.getCantidad(); i++){
           System.out.println("Imprimiendo hoja :"+i);
         try{  
           Thread.sleep(2500);
         }catch(InterruptedException e){}
       }
       
       }
   }
}
