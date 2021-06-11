/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

import intento1.Cuenta;
import intento1.Producto;
import java.math.MathContext;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Cronometro extends Thread { //una clase que hereda de la clase Thread
    protected String tiempo;
    protected ColaImpresiones color;
    protected ColaImpresiones bn;
    private AbstractTableModel dtm;
    private int row;
    private int column;
    private int nBn;
    private int col;
    private double costo;
    
    public Cronometro(ColaImpresiones bn,ColaImpresiones color,int row, int column, AbstractTableModel dtm){// Contructor porque la clase es heredada 
        super();
        nBn = 0;
        col = 0;
        costo = 0.5;
        this.dtm = dtm;
        this.row = row;
        this.column = column;
        tiempo = "0:0:0";
        dtm.setValueAt(tiempo,row,column);
        this.bn = bn;
        this.color = color;
    }
    @Override
    public void run() {
    int nuMin=0; //El Contador de minutos
    int nuSeg=55; //El Contador de de segundos
    int nuHora=0; //El Contador de Horas   
        try {//si ocurre un error al dormir el proceso(sleep(999))
            while(dtm.getValueAt(row,1).equals("No Disponible")){ //inicio del for infinito           
               if(nuSeg!=59) {//si no es el ultimo segundo
                   nuSeg++; //incremento el numero de segundos                                  
                }else{
                    if(nuMin!=59){//si no es el ultimo minuto
                        nuSeg=0;//pongo en cero los segundos 
                        nuMin++;//incremento el numero de minutos
                        dtm.setValueAt(costo*nuMin,row,3);
                        double random = 0.7;
                            if(random > 0.4899){
                                if(random > 0.65){
                                Impresion i = new Impresion(3,"Impresiones B/N",0.95,(row+1));
                                i.setCantidad(nuMin*10);
                                nBn = nBn + i.getCantidad();
                                dtm.setValueAt(nBn,row,4);
                                bn.enviarImprimir(i);
                                
                                }else{
                                Impresion i = new Impresion(3,"Impresiones color",2.5,(row+1));
                                i.setCantidad(nuMin*10);
                                col = col + i.getCantidad();
                                dtm.setValueAt(col,row,5);
                                color.enviarImprimir(i);
                                }
                               
                            }
                                
                    }else{//incremento el numero de horas
                            nuHora++;
                            nuMin=0;//pongo en cero los minutos
                            nuSeg=0;//pongo en cero los segundos           
                    }
                }               
                //tiempo = nuHora+":"+nuMin+":"+nuSeg;//Muestro en pantalla el cronometro
                dtm.setValueAt(nuHora+":"+nuMin+":"+nuSeg,row,column);
                //System.out.println(tiempo);
                //System.out.println(nuHora+":"+nuMin+":"+nuSeg+" "+fila+" "+columna);
            sleep(997);//Duermo el hilo durante 999 milisegundos(casi un segundo, quintandole el tiempo de proceso)
            }
            return;//Fin del for infinito             
        } catch (Exception ex) {
             System.out.println(ex.getMessage());//Imprima el error
        }                 
 } 
 public static void main(String[] args) {
         //Ejecuto el metodo run del Thread        
    }// Fin main
}//Fin Clase