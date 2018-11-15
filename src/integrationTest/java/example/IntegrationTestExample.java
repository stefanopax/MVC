package example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.fixture.JLabelFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unimi.di.sweng.lab12.controller.AbstractController;


public class IntegrationTestExample {

	private FrameFixture window;
	private AbstractController controller;

	@BeforeClass
	public static void setUpOnce() {
	  FailOnThreadViolationRepaintManager.install();
	}
	
	@Before
	public void setUp() {
		JFrame frame = GuiActionRunner.execute(() -> new JFrame());
		JPanel panel = GuiActionRunner.execute(() -> new JPanel());

		// Crea gli oggetti dell'interfaccia e li aggiunge al panel
		MyButton ui = GuiActionRunner.execute(() -> new MyButton("MyButton"));
		
		ui.addActionListener(ui);
	
		panel.add(ui);

		frame.add(panel);
		frame.pack();
		frame.setPreferredSize(new Dimension(300,80));
		
		window = new FrameFixture(frame);
		window.show();
	}
	
	@Test
	public void test() {
		
		JButtonFixture button = window.button();
		assertThat(button.text()).isEqualTo("MyButton");
		button.click();
		
		// verifico effetti del click
		assertThat(button.text()).isEqualTo("Premuto");
	}
	
	@After 
	public void tearDown(){
		window.cleanUp();
	}
}
