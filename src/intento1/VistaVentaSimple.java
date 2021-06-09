/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intento1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author rodri
 */
public class VistaVentaSimple extends JDialog{
    protected JPanel        principal;
    protected JTable        tablaP;
    protected JTable        tablaC;
    protected JButton       agregar;
    protected JButton       eliminar;
    protected JTextField    busqueda;
    protected JSpinner      cantidad;
    protected JButton       buscar;
    protected JButton       confirmar;
    protected Cuenta        cuentaAs;
    protected JTextArea     cuent;
    protected ModeloTablaProductos  mtp;
    protected ModeloTProductosVenta mtv;
    protected JButton generaCuenta;
    protected final String rBuqueda = "Ingresa busqueda";
    
    public VistaVentaSimple(Cuenta as){
        cuentaAs = as;
        this.setLayout(new BorderLayout());
        JLabel titulo = new JLabel("Titulo mega mamalon");
        this.add(titulo,BorderLayout.NORTH);
        mtp = new ModeloTablaProductos();
        mtv = new ModeloTProductosVenta();
        JPanel principal = new JPanel();
        JPanel der = new JPanel();
        JPanel izq = new JPanel();
        JPanel cen = new JPanel();
        principal.setLayout(new GridLayout(0,3));
        tablaP = new JTable(mtp);
        tablaC = new JTable(mtv);
        JScrollPane jsp1 = new JScrollPane(tablaP);
        JScrollPane jsp2 = new JScrollPane(tablaC);
        
        jsp1.setPreferredSize(new Dimension(300,300));
        jsp2.setPreferredSize(new Dimension(300,300));
        
        izq.setLayout(new FlowLayout());
        der.setLayout(new FlowLayout());
        cen.setLayout(new FlowLayout());
        
        JLabel bq = new JLabel("Buscar:  ");
        busqueda = new JTextField(rBuqueda);
        buscar = new JButton("Buscar");
        
        izq.add(bq);
        izq.add(busqueda);
        izq.add(buscar);
        izq.add(jsp1);
        principal.add(izq,0);
        
       der.add(new JLabel("Cantidad :"));
       cantidad = new JSpinner();
       cantidad.setValue(1);
       der.add(cantidad);
       agregar = new JButton("Agregar");
       cuent= new JTextArea("");
       der.add(agregar);
       cuent.setPreferredSize(new Dimension(300,300));
       cen.add(new JLabel("Ticket"));
       cen.add(cuent);
       
       
       //principal.add(cen,2);
       
       eliminar = new JButton("Eliminar");
       generaCuenta = new JButton("Generar Cuenta");
       generaCuenta.setEnabled(false);
       der.add(eliminar);
       der.add(jsp2);
       
       der.add(generaCuenta);
       
       principal.add(der,1);
       principal.add(cen,2);
       
       this.add(principal,BorderLayout.CENTER);
       
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setPreferredSize(new Dimension(1000,500));
        this.setSize(700,700);
       this.pack();
        
        
    }
    
 
    
    
public void conectaControlador(  ControladorVentaSimple c  ){
 
        agregar.addActionListener(c);
        agregar.setActionCommand("agregar");
        eliminar.addActionListener(c);
        eliminar.setActionCommand("eliminar");
        buscar.addActionListener(c);
        buscar.setActionCommand("buscar");
        generaCuenta.addActionListener(c);
        generaCuenta.setActionCommand("cuenta");
        //sólo se permite pulsar una fila a la vez.
        //tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }    
    
    public JTable getTableP(){
        return this.tablaP;
    }
    
    public void setTable(JTable p){
        this.tablaP = p;
    }
    
    
    
            
}
