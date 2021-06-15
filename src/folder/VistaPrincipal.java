/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

import ClasesComponentes.BotonPersonalizado;
import ClasesComponentes.Tabla;
import ClasesComponentes.Titulo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.MenuBar;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author rodri
 */
public class VistaPrincipal extends JFrame{
    private JPanel panelEquipos;
    private JPanel panelImpresoras;
    private String [] columnas = {"Equipo","Estado","Tiempo","Total de Uso","#Imp. B/N","#Imp Color"};
    private String [] columnasImp = {"Equipo","Cantidad de Hojas"};
    protected Tabla tablaEquipos;
    protected DefaultTableModel modeloE;
    protected DefaultTableModel modeloIBN;
    protected DefaultTableModel modeloColor;
    protected BotonPersonalizado renta;
    protected BotonPersonalizado detener;
    protected JMenuBar barraOpc;
    protected JMenu opciones;
    protected JMenuItem venta;
    protected Tabla colaBn;
    protected Tabla colaColor;
    protected JProgressBar barrabn;
    protected JProgressBar barracolor;
    protected JLabel equipo;
    protected JLabel equipo2;
    private JScrollPane s;
    private JScrollPane s1;
    
    public  VistaPrincipal(){
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
        panelPrincipal.setTitleAt(0,"Renta Equipo");
        panelPrincipal.setTitleAt(1,"Estado Impresoras");
        add(panelPrincipal);
        
        
        
        panelEquipos.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panelEquipos.setBackground(new Color(33, 45, 62, 255));
        modeloE = new DefaultTableModel(columnas,0);
        tablaEquipos = new Tabla(modeloE);
        tablaEquipos.setRowHeight(100);
        JScrollPane sp = new JScrollPane(tablaEquipos);
        //sp.setPreferredSize(tablaEquipos.getMaximumSize());
        renta = new BotonPersonalizado();
        renta.setText("RENTAR");
        detener = new BotonPersonalizado();
        detener.setText("DETENER");
        renta.setPreferredSize(new Dimension(150,100));
        detener.setPreferredSize(new Dimension(150,100));
       
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = 0.0;
        gbc.weightx = 0.0;
        gbc.fill = GridBagConstraints.NORTH;
        Titulo titulo = new Titulo("SIMULADOR DE CIBER");
        panelEquipos.add(titulo,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 3;
        gbc.weightx = 1.0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panelEquipos.add(sp,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.NONE;
        panelEquipos.add(renta,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.NONE;
        panelEquipos.add(detener,gbc);
        //
        barrabn = new JProgressBar();
        barracolor = new JProgressBar();
        equipo = new JLabel();
        equipo2 = new JLabel();
        modeloIBN = new DefaultTableModel(columnasImp,0);
        modeloColor = new DefaultTableModel(columnasImp,0);
        colaBn = new Tabla(modeloIBN);
        colaColor = new Tabla(modeloColor);
        s = new JScrollPane(colaBn);
        s1 = new JScrollPane(colaColor);
        panelImpresoras.setLayout(new GridLayout(3,0));
        panelImpresoras.setBackground(new Color(33, 45, 62, 255));
        
        
        
          panelImpresoras.add(new Titulo("INFORMACION IMPRESORAS"),0);
          panelImpresoras.add(formarPanelImpresora("src/imagenes/computer.png",false),1);
          panelImpresoras.add(formarPanelImpresora("src/imagenes/computer.png",true),2);
        
        
        //this.setJMenuBar(barraOpc);
        this.setVisible(true);
        this.setSize(new Dimension(800,800));
        this.setLocationRelativeTo(null);
        //this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
    
    }
    
    
    private JPanel formarPanelImpresora(String url,boolean color){
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        JLabel imagen = new JLabel(new ImageIcon(url));
        JLabel siguiente = new JLabel("Siguiente:");
        siguiente.setForeground(Color.WHITE);
        siguiente.setFont(new Font("Arial",Font.BOLD,16));
        p.add(imagen);
        if(!color){
        p.add(barrabn);
        equipo.setForeground(Color.WHITE);
        equipo.setFont(new Font("Arial",Font.BOLD,16));
        p.add(equipo);
        p.add(siguiente);
        s.setPreferredSize(new Dimension(300,50));
        p.add(s);
        }else{
        p.add(barracolor);
        equipo2.setForeground(Color.WHITE);
        equipo2.setFont(new Font("Arial",Font.BOLD,16));
        p.add(equipo2);
        p.add(siguiente);
        s1.setPreferredSize(new Dimension(300,50));
        p.add(s1);
        }
        p.setOpaque(false);
        return p;
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
