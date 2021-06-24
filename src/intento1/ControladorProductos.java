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
import javax.swing.JTextField;

/**
 *
 * @author rodri
 */
public class ControladorProductos implements ActionListener,KeyListener{
    private VentanaProductos vpr;
    private Modelo modelo;
    

public ControladorProductos(VentanaProductos vpr,Modelo m){
    this.modelo = m;
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

private boolean validaNombre(String nombre){
    String name = nombre;
    name = name.replaceAll(" ","");
    if(name.length() <17){
        String [] nombres = new String [vpr.productos.getRowCount()];
        for(int i = 0; i<nombres.length ; i++){
            nombres[i] = (String) vpr.productos.getValueAt(i,1);
            if(name.equalsIgnoreCase(nombres[i])){
                return false;
            }
            
        }
    }
    return true;
}

private boolean validaEliminacion(int i){
    if(i == 3 || i== 4){
        return false;
    }
    return true;
}



    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        int x;
        //Producto p = new Producto(0,"",0.0);
        switch(e.getActionCommand()){
            case "buscar":
                String busqueda = vpr.busqueda.getText();
                if(!busqueda.equals("")&& !busqueda.equals(vpr.rBuqueda)){
                List<Object[]> lista = new ArrayList<Object[]>();
                List<Producto> productos = modelo.listProductos(busqueda);
                for(Producto c: productos){
                Object[] ob = new Object[3];
                ob[0] = c.getId();
                ob[1] = c.getNombre();
                ob[2] = c.getPrecio();
                lista.add(ob);
            }
        vpr.mtp.setDatos(lista);
        vpr.productos.updateUI();
        
                }else{
                    JOptionPane.showMessageDialog(vpr,"Campo vacio, ingresa un nombre");
                }
        break;
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
                    
                }else{
                    JOptionPane.showMessageDialog(vpr,"Se requiere seleccionar una columna");
               }
                break;
            case "guardar":
                //System.out.println("Chale no tengo nombre: "+p.getNombre()+"F");
                try{
                if(vpr.precioN.getText() != ""){
                    double d = Double.parseDouble(vpr.precioN.getText());
                    int id = Integer.parseInt(vpr.selI.getText());
                    String s = vpr.selN.getText();
                    boolean act = modelo.updateProducto(new Producto(id,s,d));
                    System.out.println(act);
                    //if(!modelo.updateCliente(new Producto(id,s,d))){
                      //  JOptionPane.showMessageDialog(vpr,"Ha ocurrido un error");
                    //}
                vpr.precioN.setText("");
                vpr.selP.setText("");
               //vpr.principal2.add(vpr.vacio());
               vpr.principal2.removeAll();
               vpr.principal.updateUI();
               cargarTabla();
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
                vpr.precioN.setText("");
                vpr.modificar.setEnabled(true);
                vpr.principal2.removeAll();;
                vpr.principal2.updateUI();
                vpr.principal2.add(vpr.panelAgregar());
                vpr.principal2.updateUI();
                vpr.agregar.setEnabled(false);
            break;    
            case "aceptar":
                String nombre = vpr.nombre.getText();
                if(validaNombre(nombre)){
                    int id = Integer.parseInt(vpr.id.getText());
                    double precio = Double.parseDouble(vpr.precioN.getText());
                    boolean inst = modelo.insertProducto(new Producto(id,nombre,precio));
                    if(!inst){
                        JOptionPane.showMessageDialog(vpr,"Error Desconocido");
                        
                    }
                }else{
                    JOptionPane.showMessageDialog(vpr,"Error nombre no valido");
                    vpr.nombre.setText("");
                
                }
                cargarTabla();
                vpr.productos.updateUI();
                vpr.id.setText("");
                vpr.nombre.setText("");
                vpr.precioN.setText("");
                break;
                
                
            case "eliminar":
                x = vpr.productos.getSelectedRow();
                if(x != -1){
                int ele = JOptionPane.showConfirmDialog(vpr,"¿Quieres eliminar el producto :"+vpr.productos.getValueAt(x,1)+"?");
                int d = (Integer)vpr.productos.getValueAt(x,0);
                if(validaEliminacion(d)){
                    if(ele == JOptionPane.YES_OPTION){
                        boolean del = modelo.deleteProducto(d);
                         if(!del){
                        JOptionPane.showMessageDialog(vpr,"Error Desconocido");
                        }
                }
                    }else{
                        JOptionPane.showMessageDialog(vpr,"Este producto no se puede eliminar ya que esta ligado a una impresora");
                    }
                }else{
                    JOptionPane.showMessageDialog(vpr,"Se requiere seleccionar una columna");
                    
                  }
                    
                    
            
                cargarTabla();
                vpr.productos.updateUI();
                
                
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char k = e.getKeyChar();
       JTextField productor = (JTextField) e.getSource();
        if(productor == (JTextField)vpr.busqueda){
            if(vpr.busqueda.getSelectedText() != null)
               vpr.busqueda.setText("");
        }
        
        if(productor == (JTextField)vpr.id){
            if(!Character.isDigit(k)){
                e.consume();
            }
        }
        
        if(productor == (JTextField)vpr.precioN){
            if(vpr.precioN.getSelectedText() != null)
                vpr.precioN.setText("");
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
    
}
