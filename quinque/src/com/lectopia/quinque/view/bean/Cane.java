package com.lectopia.quinque.view.bean;

public enum Cane {
	ROCK("Rock"), SCISSORS("Scissors"), PAPER("Paper"), QUESTIONMARK("Questionmark");
	
	private String cane;
	Cane(String cane) {
		this.cane = cane;
	}
	
	public String getCane() {
		return cane;
	}
}