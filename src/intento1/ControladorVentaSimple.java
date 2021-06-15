/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intento1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author rodri
 */
public class ControladorVentaSimple implements ActionListener {
    private Modelo modelo;
    private VistaVentaSimple ventanaSimple;
    private ArrayList<Object[]> aux = new ArrayList<Object[]>();
    private Cuenta cuenta = new Cuenta();
   // private VistaCuenta vc;
    
    public ControladorVentaSimple (VistaVentaSimple vs){
        modelo = new Modelo("proyecto");
        this.ventanaSimple = vs;
        cargarTabla();
        cargarCuenta();
        
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
  }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        int x;
        switch(accion){
            case "agregar":
            
            Object[] o = new Object[3];
            x = ventanaSimple.tablaP.getSelectedRow();
           
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
            break;
            
            case "eliminar":
                x = ventanaSimple.tablaC.getSelectedRow();
                cuenta.eliminarProducto(x);
               aux.remove(x);
               this.ventanaSimple.mtv.setDatos(aux);
               this.ventanaSimple.tablaC.updateUI();
               if(aux.size() == 0)
                   ventanaSimple.generaCuenta.setEnabled(false);
               break;
               
            case "buscar":
                String busqueda = ventanaSimple.busqueda.getText();
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
        break;
        
            case "cuenta":
                
                ventanaSimple.cuent.setText(cuenta.toString());
                ventanaSimple.cuent.updateUI();
                ventanaSimple.cuent.setEditable(false);
                ventanaSimple.cuent.repaint();
                ventanaSimple.busqueda.setText(ventanaSimple.rBuqueda);
                cuenta = new Cuenta();
                aux = new ArrayList<Object[]>();
                this.ventanaSimple.mtv.setDatos(aux);
                this.ventanaSimple.tablaC.updateUI();
                ventanaSimple.generaCuenta.setEnabled(false);
                break;
        
        }
        
    }
    
    public void cargarCuenta(){
        this.cuenta = ventanaSimple.cuentaAs;
        if(cuenta.getProductos().size() > 0){
            List<Producto> productos = cuenta.getProductos();
            for(Producto c : productos){
                Object[] o = new Object[4];
                o[0] = c.getId();
                o[1] = c.getNombre();
                o[2] = c.getPrecio();
                o[3] = c.getCantidad();
                aux.add(o);
            }
        }
    }
    

    
}
