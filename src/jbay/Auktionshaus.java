package jbay;

import java.util.ArrayList;
import java.util.List;

public class Auktionshaus {

	private List<Auktion> auktionen = new ArrayList<Auktion>();
	
	public void addAuktion(Auktion a){
		auktionen.add(a);
	}
	
	public void removeAuktion(Auktion a){
		auktionen.remove(a);
	}
	
	public List<Auktion> getAuktionen(){
		return auktionen;
	}
	
}
