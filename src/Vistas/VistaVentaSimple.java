/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import componentesproyecto.BotonPersonalizado;
import componentesproyecto.CuadroTex;
import componentesproyecto.Spin;
import componentesproyecto.Tabla;
import componentesproyecto.Titulo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;

/**
 *
 * @author rodri
 */
public class VistaVentaSimple extends JDialog{
    
    protected JPanel        principal;
    protected Tabla        tablaP;
    protected Tabla       tablaC;
    protected BotonPersonalizado       agregar;
    protected BotonPersonalizado       eliminar;
    protected CuadroTex    busqueda;
    protected CuadroTex    recibido;
    protected JLabel       cambio;
    protected Spin      cantidad;
    protected BotonPersonalizado       buscar;
    protected BotonPersonalizado       confirmar;
    protected Cuenta        cuentaAs;
    //protected JTextArea     cuent;
    protected ModeloTablaProductos  mtp;
    protected ModeloTProductosVenta mtv;
    protected BotonPersonalizado generaCuenta;
    protected final String rBuqueda = "Ingresa busqueda";
    protected JLabel total;
    protected String usr;
    
    public VistaVentaSimple(JFrame f,Cuenta as,String usr){
        super(f);
        cuentaAs = as;
        this.usr = usr;
        this.setLayout(new BorderLayout());
        Titulo titulo = new Titulo("VENTA");
        titulo.setOpaque(false);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        this.getContentPane().setBackground(new Color(33, 45, 62, 255));
        this.add(titulo,BorderLayout.NORTH);
        mtp = new ModeloTablaProductos();
        mtv = new ModeloTProductosVenta();
        principal = new JPanel();
        principal.setOpaque(false);
        JPanel der = new JPanel();
        der.setOpaque(false);
        JPanel izq = new JPanel();
        izq.setOpaque(false);
        JPanel cen = new JPanel();
        cen.setOpaque(false);
        principal.setLayout(new GridLayout(0,2));
        //principal.setBackground(new Color(33, 45, 62, 255));
        tablaP = new Tabla(mtp);
        tablaP.setRowHeight(40);
        tablaC = new Tabla(mtv);
        tablaC.setRowHeight(40);
        tablaP.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        TableColumn columna = tablaP.getColumn("Id");
        columna.setPreferredWidth(100);
        columna.setMaxWidth(100);
        columna.setMinWidth(100);
        TableColumn columna1 = tablaP.getColumn("Nombre");
        TableColumn columna2 = tablaP.getColumn("Precio");
        columna1.setPreferredWidth(332);
        columna1.setMaxWidth(332);
        columna1.setMinWidth(332);
        columna2.setPreferredWidth(100);
        columna2.setMaxWidth(100);
        columna2.setMinWidth(100);
        
        tablaC.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumn columnaC1 = tablaC.getColumn("Cantidad");
        columnaC1.setPreferredWidth(100);
        columnaC1.setMaxWidth(100);
        columnaC1.setMinWidth(100);
        TableColumn columnaC2 = tablaC.getColumn("Nombre");
        TableColumn columnaC3 = tablaC.getColumn("Precio");
        columnaC2.setPreferredWidth(332);
        columnaC2.setMaxWidth(332);
        columnaC2.setMinWidth(332);
        columnaC3.setPreferredWidth(100);
        columnaC3.setMaxWidth(100);
        columnaC3.setMinWidth(100);
        
        
        
        
        
        
        
       
        JScrollPane jsp1 = new JScrollPane(tablaP);
        JScrollPane jsp2 = new JScrollPane(tablaC);
        jsp2.setBackground(Color.lightGray);
        jsp1.setPreferredSize(new Dimension(550,250));
        jsp2.setPreferredSize(new Dimension(550,250));
        
        izq.setLayout(new FlowLayout());
        der.setLayout(new FlowLayout());
        cen.setLayout(new FlowLayout());
        
        JLabel bq = new JLabel("Buscar:  ");
        bq.setForeground(Color.WHITE);
        bq.setFont(new Font("Arial",Font.BOLD,16));
        total = new JLabel("Total :  ");
        total.setForeground(Color.WHITE);
        total.setFont(new Font("Arial",Font.BOLD,16));
        busqueda = new CuadroTex();
        busqueda.setText(rBuqueda);
        buscar = new BotonPersonalizado();
        buscar.setText("BUSCAR");
        buscar.setToolTipText("Busca un producto por nombre");
        
        izq.add(bq);
        izq.add(busqueda);
        izq.add(buscar);
       izq.add(jsp1);
       principal.add(izq,0);
       //izq.setPreferredSize(new Dimension(1200,700));
       JLabel canad = new JLabel("Cantidad :");
       canad.setForeground(Color.WHITE);
       canad.setFont(new Font("Arial",Font.BOLD,16));
       der.add(canad);
       der.setForeground(Color.WHITE);
       der.setFont(new Font("Arial",Font.BOLD,16));
       cantidad = new Spin();
       cantidad.setValue(1);
       der.add(cantidad);
       agregar = new BotonPersonalizado();
       agregar.setText("AGREGAR");
       agregar.setToolTipText("Agrega el producto de acuerdo a la cantidad a la tabla");
       //cuent= new JTextArea("");
       der.add(agregar);
       eliminar = new BotonPersonalizado();
       eliminar.setText("ELIMINAR");
       eliminar.setEnabled(false);
       eliminar.setToolTipText("Elimina una fila de la tabla de compras");
       generaCuenta = new BotonPersonalizado();
       generaCuenta.setText("GENERAR CUENTA");
       generaCuenta.setEnabled(false);
       generaCuenta.setToolTipText("Genera la cuenta con los productos de la tabla compras");
       der.add(eliminar);
       der.add(jsp2);
       der.add(total);
       
       //this.add(generaCuenta,BorderLayout.SOUTH);
       JPanel sur = new JPanel();
       JPanel cal = new JPanel();
       cal.setLayout(new FlowLayout());
       cal.setOpaque(false);
       sur.setLayout(new BorderLayout());
       sur.setOpaque(false);
       JLabel re = new JLabel("Recibo :   ");
       re.setForeground(Color.WHITE);
       re.setFont(new Font("Arial",Font.BOLD,16));
       recibido = new CuadroTex();
       cambio = new JLabel("Cambio :    ");
       cambio.setForeground(Color.WHITE);
       cambio.setFont(new Font("Arial",Font.BOLD,16));
       cal.add(re);
       cal.add(recibido);
       cal.add(cambio);
       sur.add(cal,BorderLayout.NORTH);
       sur.add(generaCuenta,BorderLayout.SOUTH);
      /// sur.setPreferredSize(new Dimension(1200,100));
       
       principal.add(der,1);
      // principal.add(cen,2);
      // principal.setPreferredSize(new Dimension(1200,500));
       this.add(sur,BorderLayout.SOUTH);
       this.add(principal,BorderLayout.CENTER);
       this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
       this.setSize(new Dimension(1200,600));
       this.setTitle("Ventana de ventas");
      // this.setResizable(false);
       this.setIconImage(f.getIconImage());
       //this.setModal(true);
       //this.pack();
        
        
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
        recibido.addKeyListener(c);
        busqueda.addKeyListener(c);
        busqueda.addFocusListener(c);

    }    

    
    
    
            
}
