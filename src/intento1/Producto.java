/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intento1;

/**
 *
 * @author rodri
 */
public class Producto {
   private int id;
   private String nombre;
   private double precio;
   private int cantidad;
  
   public Producto(int id,String nombre , double precio){
       this.id = id;
       this.nombre = nombre;
       this.precio = precio;
       this.cantidad = 1;
   
   }
   public String getNombre(){
      return this.nombre;
   }
  
  public double getPrecio(){
      return this.precio;
  }
  
  public void setCantidad(int cantidad){
        this.cantidad = cantidad;
  }
  
  public void setPrecio(double precio){
       this.precio = precio;
  
  }
  
  
  public int getCantidad(){
      return cantidad;
  }
  
  public int getId(){
      return this.id;
  }
   
}
