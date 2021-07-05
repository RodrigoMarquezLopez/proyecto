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
import java.util.Calendar;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DateEditor;
import javax.swing.JTextArea;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;

/**
 *
 * @author rodri
 */
public class VistaDatosVenta extends JDialog{
    
    protected Tabla ventas;
    protected ModeloTablaDatosVentas modelo;


    
    protected Spin fecha;
    
    protected JTextArea ticket;
    protected BotonPersonalizado buscar;
    protected BotonPersonalizado seleccionar;
   
    
    public VistaDatosVenta(JFrame f){
        super(f);
        JPanel principal = new JPanel();
        principal.setBackground(new Color(33, 45, 62, 255));
        principal.setLayout(new BorderLayout());
        modelo = new ModeloTablaDatosVentas();
        ventas = new Tabla(modelo);
        ventas.setRowHeight(40);
        JScrollPane jsp = new JScrollPane(ventas);
        
        
        buscar = new BotonPersonalizado();
        buscar.setText("Buscar");
        buscar.setToolTipText("Busca una fecha");
        seleccionar = new BotonPersonalizado();
        seleccionar.setText("Seleccionar");
        seleccionar.setToolTipText("Selecciona una fecha");
        ticket = new JTextArea();
        ticket.setFont(new Font("Arial",Font.BOLD,12));
        ticket.setPreferredSize(new Dimension(390,500));
        
        JPanel norte = new JPanel();
        norte.setOpaque(false);
        norte.setLayout(new BorderLayout());
            Titulo datosV = new Titulo();
            datosV.setText("DATOS VENTAS");
            datosV.setHorizontalAlignment(SwingConstants.CENTER);
        norte.add(datosV,BorderLayout.CENTER);
                JPanel n1 = new JPanel();
                n1.setOpaque(false);
                n1.setLayout(new FlowLayout());
                JLabel eti = new JLabel("Buscar         :");
                eti.setForeground(Color.WHITE);
                eti.setFont(new Font("Arial",Font.BOLD,16));
                n1.add(eti);
                Date date = new Date();
                SpinnerDateModel sdm = new SpinnerDateModel(date,null,null,Calendar.YEAR);
                fecha = new Spin(sdm);
                DateEditor editor = new DateEditor(fecha,"yyyy-MM-dd");
                DateFormatter formatter = (DateFormatter)editor.getTextField().getFormatter();
                formatter.setAllowsInvalid(false); // this makes what you want
                formatter.setOverwriteMode(true);
                fecha.setEditor(editor);
                n1.add(fecha);
               n1.add(buscar);
                
        norte.add(n1,BorderLayout.SOUTH);
        principal.add(norte,BorderLayout.NORTH);
            
        JPanel centro = new JPanel();
        centro.setLayout(new GridLayout(2,0));
        centro.setOpaque(false);
            JPanel c1 = new JPanel();
            c1.setLayout(new BorderLayout());
            c1.setOpaque(false);
            c1.add(jsp,BorderLayout.CENTER);
                JPanel c1s = new JPanel();
                c1s.setOpaque(false);
                c1s.setLayout(new FlowLayout());
                c1s.add(seleccionar);
            c1.add(c1s,BorderLayout.SOUTH);
                JPanel c1w = new JPanel();
                c1w.setOpaque(false);
            c1.add(c1w,BorderLayout.WEST);
                JPanel c1e = new JPanel();
                c1e.setOpaque(false);
            c1.add(c1e,BorderLayout.EAST);
        centro.add(c1,0);
        principal.add(centro,BorderLayout.CENTER);
        JPanel sur = new JPanel();
        sur.setOpaque(false);
        sur.setLayout(new FlowLayout());
        sur.add(ticket);
        centro.add(sur,1);
        JPanel south = new JPanel();
        south.setOpaque(false);
        
        principal.add(south,BorderLayout.SOUTH);
        this.add(principal);
        
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setSize(700,800);
        this.setResizable(false);
        this.setTitle("Datos ventas");
        this.setIconImage(f.getIconImage());
}
    public void ConectaControlador(ControladorDatosVenta c){
        this.buscar.setActionCommand("buscar");
        this.buscar.addActionListener(c);
        this.seleccionar.setActionCommand("seleccionar");
        this.seleccionar.addActionListener(c);
   }
    
}
