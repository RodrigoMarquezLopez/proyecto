/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;


import componentesproyecto.BotonPersonalizado;
import componentesproyecto.Tabla;
import componentesproyecto.Titulo;
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
    private   JScrollPane s;
    private   JScrollPane s1;
    protected JLabel usr;
    protected JLabel totalC;
    protected JLabel totalB;
    protected BotonPersonalizado ventaN;
    protected BotonPersonalizado confgP;
    
    public  VistaPrincipal(){
        JTabbedPane panelPrincipal = new JTabbedPane();
        
        panelEquipos = new JPanel();
        panelImpresoras = new JPanel();
        panelPrincipal.add(panelEquipos);
        panelPrincipal.add(panelImpresoras);
        panelPrincipal.setTitleAt(0,"Renta Equipo");
        panelPrincipal.setTitleAt(1,"Estado Impresoras");
        add(panelPrincipal);
        
         panelEquipos.setLayout(new BorderLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panelEquipos.setBackground(new Color(33, 45, 62, 255));
        modeloE = new DefaultTableModel(columnas,0);
        tablaEquipos = new Tabla(modeloE);
        tablaEquipos.setRowHeight(100);
        JScrollPane sp = new JScrollPane(tablaEquipos);
        sp.setPreferredSize(new Dimension(900,500));
        usr = new JLabel("Raaaaaaaaaaaamon");
        usr.setOpaque(false);
        usr.setIcon(new ImageIcon("src/imagenes/usuario.png"));
        usr.setFont(new Font("Arial",Font.BOLD,16));
        usr.setForeground(Color.WHITE);
        usr.setHorizontalAlignment(SwingConstants.LEFT);
        
        totalB = new JLabel("Total de Hojas Impresas");
        totalB.setFont(new Font("Arial",Font.BOLD,16));
        totalB.setForeground(Color.WHITE);
        
        totalC = new JLabel("Total de Hojas Impresas");
        totalC.setFont(new Font("Arial",Font.BOLD,16));
        totalC.setForeground(Color.WHITE);
        
        renta = new BotonPersonalizado();
        renta.setText("RENTAR");
        renta.setIcon(new ImageIcon("src/imagenes/renta.png"));
        detener = new BotonPersonalizado();
        detener.setText("DETENER");
        ventaN = new BotonPersonalizado();
        ventaN.setText("VENDER");
        confgP = new BotonPersonalizado();
        confgP.setText("CONFIGURACION PRODUCTOS");
        
        JPanel top = new JPanel();
        top.setLayout(new FlowLayout());
        JLabel lg = new JLabel(new ImageIcon("src/imagenes/logo.png"));
        Titulo titulo = new Titulo(" SIMULADOR DE CIBER");
        top.setOpaque(false);
        top.add(lg);
        top.add(titulo);
        
        JPanel centro = new JPanel();
        centro.setOpaque(false);
        centro.setLayout(new GridBagLayout());
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.NONE;
        centro.add(ventaN,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.NONE;
        centro.add(usr,gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.NONE;
        centro.add(confgP,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.gridheight = 4;
        gbc.fill = GridBagConstraints.REMAINDER;
        centro.add(sp,gbc);
        
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.CENTER;
        JPanel der = new JPanel();
        FlowLayout fl = new FlowLayout(FlowLayout.RIGHT);
        fl.setHgap(50);
        fl.setVgap(200);
        
        der.setLayout(fl);
        der.setOpaque(false);
        renta.setHorizontalAlignment(SwingConstants.CENTER);
        der.add(renta,BorderLayout.NORTH);
        der.add(detener,BorderLayout.SOUTH);
        centro.add(der,gbc);
        
        
        
        
        panelEquipos.add(top,BorderLayout.NORTH);
        panelEquipos.add(centro,BorderLayout.CENTER);
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
        this.setSize(1350,950);
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
        ventaN.setActionCommand("vender");
        ventaN.addActionListener(c);
    }
    
    public static void main(String[] args) {
        VistaPrincipal vp = new VistaPrincipal();
        Controlador c = new Controlador(vp);
        vp.conectControlador(c);
    }
    
       
    
    

    
}
