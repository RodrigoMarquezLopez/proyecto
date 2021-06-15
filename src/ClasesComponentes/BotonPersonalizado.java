/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesComponentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.border.Border;

/**
 *
 * @author rodri
 */
public class BotonPersonalizado extends JButton{
    
    public BotonPersonalizado(){
        super();
        configuracion();
        
    }
    
    
    private void configuracion(){
        this.setBackground(new Color(0,206,209));
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Arial",Font.BOLD,14));
        this.setBorder(new Miborde(10));
        //this.setBounds(this.getX(),this.getY(),30,25);
    
    }
    
    
    
    private class Miborde implements Border{
    private int radio;
    public Miborde(int radio){
    this.radio = radio;
    
    }
   public Insets getBorderInsets(Component c) {
        return new Insets(this.radio+1, this.radio+1, this.radio+2, this.radio);
    }  

    public boolean isBorderOpaque() {
        return true;
    }  

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radio, radio);
    }



}
    
}
