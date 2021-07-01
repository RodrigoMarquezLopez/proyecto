/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intento1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.geometry.VPos;
import javax.swing.JOptionPane;

/**
 *
 * @author rodri
 */
public class ControladorDatosVenta implements ActionListener{
    private Modelo modelo;
    private VistaDatosVenta vdv;
    
public ControladorDatosVenta(VistaDatosVenta vdv, Modelo modelo){
    this.modelo = modelo;
    this.vdv = vdv;
    cargarTableVentas();
}

private void cargarTableVentas(){
    //SimpleDateFormat ff = new SimpleDateFormat("YYYY-MM-dd");
    List<Object []> lista = modelo.listVentas();
    vdv.modelo.setDatos(lista);
    vdv.ventas.updateUI();
}





    

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "buscar":
                try{
                SimpleDateFormat ff = new SimpleDateFormat("YYYY-MM-dd");
                String s =   ff.format((Date)vdv.fecha.getValue());
                System.out.println(s);
                List<Object []> lista = modelo.listVentas(s);
                
                if(!lista.isEmpty()){    
                    vdv.modelo.setDatos(lista);
                    vdv.ventas.updateUI();
                }else{
                    cargarTableVentas();
                    JOptionPane.showMessageDialog(vdv,"No hay elementos");
                
                }
                }catch(Exception ex){JOptionPane.showMessageDialog(vdv,"Erro al ingresar fecha");}
                
                
                
                
                break;
            case "seleccionar":
                int x = vdv.ventas.getSelectedRow();
                if(x != -1){
                    System.out.println(x);
                    int id = (Integer) vdv.ventas.getValueAt(x,0);
                    vdv.ticket.setText("");
                    String t = modelo.ticket(id);
                    System.out.println(t.length());
                    if(t.length()<1700){
                    vdv.ticket.setSize(390,500);
                    vdv.ticket.setFont(new Font("Arial",Font.BOLD,12));
                    vdv.setSize(700,800);    
                    vdv.ticket.setText(t);
                    vdv.ticket.updateUI();
                    vdv.repaint();
                    }else{
                        vdv.ticket.setSize(390,1000);
                        vdv.ticket.setFont(new Font("Arial",Font.BOLD,11));
                        vdv.setSize(700,1000);
                        vdv.ticket.setText(t);
                        vdv.ticket.updateUI();
                        vdv.repaint();
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(vdv,"Selecciona una columna de la tabla");
                }
                break;
                
                
        }
    
    
    }
    
  /***  
    private boolean valida(){
    try{
        int a = (int)vdv.año.getValue();
        int m = (int) vdv.mes.getValue();
        int d = (int) vdv.dia.getValue();
       if(m == 1 || m== 3 || m == 5 || m==7 || m==8 || m==10 || m==12){
            if(d>31){
                return false;
            }
        }else if(m == 2){
            if(a % 100 == 0 && a % 400 == 0){
                if(d > 29){
                    return false;
                }
            
            }else{
                if(d > 28){
                    return false;
                }
            
            }
        
        }else if(m==2 || m==4 || m== 6 || m==9 || m==11){
            if(d > 31){
                return false;
            }
        
        }
    }catch(Exception e){
        JOptionPane.showMessageDialog(vdv,"Erro fecha incorrecta");
        return false;
    }
       return true;
    }
    **/
    
}
