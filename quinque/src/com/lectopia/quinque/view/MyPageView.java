package com.lectopia.quinque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class MyPageView extends JPanel{

   /**
    * Launch the application.
    */
//   public static void main(String[] args) {
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               MyPageView frame = new MyPageView();
//               frame.setVisible(true);
//            } catch (Exception e) {
//               e.printStackTrace();
//            }
//         }
//      });
//   }

   /**
    * Create the frame.
    */
   public MyPageView() {
      
     //this.getContentPane().setBackground(new Color(244,228,223));
//     setBackground(new Color(244,228,223));
	   setBackground(new Color(232, 232, 255));
     // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setBounds(100,100, 1280, 720);
     // contentPane = new JPanel();
     //contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      //setContentPane(contentPane);
     // contentPane.setLayout(null);
      setLayout(null);
      
      JLabel label_1 = new JLabel("\uB9C8\uC774\uD398\uC774\uC9C0");
      label_1.setFont(new Font("메이플스토리", Font.BOLD, 70));
      label_1.setBounds(484, 147, 311, 92);
      add(label_1);
      
      JButton button = new JButton("\uB85C\uADF8\uC544\uC6C3");
      button.setBackground(Color.WHITE);
      button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      button.setFont(new Font("메이플스토리", Font.BOLD, 20));
      button.setBounds(499, 333, 282, 55);
      // contentPane.add(btnNewButton);
       add(button);
       button.addActionListener(new ButtonHandler());
      
      JButton button1 = new JButton("\uBE44\uBC00\uBC88\uD638 \uBCC0\uACBD");
      button1.setBackground(Color.WHITE);
      button1.setFont(new Font("메이플스토리", Font.BOLD, 20));
      button1.setBounds(499, 398, 282, 55);
      add(button1);
      button1.addActionListener(new ButtonHandler());
      
      JButton button2 = new JButton("\uD68C\uC6D0\uD0C8\uD1F4");
      button2.setBackground(Color.WHITE);
      button2.setFont(new Font("메이플스토리", Font.BOLD, 20));
      button2.setBounds(499, 463, 282, 55);
      add(button2);
      button2.addActionListener(new ButtonHandler());
      
      JButton button3 = new JButton("\uB418\uB3CC\uC544\uAC00\uAE30");
      button3.setBackground(Color.WHITE);
      button3.setFont(new Font("메이플스토리", Font.BOLD, 20));
      button3.setBounds(499, 528, 282, 55);
      add(button3);
      button3.addActionListener(new ButtonHandler());
      
      JLabel lblNewLabel = new JLabel("");
	  lblNewLabel.setIcon(new ImageIcon(LocalLobbyView.class.getResource("/localView/bear.png")));
	  lblNewLabel.setBounds(12, 412, 288, 290);
	  add(lblNewLabel);
      
      JLabel lblNewLabel_1 = new JLabel("");
      lblNewLabel_1.setIcon(new ImageIcon(LocalLobbyView.class.getResource("/localView/babyBear.png")));
      lblNewLabel_1.setBounds(1048, 483, 204, 188);
      add(lblNewLabel_1);
		
   
      
   }
   
   private class ButtonHandler implements ActionListener{
      public void actionPerformed(ActionEvent e) {
         JPasswordField jpf;
         JOptionPane jop;
         JDialog jd;
         String pwd;
         int result;
         String btn = e.getActionCommand();
         switch(btn) {
         case "로그아웃":
            ChangePanelService.getInstance().changePanel("LoginView");
            break;
         case "비밀번호 변경":
            jpf = new JPasswordField();
            jop = new JOptionPane(jpf, JOptionPane.QUESTION_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
            jd = jop.createDialog("비밀번호 확인");
            jd.setVisible(true);
            pwd = new String(jpf.getPassword());
            System.out.println(pwd);
            result = (Integer)jop.getValue();
            if(result == JOptionPane.OK_OPTION){
               jpf.setText("");
               jd = jop.createDialog("비밀번호 변경");
               jd.setVisible(true);
               if(0 == JOptionPane.OK_OPTION){JOptionPane.showMessageDialog(jop, "변경 되었습니다.");}
               else{JOptionPane.showMessageDialog(jop, "취소 되었습니다.");}
            }else {
               JOptionPane.showMessageDialog(jop, "취소 되었습니다.");
            }
            break;
         case "회원탈퇴":
            jpf = new JPasswordField();
            jop = new JOptionPane(jpf, JOptionPane.QUESTION_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
            jd = jop.createDialog("비밀번호 확인");
            jd.setVisible(true);
            pwd = new String(jpf.getPassword());
            System.out.println(pwd);
            result = (Integer)jop.getValue();
            if(result == JOptionPane.OK_OPTION){
               JOptionPane.showMessageDialog(jop, "탈퇴 되었습니다.");
               ChangePanelService.getInstance().changePanel("LoginView");
            }else {
               JOptionPane.showMessageDialog(jop, "취소 되었습니다.");
            }
            break;
         case "되돌아가기":
        	 ChangePanelService.getInstance().changePanel("MultiPlayListView");
            break;
         default:
            ; break;
         }
      }
   }
}