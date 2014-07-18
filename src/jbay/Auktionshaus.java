package jbay;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Auktionshaus {

	private List<Auktion> auktionen = new ArrayList<Auktion>();
	private List<BieterTerminal> terminals = new ArrayList<BieterTerminal>();
	private BufferedWriter log;
	
	public Auktionshaus(){
		try{
			this.log = new BufferedWriter(new FileWriter(new File("auktionen.txt"), true));
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void addAuktion(Auktion a){
		auktionen.add(a);
	}
	
	public void removeAuktion(Auktion a){
		auktionen.remove(a);
	}
	
	public List<Auktion> getAuktionen(){
		return auktionen;
	}
	
	public void register(BieterTerminal bt){
		terminals.add(bt);
	}
	
	public void unregister(BieterTerminal bt){
		terminals.remove(bt);
	}
	
	public void updateTerminals(){
		for(BieterTerminal terminal:terminals){
			terminal.updateTerminal();
		}
	}
	
	public void logGebot(Gebot g, Ware ware){
		String message = "[" + Calendar.getInstance().getTime().toString() + "] Gebot von " + g.getBieter().getFullName() + " für " + ware.getTitel() + ": " + g.getBetrag();
		
		try{
			log.write(message);
			log.newLine();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
