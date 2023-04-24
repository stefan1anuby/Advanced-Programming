package com.game;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ControlPanel extends JPanel{

	final MainFrame frame;
 	JButton exitBtn = new JButton("Exit");
	JButton loadBtn = new JButton("Load");
	JButton saveBtn = new JButton("Save");
	JButton exportImageBtn = new JButton("Export");
	JButton resetBtn = new JButton("Reset");
 

	public ControlPanel(MainFrame frame) {
 		this.frame = frame; 
		init();
 	}

 	private void init() {
		//change the default layout manager (just for fun)
		setLayout(new GridLayout(1, 5));
		//add all buttons ...TODO
		//configure listeners for all buttons
		exitBtn.addActionListener(this::exitGame);
		exportImageBtn.addActionListener(this::exportImage);
		resetBtn.addActionListener(this::reset);
		saveBtn.addActionListener(this::save);
		loadBtn.addActionListener(this::load);

		add(loadBtn);
		add(saveBtn);
		add(resetBtn);
		add(exportImageBtn);
		add(exitBtn);
 	}
	
 	private void exitGame(ActionEvent e) {
 		frame.dispose();
 	}

	private void load(ActionEvent e){
		frame.canvas.board.loadLastSave();
		frame.canvas.update(getGraphics());
		frame.canvas.gameLogic.switchPlayer();
	}

	private void save(ActionEvent e){
		frame.canvas.board.save();
	}

	private void reset(ActionEvent e){
		frame.canvas.gameLogic.resetGame();
		frame.canvas.update(getGraphics());
	}

	private void exportImage(ActionEvent e){
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Export Image");
		fileChooser.setFileFilter(new FileNameExtensionFilter("PNG Images", "png"));

		int userSelection = fileChooser.showSaveDialog(this);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			try {
				// Exportarea imaginii curente în fișierul PNG selectat
				ImageIO.write(frame.canvas.image, "png", fileToSave);
				JOptionPane.showMessageDialog(this, "Image exported successfully!");
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(this, "Error exporting image: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
