package jbay;

public class Ware {

	private String titel;
	@SuppressWarnings("unused")
	private String beschreibung;
	
	public Ware(String titel, String beschreibung){
		this.titel = titel;
		this.beschreibung = beschreibung;
	}
	
	public String getTitel(){
		return titel;
	}
	
}
