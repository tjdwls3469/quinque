package com.lectopia.quinque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenuView extends JPanel {
   
   private JButton[] buttons;
   
   private static final long serialVersionUID = 1L;

   public MainMenuView() {
      super();
      
      Color mainColor = new Color(244, 228, 223);
      this.setLayout(new BorderLayout());
      this.setBackground(mainColor);
      
      northView();
      westView();
      eastView();
      
      
//      JPanel centerPanel = new JPanel(new GridLayout(1, 4));
//      centerPanel.setBackground(mainColor));
//      JLabel[] centerImage = { 
//            new JLabel(new ImageIcon("Scissors.png")),
//            new JLabel(new ImageIcon("Rock.png")),
//            new JLabel(new ImageIcon("Paper.png")),
//            new JLabel(new ImageIcon("QuestionMark.png")) };
//      
//      for (JLabel label : centerImage)
//         centerPanel.add(label);
//      
//      this.add("Center", centerPanel);
      
      JPanel centerMenuPanel = new JPanel(new GridLayout(7,1, 50, 30)) {
         /**
          * 
          */
         private static final long serialVersionUID = 1L;
//         public void paintComponent(Graphics g) {
//            g.drawImage(new ImageIcon(MainMenuView.class.getResource("/mainUI/MainCenterImage.png")).getImage(), 0, 0, null);
//            setOpaque(false);
//            super.paintComponent(g);
//         }
      };
      
      centerMenuPanel.setBackground(new Color(232, 232, 255));
      
      // 화면 배치용 button index 0, 6
      buttons = new JButton[] {
            new JButton(),
            new JButton("\t로컬 플레이", new ImageIcon(MainMenuView.class.getResource("/mainUI/Home.png"))),
            new JButton("\t멀티 플레이", new ImageIcon(MainMenuView.class.getResource("/mainUI/Multi.png"))),
            new JButton("\t튜토리얼", new ImageIcon(MainMenuView.class.getResource("/mainUI/Tutorial.png"))),
            new JButton("\t게임 종료", new ImageIcon(MainMenuView.class.getResource("/mainUI/Exit.png"))),
            new JButton()
      };
      
      for (JButton button : buttons) {
         centerMenuPanel.add(button);
         button.setOpaque(true);
         button.setBackground(Color.white);
      }
      
      buttons[0].setVisible(false);
      buttons[5].setVisible(false);
      
      buttons[1].setFont(new Font("Maplestory", Font.BOLD, 20));
      buttons[2].setFont(new Font("Maplestory", Font.BOLD, 20));
      buttons[3].setFont(new Font("Maplestory", Font.BOLD, 20));
      buttons[4].setFont(new Font("Maplestory", Font.BOLD, 20));
      buttons[5].setFont(new Font("Maplestory", Font.BOLD, 20));
      
      ButtonHandler buttonHandler = new ButtonHandler();
      
      buttons[1].addActionListener(buttonHandler);
      buttons[2].addActionListener(buttonHandler);
      buttons[3].addActionListener(buttonHandler);
      buttons[4].addActionListener(buttonHandler);
      buttons[5].addActionListener(buttonHandler);
      
      this.add("Center", centerMenuPanel);
      
      JPanel southPanel = new JPanel();
      southPanel.setBackground(mainColor);
      this.add("South", southPanel);
      
      this.setSize(1280, 720);
      
      this.setVisible(true);
   }
   
   private class ButtonHandler implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         String command = e.getActionCommand();
         if (command.equals("\t로컬 플레이")) {
            ChangePanelService.getInstance().changePanel("LocalLobbyView");
         }
         else if (command.equals("\t멀티 플레이")) {
            ChangePanelService.getInstance().changePanel("LoginView");
         }
         else if (command.equals("\t튜토리얼")) {
            ChangePanelService.getInstance().changePanel("TutorialView");
         }
         else if (command.equals("\t게임 종료")) {
            System.exit(0);
         }
      }
      
   }
   
   private void northView() {
      JPanel northPanel = new JPanel(new GridLayout(2, 1));
      
      JPanel northPanel1 = new JPanel(new GridLayout(1, 1));
      JPanel northPanel2 = new JPanel();
      
      northPanel1.setBackground(new Color(208, 208, 255));
      northPanel2.setBackground(new Color(208, 208, 255));
      
      JLabel label = new JLabel("Quinque !");
      label.setFont(new Font("Maplestory", Font.BOLD, 50));
      label.setForeground(Color.WHITE);
      label.setHorizontalAlignment(JLabel.CENTER);
      
      northPanel2.add(label);
      
      northPanel.add(northPanel1);
      northPanel.add(northPanel2);
      
      this.add("North", northPanel);
   }
   
   private void westView() {
      JPanel westPanel = new JPanel(new GridLayout(2, 1));
      
      JPanel westPanel1 = new JPanel(new GridLayout(1, 2));
      JPanel westPanel2 = new JPanel();
      
      westPanel1.setBackground(new Color(232, 232, 255));
      westPanel2.setBackground(new Color(232, 232, 255));
      
      JLabel rabbitIcon = new JLabel(new ImageIcon(MainMenuView.class.getResource("/mainUI/Rabbit.png")));
      JLabel turtleIcon = new JLabel(new ImageIcon(MainMenuView.class.getResource("/mainUI/Turtle.png")));
      
      westPanel1.add(rabbitIcon);
      westPanel1.add(turtleIcon);
      
      westPanel.add(westPanel1);
      westPanel.add(westPanel2);   
      
      this.add("West", westPanel);
   }
   
   private void eastView() {
      JPanel eastPanel = new JPanel(new GridLayout(2,1));
      
      JPanel eastPanel1 = new JPanel(new GridLayout(1, 2));
      JPanel eastPanel2 = new JPanel();
            
      eastPanel1.setBackground(new Color(232, 232, 255));
      eastPanel2.setBackground(new Color(232, 232, 255));
      
      JLabel penguinIcon = new JLabel(new ImageIcon(MainMenuView.class.getResource("/mainUI/Penguin.png")));
      JLabel polarBearIcon = new JLabel(new ImageIcon(MainMenuView.class.getResource("/mainUI/PolarBear.png")));
   
      eastPanel1.add(penguinIcon);
      eastPanel1.add(polarBearIcon);
      
      eastPanel.add(eastPanel1);
      eastPanel.add(eastPanel2);
      
      this.add("East", eastPanel);
   }

}