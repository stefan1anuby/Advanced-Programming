package com.game;

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

		linesLabel = new JLabel("Number of dots:");
		Double probabilities[] = {0.1 , 0.5 , 1.0};
		linesCombo = new JComboBox(probabilities);

		createButton = new JButton("Create");

		//create the rest of the components

		
		add(dotsLabel); //JPanel uses FlowLayout by default
		add(dotsSpinner);
		add(linesLabel);
		add(linesCombo);
		add(createButton);
		 
 	}

}
