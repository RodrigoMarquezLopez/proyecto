/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Vistas.Modelo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author rodri
 */
public class ControladorCrearUsr implements ActionListener,KeyListener{

    private VentanaCrearUsr vcu;
    private Modelo modelo;

    public ControladorCrearUsr(VentanaCrearUsr vcu, Modelo modelo){
        this.vcu = vcu;
        this.modelo = modelo;
    }
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "aceptar":
                if(!vcu.nombre.getText().equals("") && !new String(vcu.cont.getPassword()).equals("") && 
                   !new String(vcu.cont1.getPassword()).equals("") && !vcu.correo.getText().equals("")){
                        
                        if(new String(vcu.cont.getPassword()).equals(new String(vcu.cont1.getPassword()))){
                            int i = JOptionPane.showConfirmDialog(vcu,"¿La informacion es correcta?");
                                if(i == JOptionPane.YES_OPTION){
                                    String p = Hash.md5(new String(vcu.cont1.getPassword()));
                                    String name = vcu.nombre.getText();
                                    String email = vcu.correo.getText();
                                    Usuario usr = new Usuario(name,p);
                                    usr.setCorreo(email);
                                    boolean ag = modelo.insertUsuario(usr);
                                    if(ag){
                                        vcu.dispose();
                                    }else{
                                        JOptionPane.showMessageDialog(vcu,"Ha ocurrido un error vuelve a intentarlo");
                                        vcu.nombre.setText("");
                                        vcu.cont.setText("");
                                        vcu.cont1.setText("");
                                        vcu.correo.setText("");
                                    }
                               }else{
                                    vcu.nombre.setText("");
                                    vcu.cont.setText("");
                                    vcu.cont1.setText("");
                                    vcu.correo.setText("");
                                    
                                }
                        
                        }else{
                            JOptionPane.showMessageDialog(vcu,"Las contraseñas no coinciden");
                            vcu.cont.setText("");
                            vcu.cont1.setText("");
                        
                        }
              }else{
                
                    JOptionPane.showMessageDialog(vcu,"¡Faltan Datos!");
                }
                
        }
        
    
    
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char k = e.getKeyChar();
        JTextField productor = (JTextField) e.getSource();
       
        if(productor == (JTextField)vcu.nombre){
            if(vcu.nombre.getSelectedText() != null)
                vcu.nombre.setText("");
            if(k == ' '){
               e.consume();
            }
        }
    
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
     }

    @Override
    public void keyReleased(KeyEvent e) {
     }
    
}
