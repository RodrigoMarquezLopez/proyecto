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
public class Equipo {
    protected Cuenta cuenta;
    protected Producto renta;
    private String nombre;
    private double total;
    private String tiempo;
    protected String estado;
    
    public Equipo(String nombre){
       cuenta = new Cuenta();
       this.nombre = nombre;
       total = 0.0;
       estado = "Disponible";
    }
    
}
