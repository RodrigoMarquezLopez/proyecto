/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import componentesproyecto.BotonPersonalizado;
import componentesproyecto.CuadroContr;
import componentesproyecto.CuadroTex;
import intento1.Modelo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author rodri
 */
public class VentanaCrearUsr extends JDialog{
    protected CuadroTex nombre;
    protected CuadroTex correo;
    protected CuadroContr cont;
    protected CuadroContr cont1;
    protected BotonPersonalizado aceptar;
    
    public VentanaCrearUsr(JFrame f){
        super(f);
        JLabel name = new JLabel();
        name.setText("Nombre del Usuario      ");
        name.setIcon(new ImageIcon("src/imagenes/user.png"));
        name.setFont(new Font("Arial", Font.ITALIC, 18));
        name.setForeground(Color.WHITE);
        
        JLabel pass = new JLabel();
        pass.setText("Contraseña                    ");
        pass.setIcon(new ImageIcon("src/imagenes/user.png"));
        pass.setFont(new Font("Arial", Font.ITALIC, 18));
        pass.setForeground(Color.WHITE);
        
        JLabel pass1 = new JLabel();
        pass1.setText("Confirma contraseña    ");
        pass1.setIcon(new ImageIcon("src/imagenes/user.png"));
        pass1.setFont(new Font("Arial", Font.ITALIC, 18));
        pass1.setForeground(Color.WHITE);
        
        JLabel mail = new JLabel();
        mail.setText("Correo Electronico       ");
        mail.setIcon(new ImageIcon("src/imagenes/user.png"));
        mail.setFont(new Font("Arial", Font.ITALIC, 18));
        mail.setForeground(Color.WHITE);
        
        JLabel titulo = new JLabel("CREAR USUARIO");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial Black", Font.BOLD, 40));
        titulo.setForeground(Color.WHITE);
        
        
        
        JPanel principal = new JPanel();
        principal.setBackground(new Color(33, 45, 62, 255));
        principal.setLayout(new BorderLayout());
        principal.add(titulo,BorderLayout.NORTH);
        
            JPanel centro = new JPanel();
            centro.setOpaque(false);
            centro.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            centro.add(name,gbc);
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.gridheight = 1;
            nombre = new CuadroTex(15);
            centro.add(nombre,gbc);
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            centro.add(pass,gbc);
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.gridwidth = 2;
            gbc.gridheight = 1;
            cont = new CuadroContr(15);
            centro.add(cont,gbc);
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            centro.add(pass1,gbc);
            gbc.gridx = 1;
            gbc.gridy = 2;
            gbc.gridwidth = 2;
            gbc.gridheight = 1;
            cont1 = new CuadroContr(15);
            centro.add(cont1,gbc);
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            centro.add(mail,gbc);
            gbc.gridx = 1;
            gbc.gridy = 3;
            gbc.gridwidth = 2;
            gbc.gridheight = 1;
            correo = new CuadroTex(15);
            centro.add(correo,gbc);
            gbc.gridx = 2;
            gbc.gridy = 4;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            
            aceptar = new BotonPersonalizado();
            aceptar.setText("Aceptar");
            centro.add(aceptar,gbc);
            
            principal.add(centro,BorderLayout.CENTER);
            this.add(principal);
            this.setVisible(true);
            this.setSize(600,400);
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.setResizable(false);
        
    
    }
    
    public void ConectaControlador(ControladorCrearUsr c){
        aceptar.setActionCommand("aceptar");
        aceptar.addActionListener(c);
        nombre.addKeyListener(c);
    }
    
    public static void main(String[] args) {
        VentanaCrearUsr vcu = new VentanaCrearUsr(new JFrame());
        ControladorCrearUsr c = new ControladorCrearUsr(vcu,new Modelo("proyecto"));
        vcu.ConectaControlador(c);
    }
 
    
    
}
