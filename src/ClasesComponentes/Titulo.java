/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesComponentes;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author rodri
 */
public class Titulo extends JLabel{
    
    public Titulo(){
        super("Titulo");
        configuracion();
    }
    
    public Titulo(String texto){
        super(texto);
        configuracion();
        
    }
    
    private void configuracion(){

        this.setFont(new Font("Serif", Font.BOLD, 50));
        this.setForeground(Color.WHITE);
    
    }
    
}
