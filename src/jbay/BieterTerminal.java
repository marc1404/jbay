package jbay;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BieterTerminal {

	private Bieter bieter;
	private Auktionshaus ah;
	
	public BieterTerminal(Bieter bieter, Auktionshaus ah){
		this.bieter = bieter;
		this.ah = ah;
		final JFrame frame = new JFrame(bieter.getFullName() + "'s Terminal");
		JLabel timeLabel = new JLabel(Calendar.getInstance().getTime().toString());
		List<Auktion> auktionen = ah.getAuktionen();
		JPanel ahPanel = new JPanel(new GridLayout(auktionen.size(), 5));
		
		for(final Auktion auktion:auktionen){
			Ware ware = auktion.getWare();
			Gebot gebot = auktion.getGebot();
			JButton button = new JButton("Gebot");
			
			ahPanel.add(new JLabel(ware.getTitel()));
			ahPanel.add(new JLabel(String.valueOf(auktion.getPreis())));
			ahPanel.add(new JLabel(gebot != null ? gebot.getBieter().getFullName() : "---"));
			ahPanel.add(new JLabel(Calendar.getInstance().getTime().toString()));
			ahPanel.add(button);
			
			button.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					double incPreis = auktion.getPreis() + Auktion.increment;
					
					JOptionPane.showInputDialog(frame, "Bitte neues Gebot eingeben.\nMindestens " + incPreis + " Euro", incPreis);
				}
			});
		}
		
		frame.add(timeLabel, BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
}
