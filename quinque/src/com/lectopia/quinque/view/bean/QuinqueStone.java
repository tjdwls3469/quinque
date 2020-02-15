package com.lectopia.quinque.view.bean;

public class QuinqueStone{
	private static final double BACKUNUSPROB = 0.0625;
	private static final double UNUSPROB = 0.1875;
	private static final double DUOPROB = 0.375;
	private static final double TRESPROB = 0.250;
	private static final double QUATTROPROB = 0.0625;
	private static final double QUINQUEPROB = 0.0625;

	public QuinqueStone() {
		
	}
	
	public int roll(int cp) {
		double rand = Math.random();
		double[] tempRand = { UNUSPROB, DUOPROB, TRESPROB, QUATTROPROB, QUINQUEPROB };
		double randSum = 0;
		for(int i=0; i<tempRand.length; i++) {
			randSum+=tempRand[i];
			if(randSum>rand) {
				return i + 1;
			}	
		}
		return -1;
	}
	
}