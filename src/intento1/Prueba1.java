/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
JFrame ventana = new JFrame();
        JScrollPane sc;
        ModeloTablaProductos mtp = new ModeloTablaProductos();
         
        
        List<Object[]> lista = new ArrayList<Object[]>();
        lista.add(new Object[]{a.getNombre(),a.getPrecio()});
        lista.add(new Object[]{b.getNombre(),b.getPrecio()});
        mtp.setDatos(lista);
        JTable tabla = new JTable(mtp);
        sc = new  JScrollPane(tabla);
       
        sc.setPreferredSize(new Dimension(500,500));
        ventana.setLayout(new FlowLayout());
        ventana.add(sc);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        ventana.pack();
        
        
        
        Cuenta c3 = new Cuenta();
        
        mtp.setDatos(lista);
        
        c3.agregarProducto(a,1);
        c3.agregarProducto(b,1);
        c3.agregarProducto(c,10);
         c3.agregarProducto(d,2);
        
        System.out.println(c3);


 */
package intento1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author rodri
 */
public class Prueba1 {
    public static void main(String[] args){
       VistaVentaSimple vi = new VistaVentaSimple(new Cuenta()); 
       ControladorVentaSimple c = new ControladorVentaSimple(vi);
       vi.conectaControlador(c);
    }
}
