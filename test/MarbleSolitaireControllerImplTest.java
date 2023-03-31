import org.junit.Test;

import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.controller.MockMarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;

/**
 * A tester class to test all the methods within MarbleSOlitaireController.
 */
public class MarbleSolitaireControllerImplTest {

  /**
   * This test will test how well the mock works and if the mock does what it is intended to do.
   */
  @Test
  public void testMock() {
    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel model = new MockMarbleSolitaireModel(log);
    Appendable a = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, a);
    Readable r = new StringReader("1 2 3 4 5 6 7 8 a s 5 6 7 8 quit a s _ % %" +
            "1 2 3 4 o o o o 9 -47 9 -1 9 8 q 2 5");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, r);
    c.playGame();
    String[] output = log.toString().split("\n");
    assertEquals("getBoardSize method", output[0]);
    assertEquals("getScore method", output[1]);
    assertEquals("isGameOver method", output[2]);
    assertEquals("0 1 2 3", output[3]);
    assertEquals("getBoardSize method", output[4]);
    assertEquals("getScore method", output[5]);
    assertEquals("isGameOver method", output[6]);
    assertEquals("4 5 6 7", output[7]);
    assertEquals("getBoardSize method", output[8]);
    assertEquals("getScore method", output[9]);
    assertEquals("isGameOver method", output[10]);
    assertEquals("4 5 6 7", output[11]);
    assertEquals("getBoardSize method", output[12]);
    assertEquals("getScore method", output[13]);
    assertEquals("isGameOver method", output[14]);
    assertEquals("1 2 3 8", output[15]);
    assertEquals("getBoardSize method", output[16]);
    assertEquals("getScore method", output[17]);
    assertEquals("isGameOver method", output[18]);
    assertEquals("-48 8 -2 8", output[19]);
    assertEquals("getBoardSize method", output[20]);
  }

  /**
   * This test will test NumParameters for the View being null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNumParamsView() {
    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel model = new MockMarbleSolitaireModel(log);
    MarbleSolitaireView view = null;
    Readable r = new StringReader("1 2 3 4 5 6 7 8 a s 5 6 7 8 quit a s _ % %" +
            "1 2 3 4 o o o o 9 -47 9 -1 9 8 q 2 5");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, r);
  }

  /**
   * This test will test NumParameters for the Readable being null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNumParamsReadable() {
    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel model = new MockMarbleSolitaireModel(log);
    Appendable a = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, a);
    Readable r = null;
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, r);
  }

  /**
   * This test will test NumParameters for the Model being null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNumParamsModel() {
    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel model = new MockMarbleSolitaireModel(log);
    Appendable a = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, a);
    Readable r = new StringReader("1 2 3 4 5 6 7 8 a s 5 6 7 8 quit a s _ % %" +
            "1 2 3 4 o o o o 9 -47 9 -1 9 8 q 2 5");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, r);
  }

  /**
   * This test will test NumParameters for the Model, View, Readable being null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNumParamsModelViewReadable() {
    MarbleSolitaireModel model = null;
    Appendable a = new StringBuilder();
    MarbleSolitaireView view = null;
    Readable r = null;
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, r);
  }

  /**
   * This tests for an lower case q.
   */
  @Test
  public void testLowerCaseQ() {
    Appendable a = new StringBuilder();
    MarbleSolitaireModel b = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(b, a);
    Readable r = new StringReader("q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(b, view, r);
    c.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", a.toString());
  }

  /**
   * This tests for an Upper case q.
   */
  @Test
  public void testUpperCaseQ() {
    Appendable a = new StringBuilder();
    MarbleSolitaireModel b = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(b, a);
    Readable r = new StringReader("Q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(b, view, r);
    c.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", a.toString());
  }

  /**
   * This tests for two valid inputs and quits the game after.
   */
  @Test
  public void testReadableWithTwoValidInputsQuitsAfter() {
    Appendable a = new StringBuilder();
    MarbleSolitaireModel b = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(b, a);
    Readable r = new StringReader("4 6 4 4 2 5 4 5 q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(b, view, r);
    c.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O O _\n" +
            "O O O O _ O O\n" +
            "O O O O O _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O _\n" +
            "O O O O _ O O\n" +
            "O O O O O _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n", a.toString());
  }

  /**
   * This tests for MultipleValidInputs and quits game after.
   */
  @Test
  public void testMultipleValidInputsQuitsAfter() {
    Appendable a = new StringBuilder();
    MarbleSolitaireModel b = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(b, a);
    Readable r = new StringReader("4 6 4 4 2 5 4 5 2 3 2 5 q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(b, view, r);
    c.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O O _\n" +
            "O O O O _ O O\n" +
            "O O O O O _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "    O O O\n" +
            "    _ _ O\n" +
            "O O O O _ O O\n" +
            "O O O O O _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 29\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    _ _ O\n" +
            "O O O O _ O O\n" +
            "O O O O O _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 29\n", a.toString());
  }

  /**
   * This tests for Multiple Valid and Invalid Inputs and quits after.
   */
  @Test
  public void testMultipleValidandInvalidInputsQuitsAfter() {
    Appendable a = new StringBuilder();
    MarbleSolitaireModel b = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(b, a);
    Readable r = new StringReader("4 6 4 4 1 2 3 4 2 3 2 5 q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(b, view, r);
    c.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Invalid move. Play again. X\n" +
            "Invalid move. Play again. X\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n", a.toString());
  }

  /**
   * This tests for Multiple Valid and Invalid Inputs, including negatives and quits after.
   */
  @Test
  public void testMultipleValidandInvalidInputsIncludingNegativesQuitsAfter() {
    Appendable a = new StringBuilder();
    MarbleSolitaireModel b = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(b, a);
    Readable r = new StringReader("4 6 4 4 -1 2 3 4 -2 3 2 5 q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(b, view, r);
    c.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Invalid move. Play again. X\n" +
            "Invalid move. Play again. X\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n", a.toString());
  }

  /**
   * This tests for MultipleValidInputs and quits In the middle.
   */
  @Test
  public void testMultipleValidInputsQuitsInTheMiddle() {
    Appendable a = new StringBuilder();
    MarbleSolitaireModel b = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(b, a);
    Readable r = new StringReader("4 6 4 4 2 5 4 5 q 2 3 2 5");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(b, view, r);
    c.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O O _\n" +
            "O O O O _ O O\n" +
            "O O O O O _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O _\n" +
            "O O O O _ O O\n" +
            "O O O O O _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n", a.toString());
  }

  /**
   * This tests for a move after two invalid move and quits game after.
   */
  @Test
  public void testMoveAfterInvalidMovesQuitsAfter() {
    Appendable a = new StringBuilder();
    MarbleSolitaireModel b = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(b, a);
    Readable r = new StringReader("1 2 3 4 5 6 7 8 4 6 4 4 2 5 4 5 2 3 2 5 q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(b, view, r);
    c.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid move. Play again. X\n" +
            "Invalid move. Play again. X\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O O _\n" +
            "O O O O _ O O\n" +
            "O O O O O _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "    O O O\n" +
            "    _ _ O\n" +
            "O O O O _ O O\n" +
            "O O O O O _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 29\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    _ _ O\n" +
            "O O O O _ O O\n" +
            "O O O O O _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 29\n", a.toString());
  }

  /**
   * This tests for one Invalid Move with Invalid Characters and Quits.
   */
  @Test
  public void testOneInvalidCharactersandthenQuit() {
    Appendable a = new StringBuilder();
    MarbleSolitaireModel b = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(b, a);
    Readable r = new StringReader("a b c d q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(b, view, r);
    c.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", a.toString());
  }

  /**
   * This tests PlayGame for gameOver() and won.
   */
  @Test
  public void testGameOverWon() {
    Appendable a = new StringBuilder();
    MarbleSolitaireModel b = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(b, a);
    Readable r = new StringReader("6 4 4 4 5 2 5 4 4 4 6 4 7 4 5 4 7 3 5 3 5 4 5 2 5 6 5 4 7 " +
            "5 5 5 5 4 5 6 5 1 5 3 4 3 6 3 3 2 5 2 3 1 5 1 5 1 5 3 6 3 4 3 5 7 5 5 4 5 6 5 3 7 " +
            "5 7 3 6 5 6 5 7 5 5 6 5 4 5 3 4 3 2 1 3 3 3 4 3 2 3 1 5 1 3 1 3 3 3 3 2 3 4 2 4" +
            " 4 4 4 4 4 6 2 5 4 5 4 6 4 4");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(b, view, r);
    c.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O _ _ _ O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 29\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O _ _ O O O O\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "Score: 28\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O _ O O O O O\n" +
            "    _ _ O\n" +
            "    _ _ O\n" +
            "Score: 27\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O _ _ O O O\n" +
            "    _ _ O\n" +
            "    _ _ O\n" +
            "Score: 26\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O _ O _ _ O\n" +
            "    _ _ O\n" +
            "    _ _ O\n" +
            "Score: 25\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O _ O O _ O\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 24\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O _ _ _ O O\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 23\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "_ _ O _ _ O O\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 22\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O _ _ O O O\n" +
            "_ _ _ _ _ O O\n" +
            "    O _ _\n" +
            "    _ _ _\n" +
            "Score: 21\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O _ O O O O O\n" +
            "O _ _ _ O O O\n" +
            "_ O _ _ _ O O\n" +
            "    O _ _\n" +
            "    _ _ _\n" +
            "Score: 20\n" +
            "    O O O\n" +
            "    O O O\n" +
            "_ _ O O O O O\n" +
            "_ _ _ _ O O O\n" +
            "O O _ _ _ O O\n" +
            "    O _ _\n" +
            "    _ _ _\n" +
            "Score: 19\n" +
            "    O O O\n" +
            "    O O O\n" +
            "_ _ O O O O O\n" +
            "_ _ _ _ O O O\n" +
            "_ _ O _ _ O O\n" +
            "    O _ _\n" +
            "    _ _ _\n" +
            "Score: 18\n" +
            "    O O O\n" +
            "    O O O\n" +
            "_ _ O O O O O\n" +
            "_ _ O _ O O O\n" +
            "_ _ _ _ _ O O\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 17\n" +
            "    O O O\n" +
            "    O O O\n" +
            "_ _ O O O O O\n" +
            "_ _ O _ O O O\n" +
            "_ _ _ _ O _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 16\n" +
            "    O O O\n" +
            "    O O O\n" +
            "_ _ O O O O O\n" +
            "_ _ O _ _ O O\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ O\n" +
            "    _ _ _\n" +
            "Score: 15\n" +
            "    O O O\n" +
            "    O O O\n" +
            "_ _ O O O O _\n" +
            "_ _ O _ _ O _\n" +
            "_ _ _ _ _ _ O\n" +
            "    _ _ O\n" +
            "    _ _ _\n" +
            "Score: 14\n" +
            "    O O O\n" +
            "    O O O\n" +
            "_ _ O O O _ _\n" +
            "_ _ O _ _ _ _\n" +
            "_ _ _ _ _ O O\n" +
            "    _ _ O\n" +
            "    _ _ _\n" +
            "Score: 13\n" +
            "    O O O\n" +
            "    O O O\n" +
            "_ _ O O O _ _\n" +
            "_ _ O _ _ _ _\n" +
            "_ _ _ _ O _ _\n" +
            "    _ _ O\n" +
            "    _ _ _\n" +
            "Score: 12\n" +
            "    O O O\n" +
            "    O O O\n" +
            "_ _ O O O _ _\n" +
            "_ _ O _ O _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 11\n" +
            "    O O O\n" +
            "    O O O\n" +
            "_ O _ _ O _ _\n" +
            "_ _ O _ O _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 10\n" +
            "    _ O O\n" +
            "    _ O O\n" +
            "_ O O _ O _ _\n" +
            "_ _ O _ O _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 9\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "_ O _ _ O _ _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 8\n" +
            "    O _ _\n" +
            "    O O O\n" +
            "_ O _ _ O _ _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 7\n" +
            "    _ _ _\n" +
            "    _ O O\n" +
            "_ O O _ O _ _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 6\n" +
            "    _ _ _\n" +
            "    _ O O\n" +
            "_ _ _ O O _ _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 5\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ O O _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 4\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ _ _ O _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 3\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ O O _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 2\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 1\n" +
            "Game over!\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 1\n", a.toString());
  }

  /**
   * Tests for an invalid input before valid inputs get put in.
   */
  @Test
  public void testInvalidBeforeValid() {
    Appendable a = new StringBuilder();
    MarbleSolitaireModel b = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(b, a);
    Readable r = new StringReader("-5 2 5 4 6 4 4 4 5 2 5 4 q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(b, view, r);
    c.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid move. Play again. X\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 30\n", a.toString());
  }

  /**
   * Tests for an EmptyReadable.
   */
  @Test
  public void testEmptyReadable() {
    Appendable a = new StringBuilder();
    MarbleSolitaireModel b = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(b, a);
    Readable r = new StringReader(" ");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(b, view, r);
    try {
      c.playGame();
    } catch (IllegalStateException e) {
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n", a.toString());
    }
  }

  /**
   * Tests for two valid inputs.
   */
  @Test
  public void testTwoValidInputs() {
    Appendable a = new StringBuilder();
    MarbleSolitaireModel b = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(b, a);
    Readable r = new StringReader("4 6 4 4 2 5 4 5");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(b, view, r);
    try {
      c.playGame();
    } catch (IllegalStateException e) {
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O _ _ O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 31\n" +
              "    O O O\n" +
              "    O O _\n" +
              "O O O O _ O O\n" +
              "O O O O O _ O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 30\n", a.toString());
    }
  }

  /**
   * Tests for multiple valid inputs.
   */
  @Test
  public void testMultipleValidInputs() {
    Appendable a = new StringBuilder();
    MarbleSolitaireModel b = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(b, a);
    Readable r = new StringReader("6 4 4 4 5 2 5 4 4 4 6 4 7 4 5 4");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(b, view, r);
    try {
      c.playGame();
    } catch (IllegalStateException e) {
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "    O _ O\n" +
              "    O O O\n" +
              "Score: 31\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O _ _ O O O O\n" +
              "    O _ O\n" +
              "    O O O\n" +
              "Score: 30\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O _ _ _ O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 29\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O _ _ O O O O\n" +
              "    O _ O\n" +
              "    O _ O\n" +
              "Score: 28\n", a.toString());
    }
  }

  /**
   * Tests for multiple valid and invalid inputs.
   */
  @Test
  public void testMultipleValidInvalidInputs() {
    Appendable a = new StringBuilder();
    MarbleSolitaireModel b = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(b, a);
    Readable r = new StringReader("6 4 4 4 -1 2 % 4 5 2 5 4 8 8 8 8 4 4 6 4 7 4 5 4");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(b, view, r);
    try {
      c.playGame();
    } catch (IllegalStateException e) {
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "    O _ O\n" +
              "    O O O\n" +
              "Score: 31\n" +
              "Invalid move. Play again. X\n" +
              "Invalid move. Play again. X\n" +
              "Invalid move. Play again. X\n" +
              "Invalid move. Play again. X\n", a.toString());
    }
  }

  /**
   * Tests multiple valid and invalid inputs.
   */
  @Test
  public void testMultipleInvalidValidInputs() {
    Appendable a = new StringBuilder();
    MarbleSolitaireModel b = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(b, a);
    Readable r = new StringReader("6 4 4 4 1 2 3 4 5 2 5 4 -0 -9 * 4 4 4 6 4 1 1 1 1 7 4 5 4 $ % " +
            "^ & 7 3 5 3 9 9 9 9 5 4 5 2");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(b, view, r);
    try {
      c.playGame();
    } catch (IllegalStateException e) {
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "    O _ O\n" +
              "    O O O\n" +
              "Score: 31\n" +
              "Invalid move. Play again. X\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O _ _ O O O O\n" +
              "    O _ O\n" +
              "    O O O\n" +
              "Score: 30\n" +
              "Invalid move. Play again. X\n" +
              "Invalid move. Play again. X\n" +
              "Invalid move. Play again. X\n" +
              "Invalid move. Play again. X\n" +
              "Invalid move. Play again. X\n" +
              "Invalid move. Play again. X\n", a.toString());
    }
  }
}
