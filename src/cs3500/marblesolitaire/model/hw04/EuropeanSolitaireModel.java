package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;

/**
 * This class is a EuropeanSolitaireModel which is a model for a type of MarbleSolitaire game that
 * can be played.
 */
public class EuropeanSolitaireModel extends AbstractSolitaireModel {


  /**
   * This constructs a {@code EuropeanSolitaireModel} object.
   */
  public EuropeanSolitaireModel() {
    this(3, 3, 3);
  }

  /**
   * This constructs a {@code EuropeanSolitaireModel} object.
   *
   * @param sRow y position on the board starting at 0.
   * @param sCol x position on the board starting at 0.
   */
  public EuropeanSolitaireModel(int sRow, int sCol) {
    this(3, sRow, sCol);
  }

  /**
   * This constructs a {@code EuropeanSolitaireModel} object.
   *
   * @param thickness number of marbles in the top row.
   */
  public EuropeanSolitaireModel(int thickness) {
    this(thickness, (thickness * 3 - 2) / 2, (thickness * 3 - 2) / 2);
  }

  public EuropeanSolitaireModel(int thickness, int sRow, int sCol) {
    super(thickness, new ArrayList<ArrayList<SlotState>>());
    this.makeBoard(thickness, sRow, sCol, this.marbles);
  }

  /**
   * This creates and initializes the board for EuropeanSolitaireModel.
   *
   * @param thickness thickness of the board, which determines the length.
   * @param sRow      the x position of the empty slot
   * @param sCol      the y position of the empty slot
   * @param marbles   represents the game board for TriangleSolitaireModel
   */
  private void makeBoard(int thickness, int sRow, int sCol, ArrayList<ArrayList<SlotState>>
          marbles) {
    if (thickness % 2 == 0) {
      throw new IllegalArgumentException("Invalid Number");
    }

    for (int r = 0; r < this.getBoardSize(); r++) {
      marbles.add(new ArrayList<SlotState>());
      for (int c = 0; c < this.getBoardSize(); c++) {
        if ((r < thickness - 1 && c < this.thickness - r - 1)
                || (r < thickness - 1 && c > this.getBoardSize() + r - this.thickness)
                || (r > this.getBoardSize() - this.thickness && c < ((r + 2) % this.thickness))
                || (r > this.getBoardSize() - this.thickness && c > this.getBoardSize() - 1 -
                ((r + 2) % this.thickness))) {
          marbles.get(r).add(SlotState.Invalid);
        } else {
          marbles.get(r).add(SlotState.Marble);
        }
      }
    }
    try {
      this.getSlotAt(sRow, sCol);
    } catch (IndexOutOfBoundsException e) {
      throw new IllegalArgumentException("Invalid Position");
    }
    if (this.marbles.get(sRow).get(sCol) == SlotState.Invalid) {
      throw new IllegalArgumentException("No Empty slot on an Invalid slot");
    } else {
      marbles.get(sRow).set(sCol, SlotState.Empty);
    }
  }

}
