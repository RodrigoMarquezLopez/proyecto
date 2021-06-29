/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;


import Inicio.Usuario;
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
    protected Usuario usuario;
    protected BotonPersonalizado ventaN;
    protected BotonPersonalizado confgP;
    protected BotonPersonalizado datosVentas;
    
    public  VistaPrincipal(Usuario usuario){
        JTabbedPane panelPrincipal = new JTabbedPane();
        this.usuario = usuario;
        panelEquipos = new JPanel();
        panelImpresoras = new JPanel();
        panelPrincipal.add(panelEquipos);
        panelPrincipal.add(panelImpresoras);
        panelPrincipal.setTitleAt(0,"Renta Equipo");
        panelPrincipal.setTitleAt(1,"Estado Impresoras");
        add(panelPrincipal);
        
        panelEquipos.setLayout(new BorderLayout());
        panelEquipos.setBackground(new Color(33, 45, 62, 255));
        modeloE = new DefaultTableModel(columnas,0);
        tablaEquipos = new Tabla(modeloE);
        tablaEquipos.setRowHeight(100);
        tablaEquipos.setToolTipText("Equipos a rentar");
        JScrollPane sp = new JScrollPane(tablaEquipos);
       // sp.setPreferredSize(new Dimension(900,500));
        
        
        usr = new JLabel("USUARIO :  "+this.usuario.getNombre());
        usr.setOpaque(false);
        usr.setIcon(new ImageIcon("src/imagenes/usuario.png"));
        usr.setFont(new Font("Arial",Font.BOLD,16));
        usr.setForeground(Color.WHITE);
        usr.setHorizontalAlignment(SwingConstants.LEFT);
        
        JPanel norte = new JPanel();
        norte.setLayout(new BorderLayout());
        norte.setOpaque(false);
        norte.add(usr,BorderLayout.NORTH);
        Titulo tituloEquipos = new Titulo();
        tituloEquipos.setIcon(new ImageIcon("src/imagenes/logo2.png"));
        tituloEquipos.setText("SIMULADOR DE CIBER");
        tituloEquipos.setHorizontalAlignment(SwingConstants.CENTER);
        norte.add(tituloEquipos,BorderLayout.CENTER);
        panelEquipos.add(norte,BorderLayout.NORTH);
        
        renta = new BotonPersonalizado();
        renta.setText("RENTAR");
        renta.setToolTipText("Rentar el equipo seleccionado");
        renta.setIcon(new ImageIcon("src/imagenes/renta.png"));
        detener = new BotonPersonalizado();
        detener.setText("DETENER");
        detener.setToolTipText("Detiene el tiempo para el equipo rentado y genera una cuenta");
        detener.setIcon(new ImageIcon("src/imagenes/detener.png"));
        ventaN = new BotonPersonalizado();
        ventaN.setText("VENDER");
        ventaN.setToolTipText("Vender un producto del ciber");
        ventaN.setIcon(new ImageIcon("src/imagenes/vender.png"));
        confgP = new BotonPersonalizado();
        confgP.setText("CONFIGURACION PRODUCTOS");
        confgP.setToolTipText("Permite ver la configuracion a los productos");
        confgP.setIcon(new ImageIcon("src/imagenes/config.png"));
        datosVentas = new BotonPersonalizado();
        datosVentas.setText("DATOS VENTAS");
        datosVentas.setIcon(new ImageIcon("src/imagenes/dVentas.png"));
        datosVentas.setToolTipText("Informacion de las ventas realizadas");
        
        
        
        JPanel centro = new JPanel();
        centro.setLayout(new BorderLayout());
        centro.setOpaque(false);
            JPanel tpc = new JPanel();
            tpc.setLayout(new FlowLayout());
            tpc.setOpaque(false);
            tpc.add(ventaN);
            JPanel b1 = new JPanel();
            b1.setOpaque(false);
            b1.setPreferredSize(new Dimension(100,100));
            tpc.add(b1);
            tpc.add(confgP);
            JPanel b2 = new JPanel();
            b2.setOpaque(false);
            b2.setPreferredSize(new Dimension(100,100));
            tpc.add(b2);
            tpc.add(datosVentas);
            
        centro.add(tpc,BorderLayout.NORTH);
        centro.add(sp,BorderLayout.CENTER);
        JPanel a1 = new JPanel();
        JPanel a2 = new JPanel();
        a1.setOpaque(false);
        a2.setOpaque(false);
        a2.setPreferredSize(new Dimension(150,150));
        a1.setPreferredSize(new Dimension(20,20));
        centro.add(a1,BorderLayout.EAST);
        //centro.add(a2,BorderLayout.WEST);
        JPanel cc = new JPanel();
            cc.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            cc.setOpaque(false);
            cc.add(renta,gbc);
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            JPanel a3 = new JPanel();
            a3.setPreferredSize(new Dimension(100,100));
            a3.setOpaque(false);
            cc.add(a3,gbc);
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            cc.add(detener,gbc);
            JPanel a4 = new JPanel();
            a4.setOpaque(false);
            a4.setPreferredSize(new Dimension(150,150));
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.gridwidth = 1;
            gbc.gridheight = 3;
            cc.add(a4,gbc);
        
       JPanel sur = new JPanel();
            sur.setOpaque(false);
            sur.setLayout(new BorderLayout());
        JLabel abc = new JLabel();
        abc.setIcon(new ImageIcon("src/imagenes/inferior.png"));
        abc.setFont(new Font("Arial Black",Font.ITALIC,20));
        abc.setText("Todos los derechos reservados. 2021");
        abc.setForeground(Color.WHITE);
        abc.setHorizontalAlignment(SwingConstants.CENTER);
        //abc.setVerticalAlignment(SwingConstants.);
        sur.add(abc,BorderLayout.CENTER);
        sur.setPreferredSize(new Dimension(200,200));
        panelEquipos.add(sur,BorderLayout.SOUTH);
        //centro.add(cc,BorderLayout.EAST);
        panelEquipos.add(centro,BorderLayout.CENTER);
        panelEquipos.add(cc,BorderLayout.EAST);
        panelEquipos.add(a2,BorderLayout.WEST);
        //
        barrabn = new JProgressBar();
        barracolor = new JProgressBar();
        equipo = new JLabel();
        equipo2 = new JLabel();
        modeloIBN = new DefaultTableModel(columnasImp,0);
        modeloColor = new DefaultTableModel(columnasImp,0);
        colaBn = new Tabla(modeloIBN);
        colaBn.setToolTipText("Documento siguiente a imprimir");
        colaColor = new Tabla(modeloColor);
        colaColor.setToolTipText("Documento siguiente a imprimir");
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
        //this.setVisible(true);
        this.setTitle("SIMULADOR CIBER");
        this.setIconImage(new ImageIcon("src/imagenes/cpu.png").getImage());
        this.setSize(1450,950);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        
    
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
        //JLabel qui = new JLabel("Imprimirendo equipo :");
        //qui.setForeground(Color.WHITE);
        //qui.setFont(new Font("Arial",Font.BOLD,16));
        //imp.add(qui);
        imp.add(equipo);
        imp.add(siguiente);
        s.setPreferredSize(new Dimension(400,75));
        imp.add(s);
        
        
    }else{
        titulo.setText("IMPRESORA A COLOR");
        imp.add(barracolor);
        equipo2.setForeground(Color.WHITE);
        equipo2.setFont(new Font("Arial",Font.BOLD,16));
        //JLabel qui = new JLabel("Imprimirendo equipo :");
        //qui.setForeground(Color.WHITE);
        //qui.setFont(new Font("Arial",Font.BOLD,16));
        //imp.add(qui);
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
        datosVentas.setActionCommand("dVentas");
        datosVentas.addActionListener(c);
        this.addWindowListener(c);
    }
    
    public static void main(String[] args) {
        //VistaPrincipal vp = new VistaPrincipal();
        //Controlador c = new Controlador(vp);
        //vp.conectControlador(c);
    }
    
       
    
    

    
}
