package com.game;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class GameBoard  implements Serializable {
	private Integer numVertices;
	private Double edgeProbability;
	private boolean[][] edges;
	private int[][] state;

	public GameBoard() {

	}

	public GameBoard(Integer numVertices, Double edgeProbability) {
		this.numVertices = numVertices;
		this.edgeProbability = edgeProbability;
		this.edges = new boolean[numVertices][numVertices];
		this.state = new int[numVertices][numVertices];
		/*
		 * 0 - empty
		 * 1 - player 1 choosed it
		 * 2 - player 2 choosed it
		 */
	}

	public void generateBoard() {

		for (int i = 0; i < numVertices; i++) {
			for (int j = i + 1; j < numVertices; j++) {
				if (Math.random() < edgeProbability) {
					edges[i][j] = edges[j][i] = true;
				}
			}
		}
	}

	public void loadLastSave() {
		try {
			FileInputStream fileIn = new FileInputStream("game.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			GameBoard savedGame = (GameBoard) in.readObject();
			in.close();
			fileIn.close();
			this.numVertices = savedGame.getNumVertices();
			this.edgeProbability = savedGame.edgeProbability;
			this.edges = savedGame.edges;
			this.state = savedGame.state;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void save() {
		try {
			FileOutputStream fileOut = new FileOutputStream("game.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(this);
			out.close();
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setEdge(int i, int j, boolean value) {
		edges[i][j] = edges[j][i] = value;
	}

	public boolean isEdge(int i, int j) {
		return edges[i][j];
	}

	public int getState(int i, int j) {
		return state[i][j];
	}

	public void setstate(int i, int j, int value) {
		state[i][j] = state[j][i] = value;
	}

	public int getNumVertices() {
		return numVertices;
	}

	public void setNumVertices(int num) {
		numVertices = num;
	}

	public void resetStates(){
		for (int i = 0; i < numVertices; i++) {
			for (int j = 0; j < numVertices; j++) {
				state[i][j] = 0;
			}
		}
	}

	public void printBoard() {
		System.out.println("Edges :");
		for (int i = 0; i < numVertices; i++) {
			for (int j = 0; j < numVertices; j++) {
				if (edges[i][j]) {
					System.out.print("1 ");
				} else {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}

		System.out.println("State :");
		for (int i = 0; i < numVertices; i++) {
			for (int j = 0; j < numVertices; j++) {
				System.out.print(state[i][j] + " ");
			}
			System.out.println();
		}
	}
}
