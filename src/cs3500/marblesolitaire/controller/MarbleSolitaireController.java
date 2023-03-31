package cs3500.marblesolitaire.controller;

/**
 * This is MarbleSolitaireController which is the controller for MarbleSolitaireModels.
 */
public interface MarbleSolitaireController {
  /**
   * This method should play a new game of Marble Solitaire.
   *
   * @throws IllegalArgumentException only if the controller is unable to
   *                                  successfully read input or transmit output.
   */
  void playGame() throws IllegalStateException;
}
