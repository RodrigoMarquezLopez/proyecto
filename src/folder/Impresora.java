/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

import intento1.Producto;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rodri
 */
public class Impresora extends Thread{
    ColaImpresiones cola;
    String nombre;
    DefaultTableModel dtm;
    DefaultTableModel dt1;
    LinkedList<Impresion> contenidoCola;
    JLabel equipo;
    JLabel total;
    JProgressBar barra;
       //Tabla tabla;
   public Impresora(ColaImpresiones cola,DefaultTableModel dtm,JLabel total, JProgressBar barra,JLabel equipo){
       super();
        this.total = total;
        this.equipo = equipo;
        this.barra = barra;
        this.cola = cola;
        this.nombre = "";
        this.dtm = dtm;
        this.dt1 = dtm;
        //this.contenidoCola = (LinkedList<Impresion>)this.cola.cola;
   }
   
   public void run(){
       equipo.setText("Esperando ...");
       while(1 == 1){
       Impresion c = cola.imprimir();
       equipo.setText(""+c.getEquipo());
       barra.setValue(0);
       int suma = 100/c.getCantidad();
       for(int i = 0;i<c.getCantidad();i++){
          equipo.setText("Imprimiendo del equipo "+ c.getEquipo() + " hoja "+(i+1)+"/"+c.getCantidad());
          cola.numero++;
          total.setText(""+cola.numero);
          //cola.numero++;
          barra.setValue(barra.getValue()+suma);
           if(!cola.cola.isEmpty()){
       Object [] ob = new Object[2];
       ob[0] = cola.cola.peek().getEquipo();
       ob[1] = cola.cola.peek().getCantidad();
       if(dtm.getRowCount() > 0){
           for(int j = 0 ; j < dtm.getRowCount(); j++){
               dtm.removeRow(j);
           }
      }
       dtm.addRow(ob);
     }else if(dtm.getRowCount() > 0){
         dtm.removeRow(0);
           }
         try{  
           Thread.sleep(2500);
         }catch(InterruptedException e){}
        }
       barra.setValue(0);
       equipo.setText("Esperando ...");
       }
   }
   
   public void setNombre(String nombre){
       this.nombre = nombre;
   }
}
