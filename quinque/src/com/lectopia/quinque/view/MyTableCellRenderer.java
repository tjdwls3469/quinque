package com.lectopia.quinque.view;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;

//
public class MyTableCellRenderer extends JButton implements TableCellRenderer {

   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
         int row, int column) {
      if (column == 3) {
         this.setContentAreaFilled(false);
         this.setFocusPainted(false);
         this.setBorderPainted(false);
         if (value.toString().equals("게임중")) {
            this.setIcon(new ImageIcon(MultiPlayListView.class.getResource("/multiGameList/ing.png")));
         }
         else if (value.toString().equals("참가")) {
            this.setIcon(new ImageIcon(MultiPlayListView.class.getResource("/multiGameList/join.png")));
         }
         else 
         {
            
         }
      }
      return this;
   }
}