/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intento1;

import java.awt.FlowLayout;
import static java.lang.Thread.sleep;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author rodri
 */
public class Temporizador implements  Runnable{
    protected String tiempo;
    private int nuMin;//El Contador de minutos
    private int nuSeg;//El Contador de de segundos
    private int nuHora;//El Contador de Horas    
    
    public Temporizador (int minutos) {// Contructor porque la clase es heredada 
            this.nuMin = minutos;
            this.nuHora = (int) minutos/60;
            this.nuMin = this.nuMin - nuHora*60;
            this.nuSeg = 0;
    }
    

    @Override
    public void run() {
           try {//si ocurre un error al dormir el proceso(sleep(999))
            for (; ;){//inicio del for infinito          
              if(nuSeg!=0) {//si no es el ultimo segundo
                   nuSeg--;  //decremento el numero de segundos                                  
                }else{
                    if(nuMin!=0){//si no es el ultimo minuto
                        nuSeg=59;//segundos comienzan en 59
                        nuMin--;//decremento el numero de minutos
                    }else{
                        if (nuHora!=0){
                            nuHora--;//decremento el numero de horas
                            nuMin=59;//minutos comienzan en 59
                            nuSeg=59;//segundos comienzan en 59
                        }else{                         
                          break;//seacabo el tiempo fin hilo  
                        }
                    }
                }               
            tiempo = nuHora+":"+nuMin+":"+nuSeg;
            System.out.println(nuHora+":"+nuMin+":"+nuSeg);//Muestro en pantalla el temporizador
             sleep(998);//Duermo el hilo durante 999 milisegundos(casi un segundo, quintandole el tiempo de proceso)
            }            
        } catch (InterruptedException ex) {
             System.out.println(ex.getMessage());
        }//Fin try               
           
    
}
    public static void main(String[] args) {
    Thread th1 = new Thread(new Temporizador(10));
    th1.start();
    }    
}
