/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesComponentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Enumeration;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author rodri
 */
public class Tabla extends JTable{
    
    public Tabla(TableModel dtm){
        
        super(dtm);
        this.setFont(new Font("Serif",Font.BOLD,18));
        JTableHeader jtableHeader = this.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        this.setTableHeader(tableHeader);
        Enumeration <TableColumn> en = this.getColumnModel().getColumns();
        while(en.hasMoreElements()){
            TableColumn tc = en.nextElement();
             tc.setCellRenderer(new Render());
        }
   }
    
    public Tabla(){
    super();
        JTableHeader jtableHeader = this.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        this.setTableHeader(tableHeader);
        Enumeration <TableColumn> en = this.getColumnModel().getColumns();
        while(en.hasMoreElements()){
            TableColumn tc = en.nextElement();
             tc.setCellRenderer(new Render());
        }
    
    }
    
    
         private class Render extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int roe, int column){
       //super.getTableCellRendererComponent(table, value, isSelected, hasFocus, roe, column);
       this.setHorizontalAlignment(CENTER);
       JComponent com = null;
        if(value instanceof JLabel){
            JLabel panel = (JLabel)value;
            panel.setOpaque(true);
            panel.setFont(new Font("Serif",Font.HANGING_BASELINE,12));
            panel.setBackground(new Color(0,206,209));
            return panel;
        }
        
         if (hasFocus) {                
            this.setBackground(Color.lightGray);   
        }
       
       boolean addRow = (roe % 2 == 0);
        Color c  = new Color(205,205,205);
        this.setHorizontalAlignment( CENTER );
        this.setFont(new Font("Serif",Font.ITALIC,20));
          
        if(addRow){
            setBackground(c);
        }
        
        return  super.getTableCellRendererComponent(table, value, isSelected, hasFocus, roe, column);
    
    }
            }
         
         
         
   private class GestionEncabezadoTabla  implements TableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        JComponent jcomponent = null;
        
        if( value instanceof String ) {
            jcomponent = new JLabel((String) value);
            ((JLabel)jcomponent).setFont(new Font("Serif",Font.ROMAN_BASELINE,18));
            
            ((JLabel)jcomponent).setHorizontalAlignment( SwingConstants.CENTER );
            ((JLabel)jcomponent).setSize( 30, jcomponent.getWidth() );   
            ((JLabel)jcomponent).setPreferredSize( new Dimension(6, jcomponent.getWidth())  );
        }
        //jcomponent.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(221, 211, 211)));
        jcomponent.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(255, 255, 255)));
        jcomponent.setOpaque(true);
        //jcomponent.setBackground( new Color(236,234,219) );
        jcomponent.setBackground(new Color(0,206,209));
        jcomponent.setToolTipText("Tabla Seguimiento Equipos");
        jcomponent.setForeground(Color.white);
        
        return jcomponent;
    }
}      
    
    
}
