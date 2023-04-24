package com.game;

public class GameLogic {
	private GameBoard board;
    private int currentPlayer;
    
    public GameLogic(GameBoard board) {
        this.board = board;
        this.currentPlayer = 1;
    }
    
    public boolean isValidMove(int i, int j) {
        if (!board.isEdge(i, j)) {
            return false;
        }

		if(board.getState(i, j) != 0){
			return false;
		}
        
        return true;
    }
    
    public void makeMove(int i, int j) {
        if (isValidMove(i, j)) {
            board.setstate(i, j, currentPlayer);
			board.setstate(j, i, currentPlayer);
            switchPlayer();
        }
    }
    
    public void switchPlayer() {
        currentPlayer = 3 - currentPlayer;
    }
    
    public int getCurrentPlayer() {
        return currentPlayer;
    }

	public int isGameOver() {

		for (int i = 0; i < board.getNumVertices(); i++) {
			for (int j = i + 1; j < board.getNumVertices(); j++) {
				int stateIJ = board.getState(i, j);
				for (int k = j + 1; k < board.getNumVertices(); k++) {
					int stateIK = board.getState(i, k);
					int stateJK = board.getState(j, k);
					if (stateIJ != 0 && stateIJ == stateIK && stateIK == stateJK) {
						return stateIJ;
					}
				}
			}
		}
		return -1;
	}

	public void handleGameOver(int winner){
		if (winner != -1) {
			System.out.println("Player " + winner + " has won!");
		} else {
			System.out.println("The game is a draw.");
		}
	}

	public void resetGame(){
		board.resetStates();
	}
}
