/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intento1;

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
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author rodri
 */
public class VistaVentaSimple extends JDialog{
    private String [] columnas = {"Equipo","Estado","Tiempo","Total de Uso","#Imp. B/N","#Imp Color"};
    private String [] columnasImp = {"Equipo","Cantidad de Hojas"};
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
    
    public VistaVentaSimple(JFrame f,Cuenta as){
        super(f);
        cuentaAs = as;
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
       
        JScrollPane jsp1 = new JScrollPane(tablaP);
        JScrollPane jsp2 = new JScrollPane(tablaC);
        jsp2.setBackground(Color.lightGray);
        jsp1.setPreferredSize(new Dimension(550,150));
        jsp2.setPreferredSize(new Dimension(550,150));
        
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
        
        izq.add(bq);
        izq.add(busqueda);
        izq.add(buscar);
       izq.add(jsp1);
       principal.add(izq,0);
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
       //cuent= new JTextArea("");
       der.add(agregar);
       eliminar = new BotonPersonalizado();
       eliminar.setText("ELIMINAR");
       eliminar.setEnabled(false);
       generaCuenta = new BotonPersonalizado();
       generaCuenta.setText("GENERAR CUENTA");
       generaCuenta.setEnabled(false);
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
       
       
       principal.add(der,1);
       principal.add(cen,2);
       this.add(sur,BorderLayout.SOUTH);
       this.add(principal,BorderLayout.CENTER);
       this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
       this.setSize(new Dimension(1200,700));
       this.setResizable(false);
       
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
