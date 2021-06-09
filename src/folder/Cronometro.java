/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

import intento1.Cuenta;
import intento1.Producto;
import java.math.MathContext;
import javax.swing.table.DefaultTableModel;

public class Cronometro extends Thread { //una clase que hereda de la clase Thread
    
    public DefaultTableModel dtm;
    public boolean parar;
    public int columna,fila;
    protected Cuenta cuenta;
    protected Producto renta;
    protected ColaImpresiones cola;
    protected double costo;
    protected double tarifa;
    private Producto impresiones;
    
    public Cronometro(DefaultTableModel dtm,int columna, int fila,ColaImpresiones cola,double precio){// Contructor porque la clase es heredada 
        super();
        this.dtm = dtm;
        dtm.setValueAt(this, fila, columna);
        this.setName("");
        this.fila = fila;
        this.columna = columna;
        this.cola = cola;
        this.costo = precio;
        this.tarifa = tarifa;
        impresiones = new Producto(3,"Impresiones color",2.5);
    }
    @Override
    public void run() {
    int nuMin=0; //El Contador de minutos
    int nuSeg=55; //El Contador de de segundos
    int nuHora=0; //El Contador de Horas   
        try {//si ocurre un error al dormir el proceso(sleep(999))
            for (; ;){ //inicio del for infinito           
               if(nuSeg!=59) {//si no es el ultimo segundo
                   nuSeg++; //incremento el numero de segundos                                  
                }else{
                    if(nuMin!=59){//si no es el ultimo minuto
                        nuSeg=0;//pongo en cero los segundos 
                        nuMin++;//incremento el numero de minutos
                        costo = costo + tarifa;
                        double random = Math.random();
                            //if(random > 0.4899){
                               
                               cola.enviarImprimir(new Producto(3,"Impresiones color"+Math.random(),2.5));
                               //System.out.println("Agregado");
                            //}
                                
                    }else{//incremento el numero de horas
                            nuHora++;
                            nuMin=0;//pongo en cero los minutos
                            nuSeg=0;//pongo en cero los segundos           
                    }
                }               
            dtm.setValueAt(nuHora+":"+nuMin+":"+nuSeg,fila,columna);//Muestro en pantalla el cronometro
            
            sleep(999);//Duermo el hilo durante 999 milisegundos(casi un segundo, quintandole el tiempo de proceso)
            }//Fin del for infinito             
        } catch (Exception ex) {
             System.out.println(ex.getMessage());//Imprima el error
        }                 
 } 
 public static void main(String[] args) {
         //Ejecuto el metodo run del Thread        
    }// Fin main
}//Fin Clase