package jbay;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BieterTerminal {

	private Bieter bieter;
	private Auktionshaus ah;
	private JFrame frame;
	private JLabel timeLabel;
	private JPanel ahPanel = new JPanel(new GridLayout(0, 5, 5, 5));
	
	public BieterTerminal(Bieter bieter, Auktionshaus ah){
		this.bieter = bieter;
		this.ah = ah;
		this.frame = new JFrame(bieter.getFullName() + "'s Terminal");
		this.timeLabel = new JLabel(Calendar.getInstance().getTime().toString());
		
		updateTerminal();
		
		frame.add(timeLabel, BorderLayout.NORTH);
		frame.add(ahPanel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		startTimeThread();
	}
	
	public void updateTerminal(){
		ahPanel.removeAll();
		
		for(Auktion auktion:ah.getAuktionen()){
			Ware ware = auktion.getWare();
			Gebot gebot = auktion.getGebot();
			JButton button = new JButton("Gebot");
			
			button.addActionListener(new GebotActionListener(frame, ah, auktion, bieter));
			ahPanel.add(new JLabel(ware.getTitel()));
			ahPanel.add(new JLabel(String.valueOf(auktion.getPreis())));
			ahPanel.add(new JLabel(gebot != null ? gebot.getBieter().getFullName() : "---"));
			ahPanel.add(new JLabel(auktion.getEnde().getTime().toString()));
			ahPanel.add(button);
		}
		
		frame.pack();
	}
	
	private void startTimeThread(){
		Runnable task = new Runnable(){
			@Override
			public void run(){
				while(!Thread.interrupted()){
					timeLabel.setText(Calendar.getInstance().getTime().toString());
					
					try{
						Thread.sleep(1000);
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}
			}
		};
		
		new Thread(task).start();
	}
	
}
