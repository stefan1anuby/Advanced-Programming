package com.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
	final MainFrame frame;
	final static int W = 800, H = 600;
	private int numVertices;
	private double edgeProbability;
	private int[] x, y;
	BufferedImage image; // the offscreen image
	Graphics2D graphics; // the tools needed to draw in the image
	private int DOT_RADIUS = 20;

	private Point startPoint;
	private Point endPoint;
	private int startDotIndex;
	private int endDotIndex;
	private boolean isLineSelected = false;

	GameLogic gameLogic;
	GameBoard board;

	public DrawingPanel(MainFrame frame) {
		this.frame = frame;
		createOffscreenImage();
		initPanel();

		/*
		 * Functia asta as vrea sa fie apelata DOAR atunci cand apas START
		 */
		createBoard();

	}

	private void initPanel() {
		setPreferredSize(new Dimension(W, H));
		setBorder(BorderFactory.createEtchedBorder());

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				startPoint = e.getPoint();
				startDotIndex = getSelectedDotIndex(startPoint);
				if (startDotIndex != -1) {
					isLineSelected = true;
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (isLineSelected) {
					endPoint = e.getPoint();
					endDotIndex = getSelectedDotIndex(endPoint);
					if (endDotIndex != -1 && startDotIndex != endDotIndex) {
						if (gameLogic.isValidMove(startDotIndex, endDotIndex)) {
							gameLogic.makeMove(startDotIndex,endDotIndex);
							
							board.printBoard();

							markLine(startDotIndex, endDotIndex);
							int winner = gameLogic.isGameOver();
							if (winner != -1) {
								gameLogic.handleGameOver(winner);
								JOptionPane.showMessageDialog(frame, "The winner is player : " + winner);

							}
						}
					}
					isLineSelected = false;
					startPoint = null;
					endPoint = null;
					startDotIndex = -1;
					endDotIndex = -1;
					repaint();
				}
			}
		});
	}

	private void createOffscreenImage() {
		image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
		graphics = image.createGraphics();
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, W, H);
	}

	final void createBoard() {
		
		System.out.println("CREATE BOARD !!!!");

		numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
		edgeProbability = (Double) frame.configPanel.linesCombo.getSelectedItem();

		this.board = new GameBoard(numVertices, edgeProbability);
		this.board.generateBoard();
		this.gameLogic = new GameLogic(board);

		createOffscreenImage();
		createVertices();
		drawLines();
		drawVertices();
		repaint();
	}

	private void createVertices() {
		int x0 = W / 2;
		int y0 = H / 2; // middle of the board
		int radius = H / 2 - 10; // board radius
		double alpha = 2 * Math.PI / numVertices; // the angle
		x = new int[numVertices];
		y = new int[numVertices];
		for (int i = 0; i < numVertices; i++) {
			x[i] = x0 + (int) (radius * Math.cos(alpha * i));
			y[i] = y0 + (int) (radius * Math.sin(alpha * i));
		}
	}

	private void drawLines() {
		for (int i = 0; i < numVertices; i++) {
			for (int j = i + 1; j < numVertices; j++) {
				if(board.isEdge(i, j))
					markLine(i, j);
			}
		}
	}

	private void drawVertices() {
		graphics.setColor(Color.BLUE);
		for (int i = 0; i < numVertices; i++) {
			graphics.fillOval(x[i] - DOT_RADIUS/2, y[i] - DOT_RADIUS/2, DOT_RADIUS, DOT_RADIUS);
		}
	}

	@Override
	public void update(Graphics g) {
		drawVertices();
		drawLines();
		repaint();
	}

	// Draw the offscreen image, using the original graphics
	@Override
	protected void paintComponent(Graphics graphics) {
		graphics.drawImage(image, 0, 0, this);
	}

	private int getSelectedDotIndex(Point point) {
		for (int i = 0; i < numVertices; i++) {
			int dotX = x[i] - DOT_RADIUS;
			int dotY = y[i] - DOT_RADIUS;
			if (point.x >= dotX && point.x <= dotX + DOT_RADIUS * 2 &&
					point.y >= dotY && point.y <= dotY + DOT_RADIUS * 2) {
				
				System.out.println("interactionat cu nodul : " + i);
				return i;
			}
		}
		return -1;
	}

	private void markLine(int i , int j){
		
		Color selectedLineColor;

		if(board.getState(i,j) == 1){
			selectedLineColor = Color.RED;
		}
		else if(board.getState(i,j) == 2){
			selectedLineColor = Color.BLUE;
		}
		else{
			selectedLineColor = Color.BLACK;
		}

		System.out.println(gameLogic.getCurrentPlayer());

		graphics.setColor(selectedLineColor);
    	graphics.drawLine(x[i], y[i], x[j], y[j]);
	}
}
