package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;

/**
 * This represents a TriangleSolitaireModel which is a type of MarbleSolitaireModel.
 */
public class TriangleSolitaireModel extends AbstractSolitaireModel {

  /**
   * This constructs a TriangleSolitaireModel object.
   */
  public TriangleSolitaireModel() {
    this(5);
  }

  /**
   * This constructs a TriangleSolitaireModel object.
   *
   * @param sRow y position on the board starting at 0.
   * @param sCol x position on the board starting at 0.
   */
  public TriangleSolitaireModel(int sRow, int sCol) {
    this(5, sRow, sCol);
  }

  /**
   * This constructs a TriangleSolitaireModel object.
   *
   * @param thickness the length of the bottom row.
   */
  public TriangleSolitaireModel(int thickness) {
    this(thickness, 0, 0);
  }

  /**
   * This constructs a TriangleSolitaireModel object.
   *
   * @param thickness the length of the bottom row.
   * @param sRow      y position on the board starting at 0.
   * @param sCol      x position on the board starting at 0.
   */
  public TriangleSolitaireModel(int thickness, int sRow, int sCol) {
    super(thickness, new ArrayList<ArrayList<SlotState>>());
    this.makeBoard(thickness, sRow, sCol, this.marbles);
  }

  /**
   * This initializes and creates the board for TriangleSolitaireModel.
   *
   * @param thickness thickness of the board, which determines the length.
   * @param sRow      the x position of the empty slot
   * @param sCol      the y position of the empty slot
   * @param marbles   represents the game board for TriangleSolitaireModel
   */
  private void makeBoard(int thickness, int sRow, int sCol, ArrayList<ArrayList<SlotState>>
          marbles) {
    for (int r = 0; r < this.getBoardSize(); r++) {
      marbles.add(new ArrayList<SlotState>());
      for (int c = 0; c < this.getBoardSize(); c++) {
        if (r >= c) { //row >= c
          marbles.get(r).add(SlotState.Marble);
        } else {
          marbles.get(r).add(SlotState.Invalid);
        }
      }
    }
    try {
      this.marbles.get(sRow).get(sCol);
    } catch (IndexOutOfBoundsException e) {
      throw new IllegalArgumentException("No Empty slot on an Invalid slot");
    }
    if (this.marbles.get(sRow).get(sCol) == SlotState.Invalid) {
      throw new IllegalArgumentException("No Empty slot on an Invalid slot");
    } else {
      marbles.get(sRow).set(sCol, SlotState.Empty);
    }
  }

  @Override
  protected boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
    try { // makes sure all are on the board
      this.marbles.get(fromRow).get(fromCol);
      this.marbles.get(toRow).get(toCol);
      this.marbles.get((fromRow + toRow) / 2).get(fromCol);
      this.marbles.get((fromRow + toRow) / 2).get((fromCol + toCol) / 2);
    } catch (IndexOutOfBoundsException e) {
      return false;
    }
    if (!((Math.abs(toRow - fromRow) == 2 && Math.abs(toCol - fromCol) == 0)
            || (Math.abs(toRow - fromRow) == 2 && Math.abs(toCol - fromCol) == 2)
            || (toRow == fromRow && Math.abs(toCol - fromCol) == 2))) {
      return false;
    }
    return (!(marbles.get(fromRow).get(fromCol) != SlotState.Marble
            || marbles.get(toRow).get(toCol) != SlotState.Empty
            || (marbles.get((toRow + fromRow) / 2).get((toCol + fromCol) / 2)
            != SlotState.Marble)));
  }

  /**
   * This method checks one individual point on the board and checks to see if a valid move can be
   * made with that slot.
   *
   * @param sRow the x coordinate of the slot
   * @param sCol the y coordinate of the slot
   * @return true if the point has valid moves
   */
  @Override
  protected boolean doesPointHaveValidMoves(int sRow, int sCol) {
    return this.isValidMove(sRow, sCol, sRow + 2, sCol + 2)
            || this.isValidMove(sRow, sCol, sRow - 2, sCol - 2)
            || this.isValidMove(sRow, sCol, sRow + 2, sCol)
            || this.isValidMove(sRow, sCol, sRow - 2, sCol)
            || this.isValidMove(sRow, sCol, sRow, sCol - 2)
            || this.isValidMove(sRow, sCol, sRow, sCol + 2);
  }

  /**
   * This gives the board size of the game.
   *
   * @return the int, representing the board size.
   */
  @Override
  public int getBoardSize() {
    return this.thickness;
  }
}





