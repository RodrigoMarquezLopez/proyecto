/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Vistas.Producto;

/**
 *
 * @author rodri
 */
public class Impresion extends Producto{
    private int numEquipo;
    //private boolean color;
    
    public Impresion(int id , String nombre, double precio, int numEquipo){
        super(id, nombre, precio);
        this.numEquipo = numEquipo;
        //this.color = color;
    }
    
    public int getEquipo(){
        return numEquipo;
    }
    
    
    
}
