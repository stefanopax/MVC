package it.unimi.di.sweng.lab12.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public abstract class TicketManagerUI extends JPanel implements TicketManagerView {

	protected JLabel label;
	protected JButton button;
	
	public TicketManagerUI(String buttonLabel) {
		label = new JLabel("          ");
		button = new JButton(buttonLabel);
		this.add(label);
		this.add(button);
	}
}
