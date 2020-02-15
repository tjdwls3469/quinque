package com.lectopia.quinque.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

class ButtonEditor extends DefaultCellEditor {
   private JButton btn;
   private String lbl;
   private boolean clicked;

   public ButtonEditor(JTextField txt) {
      super(txt);
      btn = new JButton();
//      btn.setSize(10,10);
      btn.setOpaque(true);
      btn.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {
            fireEditingStopped();
         }
      });
   }
   @Override

   public Component getTableCellEditorComponent(JTable table, Object obj, boolean selected, int row, int col) {
      lbl = (obj == null) ? "" : obj.toString();
      btn.setContentAreaFilled(false);
      btn.setFocusPainted(false);
      btn.setBorderPainted(false);
      if(obj.equals("게임중"))
      {
         return null;
      }
      else if(obj.equals("참가"))
      {
         btn.setIcon(new ImageIcon(MultiPlayListView.class.getResource("/multiGameList/join2.png")));
      }
      clicked = true;
      return btn;
   }
   @Override

   public Object getCellEditorValue() {
      if (clicked) {
         ChangePanelService.getInstance().changePanel("MultiRoomView");
      }
      clicked = false;
      return new String(lbl);
   }
   @Override
   public boolean stopCellEditing() {
      clicked = false;
      return super.stopCellEditing();
   }
   @Override
   protected void fireEditingStopped() {
      super.fireEditingStopped();
   }
}