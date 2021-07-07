/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

/**
 *
 * @author rodri
 */
public class Usuario {
    private String nombre;
    private String pass;
    private int id;
    private String correo;
    
    public Usuario(String nombre, String pass, int id, String correo){
        this.nombre = nombre;
        this.pass = pass;
        this.id = id;
        this.correo = correo;
    }
    
    public Usuario(String nombre, String pass){
        this.nombre = nombre;
        this.pass = pass;
        this.id = -1;
        this.correo = "";
    }
    
    public String getNombre(){
        return nombre;
        
    }

    public String getPass(){
        return pass;
    }
    
    public String getCorreo(){
        return correo;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
            this.id = id;
    
    }
    public void setCorreo(String correo){
        this.correo = correo;
    }
    
    
}
