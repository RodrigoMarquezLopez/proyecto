/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intento1;

import componentesproyecto.CuadroTex;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author rodri
 */
public class ControladorVentaSimple implements ActionListener,KeyListener,FocusListener {
    private Modelo modelo;
    private VistaVentaSimple ventanaSimple;
    private ArrayList<Object[]> aux = new ArrayList<Object[]>();
    private Cuenta cuenta;
   // private VistaCuenta vc;
    
    public ControladorVentaSimple (VistaVentaSimple vs){
        modelo = new Modelo("proyecto");
        this.ventanaSimple = vs;
        cargarCuenta();
        cargarTabla(); 
        
        
    }
    
    protected void cargarTabla(){
        List<Object[]> lista = new ArrayList<Object[]>();
        List<Producto> productos = modelo.listProductos();
        for(Producto c: productos){
                Object[] o = new Object[3];
                o[0] = c.getId();
                o[1] = c.getNombre();
                o[2] = c.getPrecio();
                lista.add(o);
            }
        ventanaSimple.mtp.setDatos(lista);
        ventanaSimple.tablaP.updateUI();
        ventanaSimple.mtv.setDatos(aux);
        ventanaSimple.tablaC.updateUI();
        ventanaSimple.total.setText("Total :   $"+String.format("%.2f",cuenta.getTotal()));
        if(ventanaSimple.tablaC.getRowCount()>0){
            ventanaSimple.generaCuenta.setEnabled(true);
            ventanaSimple.eliminar.setEnabled(true);
        }
  }

    @Override
    public void actionPerformed(ActionEvent e) {

        String accion = e.getActionCommand();
        int x;
        switch(accion){
            case "agregar":
            x = ventanaSimple.tablaP.getSelectedRow();
            if(x != -1){
            ventanaSimple.eliminar.setEnabled(true);
            Object[] o = new Object[3];
            o[0] = (String)ventanaSimple.tablaP.getValueAt(x,1);
            o[1] = (Double)ventanaSimple.tablaP.getValueAt(x,2);
            o[2] = (Integer)ventanaSimple.cantidad.getValue();
            aux.add(o);
            int id = (Integer)ventanaSimple.tablaP.getValueAt(x,0);
            Producto p = new Producto(x,(String)o[0],(Double)o[1]);
            cuenta.agregarProducto(p,(Integer)o[2]);
            this.ventanaSimple.mtv.setDatos(aux);
            this.ventanaSimple.tablaC.updateUI();
            ventanaSimple.generaCuenta.setEnabled(true);
            ventanaSimple.total.setText("Total :   $"+String.format("%.2f",cuenta.getTotal()));
            }else{
                JOptionPane.showMessageDialog(ventanaSimple,"Selecciona una columna");
            }
            break;
            
            case "eliminar":
                x = ventanaSimple.tablaC.getSelectedRow();
                if(x != -1){
                cuenta.eliminarProducto(x);
               aux.remove(x);
               this.ventanaSimple.mtv.setDatos(aux);
               this.ventanaSimple.tablaC.updateUI();
               if(aux.size() == 0)
                   ventanaSimple.generaCuenta.setEnabled(false);
                }else{
                     JOptionPane.showMessageDialog(ventanaSimple,"Selecciona una columna");
                }
                if(ventanaSimple.tablaC.getRowCount() == 0){
                    ventanaSimple.eliminar.setEnabled(false);
                }
               break;
               
            case "buscar":
                String busqueda = ventanaSimple.busqueda.getText();
                if(!busqueda.equals("")&& !busqueda.equals(ventanaSimple.rBuqueda)){
                List<Object[]> lista = new ArrayList<Object[]>();
                List<Producto> productos = modelo.listProductos(busqueda);
                for(Producto c: productos){
                Object[] ob = new Object[3];
                ob[0] = c.getId();
                ob[1] = c.getNombre();
                ob[2] = c.getPrecio();
                lista.add(ob);
            }
        ventanaSimple.mtp.setDatos(lista);
        ventanaSimple.tablaP.updateUI();
        
                }else{
                    JOptionPane.showMessageDialog(ventanaSimple,"Campo vacio, ingresa un nombre");
                }
        break;
        
            case "cuenta":
                
                try{
                if(!ventanaSimple.recibido.getText().equals("")&&cuenta.getTotal()< Double.parseDouble(ventanaSimple.recibido.getText())){
                ventanaSimple.cambio.setText("Cambio :    $"+String.format("%.2f",Double.parseDouble(ventanaSimple.recibido.getText())-cuenta.getTotal()));
                JDialog vCuenta = new JDialog(ventanaSimple);
                vCuenta.setLocationRelativeTo(null);
                JTextArea cuent = new JTextArea();
                vCuenta.setTitle("TICKET");
                vCuenta.add(cuent);
                vCuenta.setVisible(true);
                vCuenta.setResizable(false);
                cuent.setFont(new Font("Arial",Font.BOLD,16));
                vCuenta.setSize(500,500);
                cuent.setText(cuenta.toString()+"\nRecibido  : "+
                Double.parseDouble(ventanaSimple.recibido.getText())+"\nCambio entregado  : "+
                String.format("%.2f",Double.parseDouble(ventanaSimple.recibido.getText())-cuenta.getTotal()));
                cuent.updateUI();
                cuent.setEditable(false);
                cuent.repaint();
                ventanaSimple.busqueda.setText(ventanaSimple.rBuqueda);
                cuenta = new Cuenta();
                aux = new ArrayList<Object[]>();
                this.ventanaSimple.mtv.setDatos(aux);
                this.ventanaSimple.tablaC.updateUI();
                ventanaSimple.generaCuenta.setEnabled(false);
                
                }else{
                    JOptionPane.showMessageDialog(ventanaSimple,"No es suficiente dinero");
                }
                }catch(NumberFormatException exc){
                    JOptionPane.showMessageDialog(ventanaSimple,"Entrada no valida");
                    ventanaSimple.recibido.setText("");
                }
                break;
        
        }
        
    }
    
    public void cargarCuenta(){
        this.cuenta = ventanaSimple.cuentaAs;
        if(cuenta.getProductos().size() > 0){
            List<Producto> productos = cuenta.getProductos();
            for(Producto c : productos){
                Object[] o = new Object[3];
                //o[] = c.getId();
                o[0] = c.getNombre();
                o[1] = c.getPrecio();
                o[2] = c.getCantidad();
                aux.add(o);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char k = e.getKeyChar();
        //System.out.println(k != '.');
        JTextField productor = (JTextField) e.getSource();
        if(productor == (JTextField)ventanaSimple.busqueda){
            if(ventanaSimple.busqueda.getSelectedText() != null)
                ventanaSimple.busqueda.setText("");
                    }
        
        if(productor == (JTextField)ventanaSimple.recibido){
            if(ventanaSimple.recibido.getSelectedText() != null)
                ventanaSimple.recibido.setText("");
            if(!Character.isDigit(k)){
                if(k != '.')
                e.consume();
            }
        }
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void focusGained(FocusEvent e) {
    Object o = e.getSource();
       if(o instanceof CuadroTex){
           CuadroTex txt = (CuadroTex) o;
           txt.setSelectionStart(0);
           txt.setSelectionEnd(txt.getText().length());
       }
     
     
    }

    @Override
    public void focusLost(FocusEvent e) {
    
    }
    

    
}
