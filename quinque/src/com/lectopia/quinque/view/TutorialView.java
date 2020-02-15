package com.lectopia.quinque.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TutorialView extends JPanel {
	
	private CardLayout layout;
	private TutorialView tv;
	private ArrayList<JPanel> ary;
	
	JPanel panel = null, panel_1;
	/**
	 * Create the panel.
	 */
	
	public TutorialView() {
		tv = this;
		layout = new CardLayout();
		ary = new ArrayList<JPanel>();
		
		ButtonHandler btn = new ButtonHandler();
		
		setBounds(100,100, 1280, 720);
//		setBackground(new Color(244,228,223));
		setBackground(new Color(232, 232, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(layout);
		
		for(int i=0;i<24;i++) {
			ary.add(new JPanel());
			ary.get(i).setLayout(null);
			
			JButton prev = new JButton("");
			prev.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			prev.setIcon(new ImageIcon(TutorialView.class.getResource("/tutorialUI/prev2.png")));
			prev.setContentAreaFilled(false);
			prev.setFocusPainted(false);
			prev.setBorderPainted(false);
			prev.setBounds(450, 630, 150, 40);
			ary.get(i).add(prev);
			prev.addActionListener(btn);
			
			JButton home = new JButton("");
			home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			home.setIcon(new ImageIcon(TutorialView.class.getResource("/tutorialUI/home.png")));
			home.setContentAreaFilled(false);
			home.setFocusPainted(false);
			home.setBorderPainted(false);
			home.setBounds(580, 640, 97, 23);
			ary.get(i).add(home);
			home.addActionListener(btn);
			
			JButton next = new JButton("");
			next.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			next.setIcon(new ImageIcon(TutorialView.class.getResource("/tutorialUI/next2.png")));
			next.setContentAreaFilled(false);
			next.setFocusPainted(false);
			next.setBorderPainted(false);
			next.setBounds(660, 630, 150, 40);
			ary.get(i).add(next);
			next.addActionListener(btn);
			
			JLabel tuto = new JLabel("");
			tuto.setBounds(-65, 52, 1302, 603);
			if(i==5) {tuto.setBounds(-65, 73, 1302, 603);}
			if(i==9) {tuto.setBounds(-60, 35, 1302, 603);}
			if(i==7||i==8||i==10) {tuto.setBounds(-65, 35, 1302, 603);}
			if(i==11) {tuto.setBounds(-77, 39, 1302, 603);}
			if(i==12) {tuto.setBounds(-75, 42, 1302, 603);}
			if(i>12) {tuto.setBounds(-65, 39, 1302, 603);}
			if(i==20) {tuto.setBounds(-65, 42, 1302, 603);}
			if(i==23){tuto.setBounds(-73, 39, 1302, 603);}
			tuto.setIcon(new ImageIcon(TutorialView.class.getResource("/tutorialUI/tuto" +(i+1)+".png")));
			tuto.setBackground(new Color(244,228,223));
			
//			ary.get(i).setBackground(new Color(244,228,223));
			ary.get(i).setBackground(new Color(232, 232, 255));
			ary.get(i).setLayout(null);
			ary.get(i).add(prev);
			ary.get(i).add(next);
			ary.get(i).add(home);
			ary.get(i).add(tuto);
			
			add(ary.get(i));
		}
	}
	
	private class ButtonHandler implements ActionListener{
		private int index;
		public void actionPerformed(ActionEvent e) {
			if(((JButton)e.getSource()).getX() == 660) {
				layout.next(tv);
				index++;
				if(index == 24) {ChangePanelService.getInstance().changePanel("MainMenuView");}
			}
			else if (((JButton)e.getSource()).getX() == 450){
				layout.previous(tv);
				index--;
			}else if (((JButton)e.getSource()).getX() == 580){
				ChangePanelService.getInstance().changePanel("MainMenuView");
				layout.first(tv);
			}
		}
	}
}
