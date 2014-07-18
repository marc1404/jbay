package jbay;

public class Gebot {

	private double betrag;
	private Bieter bieter;
	
	public Gebot(double betrag, Bieter bieter){
		this.betrag = betrag;
		this.bieter = bieter;
	}
	
	public double getBetrag(){
		return betrag;
	}
	
	public Bieter getBieter(){
		return bieter;
	}
	
}
