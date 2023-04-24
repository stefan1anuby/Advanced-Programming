package com.game;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	ConfigPanel configPanel;
	ControlPanel controlPanel;
	DrawingPanel canvas;

	public MainFrame() {
		super("My Drawing Application");
		init();
	}

	private void init() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	   
		//create the components
		this.controlPanel = new ControlPanel(this);
		this.configPanel = new ConfigPanel(this);
		
		this.canvas = new DrawingPanel(this);
	   
		//arrange the components in the container (frame)
		//JFrame uses a BorderLayout by default
		add(canvas, BorderLayout.CENTER); //this is BorderLayout.CENTER
		add(configPanel,BorderLayout.NORTH);
		add(controlPanel,BorderLayout.SOUTH);
	   
		//invoke the layout manager
		pack();
	}

}
