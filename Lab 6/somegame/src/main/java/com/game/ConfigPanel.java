package com.game;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class ConfigPanel extends JPanel {

	final MainFrame frame;
	JLabel dotsLabel, linesLabel;
	JSpinner dotsSpinner;
	JComboBox linesCombo;
	JButton createButton;

	public ConfigPanel(MainFrame frame) {
		this.frame = frame;
		init();
	}

	private void init() {
		//create the label and the spinner
		dotsLabel = new JLabel("Number of dots:");
		dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));

		linesLabel = new JLabel("Line Probability");
		Double probabilities[] = {1.0 , 0.5 , 0.1 };
		linesCombo = new JComboBox(probabilities);

		createButton = new JButton("Create");

		createButton.addActionListener(this::create);
		
		add(dotsLabel);
		add(dotsSpinner);
		add(linesLabel);
		add(linesCombo);
		add(createButton);
		 
 	}

	private void create(ActionEvent e) {
		frame.canvas.createBoard();
	}

}
