/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rodri
 */
public class Vista extends JFrame{
      protected JTable tabla;
      protected DefaultTableModel dtm;
      protected JButton b1;
      //protected Cronometro c1;
      protected ColaImpresiones cI;
      
      public Vista(){
          this.setLayout(new BorderLayout());
          cI = new ColaImpresiones();
          
          String [] columnas = {"Equipo","Tiempo"};
          dtm = new DefaultTableModel(columnas,5);
          b1 = new JButton("Empezar");
          b1.setActionCommand("Empezar");
          b1.addActionListener(new AdmoAccion());
          tabla = new JTable(dtm);
          
          this.add(b1,BorderLayout.SOUTH);
          this.add(tabla,BorderLayout.CENTER);
          this.setVisible(true);
          this.setSize(500,500);
          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }
      
      private class AdmoAccion implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           switch(e.getActionCommand()){
               case "Empezar":
                   Cronometro c1 = new Cronometro(dtm,1,1,cI,2.5);
                   Cronometro c2 = new Cronometro(dtm,0,0,cI,2.5);
                   Impresora im = new Impresora(cI);
                   im.start();
                  ((Cronometro)tabla.getValueAt(1,1)).start();
                  ((Cronometro)tabla.getValueAt(0,0)).start();
                   
           }
        }
          

     }
      
      
      public static void main(String[] args) {
        new Vista();
    }
}
