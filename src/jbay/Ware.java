package jbay;

public class Ware {

	private String titel;
	private String beschreibung;
	
	public Ware(String titel, String beschreibung){
		this.titel = titel;
		this.beschreibung = beschreibung;
	}
	
	public String getTitel(){
		return titel;
	}
	
	public String getBeschreibung(){
		return beschreibung;
	}
	
}
