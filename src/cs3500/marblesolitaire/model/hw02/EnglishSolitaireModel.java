package cs3500.marblesolitaire.model.hw02;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw04.AbstractSolitaireModel;

/**
 * This is an English Solitaire Model of the MarbleSolitaire Game.
 */
public class EnglishSolitaireModel extends AbstractSolitaireModel {

  /**
   * This constructs a {@code EnglishSolitaireMode} object.
   */
  public EnglishSolitaireModel() {
    this(3, 3, 3);
  }

  /**
   * This constructs a {@code EnglishSolitaireMode} object.
   *
   * @param sRow y position on the board starting at 0.
   * @param sCol x position on the board starting at 0.
   */
  public EnglishSolitaireModel(int sRow, int sCol) {
    this(3, sRow, sCol);
  }

  /**
   * This constructs a {@code EnglishSolitaireMode} object.
   *
   * @param thickness number of marbles in the top row.
   */
  public EnglishSolitaireModel(int thickness) {
    this(thickness, (thickness * 3 - 2) / 2, (thickness * 3 - 2) / 2);
  }

  public EnglishSolitaireModel(int thickness, int sRow, int sCol) {
    super(thickness, new ArrayList<ArrayList<SlotState>>());
    this.makeBoard(thickness, sRow, sCol, this.marbles);
  }

  /**
   * This constructs a {@code EnglishSolitaireMode} object.
   *
   * @param thickness number of marbles in the top row.
   * @param sRow      y position on the board.
   * @param sCol      x position on the board.
   */

  private void makeBoard(int thickness, int sRow, int sCol, ArrayList<ArrayList<SlotState>>
          marbles) {
    if (thickness % 2 == 0) {
      throw new IllegalArgumentException("Invalid Number");
    }
    // checks to see if it is greater than length
    if (((thickness + 2 * (thickness - 1)) - 1) < sRow) {
      throw new IllegalArgumentException("Invalid Position");
    }
    // checks to see if it is greater than length
    if (((thickness + 2 * (thickness - 1)) - 1) < sCol) {
      throw new IllegalArgumentException("Invalid Position");
    }
    if (sCol < 0) {
      throw new IllegalArgumentException("Invalid Position");
    }
    if (sRow < 0) {
      throw new IllegalArgumentException("Invalid Position");
    }
    if (sRow < thickness - 1 && sCol < thickness - 1) {
      throw new IllegalArgumentException("Invalid Position");
    }
    if (sRow > 2 * thickness - 2 && sCol < thickness - 1) {
      throw new IllegalArgumentException("Invalid Position");
    }
    if (sCol > 2 * thickness - 2 && sRow < thickness - 1) {
      throw new IllegalArgumentException("Invalid Position");
    }
    if (sCol > 2 * thickness - 2 && sRow > 2 * thickness - 2) {
      throw new IllegalArgumentException("Invalid Position");
    }
    this.thickness = thickness;
    for (int r = 0; r < this.getBoardSize(); r++) {
      marbles.add(new ArrayList<SlotState>());
      for (int c = 0; c < this.getBoardSize(); c++) {
        if (((r < thickness - 1) && (c < thickness - 1))
                || ((r < thickness - 1) && (c > 2 * thickness - 2))
                || ((r > 2 * thickness - 2) && (c < thickness - 1))
                || ((r > 2 * thickness - 2) && (c > 2 * thickness - 2))) {
          marbles.get(r).add(SlotState.Invalid);
        } else {
          marbles.get(r).add(SlotState.Marble);
        }
      }
    }
    if (this.marbles.get(sRow).get(sCol) == SlotState.Invalid) {
      throw new IllegalArgumentException("No Empty slot on an Invalid slot");
    } else {
      marbles.get(sRow).set(sCol, SlotState.Empty);
    }
  }


}
