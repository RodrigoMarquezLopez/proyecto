/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

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
    protected JTable tablaEquipos;
    protected ModeloTablaEquipos modeloE;
    protected JButton renta;
    protected JButton detener;
    protected JMenuBar barraOpc;
    protected JMenu opciones;
    protected JMenuItem venta;
    
    public  VistaPrincipal(){
                this.setSize(820, 550);
        setUndecorated(true);
        setOpacity(1.0f);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 35, 35);
        setShape(forma);
        setOpacity(1.0f);
        //setLayout(new GridLayout(1, 1));
        //add(Logo());
        //add(Log());

        this.setResizable(false);
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
        modeloE = new ModeloTablaEquipos(columnas,0);
        tablaEquipos = new JTable(modeloE);
        //tablaEquipos.setPreferredSize(new Dimension(700,700));
        tablaEquipos.setDefaultRenderer(Object.class,new Render());
        JScrollPane panelT = new JScrollPane(tablaEquipos);
        //panelT.setPreferredSize(new Dimension(700,600));
        JPanel cen = new JPanel();
        cen.setLayout(new BorderLayout());
        cen.add(panelT,BorderLayout.CENTER);
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
    
     private class Render extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int roe, int column){
        if(value instanceof JButton){
            JButton btn = (JButton)value;
            return btn;
        }
        if(value instanceof JPanel){
            JPanel panel = (JPanel)value;
            return panel;
        }
            
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, roe, column);
    
    }
            }   
    
    

    
}
