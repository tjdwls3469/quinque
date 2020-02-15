package com.lectopia.quinque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.lectopia.quinque.service.GameServiceManager;


public class LocalInGameView extends JPanel { 


	/**
	*
	*/
	private static final long serialVersionUID = 1L;
	
	// 퀸키 스톤 이미지
	private JLabel stoneImage;
	private JLabel prevQuinque;
	private JLabel victoryIcon1p, victoryIcon2p;

	// 이동 효과
	private JLabel moveEffect;
	
	// player1의 캐릭터(말)들이 저장된 배열
	private JButton[] player1Characters;
	
	// player2의 캐릭터(말)들이 저장된 배열
	private JButton[] player2Characters;
	
	// 병합할 때 선택할 캐릭터들이 저장될 배열
	private JButton[] selectCharacter;
	
	// Cursor : 플레이어가 캐릭터 선택시 선택한 캐릭터의 참조값 저장 변수
	// rollButton : 주사위 굴리기 버튼
	private JButton player1Cursor, player2Cursor, rollButton, selectButton;
	
	private JLabel[] mapTiles;
	private JLabel[] arrows;
	
	// 퀸키 스톤 이미지들이 저장된 컬렉션 (우누스, 두오 등 각각의 경우 별로 나누어 따로 저장함
	private ArrayList<ArrayList<JLabel>> quinqueStones;
	
	// 퀸키 스톤 이미지를 나타낼 위치 좌표
	private Rectangle stoneRectangle;
	
	// 주사위버튼을 눌렀는지 체크하는 플래그
	private boolean isRoll;
	
	// 주사위버튼을 한 번 눌렀을 때는 게이지가 나오고,
	// 그 다음 눌렀을 때 퀸키스톤이 던져지게 하기 위한 플래그
	private JLabel gage;
	private boolean gageFlag;
	
	// 현재 턴 정보 저장 변수
	private int turn;
	
	// 합병을 위해 중앙으로 이동한 캐릭터의 원래 위치를 저장할 변수
	private Rectangle prevState;
	
	private JLabel rabbitRockAction, rabbitScissorsAction, rabbitPaperAction, rabbitWildcardAction;
	private JLabel turtleRockAction, turtleScissorsAction, turtlePaperAction, turtleWildcardAction;
	
	private JLabel standTile;
	
	private JLabel rockEffect, scissorsEffect, paperEffect, rabbitWildcardEffect, turtleWildcardEffect;
	private JLabel rabbitLose, turtleLose;
	
	boolean mergeFlag;
	String tempKeyCane;
	
	ArrayList<Integer> destinationList;
	
	public LocalInGameView() {
		setBounds(0, 0, 1280, 720);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		CharacterButtonHandler characterButtonHandler = new CharacterButtonHandler();
		TileHandler tileHandler = new TileHandler();
		
		mergeFlag = false;
		tempKeyCane = "";
		
		rabbitLose = new JLabel();
		turtleLose = new JLabel();
		
		rabbitLose.setVisible(false);
		turtleLose.setVisible(false);
		
		add(rabbitLose);
		add(turtleLose);
		
		rabbitLose.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/rabbitLose.gif")));
		turtleLose.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/turtleLose.gif")));

		victoryIcon2p = new JLabel("");
		victoryIcon2p.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/cup2.png")));
		victoryIcon2p.setBounds(240, 28, 756, 625);
		victoryIcon2p.setVisible(false);
		add(victoryIcon2p);
		

		victoryIcon1p = new JLabel("");
		victoryIcon1p.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/cup1.png")));
		victoryIcon1p.setBounds(240, 28, 756, 625);
		victoryIcon1p.setVisible(false);
		// 0528_20:01
		// 1P승리 아이콘 추가
		add(victoryIcon1p);
		

		
		standTile = new JLabel();
		standTile.setName("-1");
		standTile.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/blackstone.png")));
		
		stoneRectangle = new Rectangle(990, 49, 200, 200);
		prevQuinque = new JLabel();
		prevQuinque.setBounds(850, 10, 150, 100);
		prevQuinque.setFont(new Font("Arial", Font.BOLD, 24));
		prevQuinque.setVisible(false);
		add(prevQuinque);
		
		mapTiles = new JLabel[GameServiceManager.getInstance().getMapResource().size()];
		for (int i = 0; i < mapTiles.length; i++) {
			mapTiles[i] = new JLabel();
			mapTiles[i].addMouseListener(tileHandler);
		}
		
		arrows = new JLabel[mapTiles.length];
		for(int i=0; i<arrows.length; i++) {
			arrows[i] = new JLabel();
			arrows[i].setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/arrow.gif")));
			add(arrows[i]);
		}
		
		selectCharacter = new JButton[2];
		
		player1Characters = new JButton[4];
		player2Characters = new JButton[4];
		
		player1Cursor = null;
		player2Cursor = null;
		turn = GameServiceManager.getInstance().getCurrentTurn();
		isRoll = false;
		gageFlag = false;
		
		selectCharacter[0] = new JButton();
		selectCharacter[1] = new JButton();
		
		selectCharacter[0].setBounds(456, 238, 300, 300);
		selectCharacter[1].setBounds(756, 238, 300, 300);
		
		selectCharacter[0].setVisible(false);
		selectCharacter[1].setVisible(false);
		
		add(selectCharacter[0]);
		add(selectCharacter[1]);
		
		addQuinqueStones();
		
		JLabel chooseTable = new JLabel(new ImageIcon(LocalInGameView.class.getResource("/playUI/chooseTable.png")));
		chooseTable.setBounds(400, 238, 500, 300);
		chooseTable.setVisible(false);
	
		rockEffect = new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/rockEffect.gif")));
		rockEffect.setVisible(false);
		add(rockEffect);
		
		scissorsEffect = new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/scissorsEffect.gif")));
		scissorsEffect.setVisible(false);
		add(scissorsEffect);
	
		paperEffect = new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/paperEffect.gif")));
		paperEffect.setVisible(false);
		add(paperEffect);
		
		rabbitWildcardEffect = new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/rabbitWildcardEffect.gif")));
		rabbitWildcardEffect.setVisible(false);
		add(rabbitWildcardEffect);
		
		turtleWildcardEffect = new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/turtleWildcardEffect.gif")));
		turtleWildcardEffect.setVisible(false);
		add(turtleWildcardEffect);
	
		for (int i = 0; i < player1Characters.length; i++) {
			player1Characters[i] = new JButton();
			player1Characters[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			player1Characters[i].setFocusPainted(false);
			player1Characters[i].setContentAreaFilled(false);
			player1Characters[i].setBorderPainted(false);
			add(player1Characters[i]);
			player1Characters[i].addActionListener(characterButtonHandler);
			
			player2Characters[i] = new JButton();
			player2Characters[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			player2Characters[i].setFocusPainted(false);
			player2Characters[i].setContentAreaFilled(false);
			player2Characters[i].setBorderPainted(false);
			add(player2Characters[i]);
			player2Characters[i].addActionListener(characterButtonHandler);
		}
			
		turtleRockAction = new JLabel(new ImageIcon(LocalInGameView.class.getResource("/playUI/turtleRockAction.gif")));
		turtleRockAction.setVisible(false);
	
		turtleScissorsAction = new JLabel(new ImageIcon(LocalInGameView.class.getResource("/playUI/turtleScissorsAction.gif")));
		turtleScissorsAction.setVisible(false);
		
		turtlePaperAction = new JLabel(new ImageIcon(LocalInGameView.class.getResource("/playUI/turtlePaperAction.gif")));
		turtlePaperAction.setVisible(false);
		
		add(turtleRockAction);
		add(turtleScissorsAction);
		add(turtlePaperAction);
		
		rabbitRockAction = new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/rabbitRockAction.gif")));
		rabbitRockAction.setVisible(false);
		
		rabbitScissorsAction = new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/rabbitScissorsAction.gif")));
		rabbitScissorsAction.setVisible(false);
		
		rabbitPaperAction = new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/rabbitPaperAction.gif")));
		rabbitPaperAction.setVisible(false);
		
		rabbitWildcardAction =  new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/rabbitWildcardAction.gif")));
		rabbitWildcardAction.setVisible(false);
		
		turtleWildcardAction =  new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/turtleWildcardAction.gif")));
		turtleWildcardAction.setVisible(false);
		
		
		add(rabbitRockAction);
		add(rabbitScissorsAction);
		add(rabbitPaperAction);
		add(rabbitWildcardAction);
		add(turtleWildcardAction);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setOpaque(false);
		panel_2.setBorder(new LineBorder(new Color(153, 204, 255), 3));
		panel_2.setBounds(0, 0, 184, 116);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel name2 = new JLabel("1 vs 1 \uB300\uC804");
		name2.setOpaque(true);
		name2.setBorder(new LineBorder(new Color(153, 204, 255), 3));
		name2.setHorizontalAlignment(SwingConstants.CENTER);
		name2.setForeground(Color.BLACK);
		name2.setFont(new Font("Maplestory", Font.PLAIN, 24));
		name2.setBackground(new Color(153, 204, 255));
		name2.setBounds(0, 71, 184, 45);
		panel_2.add(name2);
		
		JButton option2 = new JButton("");
		option2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		option2.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/option2.png")));
		option2.setFocusPainted(false);
		option2.setContentAreaFilled(false);
		option2.setBorderPainted(false);
		option2.setBounds(97, 0, 73, 73);
		panel_2.add(option2);
		
		JButton bubble2 = new JButton("");
		bubble2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bubble2.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/return.png")));
		bubble2.setFocusPainted(false);
		bubble2.setContentAreaFilled(false);
		bubble2.setBorderPainted(false);
		bubble2.setBounds(12, 0, 73, 73);
		panel_2.add(bubble2);
		
		// 로컬 로비로 이동 (뒤로 가기)
		bubble2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// 정보들을 초기화
				if (stoneImage != null)
					stoneImage.setVisible(false);
				rollButton.setVisible(true);
				gage.setVisible(false);
				gageFlag = false;
				
				victoryIcon1p.setVisible(false);
				victoryIcon2p.setVisible(false);
				
				player1Cursor = null;
				player2Cursor = null;
				
				turn = 1;
				isRoll = false;
				
				prevQuinque.setText("");
				prevQuinque.setVisible(false);
				
				GameServiceManager.getInstance().resetGame();
				
				for (JButton player : player1Characters) {
					player.setEnabled(true);
					player.setVisible(true);   
				}
				for (JButton player : player2Characters) {
					player.setEnabled(false);
					player.setVisible(true);   
				}
				ChangePanelService.getInstance().changePanel("LocalLobbyView");
			}
			
		});
		
		moveEffect = new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/moveEffect.gif")));
		moveEffect.setVisible(false);
		add(moveEffect);
		
		gage = new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/gage.gif")));
		gage.setBounds(980, 454, 300, 112);
		gage.setVisible(false);
		add(gage);
		
		rollButton = new JButton("");
		rollButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rollButton.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/ROLL.png")));
		rollButton.setBounds(1060, 504, 145, 112);
		rollButton.setContentAreaFilled(false);
		rollButton.setFocusPainted(false);
		rollButton.setBorderPainted(false);
		add(rollButton);
		
//		selectButton = new JButton("");
//		selectButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		selectButton.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/selectButton.png")));
//		selectButton.setBounds(950, 424, 100, 100);
//		selectButton.setContentAreaFilled(false);
//		selectButton.setFocusPainted(false);
//		selectButton.setBorderPainted(false);
//		selectButton.setVisible(false);
//		add(selectButton);
		
		add(chooseTable);
		
		// 합병된 캐릭터 선택
//		selectButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (!chooseTable.isVisible()) {
//					if (actionCharacter != null) {
//						chooseTable.setVisible(true);
//						selectCharacter[0] = actionCharacter;
//						prevState = actionCharacter.getBounds();
//						selectCharacter[0].setBounds(430, 238, 300, 300);
//						selectCharacter[0].setVisible(true);
//						selectCharacter[0].setEnabled(true);
//					}
//				}
//				else {
//					chooseTable.setVisible(false);
//					selectCharacter[0].setVisible(false);
//					selectCharacter[0].setBounds(prevState);
//					selectCharacter[0].setVisible(true);
//					selectCharacter[0].setEnabled(false);
//				}
//			}
//		});

	    JLabel plate = new JLabel("");
	    plate.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/plate.png")));
	    plate.setBounds(879, -35, 599, 359);
	      
	    JLabel stoneRollAction = new JLabel(new ImageIcon(MultiInGameView.class.getResource("/playUI/stoneRollAction.gif")));
	    stoneRollAction.setBounds(plate.getX() - 90, plate.getY() - 80, plate.getWidth(), plate.getHeight());
	    stoneRollAction.setVisible(false);
	      
	    add(stoneRollAction);
	    add(plate);
	     
	    // 주사위 굴리기
	    rollButton.addActionListener(new ActionListener() {
	    	ArrayList<Integer> quinqueStoneResultSet;
	    	int quinqueStoneResultCheck;
	    	int cp;
	    	
	    	public void actionPerformed(ActionEvent e) {
	    		cp = 0;
	    		quinqueStoneResultCheck = 5;
	  	  		quinqueStoneResultSet = null;
	    		
	  	  		if (gageFlag) {
	  	  				if (stoneImage != null)
	  	  					stoneImage.setVisible(false);
		  	  			// 다음 굴렸을 때
			  	  		if (!isRoll) {
			  	  			gage.setVisible(false);
			  	  			quinqueStoneResultCheck = GameServiceManager.getInstance().rollStone(cp);
			  	  			if (turn == GameServiceManager.getInstance().getCurrentTurn()) {
				  	  			quinqueStoneResultSet = GameServiceManager.getInstance().getQuinqueStoneResultSet();
				  	  			
				  	  			new Thread() {
				   					public void run() {
				   						stoneRollAction.setVisible(true);
				   						((JButton) (e.getSource())).setVisible(false);
				   						try {
											sleep(750);
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
				   						stoneRollAction.setVisible(false);
				   						int res = quinqueStoneResultSet.get((quinqueStoneResultSet.size() - 1));
				   						
				   						if (res == -1) res = 0;
				   						Collections.shuffle(quinqueStones.get(res));
				   						stoneImage = quinqueStones.get(res).get(0);
				   						stoneImage.setVisible(true);
				   						
				   						if (quinqueStoneResultCheck == 5) {
				   							StringBuilder sb = new StringBuilder("");
				   							for (int i = quinqueStoneResultSet.size() - 1; i >= 0; i--) {
				   								sb.append(quinqueStoneResultSet.get(i) + " ");
				   							}
				   							prevQuinque.setText(new String(sb));
				   							prevQuinque.setVisible(true);
				   							
				   							((JButton) (e.getSource())).setVisible(true);
						    				isRoll = false;
						    			}
				   						else {
				   							((JButton) (e.getSource())).setVisible(false);
					   						isRoll = true;
				   						}
				   					}
				   				}.start();
				   				
			  	  			}
			  	  			else {
				  	  			new Thread() {
				   					public void run() {
				   						stoneRollAction.setVisible(true);
				   						try {
											sleep(750);
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
				   						
				   						stoneRollAction.setVisible(false);
				   						Collections.shuffle(quinqueStones.get(0));
				   						stoneImage = quinqueStones.get(0).get(0);
				   						stoneImage.setVisible(true);
				   					}
				  	  			}.start();
				  	  			try {
									Thread.sleep(750);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
			  	  				if (turn == 1) {
									for (int i = 0; i < player1Characters.length; i++) {
										player1Characters[i].setEnabled(false);
									}
									for (int i = 0; i < player2Characters.length; i++) {
										player2Characters[i].setEnabled(true);
									}
			  	  				}
			  	  				else if (turn == 2) {
				  	  				for (int i = 0; i < player1Characters.length; i++) {
										player1Characters[i].setEnabled(true);
									}
									for (int i = 0; i < player2Characters.length; i++) {
										player2Characters[i].setEnabled(false);
									}
			  	  				}
			  	  				
			  	  				turn = GameServiceManager.getInstance().getCurrentTurn();
			  	  			}
			    	  	}
			  	  		gageFlag = false;
			    	}
		  	  		else {
		  	  			gage.setVisible(true);
		  	  			gageFlag = true;
		  	  		}
	    	}
	    });
	    
	    for (int i = 0; i < mapTiles.length; i++) {
	    	add(mapTiles[i]);
	    }
	    
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
	      
	    JLabel black5 = new JLabel("");
	    black5.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/blackstone.png")));
	    black5.setBounds(181, 245, 122, 116);
	    add(black5);
	
	    JLabel black6 = new JLabel("");
	    black6.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/blackstone.png")));
	    black6.setBounds(270, 194, 122, 116);
	    add(black6);
	      
	    JLabel black7 = new JLabel("");
	    black7.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/blackstone.png")));
	    black7.setBounds(352, 143, 122, 116);
	    add(black7);
	      
	    JLabel black8 = new JLabel("");
	    black8.setIcon(new ImageIcon(LocalInGameView.class.getResource("/playUI/blackstone.png")));
	    black8.setBounds(426, 93, 122, 116);
	    add(black8);
	    
	    JLabel background = new JLabel("");
	    background.setIcon(new ImageIcon(MultiInGameView.class.getResource("/playUI/background.png")));
	    background.setBounds(0, 0, 1264, 681);
	    add(background);
	
		this.setFocusable(true);
		this.addKeyListener(new KeyHandler());
	}
	
	// 퀸키 스톤 이미지를 컬렉션에 저장하는 메서드
	private void addQuinqueStones() {
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

		quinqueStones = new ArrayList<ArrayList<JLabel>>();
		
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

	}
	
	private class CharacterButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// 20190526
			if (isRoll) {
				String name = ((JButton) (e.getSource())).getActionCommand();
				GameServiceManager.getInstance().deselectedMarker(name);
				GameServiceManager.getInstance().selectMarker(name);
				destinationList = GameServiceManager.getInstance().searchDestination(name);
				System.out.println("destinationList Size: " + destinationList.size());
				int i = 0;
				for(JLabel tile : mapTiles) {
					for (int dest : destinationList) {
						if (dest == Integer.parseInt(tile.getName())) {
							System.out.print("destList: ");
							System.out.println(dest);
							tile.setEnabled(true);
							arrows[i].setBounds(tile.getX()-30,tile.getY()-120,tile.getWidth(),tile.getHeight()+100);
							arrows[i].setVisible(true);
							i++;
						}
					}
				}
				
				switch (turn) {
					case 1:
						if (((JButton) (e.getSource())).isVisible() && player1Cursor == null && isRoll) {
							moveEffect.setBounds(((JButton) (e.getSource())).getBounds());
							Thread moveThread = new Thread() {
								public void run() {
									((JButton) (e.getSource())).setVisible(false);
									moveEffect.setVisible(true);
									try {
										sleep(500);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
									moveEffect.setVisible(false);
									player1Cursor = (JButton) (e.getSource());
								}
							};
							moveThread.start();
						}
						else if (((JButton) (e.getSource())) != player1Cursor && isRoll) {
							player1Cursor.setVisible(true);
							((JButton) (e.getSource())).setVisible(false);
							player1Cursor = ((JButton) (e.getSource()));
						}
						else {
							((JButton) (e.getSource())).setVisible(true);
						}
						break;
					case 2:
						if (((JButton) (e.getSource())).isVisible() && player2Cursor == null && isRoll) {
							moveEffect.setBounds(((JButton) (e.getSource())).getBounds());
							Thread moveThread = new Thread() {
								public void run() {
									((JButton) (e.getSource())).setVisible(false);
									moveEffect.setVisible(true);
									try {
										sleep(500);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
									moveEffect.setVisible(false);
									player2Cursor = (JButton) (e.getSource());
								}
							};
							moveThread.start();
						}
						else if (((JButton) (e.getSource())) != player2Cursor && isRoll) {
							player2Cursor.setVisible(true);
							((JButton) (e.getSource())).setVisible(false);
							player2Cursor = ((JButton) (e.getSource()));
						}
						else {
							((JButton) (e.getSource())).setVisible(true);
						}
						break;
					default:;
				}	
			}
		}
	}
	
	// 타일들에 달리는 리스너
	// 캐릭터 선택 후 타일 선택시 이동 이팩트 수행 후 캐릭터버튼이 이동한다.
	private class TileHandler extends MouseAdapter {
		String[][] result;
		String lastCommand;
		public void mouseClicked(MouseEvent e) {
			boolean checkTile = false;
			for (int i = 0; i < destinationList.size(); i++) {
				if (Integer.parseInt(((JLabel) e.getSource()).getName()) == destinationList.get(i)) {
					checkTile = true;
					destinationList.remove(i);
				}
			}
			if (((JLabel) e.getSource()).isEnabled() == true && isRoll == true && checkTile == true) {
				result = null;
				result = GameServiceManager.getInstance().moveMarker(Integer.parseInt(((JLabel)e.getSource()).getName()));
				
				System.out.println();
				
				for (int i = 0; i < result.length; i++) {
					System.out.println(result[i][0] + ", " + result[i][1] + ", " + result[i][2]);
				}
				
				for(int i=0; i<arrows.length; i++) {
					arrows[i].setVisible(false);
				}
				
				switch(turn) {
					case 1:
						if (player1Cursor != null) {
							System.out.println("[Click]");
							if (player1Cursor.isVisible()) {
								player1Cursor = null;
							}
							else {
								Thread moveThread = new Thread() {
									public void run() {
										for (int i = 0; i < result.length; i++) {
											if(result[i][1] == null) continue;
											switch(result[i][1]) {
												case "move" :
													move(result[i], player1Cursor);
													try {
														sleep(500);
													} catch (InterruptedException e) {
														e.printStackTrace();
													}
													break;
												case "win" :
													player1Cursor.setIcon(new ImageIcon(LocalInGameView.class.getResource(GameServiceManager.getInstance().getChangeImageURL(player1Cursor.getActionCommand()))));
													win(result[i], player1Cursor);
													try {
														sleep(3000);
													} catch (InterruptedException e) {
														e.printStackTrace();
													}
													break;
												case "draw" :
													player1Cursor.setIcon(new ImageIcon(LocalInGameView.class.getResource(GameServiceManager.getInstance().getChangeImageURL(player1Cursor.getActionCommand()))));
													draw(result[i],player1Cursor);
													try {
														sleep(1500);
													} catch (InterruptedException e) {
														e.printStackTrace();
													}
													break;
												case "lose" :
													player1Cursor.setIcon(new ImageIcon(LocalInGameView.class.getResource(GameServiceManager.getInstance().getChangeImageURL(player1Cursor.getActionCommand()))));
													lose(result[i],player1Cursor);
													try {
														sleep(2000);
													} catch (InterruptedException e) {
														e.printStackTrace();
													}
													break;
												case "merge" :
													move(result[i], player1Cursor);
													break;
												case "chance" :
													move(result[i], player1Cursor);
													break;
												case "finish":
													finish(player1Cursor);
													break;
												case "endgame":
													endGame();
													break;
											}
											lastCommand = result[i][1];
										}
										
										if (!lastCommand.equals("lose") && !lastCommand.equals("finish"))
											player1Cursor.setVisible(true);
										
										GameServiceManager.getInstance().changeTurn();
										
										if (turn != GameServiceManager.getInstance().getCurrentTurn()) {
											turn = GameServiceManager.getInstance().getCurrentTurn();
											try {
												Thread.sleep(750);
											} catch (InterruptedException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											for (int i = 0; i < player1Characters.length; i++) {
												player1Characters[i].setEnabled(false);
											}
											for (int i = 0; i < player2Characters.length; i++) {
												player2Characters[i].setEnabled(true);
											}
										}
										player1Cursor = null;
										if (GameServiceManager.getInstance().getQuinqueStoneResultSet().size() == 0) {
											isRoll = false;
											rollButton.setVisible(true);
											prevQuinque.setVisible(false);
											prevQuinque.setText("");
										}
									}
									
								};
								moveThread.start();
								stoneImage.setVisible(false);
								
							}
						}
						break;
					case 2:	
						if (player2Cursor != null) {
							if (player2Cursor.isVisible()) {
								player2Cursor = null;
							}
							else {
								Thread moveThread = new Thread() {
									public void run() {
										for (int i = 0; i < result.length; i++) {
											if(result[i][1] == null) continue;
											switch(result[i][1]) {
												case "move" :
													move(result[i], player2Cursor);
													try {
														sleep(500);
													} catch (InterruptedException e) {
														e.printStackTrace();
													}
													break;
												case "win" :
													player2Cursor.setIcon(new ImageIcon(LocalInGameView.class.getResource(GameServiceManager.getInstance().getChangeImageURL(player2Cursor.getActionCommand()))));
													win(result[i], player2Cursor);
													try {
														sleep(3000);
													} catch (InterruptedException e) {
														e.printStackTrace();
													}
													break;
												case "draw" :
													player2Cursor.setIcon(new ImageIcon(LocalInGameView.class.getResource(GameServiceManager.getInstance().getChangeImageURL(player2Cursor.getActionCommand()))));
													draw(result[i],player2Cursor);
													try {
														sleep(1500);
													} catch (InterruptedException e) {
														e.printStackTrace();
													}
													break;
												case "lose" :
													player2Cursor.setIcon(new ImageIcon(LocalInGameView.class.getResource(GameServiceManager.getInstance().getChangeImageURL(player2Cursor.getActionCommand()))));
													lose(result[i],player2Cursor);
													try {
														sleep(2000);
													} catch (InterruptedException e) {
														e.printStackTrace();
													}
													break;
												case "merge" :
													move(result[i], player2Cursor);
													break;
												case "chance" :
													move(result[i], player2Cursor);
													break;
												case "finish":
													finish(player2Cursor);
													break;
												case "endgame":
													endGame();
													break;
											}
											lastCommand = result[i][1];
										}
										if (!lastCommand.equals("lose") && !lastCommand.equals("finish"))
											player2Cursor.setVisible(true);
										
										GameServiceManager.getInstance().changeTurn();
										if (turn != GameServiceManager.getInstance().getCurrentTurn()) {
											turn = GameServiceManager.getInstance().getCurrentTurn();
											try {
												Thread.sleep(750);
											} catch (InterruptedException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											for (int i = 0; i < player1Characters.length; i++) {
												player1Characters[i].setEnabled(true);
											}
											for (int i = 0; i < player2Characters.length; i++) {
												player2Characters[i].setEnabled(false);
											}
										}		
										player2Cursor = null;
										if (GameServiceManager.getInstance().getQuinqueStoneResultSet().size() == 0) {
											isRoll = false;
											rollButton.setVisible(true);
											prevQuinque.setVisible(false);
											prevQuinque.setText("");
										}
									}
								};
								moveThread.start();
								stoneImage.setVisible(false);
								
							}
						}
						break;
					default:; 
					}
				}
			}
	}
	
	public JLabel[] attack(JButton playerCursor) {
		JLabel[] labels = new JLabel[2];
		switch(playerCursor.getActionCommand()) {
			case "Rabbit Questionmark":
				rabbitWildcardAction.setBounds(playerCursor.getX() - 250, playerCursor.getY() - 250, playerCursor.getWidth() + 500, playerCursor.getHeight() + 500);
				rabbitWildcardEffect.setBounds(rabbitWildcardAction.getBounds());
				labels[0] = rabbitWildcardAction;
				labels[1] = rabbitWildcardEffect;
				break;
			case "Turtle Questionmark":
				turtleWildcardAction.setBounds(playerCursor.getX() - 250, playerCursor.getY() - 250, playerCursor.getWidth() + 500, playerCursor.getHeight() + 500);
				turtleWildcardEffect.setBounds(turtleWildcardAction.getBounds());
				labels[0] = turtleWildcardAction;
				labels[1] = turtleWildcardEffect;
				break;
			case "Rabbit Rock" :
				rabbitRockAction.setBounds(playerCursor.getX() - 250, playerCursor.getY() - 250, playerCursor.getWidth() + 500, playerCursor.getHeight() + 500);
				rockEffect.setBounds(rabbitRockAction.getBounds());
				labels[0] = rabbitRockAction;
				labels[1] = rockEffect;
				break;
			case "Rabbit Scissors" :
				rabbitScissorsAction.setBounds(playerCursor.getX() - 250, playerCursor.getY() - 250, playerCursor.getWidth() + 500, playerCursor.getHeight() + 500);
				scissorsEffect.setBounds(rabbitScissorsAction.getBounds());
				labels[0] = rabbitScissorsAction;
				labels[1] = scissorsEffect;
				break;
			case "Rabbit Paper" :
				rabbitPaperAction.setBounds(playerCursor.getX() - 250, playerCursor.getY() - 250, playerCursor.getWidth() + 500, playerCursor.getHeight() + 500);
				paperEffect.setBounds(rabbitPaperAction.getBounds());
				labels[0] = rabbitPaperAction;
				labels[1] = paperEffect;
				break;
			case "Turtle Rock" :
				turtleRockAction.setBounds(playerCursor.getX() - 250, playerCursor.getY() - 250, playerCursor.getWidth() + 500, playerCursor.getHeight() + 500);
				rockEffect.setBounds(turtleRockAction.getBounds());
				labels[0] = turtleRockAction;
				labels[1] = rockEffect;
				break;
			case "Turtle Scissors" :
				turtleScissorsAction.setBounds(playerCursor.getX() - 250, playerCursor.getY() - 250, playerCursor.getWidth() + 500, playerCursor.getHeight() + 500);
				scissorsEffect.setBounds(turtleScissorsAction.getBounds());
				labels[0] = turtleScissorsAction;
				labels[1] = scissorsEffect;
				break;
			case "Turtle Paper" : 
				turtlePaperAction.setBounds(playerCursor.getX() - 250, playerCursor.getY() - 250, playerCursor.getWidth() + 500, playerCursor.getHeight() + 500);
				paperEffect.setBounds(turtlePaperAction.getBounds());
				labels[0] = turtlePaperAction;
				labels[1] = paperEffect;
				break;
		}
		return labels;
	}
	
	// 500
	public void move(String[] result, JButton playerCursor) {
		if(result[0].equals("-1")) return;
		
		JLabel temp = searchTile(result[0]);
		
		if (playerCursor.getActionCommand().contains("Rabbit")) {
			playerCursor.setBounds(temp.getX() - 15, temp.getY() - 86, playerCursor.getWidth(), playerCursor.getHeight());
		}
		else {
			playerCursor.setBounds(temp.getX() + 7, temp.getY() - 104,  playerCursor.getWidth(),  playerCursor.getHeight());
		}
		
		moveEffect.setBounds(playerCursor.getBounds());
		
		new Thread() {
			public void run() {
				moveEffect.setVisible(true);
				try {
					sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				moveEffect.setVisible(false);
			}
		}.start();
		
	}
	
	// 3500
	public void win(String[] result, JButton playerCursor) {
		move(result, playerCursor); // 500
		
		JLabel[] labels = attack(playerCursor);
		// 3000
		new Thread() {
			public void run() {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				playerCursor.setVisible(false);
				JButton loser = searchButton(result[2]);
				labels[0].setVisible(true);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				loser.setVisible(false);
				labels[0].setVisible(false);
				labels[1].setVisible(true);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				playerCursor.setVisible(true);
				labels[1].setVisible(false);
				
				JLabel lose;
				if(playerCursor.getActionCommand().contains("Turtle")) {
					lose = rabbitLose;
					rabbitLose.setBounds(playerCursor.getX() - 200,playerCursor.getY() - 250,playerCursor.getWidth() + 700,playerCursor.getHeight() + 500);
				}
				else {
					lose = turtleLose;
					turtleLose.setBounds(playerCursor.getX() - 210, playerCursor.getY() - 230, playerCursor.getWidth() + 700, playerCursor.getHeight() + 500);
				}
				lose.setVisible(true);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				lose.setVisible(false);
				
				playerCursor.setIcon(new ImageIcon(LocalInGameView.class.getResource(GameServiceManager.getInstance().getChangeImageURL(playerCursor.getActionCommand()))));
				loser.setIcon(new ImageIcon(LocalInGameView.class.getResource(GameServiceManager.getInstance().getChangeImageURL(loser.getActionCommand()))));
				
				goHome(loser);
				loser.setVisible(true);
			}
		}.start();
	}
	
	// 2000
	public void draw(String[] result, JButton playerCursor) {
		move(result, playerCursor); // 500
		
		JLabel[] labels = attack(playerCursor);
		
		// 1500
		new Thread() {
			public void run() {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				JButton oppoCursor = searchButton(result[2]);
				oppoCursor.setIcon(new ImageIcon(LocalInGameView.class.getResource(GameServiceManager.getInstance().getChangeImageURL(oppoCursor.getActionCommand()))));
				playerCursor.setVisible(false);
				oppoCursor.setVisible(true);
				labels[0].setVisible(true);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				playerCursor.setVisible(true);
				labels[0].setVisible(false);
			}
		}.start();
	}
	
	public void lose(String[] result, JButton playerCursor) {
		move(result, playerCursor);
		JLabel[] labels = attack(playerCursor);
		new Thread() {
			public void run() {
				playerCursor.setVisible(false);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				JButton oppoCursor = searchButton(result[2]);
				labels[0].setVisible(true);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				labels[0].setVisible(false);
				JLabel lose = null;
				if(playerCursor.getActionCommand().contains("Turtle")) {
					lose = turtleLose;
					turtleLose.setBounds(playerCursor.getX() - 200, playerCursor.getY() - 250, playerCursor.getWidth() + 700, playerCursor.getHeight() + 500);
				}
				else {
					lose = rabbitLose;
					rabbitLose.setBounds(playerCursor.getX() - 210, playerCursor.getY() - 230, playerCursor.getWidth() + 700, playerCursor.getHeight() + 500);
				}
				lose.setVisible(true);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				lose.setVisible(false);
				oppoCursor.setIcon(new ImageIcon(LocalInGameView.class.getResource(GameServiceManager.getInstance().getChangeImageURL(oppoCursor.getActionCommand()))));
				goHome(playerCursor);
				playerCursor.setVisible(true);
			}
		}.start();	
	}
	
	public void merge(String[] result, JButton playerCursor) {
		mergeFlag = true;
		tempKeyCane = "";
		String markerName=playerCursor.getActionCommand();   //현재 이동하고 있는 말의 이름을 가져온다.
		System.out.println("합병팀목록:"+GameServiceManager.getInstance().getPartyMemberCanes(result[2]));
		ArrayList<String> partyCanes=GameServiceManager.getInstance().getPartyMemberCanes(markerName);
		
		while(true) {
			System.out.println("현재 키는 " + tempKeyCane);
			for(int i=0; i<partyCanes.size(); i++) {
				if(partyCanes.get(i).equals(tempKeyCane.substring(1)) &&turn==Integer.parseInt(tempKeyCane.substring(0,1))) {
					GameServiceManager.getInstance().changePartyCane(markerName, tempKeyCane);
					mergeFlag = false;
					return;
				}
			}
		}
	}
	
	public void finish(JButton playerCursor) {
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		playerCursor.setVisible(false);
		goHome(playerCursor);
	}

	public void endGame() {
		if (GameServiceManager.getInstance().getCurrentTurn() == 2) {
			victoryIcon2p.setVisible(true);
		} else {
			victoryIcon1p.setVisible(true);
		}
	}
	
	public JLabel searchTile(String name) {
		for (JLabel tile : mapTiles) {
			if (tile.getName().equals(name))
				return tile;
		}
		return null;
	}
	
	public JButton searchButton(String name) {
		for(JButton btn : player1Characters)
		{
			if(btn.getActionCommand().equals(name))
				return btn;
		}
		
		for(JButton btn : player2Characters)
		{
			if(btn.getActionCommand().equals(name))
				return btn;
		}
		return null;
	}
	
	// 캐릭터 선택 및 내보내기
	private class KeyHandler extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			char key = e.getKeyChar();
			switch(key) {
				case 'Q':
				case 'q': player1Characters[0].doClick();
				break;
				case 'W':
				case 'w': player1Characters[1].doClick();
				break;
				case 'E':
				case 'e': player1Characters[2].doClick();
				break;
				case 'R':
				case 'r': player1Characters[3].doClick();
				break;
				case 'O':
				case 'o': player2Characters[0].doClick();
				break;
				case 'P':
				case 'p': player2Characters[1].doClick();
				break;
				case '{':
				case '[': player2Characters[2].doClick();
				break;
				case '}':
				case ']': player2Characters[3].doClick();
				break;
				case KeyEvent.VK_BACK_SPACE: rollButton.doClick();
				break;
				default: ;
			}
		}
	}
	
	public void initiateGame() {
		ArrayList<ArrayList<Object>> mapsResource = GameServiceManager.getInstance().getMapResource();
		int mapsResourceSize = mapsResource.size();
		
		for (int i = 0; i < mapsResourceSize; i++) {
			ArrayList<Object> mapResource = GameServiceManager.getInstance().getMapResource().get(i);
			mapTiles[i].setName("" + (int) mapResource.get(0));
			mapTiles[i].setIcon(new ImageIcon(LocalInGameView.class.getResource((String) mapResource.get(1))));
			mapTiles[i].setBounds((Rectangle) mapResource.get(2));
		}
		
		ArrayList<ArrayList<Object>> markersResource = GameServiceManager.getInstance().getMarkerResource();
		int rabbitTurn = GameServiceManager.getInstance().characterTurn("Rabbit");
		
		if (rabbitTurn == 1) {
			for (int i = 0; i < player1Characters.length; i++) {
				ArrayList<Object> markerResource = markersResource.get(i);
				player1Characters[i].setActionCommand((String) markerResource.get(0));
				player1Characters[i].setIcon(new ImageIcon(LocalInGameView.class.getResource((String) markerResource.get(1))));
				player1Characters[i].setBounds((Rectangle) markerResource.get(2));
				player1Characters[i].setEnabled(true);
			}
			
			for (int i = 0; i < player2Characters.length; i++) {
				ArrayList<Object> markerResource = markersResource.get(i + 4);
				player2Characters[i].setActionCommand((String) markerResource.get(0));
				player2Characters[i].setIcon(new ImageIcon(LocalInGameView.class.getResource((String) markerResource.get(1))));
				player2Characters[i].setBounds((Rectangle) markerResource.get(2));
				player2Characters[i].setEnabled(false);
			}
		}
		else {
			for (int i = 0; i < player1Characters.length; i++) {
				ArrayList<Object> markerResource = markersResource.get(i + 4);
				player1Characters[i].setActionCommand((String) markerResource.get(0));
				player1Characters[i].setIcon(new ImageIcon(LocalInGameView.class.getResource((String) markerResource.get(1))));
				player1Characters[i].setBounds((Rectangle) markerResource.get(2));
				player1Characters[i].setEnabled(true);
			}
			
			for (int i = 0; i < player2Characters.length; i++) {
				ArrayList<Object> markerResource = markersResource.get(i);
				player2Characters[i].setActionCommand((String) markerResource.get(0));
				player2Characters[i].setIcon(new ImageIcon(LocalInGameView.class.getResource((String) markerResource.get(1))));
				player2Characters[i].setBounds((Rectangle) markerResource.get(2));
				player2Characters[i].setEnabled(false);
			}
		}
	}
	
	public void goHome(JButton playerCursor) {
		GameServiceManager.getInstance().getChangeImageURL(playerCursor.getActionCommand());
		if (GameServiceManager.getInstance().characterTurn(playerCursor.getActionCommand())==1) {
			if (playerCursor.getActionCommand().contains("Turtle")) {
				switch (playerCursor.getActionCommand()) {
				case "Turtle Questionmark":
					playerCursor.setBounds(new Rectangle(137, 286, 114, 197));
					break;
				case "Turtle Paper":
					playerCursor.setBounds(new Rectangle(229, 366, 99, 161));
					break;
				case "Turtle Scissors":
					playerCursor.setBounds(new Rectangle(316, 417, 81, 150));
					break;
				case "Turtle Rock":
					playerCursor.setBounds(new Rectangle(382, 468, 119, 169));
					break;
				}
			} else {
				switch (playerCursor.getActionCommand()) {
				case "Rabbit Questionmark":
					playerCursor.setBounds(new Rectangle(137, 286, 114, 197));
					break;
				case "Rabbit Paper":
					playerCursor.setBounds(new Rectangle(229, 366, 99, 161));
					break;
				case "Rabbit Scissors":
					playerCursor.setBounds(new Rectangle(316, 417, 81, 150));
					break;
				case "Rabbit Rock":
					playerCursor.setBounds(new Rectangle(382, 468, 119, 169));

					break;
				default:
					;
					break;
				}
			}

		} else {
			if (playerCursor.getActionCommand().contains("Turtle")) {
				switch (playerCursor.getActionCommand()) {

				case "Turtle Questionmark":
					playerCursor.setBounds(new Rectangle(169, 128, 122, 169));
					break;
				case "Turtle Paper":
					playerCursor.setBounds(new Rectangle(281, 85, 99, 161));
					break;
				case "Turtle Scissors":
					playerCursor.setBounds(new Rectangle(363, 34, 99, 161));
					break;
				case "Turtle Rock":
					playerCursor.setBounds(new Rectangle(437, -16, 99, 161));
					break;
				default:
					;
					break;
				}
			} else {
				switch (playerCursor.getActionCommand()) {
				case "Rabbit Questionmark":
					playerCursor.setBounds(new Rectangle(169, 128, 122, 169));
					break;
				case "Rabbit Paper":
					playerCursor.setBounds(new Rectangle(281, 85, 99, 161));
					break;
				case "Rabbit Scissors":
					playerCursor.setBounds(new Rectangle(363, 34, 99, 161));
					break;
				case "Rabbit Rock":
					playerCursor.setBounds(new Rectangle(437, -16, 99, 161)); // 위 오른쪽
					break;
				}
			}
		}
	}

}