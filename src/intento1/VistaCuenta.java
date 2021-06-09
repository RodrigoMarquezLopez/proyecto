/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intento1;

import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author rodri
 */
public class VistaCuenta extends JFrame{
    JTextArea cuenta;
    public VistaCuenta(Cuenta c){
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        cuenta = new JTextArea(c.toString());
    }


    
}
