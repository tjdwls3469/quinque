package com.lectopia.quinque.view;

import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.JPanel;

public class ChangePanelService {
	static private ChangePanelService obj;
	private CardLayout layout;
	private JPanel mainPanel;
	
	static {
		obj = new ChangePanelService();
	}

	private ChangePanelService() {
	}

	public static ChangePanelService getInstance() {
		return obj;
	}

	public void setLayout(CardLayout layout) {
		this.layout = layout;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public void changePanel(String panelName) {
		layout.show(mainPanel, panelName);
	}

	public void initiateGame(String name) {
		JPanel panel = null;
		for (Component component : mainPanel.getComponents()) {
			if (name.equals(component.getName())) {
				panel = (JPanel) component;
				break;
			}
		}
		
		if (panel instanceof LocalInGameView) {
			((LocalInGameView) panel).initiateGame();
		}
		else if (panel instanceof MultiInGameView) {
//			((MultiInGameView) panel).setGame();
		}
	}
}