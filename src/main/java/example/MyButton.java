package example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyButton extends JButton implements ActionListener {

	public MyButton(String string) {
		setText(string);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setText("Premuto");
		
	}

}
