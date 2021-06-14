/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

import intento1.Modelo;
import intento1.Producto;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

/**
 *
 * @author rodri
 */
public class Controlador implements ActionListener{
    private Modelo modelo;
    private VistaPrincipal vp;
    private ColaImpresiones cola1;
    private ColaImpresiones cola2;
    protected Impresora im;
    protected Impresora im2;
    
    public  Controlador(VistaPrincipal vp) {
        
        this.modelo = new Modelo("proyecto");
        this.vp = vp;
        cargarTablaEquipos();
        this.cola1 = new ColaImpresiones();
        this.cola2 = new ColaImpresiones();
        im = new Impresora(cola1,this.vp.modeloIBN);
        im2 = new Impresora(cola2,this.vp.modeloColor);
        im.setNombre("Blanco y Negro");
        im2.setNombre("Color");
        im.start();
        im2.start();
        this.vp.colaBn.updateUI();
        this.vp.colaColor.updateUI();
        
    }
    
    public void cargarTablaEquipos(){
        vp.tablaEquipos.getColumnModel().getColumn(0).setPreferredWidth(50);
        vp.tablaEquipos.getColumnModel().getColumn(1).setPreferredWidth(50);
        vp.tablaEquipos.getColumnModel().getColumn(2).setPreferredWidth(50);
        vp.tablaEquipos.getColumnModel().getColumn(3).setPreferredWidth(50);
        vp.tablaEquipos.getColumnModel().getColumn(4).setPreferredWidth(50);
        vp.tablaEquipos.getColumnModel().getColumn(5).setPreferredWidth(50);
        
        vp.tablaEquipos.setRowHeight(50);
        //List<Object[]> lista = new ArrayList<Object[]>();
        for(int i = 0; i<4 ; i++){
            Object [] ob = new Object[6];
            ob[0] = new JLabel("Equipo :"+(i+1));
            //((JPanel)ob[0]).add(new JLabel("Equipo :"+(i+1)));
            ob[1] = "Disponible";
            ob[2] = "0:0:0";
            ob[3] = 0.0;
            ob[4] = 0;
            ob[5] = 0;
           // ob[4] = new JButton("Iniciar");
            //((JButton)ob[4]).setActionCommand("iniciar");
            vp.modeloE.addRow(ob);
            //lista.add(ob);
        }
        //vp.modeloE.ad
        vp.tablaEquipos.updateUI();
        
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
        int r = vp.tablaEquipos.getSelectedRow();
        switch(e.getActionCommand()){
            case "iniciar":
                if(vp.tablaEquipos.getValueAt(r,1).equals("Disponible")){
                Cronometro c1 = new Cronometro(cola1,cola2,r,2,vp.modeloE); 
                vp.modeloE.setValueAt("No Disponible",r,1);
                vp.detener.setEnabled(true);
                c1.start();
                
                break;
            }
            case "detener":
                if(vp.tablaEquipos.getValueAt(r,1).equals("No Disponible")){
                    vp.modeloE.setValueAt("Disponible",r,1);
                
                }    
        
        }
    
    }
   
    

    
}
