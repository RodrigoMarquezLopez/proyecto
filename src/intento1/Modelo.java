/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intento1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodri
 */
public class Modelo {
    private String  host     = "localhost";
    private String  usuario     = "root";
    private String  clave       = "387410";
    private int     puerto      = 3306;
    private String  servidor    = "";
    private String baseDatos;
    private static Connection conexion  = null;
    
    public Modelo(String baseDatos){
        this.baseDatos = baseDatos;
        ConexionBaseDatos();
    }
    
    private void ConexionBaseDatos(){
        this.servidor="jdbc:mysql://"+host+":"+ puerto+"/"+baseDatos;
 
        //Registrar el driver
        try {            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR AL REGISTRAR EL DRIVER "+ e);
            System.exit(0); //parar la ejecución
        }
 
        //Establecer la conexión con el servidor
        try {
            conexion = DriverManager.getConnection(this.servidor,
                        this.usuario, this.clave);
        } catch (SQLException e) {
            System.err.println("ERROR AL CONECTAR CON EL SERVIDOR");
            System.exit(0); //parar la ejecución
        }
        System.out.println("Conectado a "+baseDatos);
    }
    
    public List<Producto> listProductos(){
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos
        ResultSet rs;

        //Obtener datos de todos los clientes
        String consultaSQL = "SELECT * FROM productos;";
        // Objeto List que contendrá todos los clientes
        List<Producto> Productos = new ArrayList<Producto>();
        try {
            //Preparar el statement con la consulta SQL
            ps  = getConexion().prepareStatement(consultaSQL);
                      
            //Ejecutarla y obtiene en rs el resultado
            rs  = ps.executeQuery();
            
            //Recorrer el resultado para crear instancias de Cliente
            while(rs.next()){
                Producto p = new Producto(rs.getInt("id_producto"),rs.getString("nombre"),rs.getDouble("precio"));
                //Añadir registro a registro en el vector
                
                // agregar a la lista cada uno de los clientes
                Productos.add(p);
            }
 
        } catch (SQLException e) {
            System.err.println("Error al CARGAR DATOS " + e);
        }
        return Productos;
    }
    
    public List<Object[]> listEquipos(){
    PreparedStatement ps;
        //Objeto para recoger los datos devueltos
        ResultSet rs;

        //Obtener datos de todos los clientes
        String consultaSQL = "SELECT * FROM dispositivos;";
        // Objeto List que contendrá todos los clientes
        List<Object[]> equipos = new ArrayList<Object[]>();
        try {
            //Preparar el statement con la consulta SQL
            ps  = getConexion().prepareStatement(consultaSQL);
                      
            //Ejecutarla y obtiene en rs el resultado
            rs  = ps.executeQuery();
            
            //Recorrer el resultado para crear instancias de Cliente
            while(rs.next()){
              Object [] o = new Object[3];
              o[0] = rs.getInt(1);
              o[1] = rs.getString(2);
              o[2] = rs.getDouble(3);
                //Añadir registro a registro en el vector
                
                // agregar a la lista cada uno de los clientes
                equipos.add(o);
            }
 
        } catch (SQLException e) {
            System.err.println("Error al CARGAR DATOS " + e);
        }
        return equipos;
    
    
    }
    
    public List<Producto> listProductos(String busqueda){
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos
        ResultSet rs;

        //Obtener datos de todos los clientes
        String consultaSQL = "SELECT * FROM productos WHERE nombre LIKE '"+busqueda+"%';";
        // Objeto List que contendrá todos los clientes
        List<Producto> Productos = new ArrayList<Producto>();
        try {
            //Preparar el statement con la consulta SQL
            ps  = getConexion().prepareStatement(consultaSQL);
                      
            //Ejecutarla y obtiene en rs el resultado
            rs  = ps.executeQuery();
            
            //Recorrer el resultado para crear instancias de Cliente
            while(rs.next()){
                Producto p = new Producto(rs.getInt("id_producto"),rs.getString("nombre"),rs.getDouble("precio"));
                //Añadir registro a registro en el vector
                
                // agregar a la lista cada uno de los clientes
                Productos.add(p);
            }
 
        } catch (SQLException e) {
            System.err.println("Error al CARGAR DATOS " + e);
        }
        return Productos;
    }
    
    
    private Connection getConexion() {
        return conexion;
    }
    
}
