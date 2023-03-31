package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * This class represents a text view of the TriangleSolitaire version of the MarbleSolitaire
 * game.
 */
public class TriangleSolitaireTextView extends AbstractMarbleSolitaireView {


  /**
   * Constructor for TriangleSolitaireTextView class.
   *
   * @param type is the type of TriangleSolitaireTextView going through.
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState type) {
    super(type);
  }

  /**
   * Constructor for TriangleSolitaireTextView class.
   *
   * @param type is the type of MarbleSoliatireState we are using to play the game.
   * @param out  is the text the user gets to see after their inputs.
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState type, Appendable out) {
    super(type, out);
  }

  /**
   * This returns the board MarbleSolitaireState Game Board in the form of a String. This is the
   * text view of the placement of the marbles and spaces.
   *
   * @return the board in a String.
   */
  @Override
  public String toString() {
    String g = "";
    for (int r = 0; r < type.getBoardSize(); r++) {
      for (int x = 0; x < type.getBoardSize() - 1 - r; x++) {
        g = g + " ";
      }
      for (int c = 0; c < type.getBoardSize(); c++) {
        if (type.getSlotAt(r, c).equals(MarbleSolitaireModelState.SlotState.Empty)) {
          g = g + "_";
        }
        if (type.getSlotAt(r, c).equals(MarbleSolitaireModelState.SlotState.Invalid)) {
          g = g + " ";
        }
        if (type.getSlotAt(r, c).equals(MarbleSolitaireModelState.SlotState.Marble)) {
          g = g + "O";

        }
        if (c != type.getBoardSize() - 1) {
          g = g + " ";
        }
        if (c == type.getBoardSize() - 1) {
          g = g.stripTrailing();
        }
      }

      if (r != type.getBoardSize() - 1) {
        g = g + "\n";
      }

    }
    return g;
  }

}
