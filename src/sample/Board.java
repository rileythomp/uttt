package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.ArrayList;

public class Board {
    public ArrayList<MiniBoard> miniBoards;
    public Line winLine;

    private final int SCREEN_WIDTH = 1000;
    private final int SCREEN_HEIGHT = 800;

    private final int CELL_LEN = 50; // in px
    private final int BOARD_LEN = 9; // in cells

    Board() {
        miniBoards = new ArrayList<>();
        for (int i = 0; i < 9; ++i) {
            MiniBoard miniBoard = new MiniBoard();
            if (i != 4) {
//                miniBoard.isTaken = true;
//                miniBoard.ownedBy = (Math.random() * 2 >= 1 ? "X" : "O");
                for (int j = 0; j < miniBoard.cells.size(); ++j) {
                    miniBoard.cells.get(j).canBeMovedTo = true;
//                    miniBoard.cells.get(j).val = (Math.random() * 2 >= 1 ? "X" : "O");
                }
            }
            miniBoards.add(miniBoard);

        }
    }

    public boolean isWon() {
        if (miniBoards.get(0).ownedBy != "" && miniBoards.get(0).ownedBy == miniBoards.get(1).ownedBy && miniBoards.get(1).ownedBy == miniBoards.get(2).ownedBy) {
            winLine = new Line((SCREEN_WIDTH - (CELL_LEN*BOARD_LEN))/2 + 10, 125, (SCREEN_WIDTH - (CELL_LEN*BOARD_LEN))/2 + 440, 125);
            winLine.setStroke(Color.RED);
            winLine.setStrokeWidth(5);
            return true;
        }
        else if (miniBoards.get(3).ownedBy != "" && miniBoards.get(3).ownedBy == miniBoards.get(4).ownedBy && miniBoards.get(4).ownedBy == miniBoards.get(5).ownedBy) {
            winLine = new Line((SCREEN_WIDTH - (CELL_LEN*BOARD_LEN))/2 + 10, 275, (SCREEN_WIDTH - (CELL_LEN*BOARD_LEN))/2 + 440, 275);
            winLine.setStroke(Color.RED);
            winLine.setStrokeWidth(5);
            return true;
        }
        else if (miniBoards.get(6).ownedBy != "" && miniBoards.get(6).ownedBy == miniBoards.get(7).ownedBy && miniBoards.get(7).ownedBy == miniBoards.get(8).ownedBy) {
            winLine = new Line((SCREEN_WIDTH - (CELL_LEN*BOARD_LEN))/2 + 10, 425, (SCREEN_WIDTH - (CELL_LEN*BOARD_LEN))/2 + 440, 425);
            winLine.setStroke(Color.RED);
            winLine.setStrokeWidth(5);
            return true;
        }
        else if (miniBoards.get(0).ownedBy != "" && miniBoards.get(0).ownedBy == miniBoards.get(3).ownedBy && miniBoards.get(3).ownedBy == miniBoards.get(6).ownedBy) {
            winLine = new Line((SCREEN_WIDTH - (CELL_LEN*BOARD_LEN))/2 + 75, 60, (SCREEN_WIDTH - (CELL_LEN*BOARD_LEN))/2 + 75, 490);
            winLine.setStroke(Color.RED);
            winLine.setStrokeWidth(5);
            return true;
        }
        else if (miniBoards.get(1).ownedBy != "" && miniBoards.get(1).ownedBy == miniBoards.get(4).ownedBy && miniBoards.get(4).ownedBy == miniBoards.get(7).ownedBy) {
            winLine = new Line((SCREEN_WIDTH - (CELL_LEN*BOARD_LEN))/2 + 225, 60, (SCREEN_WIDTH - (CELL_LEN*BOARD_LEN))/2 + 225, 490);
            winLine.setStroke(Color.RED);
            winLine.setStrokeWidth(5);
            return true;
        }
        else if (miniBoards.get(2).ownedBy != "" && miniBoards.get(2).ownedBy == miniBoards.get(5).ownedBy && miniBoards.get(5).ownedBy == miniBoards.get(8).ownedBy) {
            winLine = new Line((SCREEN_WIDTH - (CELL_LEN*BOARD_LEN))/2 + 375, 60, (SCREEN_WIDTH - (CELL_LEN*BOARD_LEN))/2 + 375, 490);
            winLine.setStroke(Color.RED);
            winLine.setStrokeWidth(5);
            return true;
        }
        else if (miniBoards.get(0).ownedBy != "" && miniBoards.get(0).ownedBy == miniBoards.get(4).ownedBy && miniBoards.get(4).ownedBy == miniBoards.get(8).ownedBy) {
            winLine = new Line((SCREEN_WIDTH - (CELL_LEN*BOARD_LEN))/2 + 10, 60, (SCREEN_WIDTH - (CELL_LEN*BOARD_LEN))/2 + 440, 490);
            winLine.setStroke(Color.RED);
            winLine.setStrokeWidth(5);
            return true;
        }
        else if (miniBoards.get(2).ownedBy != "" && miniBoards.get(2).ownedBy == miniBoards.get(4).ownedBy && miniBoards.get(4).ownedBy == miniBoards.get(6).ownedBy) {
            winLine = new Line((SCREEN_WIDTH - (CELL_LEN*BOARD_LEN))/2 + 440, 60, (SCREEN_WIDTH - (CELL_LEN*BOARD_LEN))/2 + 10, 490);
            winLine.setStroke(Color.RED);
            winLine.setStrokeWidth(5);
            return true;
        }
        return false;
    }
}
