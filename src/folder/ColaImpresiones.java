/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

import intento1.Producto;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author rodri
 */
public class ColaImpresiones {
    protected Queue <Impresion> cola;
    private int numeroHojasIm;
    
    
    public ColaImpresiones(){
        cola = new LinkedList<Impresion>();
        numeroHojasIm = 0;
        
    }
    
    
    public synchronized void enviarImprimir(Impresion c){
        cola.add(c);
        System.out.println("Agregado");
        notifyAll();
    }
    
    public synchronized Impresion imprimir(){
      if(!cola.isEmpty())
            System.out.println("Pila vacia, enesperea el hilo "+Thread.currentThread().getName());
        while(cola.isEmpty())
            try{
                this.wait();
            }catch(InterruptedException e){}
        
        Impresion a = cola.remove();
        return a;
    }
    
    
}
