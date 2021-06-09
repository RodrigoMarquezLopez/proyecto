/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intento1;

import java.util.ArrayList;

/**
 *
 * @author rodri
 */
public class Cuenta{
    private double total;
    private ArrayList<Producto> contenido;
    private String encabezado;
   // private String hora;
    
    public Cuenta(){
        total = 0.0;
        contenido = new ArrayList<Producto>();
        encabezado = "Nombre Tienda\n"+
                      "Direccion";
       
    }
    
    public void agregarProducto(Producto a,int cantidad){
        Producto aux = a;
        aux.setCantidad(cantidad);
        contenido.add(a);
        total = total + a.getPrecio()*cantidad;
    }
    
    public void eliminarProducto(int a){
        Producto p1 = contenido.remove(a);
        total = total - (p1.getPrecio()*p1.getCantidad());
    }
    
    public String toString(){
        String s = "";
        s = encabezado+"\n";
        if(contenido.size()==0)
            return "";
        for(int i = 0; i < contenido.size();i++){
            s = s + contenido.get(i).getCantidad() + "   "+contenido.get(i).getNombre()+"      "+contenido.get(i).getPrecio()+"   "
                    +contenido.get(i).getCantidad()*contenido.get(i).getPrecio()+"\n";
        }
        s = s + "Total:     "+total;
        return s;
    
    }
    
    public double getTotal(){
        return total;
    }
    
    public ArrayList<Producto> getProductos(){
        return contenido;
    }
}
