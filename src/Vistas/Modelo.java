/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Login.Usuario;
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
       // System.out.println("Conectado a "+baseDatos);
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
    
     public boolean insertProducto(Producto c){
        //Objeto para ejecutar las instrucciones en la base de datos
        PreparedStatement ps;
        String sqlInsertCliente = "insert into productos values (?,?,?);";
        try{
            //Preparar la instrucción
            ps  = getConexion().prepareStatement(sqlInsertCliente);
            //Indicar qué información se pasa al Statement
            ps.setInt(1, c.getId());
            ps.setString(2, c.getNombre());
            ps.setDouble(3, c.getPrecio());
            
            //Ejecutar el comando insert
            ps.executeUpdate();
            return true;
        }catch (SQLException e) {
            //System.err.println("Error en la INSERCIÓN " + e );
            return false;
        }
    }
    
public boolean updateProducto(Producto c){
        //Objeto para ejecutar los procedimientos almacenados en la base de datos
        PreparedStatement ps;
        String sqlUpdateCliente = "update productos set precio = (?) where id_producto = (?);";
        try{
            //Preparar la llamada
            ps  = getConexion().prepareStatement(sqlUpdateCliente);
                
            //Indicar qué información se pasa al procedimiento
            ps.setDouble(1, c.getPrecio());
            ps.setInt(2, c.getId());
            
            //Ejecutar el procedimiento
            ps.executeUpdate();
            //System.out.println(this.view.dtm.getValueAt(filaPulsada, 0));
            return true;
        }catch (SQLException e) {
            //System.err.println("Error en la MODIFICACION");
            return false;
        }
    }

public boolean deleteProducto(int p){
        //Objeto para ejecutar los procedimientos almacenados en la base de datos
        PreparedStatement ps;
        String sqlUpdateCliente = "DELETE FROM productos WHERE id_producto = "+p+";";
        try{
            //Preparar la llamada
            ps  = getConexion().prepareStatement(sqlUpdateCliente);
                
            //Ejecutar el procedimiento
            ps.executeUpdate();
            //System.out.println(this.view.dtm.getValueAt(filaPulsada, 0));
            return true;
        }catch (SQLException e) {
            //System.err.println("Error en la MODIFICACION");
            return false;
        }
    }

     
         
    public void closeConexion(){
           // verifica que la conexión esté activa
        if ( getConexion() != null){
            try {
                getConexion().close();
                //System.out.println("Conexion Cerrada");
            } catch(SQLException e){
                System.err.println("Error al cerrar la bd "+ e);
            }
        }
    } 


public List<Object[]> listVentas(String busqueda){
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos
        ResultSet rs;

        //Obtener datos de todos los clientes
        String consultaSQL = "SELECT * FROM ventas WHERE fecha = '"+busqueda+"';";
        // Objeto List que contendrá todos los clientes
        List<Object [] > ventas = new ArrayList<Object[]>();
        try {
            //Preparar el statement con la consulta SQL
            ps  = getConexion().prepareStatement(consultaSQL);
                      
            //Ejecutarla y obtiene en rs el resultado
            rs  = ps.executeQuery();
            
            //Recorrer el resultado para crear instancias de Cliente
            while(rs.next()){
                Object [] o = new Object[3];
                o[0] =  rs.getInt(1);
                o[1] = rs.getString(2);
                o[2] =  rs.getDouble(3);
                ventas.add(o);
            }
 
        } catch (SQLException e) {
            System.err.println("Error al CARGAR DATOS " + e);
        }
        return ventas;
    }

public List<Object[]> listVentas(){
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos
        ResultSet rs;

        //Obtener datos de todos los clientes
        String consultaSQL = "SELECT * FROM ventas;";
        // Objeto List que contendrá todos los clientes
        List<Object [] > ventas = new ArrayList<Object[]>();
        try {
            //Preparar el statement con la consulta SQL
            ps  = getConexion().prepareStatement(consultaSQL);
                      
            //Ejecutarla y obtiene en rs el resultado
            rs  = ps.executeQuery();
            
            //Recorrer el resultado para crear instancias de Cliente
            while(rs.next()){
                Object [] o = new Object[3];
                o[0] =  rs.getInt(1);
                o[1] = rs.getString(2);
                o[2] =  rs.getDouble(3);
                ventas.add(o);
            }
 
        } catch (SQLException e) {
            System.err.println("Error al CARGAR DATOS " + e);
        }
        return ventas;
    }





public String ticket(int id){
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos
        ResultSet rs;

        //Obtener datos de todos los clientes
        String consultaSQL = "SELECT ticket FROM ventas WHERE id = "+id+";";
       String s = "";        
// Objeto List que contendrá todos los clientes
        List<Object [] > ventas = new ArrayList<Object[]>();
        try {
            //Preparar el statement con la consulta SQL
            ps  = getConexion().prepareStatement(consultaSQL);
                      
            //Ejecutarla y obtiene en rs el resultado
            rs  = ps.executeQuery();
            s = "";
            //Recorrer el resultado para crear instancias de Cliente
            while(rs.next()){
                s = rs.getString(1);
            }
 
        } catch (SQLException e) {
            System.err.println("Error al CARGAR DATOS " + e);
        }
        return s;
    }    






    public boolean insertVenta(Object [] o){
        //Objeto para ejecutar las instrucciones en la base de datos
        PreparedStatement ps;
        String sqlInsertCliente = "insert into ventas (fecha,monto,ticket) values (?,?,?);";
        try{
            //Preparar la instrucción
            ps  = getConexion().prepareStatement(sqlInsertCliente);
            //Indicar qué información se pasa al Statement
            ps.setString(1,(String)o[0]);
            ps.setDouble(2, (Double)o[1]);
            ps.setString(3,(String)o[2]);
            
            //Ejecutar el comando insert
            ps.executeUpdate();
            return true;
        }catch (SQLException e) {
            System.err.println("Error en la INSERCIÓN " + e );
            return false;
        }
    }  
    
    public boolean login(Usuario usr){
        PreparedStatement ps;
        ResultSet rs;
        String consultaSQL = "SELECT * FROM usuarios WHERE nombre = '"+usr.getNombre()+"';";
        // Objeto List que contendrá todos los clientes
        List<Producto> Productos = new ArrayList<Producto>();
        try {
            //Preparar el statement con la consulta SQL
            ps  = getConexion().prepareStatement(consultaSQL);
            rs  = ps.executeQuery();
            if(rs.next()){
                if(rs.getString(3).equals(usr.getPass()) && rs.getString(2).equals(usr.getNombre())){
                usr.setCorreo(rs.getString(4));
                usr.setId(rs.getInt(1));
                return true;
                }else{
                   return false;
            }
            }
 
        } catch (SQLException e) {
            System.err.println("Error al CARGAR DATOS " + e);
            return false;
        }
     return false;   
    }
    
    
    
    public boolean insertUsuario(Usuario usr){
        //Objeto para ejecutar las instrucciones en la base de datos
        PreparedStatement ps;
        String sqlInsertCliente = "insert into usuarios (nombre,contrasenia,correo) values (?,?,?);";
        try{
            //Preparar la instrucción
            ps  = getConexion().prepareStatement(sqlInsertCliente);
            //Indicar qué información se pasa al Statement
            ps.setString(1, usr.getNombre());
            ps.setString(2, usr.getPass());
            ps.setString(3, usr.getCorreo());
           // System.out.println("usuario agregado");
            //Ejecutar el comando insert
            ps.executeUpdate();
            return true;
        }catch (SQLException e) {
            //System.err.println("Error en la INSERCIÓN " + e );
            return false;
        }
    }
    
    
    
    
    
    
    private Connection getConexion() {
        return conexion;
    }
    
}
