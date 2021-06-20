/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intento1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
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
    SimpleDateFormat ff = new SimpleDateFormat("YYYY-MM-dd");
    List<Object []> lista = modelo.listVentas(ff.format(new Date()));
    for(int i = 0; i<lista.size(); i++){
        Object [] o = lista.get(i);
        vdv.modelo.addRow(o);
    }
    vdv.ventas.updateUI();
    

}





    

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "buscar":
                boolean val = valida();
                if(val){
                    String s = "";
                    s = vdv.año.getValue()+"-"+vdv.mes.getValue()+"-"+vdv.dia.getValue();
                    List<Object[]> lista = modelo.listVentas(s);
                    if(lista.size() > 0){
                    for(int i = 0; i < lista.size(); i++){
                        Object [] o = lista.get(i);
                        vdv.modelo.addRow(o);
                    }
                    vdv.ventas.updateUI();
                  }else{
                    JOptionPane.showMessageDialog(vdv,"No se encontro nada");
                    cargarTableVentas();
                    
                    }
                }else{
                
                    JOptionPane.showMessageDialog(vdv,"Error en fecha");
                }
                break;
            case "seleccionar":
                int x = vdv.ventas.getSelectedRow();
                if(x != -1){
                    System.out.println(x);
                    int id = (Integer) vdv.ventas.getValueAt(x,0);
                    vdv.ticket.setText("");
                    String t = modelo.ticket(id);
                    System.out.println(t);
                    vdv.ticket.setText(t);
                    vdv.ticket.updateUI();
                }else{
                    JOptionPane.showMessageDialog(vdv,"Selecciona una columna de la tabla");
                }
                break;
                
                
        }
    
    
    }
    
    
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
        
        }else{
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
    
    
}
