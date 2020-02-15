package com.lectopia.quinque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MultiRoomView extends JPanel {

   
   private JButton start_btn;
   private JButton back_btn;
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               MultiRoomView frame = new MultiRoomView();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    */
   public MultiRoomView() {
      setBounds(100, 100, 1280, 720);
      
       setBorder(new EmptyBorder(5, 5, 5, 5));
      setLayout(null);
      
      Color c = new Color(244,228,223);
      this.setBackground(c);
      MulitPlayJoinRoomHandler mpjrh = new MulitPlayJoinRoomHandler();
      JPanel panel_1 = new JPanel();
      panel_1.setBounds(359, 513, 682, 128);
      panel_1.setBackground(c);
      
      add(panel_1);
      panel_1.setLayout(null);

      start_btn = new JButton("");
      start_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      start_btn.setIcon(new ImageIcon(MultiRoomView.class.getResource("/multiRoomUi/gamestart_1.png")));
      start_btn.setFont(new Font("메이플스토리", Font.BOLD, 20));
      // button_1.setBorder(new RoundBorder(17));
      start_btn.setBounds(402, 0, 307, 112);
      panel_1.add(start_btn);
      start_btn.addActionListener(mpjrh);

      back_btn = new JButton("");
      back_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      back_btn.setBounds(153, 19, 248, 74);
      panel_1.add(back_btn);
      back_btn.setIcon(new ImageIcon(MultiRoomView.class.getResource("/multiRoomUi/back_1.png")));
      back_btn.setFont(new Font("메이플스토리", Font.BOLD, 20));
      back_btn.addActionListener(mpjrh);

      JLabel roomState = new JLabel("\uBC29 \uC81C\uBAA9");
      roomState.setFont(new Font("메이플스토리", Font.PLAIN, 40));
      roomState.setBounds(112, 56, 120, 60);
      add(roomState);

      JPanel panel = new JPanel();
      panel.setBackground(c);
      
      panel.setBounds(112, 126, 944, 379);
      add(panel);
      panel.setLayout(null);

      JLabel playerName1 = new JLabel("Name");
      playerName1.setFont(new Font("메이플스토리", Font.PLAIN, 30));
      playerName1.setBounds(186, 43, 660, 60);
      panel.add(playerName1);

      JLabel playerName2 = new JLabel("Name");
      playerName2.setFont(new Font("메이플스토리", Font.PLAIN, 30));
      playerName2.setBounds(186, 119, 649, 60);
      panel.add(playerName2);

      JLabel stateLableBlue = new JLabel("");
      stateLableBlue.setIcon(new ImageIcon(MultiRoomView.class.getResource("/multiRoomUi/ready_icon7.png")));
      stateLableBlue.setAlignmentX(0.5f);
      stateLableBlue.setBounds(72, 115, 97, 65);
      panel.add(stateLableBlue);

      JLabel stateLableLocked2 = new JLabel("");
      stateLableLocked2.setIcon(new ImageIcon(MultiRoomView.class.getResource("/multiRoomUi/locked_5.png")));
      stateLableLocked2.setAlignmentX(0.5f);
      stateLableLocked2.setBounds(72, 272, 67, 65);
      panel.add(stateLableLocked2);

      JLabel stateLableLocked1 = new JLabel("");
      stateLableLocked1.setIcon(new ImageIcon(MultiRoomView.class.getResource("/multiRoomUi/locked_5.png")));
      stateLableLocked1.setAlignmentX(0.5f);
      stateLableLocked1.setBounds(72, 194, 67, 65);
      panel.add(stateLableLocked1);

      JLabel stateLableRed = new JLabel("");
      stateLableRed.setAlignmentX(Component.CENTER_ALIGNMENT);
      stateLableRed.setIcon(new ImageIcon(MultiRoomView.class.getResource("/multiRoomUi/host_icon.png")));
      stateLableRed.setBounds(72, 43, 97, 60);
      panel.add(stateLableRed);

      JLabel lable2P = new JLabel("");
      lable2P.setIcon(new ImageIcon(MultiRoomView.class.getResource("/multiRoomUi/player_blue_1.png")));
      lable2P.setBounds(68, 112, 795, 70);
      panel.add(lable2P);

      JLabel lable3P = new JLabel("");
      lable3P.setIcon(new ImageIcon(MultiRoomView.class.getResource("/multiRoomUi/locked_1.png")));
      lable3P.setBounds(68, 192, 795, 70);
      panel.add(lable3P);

      JLabel lable4P = new JLabel("");
      lable4P.setIcon(new ImageIcon(MultiRoomView.class.getResource("/multiRoomUi/locked_1.png")));
      lable4P.setBounds(68, 269, 795, 70);
      panel.add(lable4P);

      JLabel label1P = new JLabel("New label");
      label1P.setIcon(new ImageIcon(MultiRoomView.class.getResource("/multiRoomUi/player_red_1.png")));
      label1P.setBounds(68, 35, 795, 76);
      panel.add(label1P);

      JLabel outerFrameBlue = new JLabel("");
      outerFrameBlue.setBounds(26, 10, 896, 369);
      panel.add(outerFrameBlue);
      outerFrameBlue.setIcon(new ImageIcon(MultiRoomView.class.getResource("/multiRoomUi/frame_blue.png")));
      // 겉에 파란 테두리
      back_btn.setContentAreaFilled(false);
      back_btn.setFocusPainted(false);
      back_btn.setBorderPainted(false);
      start_btn.setContentAreaFilled(false);
      start_btn.setFocusPainted(false);
      start_btn.setBorderPainted(false);
      
      JLabel label = new JLabel("33. \uC544\uBB34\uB098 \uD55C\uD310\uD558\uC790");
      label.setFont(new Font("메이플스토리", Font.PLAIN, 38));
      label.setBounds(258, 57, 620, 60);
      add(label);

   }

   class MulitPlayJoinRoomHandler implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         JButton btn = (JButton)e.getSource();
         if (btn.equals(back_btn)) {
            ChangePanelService.getInstance().changePanel("MultiPlayListView");//방리스트로 이동
         } else if (btn.equals(start_btn)) {
            ChangePanelService.getInstance().changePanel("MultiInGameView");//게임화면으로 이동
         }
      }

   }
}