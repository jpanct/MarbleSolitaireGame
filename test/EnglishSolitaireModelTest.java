import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This is a class used to test all the methods used in EnglishSolitaireModelTest.
 * This class also tests the toString() method in the MarbleSolitaireTextView class.
 */
public class EnglishSolitaireModelTest {

  MarbleSolitaireModel a;
  MarbleSolitaireModel b;
  MarbleSolitaireModel c;
  MarbleSolitaireModel d;
  MarbleSolitaireModel e;
  MarbleSolitaireModel k;
  MarbleSolitaireTextView f;
  MarbleSolitaireModel g;

  /**
   * This creates examples of EnglishSolitaireModels.
   */
  @Before
  public void init() {
    this.a = new EnglishSolitaireModel(3);
    this.b = new EnglishSolitaireModel(3, 3);
    this.c = new EnglishSolitaireModel(5);
    this.d = new EnglishSolitaireModel(7, 7, 7);
    this.e = new EnglishSolitaireModel(9, 9, 10);
    this.g = new EnglishSolitaireModel(9, 8, 8);
    this.k = new EnglishSolitaireModel(15);


  }

  /**
   * Testing for a valid constructor that only takes in two inputs.
   */
  @Test
  public void testValidSrowSCol() {
    MarbleSolitaireModel x = new EnglishSolitaireModel(3, 3);
    assertEquals(7, x.getBoardSize());
  }

  /**
   * Testing for a valid constructor that only takes in one input.
   */
  @Test
  public void testValidthickness() {
    MarbleSolitaireModel x = new EnglishSolitaireModel(11);
    assertEquals(31, x.getBoardSize());
  }

  /**
   * Testing for a valid constructor that take in three inputs.
   */
  @Test
  public void testValidthicknessSrowScol() {
    MarbleSolitaireModel x = new EnglishSolitaireModel(11, 10, 11);
    assertEquals(31, x.getBoardSize());
  }

  /**
   * Tests IllegalArgumentException sRow and Scol.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInValidSrowSCol() {
    MarbleSolitaireModel x = new EnglishSolitaireModel(0, 1);
  }

  /**
   * Tests IllegalArgumentException for Invalid Thickness.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInValidThickness() {
    MarbleSolitaireModel x = new EnglishSolitaireModel(4);
  }

  /**
   * Tests IllegalArgumentException for Invalid Thickness with two other inputs in the constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEvenThicknessSrowSCol() {
    MarbleSolitaireModel x = new EnglishSolitaireModel(-20, 5, 19);
  }


  /**
   * Tests IllegalArgumentException for Invalid Thickness.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInValidThicknessSrowSCol() {
    MarbleSolitaireModel x = new EnglishSolitaireModel(7, 5, 19);
  }

  /**
   * Tests to see if an IllegalArgumentException is being thrown when the from
   * and to position are in an invalid spot.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveWrongSlot() {
    this.a.move(3, 3, 3, 6);
  }

  /**
   * Tests to see if an IllegalArgumentException class is thrown when the moves are too far apart.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveTooFarApart() {
    this.a.move(3, 3, 3, 8);
  }

  /**
   * Tests to see if an IllegalArgumentException class is thrown when there is no marble inbetween.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveMarbleInBetweenIsNotMarble() {
    this.a.move(3, 5, 3, 3);
    this.a.move(3, 6, 3, 4);
  }

  /**
   * Tests to see if an IllegalArgumentException class is thrown when tp position does not exist.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNonExistingToPosition() {
    this.a.move(1, 5, -13, 3);
  }

  /**
   * Tests to see if an IllegalArgumentException class is thrown when from position has no marble.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNonExistingFromPositionHasNoMarble() {
    this.a.move(3, 3, 3, 5);
  }

  /**
   * Tests to see if an IllegalArgumentException class is thrown when there is a diagonol move.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testDiagonolMove() {
    this.a.move(5, 5, 3, 3);
  }


  /**
   * Tests to verify that your move method works correctly when attempting to move a marble into
   * an empty slot from two columns to the left and same row, with a marble in the slot in between.
   */
  @Test
  public void testMovetoTheRightandTheLeft() {
    this.a.move(3, 1, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.a.getSlotAt(3, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.a.getSlotAt(3, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.a.getSlotAt(3, 3));
    this.b.move(3, 5, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.b.getSlotAt(3, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.b.getSlotAt(3, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b.getSlotAt(3, 3));
  }

  /**
   * Tests the Move method.
   */
  @Test
  public void testMove() {
    this.a.move(3, 5, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.a.getSlotAt(3, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.a.getSlotAt(3, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.a.getSlotAt(3, 3));
    this.g.move(8, 10, 8, 8);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.g.getSlotAt(8, 10));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.g.getSlotAt(8, 9));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.g.getSlotAt(8, 8));
    this.d.move(9, 7, 7, 7);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.d.getSlotAt(9, 7));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.d.getSlotAt(8, 7));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.d.getSlotAt(7, 7));
  }


  /**
   * Tests getBoardSize() to check the longest side.
   */
  @Test
  public void testGetBoardSize() {
    assertEquals(7, b.getBoardSize());
    assertEquals(13, c.getBoardSize());
    assertEquals(19, d.getBoardSize());
  }

  /**
   * Tests getSlotAt() to see what SlotState is at a certain point().
   */
  @Test
  public void testGetSlotAt() {
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, b.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, d.getSlotAt(5, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, d.getSlotAt(7, 7));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, e.getSlotAt(9, 10));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, d.getSlotAt(7, 9));
    this.d.move(9, 7, 7, 7);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.d.getSlotAt(9, 7));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.d.getSlotAt(8, 7));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.d.getSlotAt(7, 7));
  }

  /**
   * Tests the getScore method to count the number of pegs on the board.
   */
  @Test
  public void testGetScore() {
    assertEquals(32, this.a.getScore());
    assertEquals(1064, this.k.getScore());
    assertEquals(368, this.g.getScore());
    this.a.move(3, 5, 3, 3);
    assertEquals(31, this.a.getScore());
  }

  /**
   * Tests to the gameOver() function to see if the game actually is over.
   * This example should print false, because the game is not over
   */
  @Test
  public void testgameOverprintsFalse() {
    assertFalse(this.a.isGameOver());
  }

  /**
   * Tests to the gameOver() function to see if the game actually is over.
   * This example should print true, because the game is over.3e
   */
  @Test
  public void testgameOver() {
    this.a.move(1, 3, 3, 3);
    this.a.move(4, 3, 2, 3);
    this.a.move(6, 3, 4, 3);
    this.a.move(3, 1, 3, 3);
    this.a.move(3, 4, 3, 2);
    this.a.move(3, 6, 3, 4);
    assertTrue(this.a.isGameOver());
  }


}
