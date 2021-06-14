/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

import intento1.Producto;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rodri
 */
public class ColaImpresiones {
    protected Queue <Impresion> cola;
    protected DefaultTableModel dtm;
    
    
    public ColaImpresiones(){
        cola = new LinkedList<Impresion>();
        
    }
    
    
    public synchronized void enviarImprimir(Impresion c){
        cola.add(c);
        System.out.println("Agregado");
        notifyAll();
    }
    
    public synchronized Impresion imprimir(){
    while(cola.isEmpty())
            try{
                this.wait();
            }catch(InterruptedException e){}
        
        Impresion a = cola.remove();
        return a;
    }
    
    
}
