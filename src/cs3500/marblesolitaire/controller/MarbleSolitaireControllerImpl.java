package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * This is a class representing the MarbleSolitaire's Controller Implementer.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  private final Readable in;
  private final MarbleSolitaireView object;
  private final MarbleSolitaireModel model;

  /**
   * This is the constructor used to make a MarbleSolitaireController Impl.
   *
   * @param model  is the MarbleSolitaireModel object that is being run in the game.
   * @param object is the view for the game that is being displayed.
   * @param in     is what is being passed in and what the user is typing in.
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model, MarbleSolitaireView object,
                                       Readable in) {
    if (model == null || in == null || object == null) {
      throw new IllegalArgumentException("No Null Types");
    }
    this.model = model;
    this.in = in;
    this.object = object;
  }

  /**
   * This method should play a new game of Marble Solitaire.
   *
   * @throws IllegalArgumentException only if the controller is unable to successfully read input
   *                                  or transmit output.
   */
  @Override
  public void playGame() throws IllegalStateException {
    int[] moveInputs = new int[4];
    Scanner sc = new Scanner(this.in);
    this.drawBoard();
    writeMessage("\n" + "Score: " + this.model.getScore() + "\n");
    String userInstruction;
    while (!this.model.isGameOver()) {
      for (int i = 0; i < 4; i++) {
        try {
          userInstruction = sc.next();
        } catch (NoSuchElementException e) {
          throw new IllegalStateException("Failed to Read");
        }
        if (userInstruction.equals("q") || userInstruction.equals("Q")) {
          writeMessage("Game quit!\nState of game when quit:\n");
          this.drawBoard();
          writeMessage("\n" + "Score: " + this.model.getScore() + "\n");
          sc.close();
          return;
        }
        try {
          int n = Integer.parseInt(userInstruction) - 1;
          moveInputs[i] = n;
        } catch (NumberFormatException e) {
          i--;
        }
      }
      try {
        this.model.move(moveInputs[0], moveInputs[1], moveInputs[2], moveInputs[3]);
        this.drawBoard();
        writeMessage("\n" + "Score: " + this.model.getScore() + "\n");
      } catch (IllegalArgumentException e) {
        writeMessage("Invalid move. Play again. X\n");
      }
    }
    writeMessage("Game over!\n");
    this.drawBoard();
    writeMessage("\n" + "Score: " + this.model.getScore() + "\n");
    sc.close();
  }

  /**
   * Helper function for writing any text for the user to see.
   *
   * @param s is the string that passes through.
   * @throws IllegalStateException when an IOException is caught.
   */
  private void writeMessage(String s) throws IllegalStateException {
    try {
      this.object.renderMessage(s);
    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    }
  }

  /**
   * Draws the board out for the viewers to see.
   *
   * @throws IllegalStateException when an IOException is caught.
   */
  private void drawBoard() throws IllegalStateException {
    try {
      this.object.renderBoard();
    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    }
  }
}