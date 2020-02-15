package com.lectopia.quinque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class MultiInGameView extends JPanel {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final JPanel panel = new JPanel();
	
	private JLabel stoneImage;
	private JLabel moveEffect;
	
	private JButton[] characters;

	private JButton actionCharacter;
	
	private JButton[] selectCharacter;
	
	private JButton characterCursor, rollButton, actionButton, selectButton;
	private boolean isRoll;	
	private boolean gageFlag;
	
	
	private Rectangle prevState;
	
	public MultiInGameView() {
	  setBounds(100,100, 1280, 720);
	  setBorder(new EmptyBorder(5, 5, 5, 5));
	  setLayout(null);
	  
	  selectCharacter = new JButton[2];
	  characters = new JButton[4];
	  actionCharacter = null;
	  characterCursor = null;
	  isRoll = false;
	  
	  JLabel[] boxes = new JLabel[25];
      
	  CharacterButtonHandler characterButtonHandler = new CharacterButtonHandler();
	  BoxHandler boxHandler = new BoxHandler();
	  
	  Rectangle stoneRectangle = new Rectangle(990, 49, 170, 150);
	  
	  selectCharacter[0] = new JButton();
	  selectCharacter[1] = new JButton();
	  
	  selectCharacter[0].setBounds(456, 238, 300, 300);
	  selectCharacter[1].setBounds(756, 238, 300, 300);
	  
	  selectCharacter[0].setVisible(false);
	  selectCharacter[1].setVisible(false);
	  
	  add(selectCharacter[0]);
	  add(selectCharacter[1]);
	  
	  JLabel chatText = new JLabel("");
	  chatText.setBounds(1050, 500, 300, 30);
	  chatText.setVisible(false);
	  add(chatText);
	  
	  JLabel chatBox = new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/chatBox.png")));
	  chatBox.setBounds(950, 450, 300, 150);
	  chatBox.setVisible(false);
	  add(chatBox);
	  
	  JTextField chat = new JTextField();
	  chat.setBounds(950, 504, 300, 30);
	  chat.setVisible(false);
	  add(chat);
	  
	  
	  JLabel chooseTable = new JLabel(new ImageIcon(LocalInGameView.class.getResource("/playUI/chooseTable.png")));
	  chooseTable.setBounds(400, 238, 500, 300);
	  chooseTable.setVisible(false);
	  
	  
	  JLabel backUnus01 = new JLabel("");
	  backUnus01.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/backUnus01.png")));
	  backUnus01.setBounds(stoneRectangle);
      
      JLabel backUnus02 = new JLabel("");
	  backUnus02.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/backUnus02.png")));
	  backUnus02.setBounds(stoneRectangle);
      
      JLabel backUnus03 = new JLabel("");
      backUnus03.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/backUnus03.png")));
      backUnus03.setBounds(stoneRectangle);
      
      JLabel unus01 = new JLabel("");
      unus01.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/unus01.png")));
      unus01.setBounds(stoneRectangle);
     
      JLabel unus02 = new JLabel("");
      unus02.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/unus02.png")));
      unus02.setBounds(stoneRectangle);
      
      JLabel unus03 = new JLabel("");
      unus03.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/unus03.png")));
      unus03.setBounds(stoneRectangle);
      
      JLabel duo01 = new JLabel("");
      duo01.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/duo01.png")));
      duo01.setBounds(stoneRectangle);
      
      JLabel duo02 = new JLabel("");
      duo02.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/duo02.png")));
      duo02.setBounds(stoneRectangle);
      
      JLabel duo03 = new JLabel("");
      duo03.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/duo03.png")));
      duo03.setBounds(stoneRectangle);
      
      JLabel tres01 = new JLabel("");
      tres01.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/tres01.png")));
      tres01.setBounds(stoneRectangle);
      
      JLabel tres02 = new JLabel("");
      tres02.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/tres02.png")));
      tres02.setBounds(stoneRectangle);
     
      JLabel tres03 = new JLabel("");
      tres03.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/tres03.png")));
      tres03.setBounds(stoneRectangle);
      
      JLabel tres04 = new JLabel("");
      tres04.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/tres04.png")));
      tres04.setBounds(stoneRectangle);
      
      JLabel quattuor01 = new JLabel("");
      quattuor01.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/quattuor01.png")));
      quattuor01.setBounds(stoneRectangle);
      
      JLabel quattuor02 = new JLabel("");
      quattuor02.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/quattuor02.png")));
      quattuor02.setBounds(stoneRectangle);
      
      JLabel quattuor03 = new JLabel("");
      quattuor03.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/quattuor03.png")));
      quattuor03.setBounds(stoneRectangle);
      
      JLabel quinque01 = new JLabel("");
      quinque01.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/quinque01.png")));
      quinque01.setBounds(stoneRectangle);
     
      JLabel quinque02 = new JLabel("");
      quinque02.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/quinque02.png")));
      quinque02.setBounds(stoneRectangle);
     
      ArrayList<JLabel> backUnus = new ArrayList<JLabel>();
      
      backUnus.add(backUnus01);
      backUnus.add(backUnus02);
      backUnus.add(backUnus03);
      
      ArrayList<JLabel> unus = new ArrayList<JLabel>();
      
      unus.add(unus01);
      unus.add(unus02);
      unus.add(unus03);
      
      ArrayList<JLabel> duo = new ArrayList<JLabel>();
      
      duo.add(duo01);
      duo.add(duo02);
      duo.add(duo03);
      
      ArrayList<JLabel> tres = new ArrayList<JLabel>();
      
      tres.add(tres01);
      tres.add(tres02);
      tres.add(tres03);
      tres.add(tres04);
      
      ArrayList<JLabel> quattuor = new ArrayList<JLabel>();
      
      quattuor.add(quattuor01);
      quattuor.add(quattuor02);
      quattuor.add(quattuor03);
      
      ArrayList<JLabel> quinque = new ArrayList<JLabel>();
      
      quinque.add(quinque01);
      quinque.add(quinque02);

      ArrayList<ArrayList<JLabel>>quinqueStones = new ArrayList<ArrayList<JLabel>>();
      
      quinqueStones.add(backUnus);
      quinqueStones.add(unus);
      quinqueStones.add(duo);
      quinqueStones.add(tres);
      quinqueStones.add(quattuor);
      quinqueStones.add(quinque);
      
      for (ArrayList<JLabel> stones : quinqueStones) {
    	  for (JLabel stone : stones) {
    		  stone.setVisible(false);
    		  add(stone);
    	  }
      }
      
      JLabel rockEffect = new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/rockEffect.gif")));
      rockEffect.setVisible(false);
      add(rockEffect);
      
      JLabel scissorsEffect = new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/scissorsEffect.gif")));
      scissorsEffect.setVisible(false);
      add(scissorsEffect);
      
      JLabel paperEffect = new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/paperEffect.gif")));
      paperEffect.setVisible(false);
      add(paperEffect);
      
      JButton wildcard = new JButton("");
      wildcard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      wildcard.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/wildcard.png")));
      wildcard.setBounds(148, 276, 114, 197);
      wildcard.setContentAreaFilled(false);
      wildcard.setFocusPainted(false);
      wildcard.setBorderPainted(false);
      
      JButton paper = new JButton("");
      paper.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      paper.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/paper.png")));
      paper.setBounds(225, 350, 99, 161);
      paper.setContentAreaFilled(false);
      paper.setFocusPainted(false);
      paper.setBorderPainted(false);
      
      JButton scissors = new JButton("");
      scissors.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      scissors.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/scissors.png")));
      scissors.setBounds(315, 406, 81, 150);
      scissors.setContentAreaFilled(false);
      scissors.setFocusPainted(false);
      scissors.setBorderPainted(false);
      
      JButton rock = new JButton("");
      rock.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      rock.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/rock.png")));
      rock.setBounds(403, 462, 89, 144);
      rock.setContentAreaFilled(false);
      rock.setFocusPainted(false);
      rock.setBorderPainted(false);
      
      JLabel rabbitRockAction = new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/rabbitRockAction.gif")));
      rabbitRockAction.setBounds(rock.getBounds());
      rabbitRockAction.setVisible(false);
      
      JLabel rabbitScissorsAction = new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/rabbitScissorsAction.gif")));
      rabbitScissorsAction.setBounds(scissors.getBounds());
      rabbitScissorsAction.setVisible(false);
      
      JLabel rabbitPaperAction = new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/rabbitPaperAction.gif")));
      rabbitPaperAction.setBounds(paper.getBounds());
      rabbitPaperAction.setVisible(false);
      
      add(rabbitRockAction);
      add(rabbitScissorsAction);
      add(rabbitPaperAction);
      
      add(rock);
      add(scissors);
      add(paper);
      add(wildcard);
     
      characters[0] = wildcard;
      characters[1] = rock;
      characters[2] = scissors;
      characters[3] = paper;
    		  
      wildcard.addActionListener(characterButtonHandler);
      paper.addActionListener(characterButtonHandler);
      scissors.addActionListener(characterButtonHandler);
      rock.addActionListener(characterButtonHandler);
      
      JPanel panel_2 = new JPanel();
      panel_2.setBackground(new Color(255, 255, 255));
      panel_2.setOpaque(false);
      panel_2.setBorder(new LineBorder(new Color(153, 204, 255), 3));
      panel_2.setBounds(0, 0, 314, 150);
      add(panel_2);
      panel_2.setLayout(null);
      
      JLabel character2 = new JLabel("");
      character2.setBorder(new LineBorder(new Color(153, 204, 255), 3));
      character2.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/turtle.png")));
      character2.setBounds(0, 0, 119, 150);
      panel_2.add(character2);
      
      JLabel name2 = new JLabel("\uD0A4\uC704\uB9DB\uC0AC\uACFC");
      name2.setOpaque(true);
      name2.setBorder(new LineBorder(new Color(153, 204, 255), 3));
      name2.setHorizontalAlignment(SwingConstants.CENTER);
      name2.setForeground(Color.BLACK);
      name2.setFont(new Font("Maplestory", Font.PLAIN, 24));
      name2.setBackground(new Color(153, 204, 255));
      name2.setBounds(116, 105, 198, 45);
      panel_2.add(name2);
      
      moveEffect = new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/moveEffect.gif")));
      moveEffect.setVisible(false);
      add(moveEffect);
      
	  JLabel gage = new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/gage.gif")));
	  gage.setBounds(1011, 344, 300, 112);
	  gage.setVisible(false);
	  add(gage);
      
      rollButton = new JButton("");
      rollButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      rollButton.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/ROLL.png")));
      rollButton.setBounds(1091, 394, 145, 112);
      rollButton.setContentAreaFilled(false);
      rollButton.setFocusPainted(false);
      rollButton.setBorderPainted(false);
      add(rollButton);
      
      actionButton = new JButton("");
      actionButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      actionButton.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/attack.png")));
      actionButton.setBounds(1000, 424, 100, 100);
      actionButton.setContentAreaFilled(false);
      actionButton.setFocusPainted(false);
      actionButton.setBorderPainted(false);
      actionButton.setVisible(false);
      add(actionButton);
      
      selectButton = new JButton("");
      selectButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      selectButton.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/selectButton.png")));
      selectButton.setBounds(950, 424, 100, 100);
      selectButton.setContentAreaFilled(false);
      selectButton.setFocusPainted(false);
      selectButton.setBorderPainted(false);
      selectButton.setVisible(false);
      add(selectButton);
      
      add(chooseTable);
      
      selectButton.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    		  if (!chooseTable.isVisible()) {
    			  if (actionCharacter != null) {
		    		  chooseTable.setVisible(true);
		    		  selectCharacter[0] = actionCharacter;
		    		  prevState = actionCharacter.getBounds();
		    		  selectCharacter[0].setBounds(430, 238, 300, 300);
		    		  selectCharacter[0].setVisible(true);
    			  }
    		  }
    		  else {
    			  chooseTable.setVisible(false);
    			  selectCharacter[0].setVisible(false);
    			  selectCharacter[0].setBounds(prevState);
    			  selectCharacter[0].setVisible(true);
    		  }
    	  }
      });
      
      actionButton.addActionListener(new ActionListener() {
    	private int i;
    	@Override
		public void actionPerformed(ActionEvent e) {
    		for (i = 0; i < characters.length; i++) {
    			if (actionCharacter == characters[i]) break;
    		} 
    		
    		Thread action = new Thread() {
				public void run() {
	    			switch(i) {
			    		case 1 : 
			    			rock.setVisible(false);
			    			rabbitRockAction.setBounds(rock.getX() - 150, rock.getY() - 150, rock.getWidth() + 300, rock.getHeight() + 300);
			    			rabbitRockAction.setVisible(true);
			    			break;
			    		case 2 :
			    			scissors.setVisible(false);
			    			rabbitScissorsAction.setBounds(scissors.getX() - 150, scissors.getY() - 150, scissors.getWidth() + 300, scissors.getHeight() + 300);
			    			rabbitScissorsAction.setVisible(true);
			    			break;
			    		case 3 :
			    			paper.setVisible(false);
			    			rabbitPaperAction.setBounds(paper.getX() - 150, paper.getY() - 150, paper.getWidth() + 300, paper.getHeight() + 300);
			    			rabbitPaperAction.setVisible(true);
			    			break;
					}
	    			
	    			try {
						sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    			
	    			switch(i) {
			    		case 1 : 
			    			rock.setVisible(true);
			    			rabbitRockAction.setVisible(false);
			    			rockEffect.setBounds(rabbitRockAction.getX() + 50, rabbitRockAction.getY(), rabbitRockAction.getWidth(), rabbitRockAction.getHeight());
			    			rockEffect.setVisible(true);
			    			break;
			    		case 2 :
			    			scissors.setVisible(true);
			    			rabbitScissorsAction.setVisible(false);
			    			scissorsEffect.setBounds(rabbitScissorsAction.getX() + 50, rabbitScissorsAction.getY(), rabbitScissorsAction.getWidth(), rabbitScissorsAction.getHeight());
			    			scissorsEffect.setVisible(true);
			    			break;
			    		case 3 :
			    			paper.setVisible(true);
			    			rabbitPaperAction.setVisible(false);
			    			paperEffect.setBounds(rabbitPaperAction.getX() + 50, rabbitPaperAction.getY(), rabbitPaperAction.getWidth(), rabbitPaperAction.getHeight());
			    			paperEffect.setVisible(true);
				    		break;
					}
	    			
	    			
	    			try {
	    				sleep(500);
	    			} catch (InterruptedException e) {
	    				e.printStackTrace();
	    			}
	    			
	    			switch(i) {
		    		case 1 : 
		    			rockEffect.setVisible(false);
		    			break;
		    		case 2 :
		    			scissorsEffect.setVisible(false);
		    			break;
		    		case 3 :
		    			paperEffect.setVisible(false);
			    		break;
				}
	    			
	    			
				}
    		};
    		action.start();
    		actionButton.setVisible(false);
    		actionCharacter = null;
		}
      });
      
      JLabel plate = new JLabel("");
      plate.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/plate.png")));
      plate.setBounds(879, -35, 599, 359);
     
      
      JLabel stoneRollAction = new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/stoneRollAction.gif")));
      stoneRollAction.setBounds(plate.getX() - 90, plate.getY() - 80, plate.getWidth(), plate.getHeight());
      stoneRollAction.setVisible(false);
      
      add(stoneRollAction);
      add(plate);
       
      rollButton.addActionListener(new ActionListener() {
    	  	public void actionPerformed(ActionEvent e) {
    	  		if (gageFlag) {
	    	  		if (!isRoll) {
	    	  			gage.setVisible(false);
		  	  			
	    	  			int key = (int) (Math.random() * 6);
	    	  			System.out.println(key);
	    	  			Thread stoneAction = new Thread() {
	    					public void run() {
	    						stoneRollAction.setVisible(true);
	    						try {
									sleep(750);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
	    						stoneRollAction.setVisible(false);
	    						Collections.shuffle(quinqueStones.get(key));
	    						stoneImage = quinqueStones.get(key).get(0);
	    						stoneImage.setVisible(true);
	    					}
	    				};
	       				stoneAction.start();
	    				isRoll = true;
	    				((JButton) (e.getSource())).setVisible(false); 
	    	  		}
	    	  		gageFlag = false;
    	  		}
    	  		else {
	  	  			gage.setVisible(true);
	  	  			gageFlag = true;
	  	  		}
    	  	}
      });
      
      panel.setOpaque(false);
      panel.setBorder(new LineBorder(new Color(255, 204, 204), 3));
      panel.setBounds(950, 531, 314, 150);
      add(panel);
      panel.setLayout(null);
      
      JLabel chracter1 = new JLabel("");
      chracter1.setBorder(new LineBorder(new Color(255, 204, 204), 3));
      chracter1.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/rabbit.png")));
      chracter1.setBounds(195, 0, 119, 150);
      panel.add(chracter1);
      
      JLabel name1 = new JLabel("\uACC4\uD53C\uC870\uC544\uC2DC\uB098\uBAAC\uC2DC\uB7EC");
      name1.setOpaque(true);
      name1.setBorder(new LineBorder(new Color(255, 204, 204), 3));
      name1.setHorizontalAlignment(SwingConstants.CENTER);
      name1.setBackground(new Color(255, 204, 204));
      name1.setForeground(Color.BLACK);
      name1.setFont(new Font("Maplestory", Font.PLAIN, 24));
      name1.setBounds(0, 105, 198, 45);
      panel.add(name1);
      
      JButton option1 = new JButton("");
      option1.setOpaque(false);
      option1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      option1.setContentAreaFilled(false);
      option1.setFocusPainted(false);
      option1.setBorderPainted(false);
      option1.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/return.png")));
      option1.setBounds(97, 22, 73, 73);
      panel.add(option1);
      
      option1.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    		  ChangePanelService.getInstance().changePanel("MultiPlayListView");
    	  }
      });
      
      JButton bubble1 = new JButton("");
      bubble1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      bubble1.setContentAreaFilled(false);
      bubble1.setFocusPainted(false);
      bubble1.setBorderPainted(false);
      bubble1.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/option1.png")));
      bubble1.setBounds(12, 22, 73, 73);
      panel.add(bubble1);
      
      
      bubble1.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    		  if (chat.isVisible()) {
    			  chatText.setText(chat.getText()); 	
    			  
    			  new Thread() {
    				  public void run() {
    					  chatBox.setVisible(true);
    					  chatText.setVisible(true);
    					  try {
							sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
    					  chatText.setVisible(false);
    	    			  chatBox.setVisible(false);
    	    			  chatText.setText("");
    	    			  chat.setText("");
    	    			  
    				  } 
    				  
    			  }.start();
    			  
    			  chat.setVisible(false);
    			  
    		  }
    		  else 
    			  chat.setVisible(true);
    	  }
      });
      
      for (int i = 0; i < boxes.length; i++) {
    	  boxes[i] = new JLabel("");
      }
      
      boxes[0].setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blueBlock.png")));
	    boxes[0].setBounds(596, 504, 157, 167);
	    add(boxes[0]);
	    
	    boxes[15].setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blackBlock.png")));
	    boxes[15].setBounds(504, 477, 129, 125);
	    add(boxes[15]);
	    
	    boxes[14].setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blackBlock.png")));
	    boxes[14].setBounds(432, 431, 129, 125);
	    add(boxes[14]);
	      
	    boxes[16].setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blackBlock.png")));
	    boxes[16].setBounds(606, 437, 129, 125);
	    add(boxes[16]);
	     
	    boxes[17].setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blackBlock.png")));
	    boxes[17].setBounds(606, 381, 129, 125);
	    add(boxes[17]);
	    
	    boxes[3].setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blackBlock.png")));
	    boxes[3].setBounds(848, 394, 129, 125);
	    add(boxes[3]);
	    
	    boxes[23].setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blackBlock.png")));
	    boxes[23].setBounds(717, 327, 129, 125);
	    add(boxes[23]);
	    
	    boxes[24].setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blackBlock.png")));
	    boxes[24].setBounds(806, 327, 129, 125);
	    add(boxes[24]);
	    
	    boxes[13].setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blackBlock.png")));
	    boxes[13].setBounds(363, 381, 129, 125);
	    add(boxes[13]);
	    
	    boxes[22].setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blackBlock.png")));
	    boxes[22].setBounds(489, 327, 129, 125);
	    add(boxes[22]);
	    
	    boxes[21].setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blackBlock.png")));
	    boxes[21].setBounds(396, 327, 129, 125);
	    add(boxes[21]);
	    
	    boxes[4].setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blueBlock.png")));
	    boxes[4].setBounds(912, 306, 157, 167);
	    add(boxes[4]);
	    
	    boxes[5].setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blackBlock.png")));
	    boxes[5].setBounds(848, 238, 129, 125);
	    add(boxes[5]);
	    
	    boxes[6].setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blackBlock.png")));
	    boxes[6].setBounds(771, 192, 129, 125);
	    add(boxes[6]);
	    
	    boxes[7].setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blackBlock.png")));
	    boxes[7].setBounds(698, 149, 129, 125);
	    add(boxes[7]);
	     
	    boxes[12].setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blueBlock.png")));
	    boxes[12].setBounds(274, 291, 157, 167);
	    add(boxes[12]);
	    
	    boxes[11].setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blackBlock.png")));
	    boxes[11].setBounds(363, 238, 129, 125);
	    add(boxes[11]);
	    
	    boxes[10].setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blackBlock.png")));
	    boxes[10].setBounds(436, 197, 129, 125);
	    add(boxes[10]);
	    
	    boxes[9].setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blackBlock.png")));
	    boxes[9].setBounds(513, 149, 129, 125);
	    add(boxes[9]);
	    
	    boxes[1].setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blackBlock.png")));
	    boxes[1].setBounds(698, 483, 129, 125);
	    add(boxes[1]);
	    
	    boxes[2].setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blackBlock.png")));
	    boxes[2].setBounds(771, 442, 129, 125);
	    add(boxes[2]);
	    
	    boxes[18].setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blueBlock.png")));
	    boxes[18].setBounds(596, 306, 157, 167);
	    add(boxes[18]);
	    
	    boxes[19].setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blackBlock.png")));
	    boxes[19].setBounds(606, 238, 129, 125);
	    add(boxes[19]);
	    
	    boxes[20].setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blackBlock.png")));
	    boxes[20].setBounds(606, 175, 129, 125);
	    add(boxes[20]);
	    
	    boxes[8].setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blueBlock.png")));
	    boxes[8].setBounds(596, 89, 157, 167);
	    add(boxes[8]);
      
      JLabel windmill = new JLabel("");
      windmill.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/home.png")));
      windmill.setBounds(-25, 374, 239, 345);
      add(windmill);
      
      JLabel black1 = new JLabel("");
      black1.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blackstone.png")));
      black1.setBounds(379, 575, 122, 116);
      add(black1);
      
      JLabel black2 = new JLabel("");
      black2.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blackstone.png")));
      black2.setBounds(294, 521, 122, 116);
      add(black2);
      
      JLabel black3 = new JLabel("");
      black3.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blackstone.png")));
      black3.setBounds(218, 475, 122, 116);
      add(black3);
      
      JLabel black4 = new JLabel("");
      black4.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blackstone.png")));
      black4.setBounds(137, 411, 122, 116);
      add(black4);
      
      for (JLabel box : boxes) {
    	  box.addMouseListener(boxHandler);
      }
        
      black1.addMouseListener(boxHandler);
      black2.addMouseListener(boxHandler);
      black3.addMouseListener(boxHandler);
      black4.addMouseListener(boxHandler);
      
      
      JLabel background = new JLabel("");
      background.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/background.png")));
      background.setBounds(0, 0, 1264, 681);
      add(background);
   }
   
	private class CharacterButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (((JButton) (e.getSource())).isVisible() && characterCursor == null && isRoll) {
				moveEffect.setBounds(((JButton) (e.getSource())).getBounds());
				Thread moveThread = new Thread() {
					public void run() {
						moveEffect.setVisible(true);
						try {
							sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						moveEffect.setVisible(false);
					}
				};
				moveThread.start();
				
				Thread moveCharacter = new Thread() {
					public void run() {
						((JButton) (e.getSource())).setVisible(false);
						try {
							sleep(500);
						} catch(InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				};
				moveCharacter.start();
				
				characterCursor = (JButton) (e.getSource());
				actionCharacter = characterCursor;
				actionButton.setVisible(true);
				selectButton.setVisible(true);
			}
			else if (((JButton) (e.getSource())) != characterCursor && isRoll) {
				characterCursor.setVisible(true);
				((JButton) (e.getSource())).setVisible(false);
				characterCursor = ((JButton) (e.getSource()));
			}
			else {
				((JButton) (e.getSource())).setVisible(true);
			}
		}
		
	}
	
	private class BoxHandler extends MouseAdapter {
		
	    public void mouseClicked(MouseEvent e) {
		   if (characterCursor != null) {
			   System.out.println("[Click]");
			   if (characterCursor.isVisible()) {
				   characterCursor = null;
			   }
			   else {
				 characterCursor.setBounds(((JLabel) (e.getSource())).getX(), ((JLabel) (e.getSource())).getY() - 100, characterCursor.getWidth(), characterCursor.getHeight());
				
				 moveEffect.setBounds(characterCursor.getBounds());
					Thread moveThread = new Thread() {
						public void run() {
							moveEffect.setVisible(true);
							try {
								sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							moveEffect.setVisible(false);
						}
					};
					moveThread.start();
					
					Thread moveCharacter = new Thread() {
						public void run() {
							try {
								sleep(500);
							} catch(InterruptedException e) {
								e.printStackTrace();
							}
							characterCursor.setVisible(true);	
							characterCursor = null;
						}
						
					};
				 moveCharacter.start();	
				 
				 stoneImage.setVisible(false);
				 isRoll = false;
				 rollButton.setVisible(true);
			   }
		   }
	    }
   }
}