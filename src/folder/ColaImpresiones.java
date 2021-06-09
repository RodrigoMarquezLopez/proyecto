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
    protected Queue <Producto> cola;
    private int numeroHojasIm;
    
    
    public ColaImpresiones(){
        cola = new LinkedList<Producto>();
        numeroHojasIm = 0;
        
    }
    
    
    public synchronized void enviarImprimir(Producto c){
        cola.add(c);
        System.out.println("Agregado");
        notifyAll();
    }
    
    public synchronized Producto imprimir(){
        char d = ' ';
        if(!cola.isEmpty())
            System.out.println("Pila vacia, enesperea el hilo "+Thread.currentThread().getName());
        while(cola.isEmpty())
            try{
                this.wait();
            }catch(InterruptedException e){}
        
        Producto a = cola.remove();
        return a;
    }
    
    
}
