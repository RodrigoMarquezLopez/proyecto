/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import componentesproyecto.BotonPersonalizado;
import componentesproyecto.CuadroTex;
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
public class VentanaProductos extends JDialog{
    protected JPanel principal;
    protected JPanel principal2;
    protected JScrollPane jsb;
    protected ModeloTablaProductos mtp;
    protected JLabel buscar;
    
    protected CuadroTex busqueda;
    protected CuadroTex id;
    protected CuadroTex nombre;
    protected CuadroTex precioN;
    
    protected JLabel selN;
    protected JLabel selI;
    protected JLabel selP;
    
    protected BotonPersonalizado find;
    protected BotonPersonalizado modificar;
    protected BotonPersonalizado eliminar;
    protected BotonPersonalizado agregar;
    
    protected BotonPersonalizado guardar;
    protected BotonPersonalizado aceptar;
    
    protected Tabla productos;
    protected final String rBuqueda = "Ingresa busqueda";
    
    
    
    
    public VentanaProductos(JFrame f){
        super(f);
        Color color = new Color(3, 45, 62, 255);
        principal = (JPanel) this.getContentPane();
        principal.setLayout(new GridLayout(2,0));
        principal.setBackground(color);
        
        mtp = new ModeloTablaProductos();
        productos = new Tabla(mtp);
        productos.setRowHeight(40);
        
        productos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumn columna = productos.getColumn("Id");
        columna.setPreferredWidth(100);
        columna.setMaxWidth(100);
        columna.setMinWidth(100);
        TableColumn columna1 = productos.getColumn("Nombre");
        TableColumn columna2 = productos.getColumn("Precio");
        columna1.setPreferredWidth(500);
        columna1.setMaxWidth(500);
        columna1.setMinWidth(500);
        columna2.setPreferredWidth(100);
        columna2.setMaxWidth(100);
        columna2.setMinWidth(100);




//Panel para la tabla y los botones de las acciones a realizar
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        top.setOpaque(false);
            JPanel arriba = new JPanel();
            arriba.setLayout(new FlowLayout());
            arriba.setOpaque(false);
            Titulo titulo = new Titulo();
            titulo.setText("PRODUCTOS");
            arriba.add(titulo);
            JLabel bq = new JLabel("Buscar:  ");
            bq.setForeground(Color.WHITE);
            bq.setFont(new Font("Arial",Font.BOLD,16));
            arriba.add(bq);
            busqueda = new CuadroTex();
            busqueda.setText(rBuqueda);
            arriba.add(busqueda);
            find = new BotonPersonalizado();
            find.setText("Buscar");
            find.setToolTipText("Busca un producto por nombre");
            arriba.add(find);
        top.add(arriba,BorderLayout.NORTH);
            jsb = new JScrollPane(productos);
            jsb.setOpaque(false);
            jsb.setPreferredSize(new Dimension(700,100));
        top.add(jsb,BorderLayout.CENTER);
            JPanel sur = new JPanel();
            sur.setLayout(new FlowLayout());
            sur.setOpaque(false);
            modificar = new BotonPersonalizado();
            modificar.setText("MODIFICAR PRECIO");
            modificar.setToolTipText("Modifica el precio del producto seleccionado");
            sur.add(modificar);
            agregar = new BotonPersonalizado();
            agregar.setText("AGREGAR");
            agregar.setToolTipText("Agregar un nuevo producto para el ciber");
            sur.add(agregar);
            eliminar = new BotonPersonalizado();
            eliminar.setText("ELIMINAR");
            eliminar.setToolTipText("Elimina un producto del ciber");
            sur.add(eliminar);
        top.add(sur,BorderLayout.SOUTH);
        JPanel borde = new JPanel();
        borde.setOpaque(false);
        JPanel borde1 = new JPanel();
        borde1.setOpaque(false);
        top.add(borde,BorderLayout.WEST);
        top.add(borde1,BorderLayout.EAST);
       principal.add(top,0);
       //Inicializan variables
       id = new CuadroTex();
       nombre = new CuadroTex();
       precioN = new CuadroTex();
       
       selI = new JLabel();
       selI.setForeground(Color.WHITE);
       selI.setFont(new Font("Arial",Font.BOLD,18));
       
       selP = new JLabel();
       selP.setForeground(Color.WHITE);
       selP.setFont(new Font("Arial",Font.BOLD,18));
       
       selN = new JLabel();
       selN.setForeground(Color.WHITE);
       selN.setFont(new Font("Arial",Font.BOLD,18));
       
       guardar = new BotonPersonalizado();
       guardar.setText("GUARDAR");
       guardar.setToolTipText("Guarda el cambio de precio");
       aceptar = new BotonPersonalizado();
       aceptar.setText("ACEPTAR");
       aceptar.setToolTipText("Agrega el nuevo producto");
       principal2 = new JPanel();
       principal2.setOpaque(false);
       principal.add(principal2,1);
       
       this.setSize(new Dimension(745,700));
       //this.setModal(true);
       
       this.setResizable(false);
       this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
       this.setTitle("Configuracion productos");
       this.setIconImage(f.getIconImage());
    
    
    }
    
    protected JPanel panelModificar(){
        JPanel princ = new JPanel();
        princ.setLayout(new BorderLayout());
        princ.setOpaque(false);
            JPanel titulos = new JPanel();
            titulos.setLayout(new BorderLayout());
            titulos.setOpaque(false);
            JLabel titulo = new JLabel("--- MODIFICAR ---");
            titulo.setHorizontalAlignment(SwingConstants.CENTER);
            titulo.setForeground(Color.WHITE);
            titulo.setFont(new Font("Arial",Font.BOLD,20));
            titulos.add(titulo,BorderLayout.NORTH);
                JPanel datosP = new JPanel();
                datosP.setOpaque(false);
                datosP.setLayout(new FlowLayout());
                
                JLabel idi = new JLabel(" ID :");
                    idi.setForeground(Color.WHITE);
                    idi.setFont(new Font("Arial",Font.BOLD,16));
                    datosP.add(idi);
                    datosP.add(selI);
                
                JLabel idn = new JLabel(" Nombre :");
                    idn.setForeground(Color.WHITE);
                    idn.setFont(new Font("Arial",Font.BOLD,16));
                    datosP.add(idn);
                    datosP.add(selN);
                
                JLabel idP = new JLabel(" Precio :");
                    idP.setForeground(Color.WHITE);
                    idP.setFont(new Font("Arial",Font.BOLD,16));
                    datosP.add(idP);
                    datosP.add(selP); 
                titulos.add(datosP,BorderLayout.CENTER);
                
        princ.add(titulos,BorderLayout.NORTH);
            JPanel datos = new JPanel();
            datos.setOpaque(false);
            datos.setLayout(new FlowLayout());
            JLabel precio = new JLabel("Nuevo Precio:  ");
            precio.setForeground(Color.WHITE);
            precio.setFont(new Font("Arial",Font.BOLD,16));
            datos.add(precio);
            datos.add(precioN);
            datos.add(guardar);
        princ.add(datos,BorderLayout.CENTER);
        return princ;
    }
    
    protected JPanel panelAgregar(){
        JPanel princ = new JPanel();
        princ.setLayout(new BorderLayout());
        princ.setOpaque(false);
            
            JLabel titulo = new JLabel( "--- AGREGAR PRODUCTO ---");
            titulo.setHorizontalAlignment(SwingConstants.CENTER);
            titulo.setForeground(Color.WHITE);
            titulo.setFont(new Font("Arial",Font.BOLD,20));
            princ.add(titulo,BorderLayout.NORTH);
            JPanel datos = new JPanel();
            datos.setOpaque(false);
            datos.setLayout(new GridLayout(4,0));
                JPanel idp = new JPanel();
                idp.setOpaque(false);
                idp.setLayout(new FlowLayout());
                JLabel idN = new JLabel("  ID del nuevo producto :");
                idN.setForeground(Color.WHITE);
                idN.setFont(new Font("Arial",Font.BOLD,16));
                idp.add(idN);
                idp.add(id);
            datos.add(idp,0);
                idp = new JPanel();
                idp.setOpaque(false);
                idp.setLayout(new FlowLayout());
                idN = new JLabel("Nombre del nuevo producto :");
                idN.setForeground(Color.WHITE);
                idN.setFont(new Font("Arial",Font.BOLD,16));
                idp.add(idN);
                idp.add(nombre);
            datos.add(idp,1);
                idp = new JPanel();
                idp.setOpaque(false);
                idp.setLayout(new FlowLayout());
                idN = new JLabel("Precio del nuevo producto :");
                idN.setForeground(Color.WHITE);
                idN.setFont(new Font("Arial",Font.BOLD,16));
                idp.add(idN);
                idp.add(precioN);
            datos.add(idp,2);
            datos.add(aceptar,3);
        JPanel borde = new JPanel();
        borde.setOpaque(false);
        JPanel borde1 = new JPanel();
        borde1.setOpaque(false);
        JPanel borde2 = new JPanel();
        borde2.setOpaque(false);
        princ.add(borde,BorderLayout.WEST);
        princ.add(borde1,BorderLayout.EAST);
        princ.add(borde2,BorderLayout.SOUTH);
        princ.add(datos,BorderLayout.CENTER);
        
        return princ;
                
    }
    
    protected JPanel vacio(){
        JPanel p = new JPanel();
        p.setOpaque(false);
        return p;
    }
    
    
    public void conectaControlador(ControladorProductos c){
        modificar.setActionCommand("modificar");
        modificar.addActionListener(c);
        guardar.setActionCommand("guardar");
        guardar.addActionListener(c);
        agregar.setActionCommand("agregar");
        agregar.addActionListener(c);
        find.setActionCommand("buscar");
        find.addActionListener(c);
        precioN.addKeyListener(c);
        id.addKeyListener(c);
        aceptar.setActionCommand("aceptar");
        aceptar.addActionListener(c);
        eliminar.setActionCommand("eliminar");
        eliminar.addActionListener(c);
    }
    
 

}
