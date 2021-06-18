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
    protected JLabel totalbn;
    protected JLabel totalcolor;
    private   JScrollPane s;
    private   JScrollPane s1;
    protected JLabel usr;
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
        colaBn.setRowHeight(40);
        colaColor.setRowHeight(40);
        s = new JScrollPane(colaBn);
        s1 = new JScrollPane(colaColor);
        totalbn = new JLabel();
        totalcolor = new JLabel();
        panelImpresoras.setLayout(new BorderLayout());
        panelImpresoras.setBackground(new Color(33, 45, 62, 255));
        
        Titulo imTit = new Titulo();
        imTit.setText("INFORMACION IMPRESORAS");
        imTit.setHorizontalAlignment(SwingConstants.CENTER);
        panelImpresoras.add(imTit,BorderLayout.NORTH);
        JPanel panelSubIm = new JPanel();
        panelSubIm.setOpaque(false);
        panelSubIm.setLayout(new GridLayout(2,0));
        
        panelImpresoras.add(panelSubIm,BorderLayout.CENTER);
        JPanel z = new JPanel();
        z.setOpaque(false);
        z.setLayout(new FlowLayout());
        
        totalbn.setForeground(Color.WHITE);
        totalbn.setFont(new Font("Arial",Font.BOLD,25));
        totalcolor.setForeground(Color.WHITE);
        totalcolor.setFont(new Font("Arial",Font.BOLD,25));
        
        JLabel aux1 = new JLabel("Total Blanco y Negro : ");
        aux1.setForeground(Color.WHITE);
        aux1.setFont(new Font("Arial",Font.BOLD,25));
        JLabel aux2 = new JLabel("                           Total Color: ");
        aux2.setForeground(Color.WHITE);
        aux2.setFont(new Font("Arial",Font.BOLD,25));
        z.add(aux1);
        z.add(totalbn);
        z.add(aux2);
        z.add(totalcolor);
        
        JPanel w = new JPanel();
        w.setOpaque(false);
        JPanel y = new JPanel();
        y.setOpaque(false);
        
        panelImpresoras.add(z,BorderLayout.SOUTH);
        panelImpresoras.add(y,BorderLayout.WEST);
        panelImpresoras.add(y,BorderLayout.EAST);
        
        panelSubIm.add(formarPanelImpresora("src/imagenes/impresorabn.png",false),0);
        panelSubIm.add(formarPanelImpresora("src/imagenes/impresoracolor.png",true),1);
        //panelImpresoras.add(new Titulo("INFORMACION IMPRESORAS"),0);
        //panelImpresoras.add(formarPanelImpresora("src/imagenes/computer.png",false),1);
        //panelImpresoras.add(formarPanelImpresora("src/imagenes/computer.png",true),2);
        
        
        //this.setJMenuBar(barraOpc);
        this.setVisible(true);
        this.setSize(1350,950);
        this.setLocationRelativeTo(null);
        //this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
    
    }
    
    
    private JPanel formarPanelImpresora(String url,boolean color){
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        JLabel titulo = new JLabel();
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial",Font.BOLD,25));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        p.add(titulo,BorderLayout.NORTH);
        
        JPanel imp = new JPanel();
        imp.setOpaque(false);
        imp.setLayout(new FlowLayout());
        
        JLabel imagen = new JLabel(new ImageIcon(url));
        JLabel siguiente = new JLabel("Siguiente archivo en la cola : ");
        siguiente.setForeground(Color.WHITE);
        siguiente.setFont(new Font("Arial",Font.BOLD,16));
        imp.add(imagen);
    if(!color){
        titulo.setText("IMPRESORA BLANCO Y NEGRO");
        imp.add(barrabn);
        equipo.setForeground(Color.WHITE);
        equipo.setFont(new Font("Arial",Font.BOLD,16));
        JLabel qui = new JLabel("Imprimirendo equipo :");
        qui.setForeground(Color.WHITE);
        qui.setFont(new Font("Arial",Font.BOLD,16));
        imp.add(qui);
        imp.add(equipo);
        imp.add(siguiente);
        s.setPreferredSize(new Dimension(400,75));
        imp.add(s);
        
        
    }else{
        titulo.setText("IMPRESORA A COLOR");
        imp.add(barracolor);
        equipo2.setForeground(Color.WHITE);
        equipo2.setFont(new Font("Arial",Font.BOLD,16));
        JLabel qui = new JLabel("Imprimirendo equipo :");
        qui.setForeground(Color.WHITE);
        qui.setFont(new Font("Arial",Font.BOLD,16));
        imp.add(qui);
        imp.add(equipo2);
        imp.add(siguiente);
        s1.setPreferredSize(new Dimension(400,75));
        imp.add(s1);
    }
        
    
        p.add(imp,BorderLayout.CENTER);
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
        confgP.setActionCommand("producto");
        confgP.addActionListener(c);
    }
    
    public static void main(String[] args) {
        VistaPrincipal vp = new VistaPrincipal();
        Controlador c = new Controlador(vp);
        vp.conectControlador(c);
    }
    
       
    
    

    
}
