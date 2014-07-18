package jbay;

public class jBay {

	public static void main(String[] args){
		Auktionshaus jbay = new Auktionshaus();
		
		jbay.addAuktion(new Auktion(new Ware("Turnschuhe", "Tolle Turnschuhe, kaum getragen"), 2));
		jbay.addAuktion(new Auktion(new Ware("iPad", "Nagelneues iPad 3"), 4));
		jbay.addAuktion(new Auktion(new Ware("Currywurst", "Scharf, ohne Pommes"), 5));
	}
	
}
