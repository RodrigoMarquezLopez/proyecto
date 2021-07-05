/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import componentesproyecto.CuadroContr;
import componentesproyecto.CuadroTex;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

/**
 *
 * @author Jose Alfredo Garcia Cortes
 */
public class Login extends JFrame {

    protected CuadroContr passwordField;
    protected JButton join;
    protected CuadroTex txuser;
    protected JButton close;
    protected JButton Nuevo;

    public Login() {
        this.setSize(820, 550);
        setUndecorated(true);
        setOpacity(1.0f);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 35, 35);
        setShape(forma);
        setOpacity(1.0f);
        setLayout(new GridLayout(1, 1));
        add(Logo());
        add(Log());

        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon("src/imagenes/cpu.png").getImage());
    }

    public JPanel Logo() {
        SpringLayout s = new SpringLayout();
        JPanel main = new JPanel(s);
        main.setBackground(new Color(15, 157, 167));
        JLabel titulo = title("     SIMULADOR    ");
        main.add(titulo);
        s.putConstraint(SpringLayout.WEST, titulo, 12, SpringLayout.WEST, main);
        s.putConstraint(SpringLayout.NORTH, titulo, 22, SpringLayout.NORTH, main);
        JLabel titulo2 = title("   CIBER      ");
        main.add(titulo2);
        s.putConstraint(SpringLayout.NORTH, titulo2, 40, SpringLayout.NORTH, titulo);
        s.putConstraint(SpringLayout.WEST, titulo2, 98, SpringLayout.WEST, main);
        ImageIcon imageIcon = new ImageIcon("src/imagenes/fondo1.png");
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(350, 480, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        JLabel img = new JLabel(imageIcon);
        main.add(img);
        s.putConstraint(SpringLayout.WEST, img, 35, SpringLayout.WEST, main);
        s.putConstraint(SpringLayout.NORTH, img, 20, SpringLayout.NORTH, titulo2);
        return main;
    }

    public JLabel title(String leyenda) {
        JLabel titulo = new JLabel(leyenda);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial Black", Font.BOLD, 35));
        titulo.setForeground(Color.WHITE);
        return titulo;
    }

    public JPanel Log() {
        JPanel main = new JPanel(new BorderLayout());
        main.setBackground(new Color(33, 45, 62, 255));
        JLabel titulo = new JLabel("INICIAR SESION");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial Black", Font.BOLD, 40));
        titulo.setForeground(Color.WHITE);
        JPanel title = new JPanel(new BorderLayout());
        title.setBackground(new Color(33, 45, 62, 255));
        ImageIcon imageIcon = new ImageIcon("src/imagenes/close.png");
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(25, 23, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        close = new JButton(imageIcon);
        close.setToolTipText("Cierra la aplicación");
        //close.setActionCommand("Cerrrar");
        //close.adctionListener(this);
        close.setBorder(null);
        close.setBackground(new Color(33, 45, 62, 255));
        JPanel bot = new JPanel(new BorderLayout());
        bot.setBackground(new Color(33, 45, 62, 255));
        bot.add(close, BorderLayout.EAST);
        title.add(bot, BorderLayout.NORTH);
        title.add(titulo, BorderLayout.CENTER);
        main.add(title, BorderLayout.NORTH);
        JPanel formulario = new JPanel(new GridBagLayout());
        formulario.setBackground(new Color(33, 45, 62, 255));
        GridBagConstraints r = new GridBagConstraints();
        JLabel user = new JLabel(new ImageIcon("src/imagenes/user.png"));
        JLabel Js = jLabel("Usuario");
        r.anchor = GridBagConstraints.WEST;
        r.fill = GridBagConstraints.HORIZONTAL;
        r.gridwidth = GridBagConstraints.REMAINDER;
        r.insets = new Insets(20, 7, 0, 7);
        formulario.add(Js, r);
        r.gridwidth = 1;
        formulario.add(user, r);
        txuser = new CuadroTex(15);
        r.fill = GridBagConstraints.NONE;
        r.gridwidth = GridBagConstraints.REMAINDER;
        r.ipady = 5;
        formulario.add(txuser, r);
        r.gridwidth = GridBagConstraints.REMAINDER;
        r.ipadx = 0;
        formulario.add(jLabel("Contraseña"), r);
        JLabel lock = new JLabel(new ImageIcon("src/imagenes/lock.png"));
        r.gridwidth = 1;
        formulario.add(lock, r);
        r.fill = GridBagConstraints.NONE;
        r.gridwidth = GridBagConstraints.REMAINDER;
        r.ipady = 5;
        passwordField = new CuadroContr(15);
        formulario.add(passwordField, r);
        r.insets = new Insets(15, 55, 15, 0);
        join = new JButton(new ImageIcon("src/imagenes/button_ingresar.png"));
        join.setBackground(new Color(33, 45, 62, 255));
        join.setBorder(null);
        join.setToolTipText("Ingresar con el usuario");
       // join.setActionCommand("ingresar");
        //join.addActionListener(this);
        r.fill = GridBagConstraints.HORIZONTAL;
        r.gridwidth = GridBagConstraints.REMAINDER;
        r.anchor = GridBagConstraints.EAST;
        formulario.add(join, r);

        Nuevo = new JButton(new ImageIcon("src/imagenes/nuevo.png"));
        Nuevo.setBorder(null);
        Nuevo.setToolTipText("Crear un nuevo usuario");
        Nuevo.setBackground(new Color(33, 45, 62, 255));
        formulario.add(Nuevo,r);
        main.add(formulario, BorderLayout.CENTER);
        JPanel col = new JPanel();
        col.setBackground(new Color(0, 0, 0, 0));
        main.add(col, BorderLayout.SOUTH);
        return main;
    }

    public JLabel jLabel(String leyenda) {
        JLabel label = new JLabel(leyenda);
        label.setFont(new Font("Arial", Font.ITALIC, 18));
        label.setForeground(Color.WHITE);
        return label;
    }



    public void ConectaControlador(ControladorLogin c) {
        join.setActionCommand("ingresar");
        join.addActionListener(c);
        
        Nuevo.setActionCommand("nuevo");
        Nuevo.addActionListener(c);
        
        close.setActionCommand("cerrar");
        close.addActionListener(c);

    }

}
