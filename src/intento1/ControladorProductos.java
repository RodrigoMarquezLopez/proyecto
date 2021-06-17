/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intento1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rodri
 */
public class ControladorProductos implements ActionListener,KeyListener{
    private VentanaProductos vpr;
    private Modelo modelo;
    

public ControladorProductos(VentanaProductos vpr){
    this.modelo = new Modelo("proyecto");
    this.vpr = vpr;
    cargarTabla();
}
    
private void cargarTabla(){
        List<Object[]> lista = new ArrayList<Object[]>();
        List<Producto> productos = modelo.listProductos();
        for(Producto c: productos){
                Object[] o = new Object[3];
                o[0] = c.getId();
                o[1] = c.getNombre();
                o[2] = c.getPrecio();
                lista.add(o);
            }
        vpr.mtp.setDatos(lista);
        vpr.productos.updateUI();
        
        
  }

private boolean validaNombre(){
    return (vpr.nombre.getText().length() <17);

}



    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        int x;
        //Producto p = new Producto(0,"",0.0);
        switch(e.getActionCommand()){
            case "modificar":
                vpr.principal2.removeAll();
                vpr.agregar.setEnabled(true);
                x = vpr.productos.getSelectedRow();
                if(x != -1){
                    String s = (String)vpr.productos.getValueAt(x,1);
                    double d = (Double)vpr.productos.getValueAt(x,2);
                    int id = (int)vpr.productos.getValueAt(x,0);
                    //p = new Producto((int)vpr.productos.getValueAt(x,0),s,0.0);
                    vpr.principal2.add(vpr.panelModificar());
                    vpr.selI.setText(""+id);
                    vpr.selN.setText(s);
                    vpr.selP.setText(""+d);
                    vpr.principal.updateUI();
                    vpr.modificar.setEnabled(false);
                    
                }else{}
                break;
            case "guardar":
                //System.out.println("Chale no tengo nombre: "+p.getNombre()+"F");
                try{
                if(vpr.precioN.getText() != ""){
                    double d = Double.parseDouble(vpr.selP.getText());
                    int id = 0;//Integer.parseInt(vpr.selI.getText());
                    String s = vpr.selN.getText();
                    if(!modelo.updateCliente(new Producto(id,s,d))){
                        JOptionPane.showMessageDialog(vpr,"Ha ocurrido un error");
                    }
                vpr.precioN.setText("");
                vpr.selP.setText("");
               //vpr.principal2.add(vpr.vacio());
               vpr.principal2.removeAll();
               vpr.principal.updateUI();
               vpr.modificar.setEnabled(true);
                }else{
                    JOptionPane.showMessageDialog(vpr,"Ingresa el nuevo precio");
                }
                
                }catch(NumberFormatException exc){
                    JOptionPane.showMessageDialog(vpr,"Entrada no valida");
                    vpr.precioN.setText("");
                }
                break;
            case "agregar":
                vpr.modificar.setEnabled(true);
                vpr.principal2.removeAll();;
                vpr.principal2.updateUI();
                vpr.principal2.add(vpr.panelAgregar());
                vpr.principal2.updateUI();
                vpr.agregar.setEnabled(false);
        
        }
    
    
    
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
