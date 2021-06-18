/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

import intento1.ControladorProductos;
import intento1.ControladorVentaSimple;
import intento1.Cuenta;
import intento1.Modelo;
import intento1.Producto;
import intento1.VentanaProductos;
import intento1.VistaVentaSimple;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

/**
 *
 * @author rodri
 */
public class Controlador implements ActionListener,WindowListener{
    private Modelo modelo;
    private VistaPrincipal vp;
    private ColaImpresiones cola1;
    private ColaImpresiones cola2;
    private Double [] tarifas;
    protected Impresora im;
    protected Impresora im2;
    private Producto impresionColor;
    private Producto impresionBN;
    private ControladorVentaSimple contro;
    private ControladorProductos cproductos;

    
    public  Controlador(VistaPrincipal vp) {
        this.modelo = new Modelo("proyecto");
        this.vp = vp;
        cargarCostoImpresiones();
        cargarTablaEquipos();
        this.cola1 = new ColaImpresiones();
        this.cola2 = new ColaImpresiones();
        im = new Impresora(cola1,this.vp.modeloIBN,this.vp.totalbn,this.vp.barrabn,this.vp.equipo);
        im2 = new Impresora(cola2,this.vp.modeloColor,this.vp.totalcolor,this.vp.barracolor,this.vp.equipo2);
        im.setNombre("Blanco y Negro");
        im2.setNombre("Color");
        im.start();
        im2.start();
        
        //this.vp.colaBn.updateUI();
        //this.vp.colaColor.updateUI();
        
    }
    
    public void cargarTablaEquipos(){
        List<Object[]> lista = modelo.listEquipos();
        tarifas = new Double[lista.size()];
        for(int i = 0; i< lista.size(); i++){
            Object [] po = lista.get(i);
            Object [] ob = new Object[6];
            if(((String)po[1]).equalsIgnoreCase("computadora")){
            ob[0] = new JLabel(new ImageIcon("src/imagenes/computer.png"));
            }else if(((String)po[1]).equalsIgnoreCase("tableta")){
            ob[0] = new JLabel(new ImageIcon("src/imagenes/tableta.png"));     
            }
            ((JLabel)ob[0]).setText("Equipo: "+(Integer)po[0]);
            tarifas[i] = (Double)po[2];
            ob[1] = "Disponible";
            ob[2] = "0:0:0";
            ob[3] = 0.0;
            ob[4] = 0;
            ob[5] = 0;
            vp.modeloE.addRow(ob);
        }

    }
    
    public void cargarCostoImpresiones(){
        List<Producto> productos = modelo.listProductos("Impresion");
        for(int i = 0; i<productos.size(); i++){
            Producto p = productos.get(i);
            if(p.getNombre().equals("Impresiones color"))
                impresionColor = p;
            if(p.getNombre().equals("Impresiones B/N"))
                impresionBN = p;
        }
}

    

    @Override
    public void actionPerformed(ActionEvent e) {
        int r = vp.tablaEquipos.getSelectedRow();
        //if(r != -1)
        switch(e.getActionCommand()){
            case "iniciar":
                if(r != -1){
                cargarCostoImpresiones();
                if(vp.tablaEquipos.getValueAt(r,1).equals("Disponible")){
                Cronometro c1 = new Cronometro(cola1,cola2,r,2,vp.modeloE,tarifas[r]); 
                vp.modeloE.setValueAt("No Disponible",r,1);
                vp.detener.setEnabled(true);
                c1.start();
                }else if(vp.tablaEquipos.getValueAt(r,1).equals("No Disponible")){
                    JOptionPane.showMessageDialog(vp,"El equipo ya esta rentado");
                }
           }else if(r == -1){
                    JOptionPane.showMessageDialog(vp,"Selecciona un equipo");
                }
                
                break;
            
            case "detener":
                if(r != -1){
                    cargarCostoImpresiones();
                if(vp.tablaEquipos.getValueAt(r,1).equals("No Disponible")){
                    vp.modeloE.setValueAt("Disponible",r,1);
                    double cantidad = (Double)vp.tablaEquipos.getValueAt(r,3);
                    int bln = (Integer)vp.tablaEquipos.getValueAt(r,4);
                    int clr = (Integer)vp.tablaEquipos.getValueAt(r,5);
                    vp.modeloE.setValueAt(0.0, r,3);
                    vp.modeloE.setValueAt(0,r,4);
                    vp.modeloE.setValueAt(0,r,5);
                    impresionBN.setCantidad(bln);
                    impresionColor.setCantidad(clr);
                    Cuenta c = new Cuenta();
                    if(impresionBN.getCantidad() > 0)
                        c.agregarProducto(impresionBN, impresionBN.getCantidad());
                    if(impresionColor.getCantidad() > 0)
                        c.agregarProducto(impresionColor,impresionColor.getCantidad());
                    
                    cantidad = cantidad/tarifas[r];
                    int min = (int) cantidad;
                    c.agregarProducto(new Producto(0,"Renta de equipo",tarifas[r]),min);
                    VistaVentaSimple vi = new VistaVentaSimple(vp,c,vp.usuario); 
                    contro = new ControladorVentaSimple(vi,modelo);
                    vi.conectaControlador(contro);
                    vi.setModal(true);
                    vi.setVisible(true);
                    
                }else if(vp.tablaEquipos.getValueAt(r,1).equals("Disponible")){
                    JOptionPane.showMessageDialog(vp,"El equipo no se ha rentado");
                }
                }else{
                    JOptionPane.showMessageDialog(vp,"Selecciona un equipo");
                
                }
                
                break;
                
            case "vender":
                VistaVentaSimple vi = new VistaVentaSimple(vp,new Cuenta(),vp.usuario); 
                contro = new ControladorVentaSimple(vi,modelo);
                vi.conectaControlador(contro);
                vi.setModal(true);
                vi.setVisible(true);
                cargarCostoImpresiones();
                
                
                break;
            
            case "producto":
                VentanaProductos vpr = new VentanaProductos(vp);
                cproductos = new ControladorProductos(vpr,modelo);
                vpr.conectaControlador(cproductos);
                vpr.setModal(true);
                vpr.setVisible(true);
                cargarCostoImpresiones();
                break;
        
        }
    
    }
    

    
    public void confirmarSalida(){
        /**JLabel msg = new JLabel("¿Seguro que quiere salir?");
        msg.setBackground(new Color(33, 45, 62, 255));
        msg.setOpaque(true);
        msg.setForeground(Color.WHITE);
        msg.setFont(new Font("Arial",Font.BOLD,18));
        * **/
        int valor = JOptionPane.showConfirmDialog(vp,"¿Seguro que quiere salir?");
        if(valor == JOptionPane.YES_OPTION){
            modelo.closeConexion();
            System.exit(0);
        }
    }
    
    

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        confirmarSalida();
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
     }
    
    
    
   
    

    
}
