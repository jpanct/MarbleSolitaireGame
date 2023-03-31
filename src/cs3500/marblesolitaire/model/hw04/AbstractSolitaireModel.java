package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * This is an AbstractSolitaireModel class which implements MarbleSolitaireModel. This class is
 * used to help build and design the setup for other MarbleSolitaireModel classes like
 * TriangleSolitaireModel, AbstractSolitaireModel, and EuropeanSolitaireModel.
 * T
 */
public abstract class AbstractSolitaireModel implements MarbleSolitaireModel {
  protected int thickness;
  protected ArrayList<ArrayList<SlotState>> marbles;

  /**
   * This is a AbstractSolitaireModel constructor that creates an AbstractSolitaireModel object.
   *
   * @param thickness length of the bottom row of the board.
   * @param marbles   an ArrayList of an ArrayList of SlotStates, representing the game board.
   */
  public AbstractSolitaireModel(int thickness, ArrayList<ArrayList<SlotState>> marbles) {
    if (thickness < 0) {
      throw new IllegalArgumentException("Invalid number");
    }
    this.thickness = thickness;
    this.marbles = marbles;
  }

  /**
   * This function returns true if the move are valid. A position is valid if the piece
   * can be moved during the game.
   *
   * @param fromRow the x position for the Marble that we are trying to move
   * @param fromCol the y position for the Marble that we are trying to move
   * @param toRow   the x position that we are trying to move our Marble to
   * @param toCol   the y position that we are trying to move our Marble to
   * @return true if the move can be made and false otherwise
   */
  protected boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
    if (fromCol < 0 || fromRow < 0 || toCol < 0 || toRow < 0
            || fromCol >= this.getBoardSize() || fromRow >= this.getBoardSize()
            || toCol >= this.getBoardSize() || toRow >= this.getBoardSize()) {
      return false;
    }
    if (marbles.get(fromRow).get(fromCol) != SlotState.Marble
            || marbles.get(toRow).get(toCol) != SlotState.Empty) {
      return false;
    }
    if ((Math.abs(fromCol - toCol) == 2) == (Math.abs(toRow - fromRow) == 2)) {
      return false;
    }
    return ((fromCol == toCol && marbles.get((fromRow + toRow) / 2).get(fromCol)
            == SlotState.Marble) ^ (fromRow == toRow && marbles.get(fromRow).get((fromCol + toCol)
            / 2) == SlotState.Marble));
  }


  /**
   * Moves to Marble from position (fromRow, fromCol) to (toRow, toCol), does not return anything.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException when the moves are invalid.
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (!this.isValidMove(fromRow, fromCol, toRow, toCol)) {
      throw new IllegalArgumentException("Invalid Move");
    }
    marbles.get(fromRow).set(fromCol, SlotState.Empty);
    marbles.get(toRow).set(toCol, SlotState.Marble);
    marbles.get((fromRow + toRow) / 2).set((fromCol + toCol) / 2, SlotState.Empty);

  }

  /**
   * This is a function that tells if a point at (r,c) has a valid move and returns a boolean.
   *
   * @return true if that coordinate has a valid move that can be made.
   */
  protected boolean doesPointHaveValidMoves(int r, int c) {
    if (this.getSlotAt(r, c) != SlotState.Marble) {
      return false;
    }
    if (r == 0 || r == 1) {
      return isValidMove(r, c, r, c + 2) || isValidMove(r, c, r, c - 2)
              || isValidMove(r, c, r + 2, c);
    }
    if (r == this.getBoardSize() - 1 || r == this.getBoardSize() - 2) {
      return isValidMove(r, c, r, c + 2) || isValidMove(r, c, r, c - 2)
              || isValidMove(r, c, r - 2, c);
    }
    if (c == 0 || c == 1) {
      return isValidMove(r, c, r, c + 2)
              || isValidMove(r, c, r - 2, c) || isValidMove(r, c, r + 2, c);
    }
    if (c == this.getBoardSize() - 1 || c == this.getBoardSize() - 2) {
      return isValidMove(r, c, r, c - 2)
              || isValidMove(r, c, r - 2, c) || isValidMove(r, c, r + 2, c);
    } else {
      return isValidMove(r, c, r, c + 2) || isValidMove(r, c, r, c - 2)
              || isValidMove(r, c, r - 2, c) || isValidMove(r, c, r + 2, c);
    }
  }

  /**
   * Tells if the game has ended or not.
   *
   * @return true if the game is over.
   */
  @Override
  public boolean isGameOver() {
    for (int r = 0; r < this.getBoardSize(); r++) {
      for (int c = 0; c < this.getBoardSize(); c++) {
        if (doesPointHaveValidMoves(r, c)) {
          return false;
        }
      }
    }
    return true;
  }


  /**
   * Return the size of this board. The size is roughly the longest dimension of a board.
   *
   * @return the size as an integer
   */
  @Override
  public int getBoardSize() {
    return this.thickness * 2 + (this.thickness - 2);
  }

  /**
   * Get the state of the slot at a given position on the board.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return the state of the slot at the given row and column
   * @throws IllegalArgumentException if the row or the column are beyond
   *                                  the dimensions of the board
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (row < 0 || col < 0 || row >= this.getBoardSize() || col >= this.getBoardSize()) {
      throw new IllegalArgumentException("Row and Column are beyond dimensions of the board");
    }
    return this.marbles.get(row).get(col);
  }

  /**
   * This gives you the number of marbles that are currently on the Board.
   *
   * @return the number of marbles on the board
   */
  @Override
  public int getScore() {
    int i = 0;
    for (int r = 0; r < this.marbles.size(); r++) {
      for (int c = 0; c < this.marbles.get(r).size(); c++) {
        if (this.marbles.get(r).get(c) == SlotState.Marble) {
          i += 1;
        }
      }
    }
    return i;
  }
}
