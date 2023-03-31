package cs3500.marblesolitaire.controller;

import java.util.Objects;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * This is a class that represents the Mock for MarbleSOlitaireModel. This is used in testing cases
 * to test MarbleSolitaireModel and the controller.
 */
public class MockMarbleSolitaireModel implements MarbleSolitaireModel {
  final StringBuilder log;

  /**
   * This is a Mock for the MarbleSolitaireModel.
   *
   * @param log is the output that is printed.
   */
  public MockMarbleSolitaireModel(StringBuilder log) {
    this.log = Objects.requireNonNull(log);
  }

  /**
   * This is a method that appends the method stub (move) to the log.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    this.log.append(fromRow + " " + fromCol + " " + toRow + " " + toCol + "\n");
  }

  /**
   * This is a method that appends the method stub (isGameOver) to the log.
   *
   * @return method stub appended to the log.
   */
  @Override
  public boolean isGameOver() {
    this.log.append("isGameOver method\n");
    return false;
  }

  /**
   * This is a method that appends the method stub(getBoarSize) to the log.
   *
   * @return method stub appended to the log.
   */
  @Override
  public int getBoardSize() {
    this.log.append("getBoardSize method\n");
    return 0;
  }

  /**
   * This is a method that appends the method stub (getSlotAt) to the log.
   *
   * @return method stub appended to the log.
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    this.log.append("getSlotAt method\n");
    return null;
  }

  /**
   * This is a method that appends the method stub(getScore) to the log.
   *
   * @return method stub appended to the log.
   */
  @Override
  public int getScore() {
    this.log.append("getScore method\n");
    return 0;
  }
}
