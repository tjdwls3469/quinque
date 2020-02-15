package com.lectopia.quinque.view.bean;

import java.util.ArrayList;

public class Player {
	private ArrayList<Integer> quinqueStoneResultSet;
	private int turn;
	private String nickname;
	private String selectedMarker;
	
	public Player() {
		
	}
	
	public Player(int turn, String nickname) {
		if (nickname == null || nickname.equals("")) nickname = "empty";
		this.quinqueStoneResultSet = new ArrayList<Integer>();
		this.turn = turn;
		this.nickname = nickname;
	}
	
	public ArrayList<Integer> getQuinqueStoneResultSet() {
		return quinqueStoneResultSet;
	}
	
	public void setQuinqueStoneResultSet(ArrayList<Integer> quinqueStoneResultSet) {
		this.quinqueStoneResultSet = quinqueStoneResultSet;
	}
	
	public void addQuinqueStoneResultSet(int quinqueStoneResult) {
		quinqueStoneResultSet.add(quinqueStoneResult);
	}
	
	public int getTurn() {
		return turn;
	}
	
	public void setTurn(int turn) {
		this.turn = turn;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getSelectedMarker() {
		return selectedMarker;
	}
	
	public void setSelectedMarker(String selectedMarker) {
		this.selectedMarker = selectedMarker;
	}
}