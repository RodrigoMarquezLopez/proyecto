/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import javax.swing.table.AbstractTableModel;

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
    private int rHojas;
    private boolean rImpresora;
    private boolean impb;
    private boolean impc;
    
    public Cronometro(ColaImpresiones bn,ColaImpresiones color,int row, int column, AbstractTableModel dtm,Double tarifa){// Contructor porque la clase es heredada 
        super();
        nBn = 0;
        col = 0;
        costo = tarifa;
        this.dtm = dtm;
        this.row = row;
        this.column = column;
        tiempo = "0:0:0";
        dtm.setValueAt(tiempo,row,column);
        dtm.setValueAt(costo,row,3);
        this.bn = bn;
        this.color = color;
        int rHojas = 0;
        impc = true;
        impb = true;
       
    }
    @Override
    public void run() {
    int nuMin=0; //El Contador de minutos
    int nuSeg=0; //El Contador de de segundos
    int nuHora=0; //El Contador de Horas   
        try {//si ocurre un error al dormir el proceso(sleep(999))
            while(dtm.getValueAt(row,1).equals("No Disponible")){ //inicio del for infinito           
               if(nuSeg!=59) {//si no es el ultimo segundo
                   nuSeg++; //incremento el numero de segundos                                  
                }else{
                    if(nuMin!=59){//si no es el ultimo minuto
                        nuSeg=0;//pongo en cero los segundos 
                        nuMin++;//incremento el numero de minutos
                        dtm.setValueAt(costo*(nuMin+1),row,3);
                     //if(impb || impc){   
                        if(randoms()){
                            if(rImpresora){
                            Impresion i = new Impresion(3,"Impresiones B/N",0.0,(row+1));
                            i.setCantidad(rHojas);
                            nBn = nBn + i.getCantidad();
                            dtm.setValueAt(nBn,row,4);
                            bn.enviarImprimir(i);
                            impb = false;
                           }else if(!rImpresora){
                            Impresion i = new Impresion(4,"Impresiones color",0.0,(row+1));
                            i.setCantidad(rHojas);
                            col = col + i.getCantidad();
                            dtm.setValueAt(col,row,5);
                            color.enviarImprimir(i);
                            impc = false;
                           }
                        }
                     //}
                                
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
            sleep(100);//Duermo el hilo durante 999 milisegundos(casi un segundo, quintandole el tiempo de proceso)
            }
            dtm.setValueAt("0:0:0", row, column);
            return;//Fin del for infinito             
        } catch (Exception ex) {
             System.out.println(ex.getMessage());//Imprima el error
        }                 
 }
    
public boolean randoms(){
    double imprimir = Math.random();
    if(imprimir > 0.4999){
        this.rImpresora  = (Math.random() < 0.5);
        this.rHojas = ((int)(Math.random()*15))+1;
        return true;
    }
    return false;
}    
    
 
    
}