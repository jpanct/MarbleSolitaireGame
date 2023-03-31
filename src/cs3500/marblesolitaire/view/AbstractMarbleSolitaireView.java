package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * This is an abstract class of the MarbleSolitaireView class, which includes many methods needed
 * to run MarbleSolitaireTextView and TriangleSolitaireTextView.
 */
public abstract class AbstractMarbleSolitaireView implements MarbleSolitaireView {
  MarbleSolitaireModelState type;
  Appendable out;

  /**
   * Constructor for AbstractMarbleSolitaireView class.
   *
   * @param type is the type of MarbleSolitaireModelState going through.
   */
  public AbstractMarbleSolitaireView(MarbleSolitaireModelState type) {
    if (type == null) {
      throw new IllegalArgumentException("No Null Types");
    }
    this.type = type;
  }

  /**
   * Constructor for AbstractMarbleSolitaireView class.
   *
   * @param type is the type of MarbleSoliatireState we are using to play the game.
   * @param out  is the text the user gets to see after their inputs.
   */
  public AbstractMarbleSolitaireView(MarbleSolitaireModelState type, Appendable out) {
    if (type == null || out == null) {
      throw new IllegalArgumentException("No Null Types");
    }
    this.type = type;
    this.out = out;
  }

  /**
   * Render the board to the provided data destination. The board should be rendered exactly
   * in the format produced by the toString method above
   *
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderBoard() throws IOException {
    out.append(this.toString());
  }

  /**
   * Render a specific message to the provided data destination.
   *
   * @param message the message to be transmitted
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderMessage(String message) throws IOException {
    out.append(message);
  }
}
