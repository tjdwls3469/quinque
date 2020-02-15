package com.lectopia.quinque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lectopia.quinque.service.GameServiceManager;

public class LocalLobbyView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JComboBox<ImageIcon> comboBox;
	private JComboBox<ImageIcon> comboBox_1;

	public LocalLobbyView() {
		setBounds(100,100, 1280, 720);
		setBackground(new Color(232, 232, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LocalLobbyView.class.getResource("/localView/bear.png")));
		lblNewLabel.setBounds(12, 412, 288, 290);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LocalLobbyView.class.getResource("/localView/babyBear.png")));
		lblNewLabel_1.setBounds(1048, 483, 204, 188);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(LocalLobbyView.class.getResource("/localView/home.png")));
		lblNewLabel_2.setBounds(435, 181, 90, 79);
		add(lblNewLabel_2);
		
		JLabel label = new JLabel("\uB85C\uCEEC \uD50C\uB808\uC774");
		label.setFont(new Font("Maplestory", Font.BOLD, 70));
		label.setBounds(517, 179, 367, 92);
		add(label);
		
		ButtonHandler bth = new ButtonHandler();
		
		JButton button_1 = new JButton("\uB3CC\uC544\uAC00\uAE30\r\n");
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.setIcon(new ImageIcon(LocalLobbyView.class.getResource("/localView/return.png")));
		button_1.setBackground(Color.WHITE);
		button_1.setFont(new Font("Maplestory", Font.PLAIN, 36));
		button_1.setBounds(375, 508, 270, 60);
		add(button_1);
		button_1.addActionListener(new ButtonHandler());
		
		JButton button_2 = new JButton("\uAC8C\uC784\uC2DC\uC791");
		button_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_2.setIcon(new ImageIcon(LocalLobbyView.class.getResource("/localView/play.png")));
		button_2.setBackground(Color.WHITE);
		button_2.setFont(new Font("Maplestory", Font.PLAIN, 36));
		button_2.setBounds(682, 508, 270, 60);
		add(button_2);
		button_2.addActionListener(new ButtonHandler());
		
		JLabel label_1 = new JLabel("\uD50C\uB808\uC774\uC5B42");
		label_1.setFont(new Font("Maplestory", Font.PLAIN, 36));
		label_1.setBounds(530, 405, 165, 60);
		add(label_1);
		
		JLabel label_2 = new JLabel("\uD50C\uB808\uC774\uC5B41");
		label_2.setFont(new Font("Maplestory", Font.PLAIN, 36));
		label_2.setBounds(530, 321, 149, 60);
		add(label_2);
		
		comboBox = new JComboBox<ImageIcon>();
		comboBox.addItem(new ImageIcon(LocalLobbyView.class.getResource("/localView/rabitface.png")));
		comboBox.addItem(new ImageIcon(LocalLobbyView.class.getResource("/localView/turtleface.png")));
		comboBox.setBounds(692, 322, 73, 60);
		add(comboBox);
		
		comboBox_1 = new JComboBox<ImageIcon>();
		comboBox_1.addItem(new ImageIcon(LocalLobbyView.class.getResource("/localView/rabitface.png")));
		comboBox_1.addItem(new ImageIcon(LocalLobbyView.class.getResource("/localView/turtleface.png")));
		comboBox_1.setBounds(692, 406, 73, 60);
		add(comboBox_1);
	}
	
	class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("게임시작")){
				System.out.println("[게임시작 클릭]");
				if(comboBox.getSelectedIndex() == 0) {
					System.out.print(", 캐릭터 : 토끼");
					comboBox.setName("Rabbit");
					}
				else {
					System.out.print(", 캐릭터 : 거북이");
					comboBox.setName("Turtle");
				}
				
				if(comboBox_1.getSelectedIndex() == 0) {
					System.out.println(", 캐릭터 : 토끼)");
					comboBox_1.setName("Rabbit");
				}
				else {
					System.out.println(", 캐릭터 : 거북이)");
					comboBox_1.setName("Turtle");
				}
				
//				플레이어 캐릭터 세팅 부분 (20190525)
				if (!comboBox.getName().equals(comboBox_1.getName())) {
					GameServiceManager.getInstance().setPlayerMarker(comboBox.getName(), comboBox_1.getName());
					ChangePanelService.getInstance().initiateGame("LocalInGameView");
					ChangePanelService.getInstance().changePanel("LocalInGameView");
				}
				
			}else {
				System.out.println("[돌아가기 클릭]");
				ChangePanelService.getInstance().changePanel("MainMenuView");
			}
		}
	}
}