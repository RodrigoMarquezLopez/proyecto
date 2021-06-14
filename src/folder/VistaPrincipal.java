/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

import ClasesComponentes.Tabla;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.MenuBar;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rodri
 */
public class VistaPrincipal extends JFrame{
    private JPanel panelEquipos;
    private JPanel panelImpresoras;
    private String [] columnas = {"Equipo","Estado","Tiempo","Costo","Impresiones B/N","Impresiones Color"};
    private String [] columnasImp = {"Equipo","Cantidad de Hojas"};
    protected Tabla tablaEquipos;
    protected DefaultTableModel modeloE;
    protected DefaultTableModel modeloIBN;
    protected DefaultTableModel modeloColor;
    protected JButton renta;
    protected JButton detener;
    protected JMenuBar barraOpc;
    protected JMenu opciones;
    protected JMenuItem venta;
    protected Tabla colaBn;
    protected Tabla colaColor;
    
    public  VistaPrincipal(){
       // this.setSize(820, 550);
       //this.setBackground(new Color(15, 157, 167));
        
        //setLayout(new GridLayout(1, 1));
        //add(Logo());
        //add(Log());

        //this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JTabbedPane panelPrincipal = new JTabbedPane();
        
        barraOpc = new JMenuBar();
        opciones = new JMenu("Opciones");
        venta = new JMenuItem("Venta Nueva");
        barraOpc.add(venta);
        barraOpc.add(opciones);
        panelEquipos = new JPanel();
        panelImpresoras = new JPanel();
        panelPrincipal.add(panelEquipos);
        panelPrincipal.add(panelImpresoras);
        panelEquipos.setLayout(new BorderLayout());
        panelPrincipal.setTitleAt(0,"Renta Equipo");
        panelPrincipal.setTitleAt(1,"Estado Impresoras");
        add(panelPrincipal);
        
        //Panel Equipos
        modeloE = new DefaultTableModel(columnas,0);
        tablaEquipos = new Tabla(modeloE);
        //tablaEquipos.setModel(modeloE);
        //tablaEquipos.setPreferredSize(new Dimension(700,700));
        //tablaEquipos.setDefaultRenderer(Object.class,new Render());
        JScrollPane panelT = new JScrollPane(tablaEquipos);
        //panelT.setPreferredSize(new Dimension(700,600));
        JPanel cen = new JPanel();
        cen.setLayout(new BorderLayout());
        cen.add(panelT,BorderLayout.CENTER);
        cen.setBackground(new Color(15, 157, 167));
        panelEquipos.add(cen,BorderLayout.CENTER);
        JPanel der = new JPanel();
        der.setLayout(new FlowLayout());
        renta = new JButton("Rentar");
        detener = new JButton("Detener");
        detener.setEnabled(false);
        //renta.setPreferredSize(new Dimension(150,150));
        der.add(renta);
        der.add(detener);
        panelEquipos.add(der,BorderLayout.EAST);
        
        //Panel Impresoras
        //panelPrincipal.add(panelEquipos);
        //panelPrincipal.add(panelImpresoras);
        modeloIBN = new DefaultTableModel(columnasImp,0);
        modeloColor = new DefaultTableModel(columnasImp,0);
        panelImpresoras.setLayout(new GridLayout(2,0));
        colaBn = new Tabla(modeloIBN);
        colaColor = new Tabla(modeloIBN);
        JScrollPane s = new JScrollPane(colaBn);
        JScrollPane s1 = new JScrollPane(colaColor);
        
        panelImpresoras.add(s,0);
        panelImpresoras.add(s1,1);
        
        
        this.setJMenuBar(barraOpc);
        this.setVisible(true);
        this.setSize(new Dimension(700,700));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    
    }
    
    public void conectControlador(Controlador c){
        //tablaEquipos.addMouseListener(c);
        renta.setActionCommand("iniciar");
        renta.addActionListener(c);
        detener.setActionCommand("detener");
        detener.addActionListener(c);
    }
    
    public static void main(String[] args) {
        VistaPrincipal vp = new VistaPrincipal();
        Controlador c = new Controlador(vp);
        vp.conectControlador(c);
    }
    
       
    
    

    
}
