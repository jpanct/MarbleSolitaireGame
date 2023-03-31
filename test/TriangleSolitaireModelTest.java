import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This is a class that tests all the methods in TriangleSolitaireModel.
 */
public class TriangleSolitaireModelTest {

  MarbleSolitaireModel a;
  MarbleSolitaireModel b;
  MarbleSolitaireModel c;
  MarbleSolitaireModel d;
  MarbleSolitaireModel e;
  MarbleSolitaireModel f;
  MarbleSolitaireModel g;
  MarbleSolitaireModel h;
  MarbleSolitaireModel i;

  @Before
  public void init() {
    this.a = new TriangleSolitaireModel(5);
    this.b = new TriangleSolitaireModel(7);
    this.c = new TriangleSolitaireModel(2, 2);
    this.d = new TriangleSolitaireModel(4, 4);
    this.e = new TriangleSolitaireModel(3, 2, 0);
    this.f = new TriangleSolitaireModel(10, 9, 9);
    this.g = new TriangleSolitaireModel(4, 3);
    this.h = new TriangleSolitaireModel(7,5,3);
    this.i = new TriangleSolitaireModel(6,3,2);
  }

  /**
   * This tests to make sure that a TriangleSolitaireModel is properly made with one constructor
   * input.
   */
  @Test
  public void testValidThickness() {
    TriangleSolitaireModel q = new TriangleSolitaireModel(7);
    assertEquals(7,q.getBoardSize());
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,q.getSlotAt(0,0));
  }

  /**
   * This tests to make sure that a TriangleSolitaireModel is properly made with three constructor
   * inputs.
   */
  @Test
  public void testValidThicknesssRowSCol() {
    TriangleSolitaireModel q = new TriangleSolitaireModel(7,5,3);
    assertEquals(7,q.getBoardSize());
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,q.getSlotAt(5,3));
  }

  /**
   * This tests to make sure that a TriangleSolitaireModel is properly made with two constructor
   * inputs.
   */
  @Test
  public void testValidRowAndColumn() {
    TriangleSolitaireModel q = new TriangleSolitaireModel(4,3);
    assertEquals(5,q.getBoardSize());
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,q.getSlotAt(4,3));
  }

  /**
   * This tests to make sure that a TriangleSolitaireModel is properly made with nothing passed
   * through the constructors.
   */
  @Test
  public void testValidEmptyConstructor() {
    TriangleSolitaireModel q = new TriangleSolitaireModel(4,3);
    assertEquals(5,q.getBoardSize());
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,q.getSlotAt(4,3));
  }


  /**
   * This tests the constructor to see if the Row and Column throw an IllegalArgumentException,
   * which it should throw. In this test, the row and Column goes off the board.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidsRowAndColumn() {
    MarbleSolitaireModel z = new TriangleSolitaireModel(9, 11, 11);
  }

  /**
   * This tests the constructor to see if the Column throw an IllegalArgumentException,
   * which it should throw. In this test, the index for Column is too big. This test has three
   * parameters.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidsColumnThreeConstructor() {
    MarbleSolitaireModel z = new TriangleSolitaireModel(9, 4, 7);
  }

  /**
   * This tests the constructor to see if the Column throw an IllegalArgumentException,
   * which it should throw. In this test, the index for Column is too big. This test has two
   * parameters.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidsColumnTwoConstructor() {
    MarbleSolitaireModel z = new TriangleSolitaireModel(4, 5);
  }

  /**
   * This tests the constructor to see if the Row throw an IllegalArgumentException,
   * which it should throw. In this test, the index for Row is too big. This test has three
   * parameters.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidsRowsThreeConstructor() {
    MarbleSolitaireModel z = new TriangleSolitaireModel(9, 10, 0);
  }

  /**
   * This tests the constructor to see if the Row throw an IllegalArgumentException,
   * which it should throw. In this test, the index for Row is too big. This test has three
   * parameters.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidsRowsTwoConstructor() {
    MarbleSolitaireModel z = new TriangleSolitaireModel(5, 0);
  }

  /**
   * This tests a valid move from the start of the games in different directions (left and right
   * diagonal), when the empty slot is at (0,0).
   */
  @Test
  public void testValidMoveFromZeroZero() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.a.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.a.getSlotAt(1, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.a.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.b.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b.getSlotAt(1, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b.getSlotAt(2, 2));
    this.a.move(2, 0, 0, 0);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.a.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.a.getSlotAt(1, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.a.getSlotAt(2, 0));
    this.b.move(2, 2, 0, 0);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.b.getSlotAt(1, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.b.getSlotAt(2, 2));
  }

  /**
   * This tests a valid move from the start of the games in different directions (left and right),
   * when the empty slot at a slot other than at (0,0).
   */
  @Test
  public void testValidMoveFromRandomEmptySlot() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.e.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.e.getSlotAt(1, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.e.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.f.getSlotAt(7, 7));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.f.getSlotAt(8, 8));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.f.getSlotAt(9, 9));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.c.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.c.getSlotAt(1, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.c.getSlotAt(0, 0));
    this.e.move(0, 0, 2, 0);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.e.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.e.getSlotAt(1, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.e.getSlotAt(2, 0));
    this.f.move(7, 7, 9, 9);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.f.getSlotAt(7, 7));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.f.getSlotAt(8, 8));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.f.getSlotAt(9, 9));
    this.c.move(0, 0, 2, 2);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.c.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.c.getSlotAt(1, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.c.getSlotAt(0, 0));
  }

  /**
   * This tests a valid move from the start of the games in directly to the left in the same row,
   * and right.
   */
  @Test
  public void testValidMoveDirectlyToTheRightAndLeft() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.d.getSlotAt(4, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.d.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.d.getSlotAt(4, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.f.getSlotAt(7, 7));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.f.getSlotAt(8, 8));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.f.getSlotAt(9, 9));
    this.d.move(4, 2, 4, 4);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.d.getSlotAt(4, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.d.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.d.getSlotAt(4, 4));
    this.f.move(9, 7, 9, 9);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.f.getSlotAt(9, 7));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.f.getSlotAt(9, 8));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.f.getSlotAt(9, 9));
  }

  /**
   * This tests to see if a move is valid when it goes upwards and is diagonal.
   */
  @Test
  public void testValidMoveUpwardDiagonal() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.f.getSlotAt(7, 7));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.f.getSlotAt(8, 8));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.f.getSlotAt(9, 9));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.g.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.g.getSlotAt(3, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.g.getSlotAt(2, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.h.getSlotAt(3, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.h.getSlotAt(4, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.h.getSlotAt(5, 3));
    this.f.move(7, 7, 9, 9);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.f.getSlotAt(7, 7));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.f.getSlotAt(8, 8));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.f.getSlotAt(9, 9));
    this.g.move(2, 1, 4, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.g.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.g.getSlotAt(3, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.g.getSlotAt(2, 1));
    this.h.move(3,1,5,3);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.h.getSlotAt(5, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.h.getSlotAt(4, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.h.getSlotAt(3, 1));
  }

  /**
   * This tests to see if a move is valid when it goes downwards and is diagonal.
   */
  @Test
  public void testValidMoveDownwardDiagonal() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,this.i.getSlotAt(3,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,this.i.getSlotAt(4,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,this.i.getSlotAt(5,2));
    this.i.move(5,2,3,2);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,this.i.getSlotAt(3,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,this.i.getSlotAt(4,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,this.i.getSlotAt(5,2));
  }

  /**
   * Tests to make sure that an illegalArgument is thrown when the move is not valid, because the
   * slots are not valid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testThrowsArgumentInvalidMove() {
    this.g.move(4, 3, 2, 1);
  }

  /**
   * Tests to make sure that an illegalArgument is thrown because the from points are off the board.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testThrowsArgumentInvalidFromPositions() {
    this.g.move(0, 2, 0, 0);
  }

  /**
   * Tests to make sure that an illegalArgument is thrown because the to points are off the board.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testThrowsArgumentInvalidToPositions() {
    this.f.move(9, 11, 9, 9);
  }

  /**
   * Tests to make sure the game is not over.
   */
  @Test
  public void testGameIsNotOver() {
    assertFalse(this.a.isGameOver());
    assertFalse(this.b.isGameOver());
    assertFalse(this.c.isGameOver());
    assertFalse(this.d.isGameOver());
    assertFalse(this.e.isGameOver());
    assertFalse(this.f.isGameOver());
  }

  /**
   * Tests to make sure the game is over.
   */
  @Test
  public void testGameIsOver() {
    assertFalse(this.a.isGameOver());
    this.a.move(2, 2, 0, 0);
    this.a.move(2, 0, 2, 2);
    this.a.move(0, 0, 2, 0);
    this.a.move(3, 0, 1, 0);
    this.a.move(3, 3, 1, 1);
    this.a.move(3, 1, 3, 3);
    this.a.move(4, 4, 2, 2);
    this.a.move(1, 1, 3, 3);
    this.a.move(4, 2, 4, 4);
    this.a.move(4, 0, 4, 2);
    this.a.move(4, 4, 2, 2);
    assertTrue(this.a.isGameOver());
  }

  /**
   * Tests to make sure that the boardSize is correct.
   */
  @Test
  public void testBoardSizeIsCorrect() {
    assertEquals(5, this.a.getBoardSize());
    assertEquals(7, this.b.getBoardSize());
    assertEquals(5, this.c.getBoardSize());
    assertEquals(5, this.d.getBoardSize());
    assertEquals(3, this.e.getBoardSize());
  }

  /**
   * Tests to check to make sure that getSlot is correct.
   */
  @Test
  public void testGetSlot() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.e.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.e.getSlotAt(1, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.e.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.f.getSlotAt(7, 7));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.f.getSlotAt(8, 8));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.f.getSlotAt(9, 9));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.c.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.c.getSlotAt(1, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.c.getSlotAt(0, 0));
    this.a.move(2, 2, 0, 0);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.a.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.a.getSlotAt(1, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.a.getSlotAt(2, 2));
    this.b.move(2, 2, 0, 0);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.b.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.b.getSlotAt(1, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.b.getSlotAt(2, 2));
  }

  /**
   * Tests to make sure that an illegalArgumentException is thrown when the row and column indices
   * are not correct and when the row and column positions in getSlotAt are invalid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPositionsGetSlotAt() {
    this.a.getSlotAt(2, 5);
  }

  /**
   * Tests to make sure that getScore works properly and that the correct score is retrieved.
   */
  @Test
  public void testGetScore() {
    assertEquals(54, this.f.getScore());
    this.f.move(7, 7, 9, 9);
    assertEquals(53, this.f.getScore());
    this.f.move(5, 5, 7, 7);
    assertEquals(52, this.f.getScore());
  }
}