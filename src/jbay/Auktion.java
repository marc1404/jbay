package jbay;

import java.util.Calendar;

public class Auktion {

	private static final double increment = 1;
	
	private Ware ware;
	private Gebot gebot = null;
	private double preis = 0;
	private Calendar ende;
	
	public Auktion(Ware ware, int dauer){
		this.ware = ware;
		this.ende = Calendar.getInstance();
		
		this.ende.setTimeInMillis(System.currentTimeMillis() + 60000 * dauer);
	}
	
	public boolean gebotAbgeben(Gebot g){
		double betrag = g.getBetrag();
		double incPreis = preis + increment;
		
		if(betrag < incPreis){
			return false;
		}
		
		if(this.gebot == null){
			this.preis = increment;
			this.gebot = g;
			
			return true;
		}
		
		if(g.getBieter() == this.gebot.getBieter()){
			if(betrag > this.gebot.getBetrag()){
				this.gebot = g;
				
				return true;
			}else{
				return false;
			}
		}
		
		if(betrag >= incPreis && betrag <= this.gebot.getBetrag()){
			this.preis = Math.min(betrag + increment, this.gebot.getBetrag());
			
			return false;
		}
		
		if(betrag >= incPreis && betrag > this.gebot.getBetrag()){
			this.preis = Math.min(betrag, this.gebot.getBetrag() + increment);
			this.gebot = g;
			
			return true;
		}
		
		return false;
	}
	
}
