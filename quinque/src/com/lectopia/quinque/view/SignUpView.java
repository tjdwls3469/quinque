package com.lectopia.quinque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class SignUpView extends JDialog {

   private static final long serialVersionUID = 1L;
   private JPanel contentPane;
   private JTextField email;
   private JTextField id;
   private JPasswordField password;
   private JPasswordField passwordCheck;
   private JTextField textField;

   public SignUpView() {
      this(null, "");
   }

   public SignUpView(JFrame frame, String str) {
      super(frame, str, true);
      SignUpViewHandler suvh = new SignUpViewHandler();
//      Color c = new Color(244, 228, 223);
      Color c = new Color(232, 232, 255);
      this.setBackground(c);
      this.getContentPane().setBackground(c);
      // setDefaultCloseOperation(JFrame.DISOPOSE);
      setBounds(100, 100, 640, 480);
      contentPane = new JPanel();
      contentPane.setForeground(Color.BLUE);
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      contentPane.setLayout(new BorderLayout(0, 0));
      contentPane.setBackground(c);
      setContentPane(contentPane);

      JPanel panel = new JPanel();
      contentPane.add(panel, BorderLayout.CENTER);
      panel.setLayout(new GridLayout(0, 1, 0, 0));

      JPanel panel_4 = new JPanel();
      panel.add(panel_4);
      panel_4.setLayout(null);

      JLabel lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
      lblNewLabel_1.setFont(new Font("메이플스토리", Font.BOLD, 15));
      lblNewLabel_1.setBounds(163, 54, 65, 15);
      panel_4.add(lblNewLabel_1);
      lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

      id = new JTextField();
      id.setAlignmentX(Component.LEFT_ALIGNMENT);
      id.setFont(new Font("메이플스토리", Font.PLAIN, 15));
      id.setBounds(240, 44, 215, 35);
      panel_4.add(id);
      id.setColumns(10);

      JPanel panel_5 = new JPanel();
      panel.add(panel_5);
      panel_5.setLayout(null);

      JLabel lblNewLabel = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
      lblNewLabel.setFont(new Font("메이플스토리", Font.BOLD, 15));
      lblNewLabel.setBounds(139, 60, 84, 15);
      panel_5.add(lblNewLabel);
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

      JLabel lblId = new JLabel("\uC774\uBA54\uC77C");
      lblId.setFont(new Font("메이플스토리", Font.BOLD, 15));
      lblId.setBounds(164, 105, 59, 25);
      panel_5.add(lblId);
      lblId.setHorizontalAlignment(SwingConstants.CENTER);

      email = new JTextField();
      email.setAlignmentX(Component.LEFT_ALIGNMENT);
      email.setFont(new Font("메이플스토리", Font.PLAIN, 15));
      email.setBounds(240, 100, 215, 35);
      panel_5.add(email);
      email.setHorizontalAlignment(SwingConstants.LEFT);
      email.setColumns(10);

      passwordCheck = new JPasswordField();
      passwordCheck.setAlignmentX(Component.LEFT_ALIGNMENT);
      passwordCheck.setBounds(240, 50, 215, 35);
      panel_5.add(passwordCheck);

      JPanel panel_6 = new JPanel();
      panel.add(panel_6);
      panel_6.setLayout(null);

      JButton cancel = new JButton("취소");
      Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
      cancel.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            cancel.setCursor(cursor);
         }
      });
      cancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      cancel.setMargin(new Insets(5, 17, 5, 17));
      cancel.setFont(new Font("메이플스토리", Font.BOLD, 20));
      cancel.setBounds(189, 35, 92, 53);
      panel_6.add(cancel);

      JButton success = new JButton("회원가입 완료");
      success.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      success.addActionListener(suvh);
      success.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            success.setCursor(cursor);
         }
      });
      success.setFont(new Font("메이플스토리", Font.BOLD, 20));
      success.setBounds(311, 35, 165, 53);
      panel_6.add(success);
      cancel.addActionListener(suvh);

      cancel.setBorder(new RoundBorder(17));
      cancel.setOpaque(true);
      success.setBorder(new RoundBorder(17));
      panel.setBackground(c);
      panel_4.setBackground(c);

      JLabel lblNewLabel_6 = new JLabel("");
      lblNewLabel_6.setIcon(new ImageIcon(SignUpView.class.getResource("/signUpUI/clam.png")));
      lblNewLabel_6.setBounds(-48, -4, 125, 98);
      panel_4.add(lblNewLabel_6);
      
      JLabel label_3 = new JLabel("\uB2C9\uB124\uC784");
      label_3.setHorizontalAlignment(SwingConstants.CENTER);
      label_3.setFont(new Font("메이플스토리", Font.BOLD, 15));
      label_3.setBounds(163, 104, 65, 15);
      panel_4.add(label_3);
      
      textField = new JTextField();
      textField.setFont(new Font("메이플스토리", Font.PLAIN, 15));
      textField.setColumns(10);
      textField.setAlignmentX(0.0f);
      textField.setBounds(240, 94, 215, 35);
      panel_4.add(textField);

      // JLabel lblNewLabel_8 = new JLabel("New label");
      // lblNewLabel_8.setBounds(71, 78, 57, 15);
      // panel_4.add(lblNewLabel_8);
      panel_5.setBackground(c);

      JLabel label_2 = new JLabel("");
      label_2.setBounds(538, 20, 89, 88);
      panel_5.add(label_2);
      label_2.setIcon(new ImageIcon(SignUpView.class.getResource("/signUpUI/fence.png")));

      JLabel label_1 = new JLabel("");
      label_1.setBounds(558, 0, 89, 88);
      panel_5.add(label_1);
      label_1.setIcon(new ImageIcon(SignUpView.class.getResource("/signUpUI/fence.png")));

      JLabel label = new JLabel("New label");
      label.setBounds(-39, -3, 125, 98);
      panel_5.add(label);
      label.setIcon(new ImageIcon(SignUpView.class.getResource("/signUpUI/pearlClam.png")));
      
            JLabel lblNewLabel_2 = new JLabel("\uBE44\uBC00\uBC88\uD638");
            lblNewLabel_2.setBounds(163, 10, 65, 15);
            panel_5.add(lblNewLabel_2);
            lblNewLabel_2.setFont(new Font("메이플스토리", Font.BOLD, 15));
            lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
            
                  password = new JPasswordField();
                  password.setBounds(240, 0, 215, 35);
                  panel_5.add(password);
                  password.setAlignmentX(Component.LEFT_ALIGNMENT);
      panel_6.setBackground(c);

      JLabel lblNewLabel_3 = new JLabel("");
      lblNewLabel_3.setBounds(25, 23, 83, 78);
      panel_6.add(lblNewLabel_3);
      lblNewLabel_3.setIcon(new ImageIcon(SignUpView.class.getResource("/signUpUI/cube.png")));

      JLabel lblNewLabel_4 = new JLabel("");
      lblNewLabel_4.setIcon(new ImageIcon(SignUpView.class.getResource("/signUpUI/grayCube.png")));
      lblNewLabel_4.setBounds(93, 37, 51, 50);
      panel_6.add(lblNewLabel_4);

      JLabel lblNewLabel_5 = new JLabel("");
      lblNewLabel_5.setBounds(550, 10, 89, 88);
      panel_6.add(lblNewLabel_5);
      lblNewLabel_5.setIcon(new ImageIcon(SignUpView.class.getResource("/signUpUI/fence.png")));

      this.setVisible(true);
   }

   private class RoundBorder implements Border {
      int radius;

      RoundBorder() {
      }

      RoundBorder(int radius) {
         this.radius = radius;
      }

      public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
         g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);

      }

      public Insets getBorderInsets(Component c) {
         return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
      }

      public boolean isBorderOpaque() {
         return true;
      }
   }

   private class SignUpViewHandler implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         if (e.getActionCommand().equals("취소")) {
            System.out.println("취소");
            dispose();
         } else if (e.getActionCommand().equals("회원가입 완료")) {
            System.out.println("아이디 " + id.getText());
            // System.out.println(password.getPassword());
            // System.out.println(passwordCheck.getPassword());
            if (new String(password.getPassword()).equals(new String(passwordCheck.getPassword()))) {
               System.out.println("닉네임 " + textField.getText());
               System.out.println("일치");
            } else {
               System.out.println("닉네임 " + textField.getText());
               System.out.println("불일치");
            }
            System.out.println("비밀번호 " + password.getText());
            System.out.println("비밀번호 확인 " + passwordCheck.getText());
            System.out.println("이메일 " + email.getText());
            JOptionPane.showMessageDialog(contentPane, "회원가입이 완료되었습니다.");
            dispose();
         }
      }
   }
}