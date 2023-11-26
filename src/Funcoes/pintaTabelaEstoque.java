package Funcoes;

import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class pintaTabelaEstoque implements TableCellRenderer{

       Color foreground, background;

  public static DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

  public String getDataAtual(){
     SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
     Date dt1 = new Date();
     return sdf.format(dt1);
  }

  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {

      Component renderer = DEFAULT_RENDERER.getTableCellRendererComponent(
                                table, value, isSelected, hasFocus, row, column);

    ((JLabel) renderer).setOpaque(true);
                // pega data da tabela
                     String pg = (String) table.getValueAt(row, 5);
                     int min = Integer.parseInt((String)table.getValueAt(row, 5));
                     int qnt = Integer.parseInt((String)table.getValueAt(row, 6));
                                         
                   if(qnt <= min){
                    background = new Color(175,209,209);
                   }
                   if(qnt > min){
                    background = new Color(242,145,145);
                   }

 //   renderer.setForeground(foreground);
    renderer.setBackground(background);

    return renderer;
  }

}
