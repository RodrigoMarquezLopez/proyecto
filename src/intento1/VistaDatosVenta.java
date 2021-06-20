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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rodri
 */
public class VistaDatosVenta extends JDialog{
    
    protected Tabla ventas;
    protected DefaultTableModel modelo;
    protected final String [] columnas = {"Id","Monto Total"};
    protected final String [] años = {"2021","2020","2019","2018"};
    protected final String [] meses = {"12","11","10","09","08","07","06","05","04","03","02","01"};
    protected final String [] dias = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15",
                                     "16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    protected Spin año;
    protected Spin mes;
    protected Spin dia;
    protected JTextArea ticket;
    protected BotonPersonalizado buscar;
    protected BotonPersonalizado seleccionar;
   
    
    public VistaDatosVenta(JFrame f){
        super(f);
        JPanel principal = new JPanel();
        principal.setBackground(new Color(33, 45, 62, 255));
        principal.setLayout(new BorderLayout());
        modelo = new DefaultTableModel(columnas,0);
        ventas = new Tabla(modelo);
        ventas.setRowHeight(40);
        JScrollPane jsp = new JScrollPane(ventas);
        
        año = new Spin(2010,2021);
        mes = new Spin(01,12);
        dia = new Spin(01,31);
        
        año.setPreferredSize(new Dimension(100,50));
        mes.setPreferredSize(new Dimension(100,50));
        dia.setPreferredSize(new Dimension(100,50));
        buscar = new BotonPersonalizado();
        buscar.setText("Buscar");
        seleccionar = new BotonPersonalizado();
        seleccionar.setText("Seleccionar");
        ticket = new JTextArea();
        ticket.setFont(new Font("Arial",Font.BOLD,12));
        ticket.setPreferredSize(new Dimension(500,500));
        
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
                JLabel eti = new JLabel("Buscar         Año: ");
                eti.setForeground(Color.WHITE);
                eti.setFont(new Font("Arial",Font.BOLD,16));
                n1.add(eti);
                n1.add(año);
                JLabel eti1 = new JLabel(" Mes: ");
                eti1.setForeground(Color.WHITE);
                eti1.setFont(new Font("Arial",Font.BOLD,16));
                n1.add(eti1);
                n1.add(mes);
                JLabel eti2 = new JLabel("Dia: ");
                eti2.setForeground(Color.WHITE);
                eti2.setFont(new Font("Arial",Font.BOLD,16));
                n1.add(eti2);
                n1.add(dia);
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
}
    public void ConectaControlador(ControladorDatosVenta c){
        this.buscar.setActionCommand("buscar");
        this.buscar.addActionListener(c);
        this.seleccionar.setActionCommand("seleccionar");
        this.seleccionar.addActionListener(c);
   }
    
    
    
    
    public static void main(String[] args) {
        VistaDatosVenta vdv = new VistaDatosVenta(new JFrame());
        ControladorDatosVenta c = new ControladorDatosVenta(vdv,new Modelo("proyecto"));
        vdv.ConectaControlador(c);
    
    }
    
    
    
    
}
