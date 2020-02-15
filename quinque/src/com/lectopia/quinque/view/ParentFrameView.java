package com.lectopia.quinque.view;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * 퀸키스톤(Quinque Stone) 게임에서 사용되는 view 클래스를 관리하는 클래스이다.
 * <br>-view 클래스들을 생성해주고 cardLayout이 적용되어있다.
 * @author QuinqueBliss
 *
 */
public class ParentFrameView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private CardLayout cardLayout;
	
	public ParentFrameView(){
		super();
		
		mainPanel = new JPanel();
		cardLayout = new CardLayout();
		mainPanel.setLayout(cardLayout);
		
		mainPanel.add("MainMenuView", new MainMenuView());
		mainPanel.add("LocalLobbyView",new LocalLobbyView());
		mainPanel.add("LoginView",new LoginView(this));
		
		LocalInGameView localInGameView = new LocalInGameView();
		localInGameView.setName("LocalInGameView");
		
		mainPanel.add("LocalInGameView", localInGameView);
		mainPanel.add("MultiRoomView", new MultiRoomView());
		
		MultiInGameView multiInGameView = new MultiInGameView();
		multiInGameView.setName("MultiInGameView");
		
		mainPanel.add("MultiInGameView", new MultiInGameView());
		mainPanel.add("MyPageView", new MyPageView());
		mainPanel.add("TutorialView", new TutorialView());
		mainPanel.add("MultiPlayListView", new MultiPlayListView());
		
		System.out.println(multiInGameView.getName());
		
		ChangePanelService cpService = ChangePanelService.getInstance();
		
		
		cpService.setLayout(cardLayout);
		cpService.setMainPanel(mainPanel);
		
		add(mainPanel);
		
		cpService.changePanel("MainMenuView");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 720);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ParentFrameView();
	}
}