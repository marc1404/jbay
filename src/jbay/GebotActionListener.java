package jbay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GebotActionListener implements ActionListener {

	private JFrame frame;
	private Auktionshaus ah;
	private Auktion auktion;
	private Bieter bieter;
	
	public GebotActionListener(JFrame frame, Auktionshaus ah, Auktion auktion, Bieter bieter){
		this.frame = frame;
		this.ah = ah;
		this.auktion = auktion;
		this.bieter = bieter;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if(auktion.getEnde().after(Calendar.getInstance())){
			double incPreis = auktion.getPreis() + Auktion.increment;
			String result = JOptionPane.showInputDialog(frame, "Bitte neues Gebot eingeben.\nMindestens " + incPreis + " Euro", incPreis);
			double betrag = 0;
			
			try{
				betrag = Double.parseDouble(result);
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
			Gebot g = new Gebot(betrag, bieter);
			
			if(auktion.gebotAbgeben(g)){
				JOptionPane.showMessageDialog(frame, "Sie sind Höchstbietender!", "Meldung", JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(frame, "Gebot zu gering!", "Meldung", JOptionPane.INFORMATION_MESSAGE);
			}
			
			ah.updateTerminals();
			ah.logGebot(g, auktion.getWare());
		}else{
			JOptionPane.showMessageDialog(frame, "Die Auktion ist leider schon vorbei...", "Meldung", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
