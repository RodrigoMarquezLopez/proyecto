/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Principal.Controlador;
import Principal.VistaPrincipal;
import Vistas.Modelo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author rodri
 */
public class ControladorLogin implements ActionListener, KeyListener {

    private Login log;
    private Modelo modelo;

    public ControladorLogin(Login log) {
        this.log = log;
        this.modelo = new Modelo("proyecto");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "ingresar":
                if (!log.txuser.getText().equals("")) {
                    Usuario usr = new Usuario(log.txuser.getText(), Hash.md5(new String(log.passwordField.getPassword())));
                    boolean aux = modelo.login(usr);
                    if (aux) {
                        System.out.println("Sobres entre");
                        System.out.println(usr.getId());
                        System.out.println(usr.getNombre());
                        System.out.println(usr.getCorreo());
                        VistaPrincipal vp = new VistaPrincipal(usr);
                        Controlador c = new Controlador(vp, modelo);
                        vp.conectControlador(c);
                        log.dispose();
                        vp.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(log, "Usuario o contraseña incorrectos");

                    }
                } else {
                    JOptionPane.showMessageDialog(log, "Faltan Datos");
                }
                break;
            case "nuevo":
                VentanaCrearUsr crearUsr = new VentanaCrearUsr(log);
                ControladorCrearUsr c = new ControladorCrearUsr(crearUsr, modelo);
                crearUsr.ConectaControlador(c);
                crearUsr.setModal(true);
                crearUsr.setVisible(true);
                break;
            case "cerrar":
                modelo.closeConexion();
                System.exit(0);
                break;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (KeyEvent.VK_ENTER == e.getKeyCode()) {
           ((JComponent) e.getSource()).transferFocus(); 
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
