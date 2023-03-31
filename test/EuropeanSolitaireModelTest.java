import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This is a class that tests for all methods in EuropeanSolitaireModel.
 */
public class EuropeanSolitaireModelTest {
  MarbleSolitaireModel a;
  MarbleSolitaireModel b;
  MarbleSolitaireModel c;
  MarbleSolitaireModel d;
  MarbleSolitaireModel e;
  MarbleSolitaireModel k;
  MarbleSolitaireModel g;

  /**
   * This creates examples of EuropeanSolitaireModels.
   */
  @Before
  public void init() {
    this.a = new EuropeanSolitaireModel(3);
    this.b = new EuropeanSolitaireModel(3, 3);
    this.c = new EuropeanSolitaireModel(5);
    this.d = new EuropeanSolitaireModel(7, 7, 7);
    this.e = new EuropeanSolitaireModel(9, 9, 10);
    this.g = new EuropeanSolitaireModel(9, 8, 8);
    this.k = new EuropeanSolitaireModel(15);
  }

  /**
   * Testing for a valid constructor that only takes in two inputs.
   */
  @Test
  public void testValidSrowSCol() {
    MarbleSolitaireModel x = new EuropeanSolitaireModel(3, 3);
    assertEquals(7, x.getBoardSize());
  }

  /**
   * Testing for a valid constructor that only takes in one input.
   */
  @Test
  public void testValidthickness() {
    MarbleSolitaireModel x = new EuropeanSolitaireModel(11);
    assertEquals(31, x.getBoardSize());
  }

  /**
   * Testing for a valid constructor that take in three inputs.
   */
  @Test
  public void testValidthicknessSrowScol() {
    MarbleSolitaireModel x = new EuropeanSolitaireModel(11, 10, 11);
    assertEquals(31, x.getBoardSize());
  }

  /**
   * Tests IllegalArgumentException sRow and Scol.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInValidSrowSCol() {
    MarbleSolitaireModel x = new EuropeanSolitaireModel(0, 1);
  }

  /**
   * Tests IllegalArgumentException for Invalid Thickness.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInValidThickness() {
    MarbleSolitaireModel x = new EuropeanSolitaireModel(4);
  }

  /**
   * Tests IllegalArgumentException for Invalid Thickness with two other inputs in the constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEvenThicknessSrowSCol() {
    MarbleSolitaireModel x = new EuropeanSolitaireModel(-20, 5, 19);
  }

  /**
   * Tests IllegalArgumentException for Invalid Thickness.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInValidThicknessSrowSCol() {
    MarbleSolitaireModel x = new EuropeanSolitaireModel(7, 5, 19);
  }

  /**
   * Test the gameOver method.
   */
  @Test
  public void testGameOver() {
    assertFalse(this.a.isGameOver());
    this.a.move(5,3,3,3);
    this.a.move(2,3,4,3);
    this.a.move(0,3,2,3);
    this.a.move(1,1,1,3);
    this.a.move(1,4,1,2);
    this.a.move(3,1,1,1);
    this.a.move(1,1,1,3);
    this.a.move(5,1,3,1);
    this.a.move(2,3,2,1);
    this.a.move(2,0,2,2);
    this.a.move(4,0,2,0);
    this.a.move(2,5,2,3);
    this.a.move(1,3,3,3);
    this.a.move(3,2,3,0);
    this.a.move(2,0,4,0);
    this.a.move(3,4,3,2);
    this.a.move(3,2,1,2);
    this.a.move(0,2,2,2);
    this.a.move(3,6,3,4);
    this.a.move(5,2,3,2);
    this.a.move(2,2,4,2);
    this.a.move(4,3,4,1);
    this.a.move(4,0,4,2);
    this.a.move(4,5,4,3);
    this.a.move(4,2,4,4);
    this.a.move(4,4,2,4);
    this.a.move(6,4,4,4);
    this.a.move(6,2,6,4);
    assertTrue(this.a.isGameOver());
  }

  /**
   * Tests to make sure an IllegalArgumentException is thrown when the move
   * is off the board.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveOfftheBoard() {
    this.a.move(7,7,13,13);
  }

  /**
   * Tests to make sure an IllegalArgumentException is thrown when the move is invalid due to
   * slots.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSlots() {
    this.a.move(7,7,9,7);
  }

  /**
   * Tests to make sure an IllegalArgumentException is thrown when the move is invalid due to
   * negative numbers/coordinates.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeMoves() {
    this.a.move(7,7,-9,7);
  }

  /**
   * Tests to make sure an IllegalArgumentException is thrown when the move is invalid due to
   * it being a diagonal move.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidDiagonal() {
    this.a.move(9,9,7,7);
  }

  /**
   * Tests to make sure that valid moves will actually be executed.
   */
  @Test
  public void testValidMoves() {
    // moves to down
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,this.a.getSlotAt(5,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,this.a.getSlotAt(4,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,this.a.getSlotAt(3,3));
    this.a.move(5,3,3,3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,this.a.getSlotAt(5,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,this.a.getSlotAt(4,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,this.a.getSlotAt(3,3));
    //moves up
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,this.k.getSlotAt(19,21));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,this.k.getSlotAt(20,21));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,this.k.getSlotAt(21,21));
    this.k.move(19,21,21,21);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,this.k.getSlotAt(19,21));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,this.k.getSlotAt(20,21));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,this.k.getSlotAt(21,21));
    // moves to the left
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,this.g.getSlotAt(8,10));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,this.g.getSlotAt(8,9));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,this.g.getSlotAt(8,8));
    this.g.move(8, 10, 8,8);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,this.g.getSlotAt(8,10));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,this.g.getSlotAt(8,9));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,this.g.getSlotAt(8,8));
    // moves to the right
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,this.c.getSlotAt(6,6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,this.c.getSlotAt(6,5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,this.c.getSlotAt(6,4));
    this.c.move(6,4,6,6);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,this.c.getSlotAt(6,6));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,this.c.getSlotAt(6,5));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,this.c.getSlotAt(6,4));
  }

  /**
   * Tests to see if getBoardSize() returns the right board size.
   */
  @Test
  public void testGetBoardSize() {
    assertEquals(7,this.a.getBoardSize());
    assertEquals(7,this.b.getBoardSize());
    assertEquals(13,this.c.getBoardSize());
    assertEquals(19,this.d.getBoardSize());
    assertEquals(25,this.e.getBoardSize());
  }

  /**
   * Tests to see if getSlotAt returns the right Slot.
   */
  @Test
  public void testGetSlotAt() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,this.a.getSlotAt(5,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,this.a.getSlotAt(4,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,this.a.getSlotAt(3,3));
  }

  /**
   * Tests to see if getScore returns the correct score, before and after moves are made.
   */
  @Test
  public void getScore() {
    assertEquals(276, this.d.getScore());
    assertEquals(36, this.b.getScore());
    assertEquals(128, this.c.getScore());
    assertEquals(480, this.e.getScore());
    assertEquals(36, this.a.getScore());
    this.a.move(5,3,3,3);
    assertEquals(35, this.a.getScore());
    this.a.move(2,3,4,3);
    this.a.move(0,3,2,3);
    this.a.move(1,1,1,3);
    this.a.move(1,4,1,2);
    this.a.move(3,1,1,1);
    this.a.move(1,1,1,3);
    this.a.move(5,1,3,1);
    this.a.move(2,3,2,1);
    assertEquals(27, this.a.getScore());
    this.a.move(2,0,2,2);
    this.a.move(4,0,2,0);
    this.a.move(2,5,2,3);
    this.a.move(1,3,3,3);
    this.a.move(3,2,3,0);
    this.a.move(2,0,4,0);
    this.a.move(3,4,3,2);
    this.a.move(3,2,1,2);
    this.a.move(0,2,2,2);
    this.a.move(3,6,3,4);
    this.a.move(5,2,3,2);
    this.a.move(2,2,4,2);
    this.a.move(4,3,4,1);
    this.a.move(4,0,4,2);
    this.a.move(4,5,4,3);
    assertEquals(12, this.a.getScore());
    this.a.move(4,2,4,4);
    this.a.move(4,4,2,4);
    this.a.move(6,4,4,4);
    this.a.move(6,2,6,4);
    assertEquals(8, this.a.getScore());
  }
}