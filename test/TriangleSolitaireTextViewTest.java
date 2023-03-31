import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;

/**
 * This is a class that tests the methods in TextViewTest.
 */
public class TriangleSolitaireTextViewTest {
  MarbleSolitaireModel a;
  MarbleSolitaireModel b;
  MarbleSolitaireModel c;
  MarbleSolitaireModel d;
  MarbleSolitaireModel e;
  MarbleSolitaireModel f;
  MarbleSolitaireModel g;
  TriangleSolitaireTextView a1;
  TriangleSolitaireTextView b1;
  TriangleSolitaireTextView c1;
  TriangleSolitaireTextView d1;
  TriangleSolitaireTextView e1;
  TriangleSolitaireTextView f1;
  TriangleSolitaireTextView g1;

  @Before
  public void init() {
    this.a = new TriangleSolitaireModel(5);
    this.b = new TriangleSolitaireModel(7);
    this.c = new TriangleSolitaireModel(2, 2);
    this.d = new TriangleSolitaireModel(4, 4);
    this.e = new TriangleSolitaireModel(3, 2, 0);
    this.f = new TriangleSolitaireModel(10, 9, 9);
    this.g = new TriangleSolitaireModel(4, 3);
    this.a1 = new TriangleSolitaireTextView(a);
    this.b1 = new TriangleSolitaireTextView(b);
    this.c1 = new TriangleSolitaireTextView(c);
    this.d1 = new TriangleSolitaireTextView(d);
    this.e1 = new TriangleSolitaireTextView(e);
    this.f1 = new TriangleSolitaireTextView(f);
    this.g1 = new TriangleSolitaireTextView(g);
  }

  /**
   * A test for a null MarbleSolitaireModelState passing through TriangleSolitaireTextView.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testContructorNull() {
    MarbleSolitaireModelState o = null;
    TriangleSolitaireTextView test = new TriangleSolitaireTextView(o);
  }


  /**
   * Tests the toString method to make sure that the view is correct for each board.
   */
  @Test
  public void testToString() {
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", this.a1.toString());
    assertEquals("      _\n" +
            "     O O\n" +
            "    O O O\n" +
            "   O O O O\n" +
            "  O O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O", this.b1.toString());
    assertEquals("    O\n" +
            "   O O\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O", this.c1.toString());
    assertEquals("    O\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O _", this.d1.toString());
    assertEquals("  O\n" +
            " O O\n" +
            "_ O O", this.e1.toString());
    assertEquals("         O\n" +
            "        O O\n" +
            "       O O O\n" +
            "      O O O O\n" +
            "     O O O O O\n" +
            "    O O O O O O\n" +
            "   O O O O O O O\n" +
            "  O O O O O O O O\n" +
            " O O O O O O O O O\n" +
            "O O O O O O O O O _", this.f1.toString());
    assertEquals("    O\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O _ O", this.g1.toString());
  }


  /**
   * Tests to make sure the toString method works after a player makes a valid and a invalid move.
   */
  @Test
  public void viewBoardAfterValidAndInvalidMove() {
    assertEquals("         O\n" +
            "        O O\n" +
            "       O O O\n" +
            "      O O O O\n" +
            "     O O O O O\n" +
            "    O O O O O O\n" +
            "   O O O O O O O\n" +
            "  O O O O O O O O\n" +
            " O O O O O O O O O\n" +
            "O O O O O O O O O _", this.f1.toString());
    this.f.move(7, 7, 9, 9);
    assertEquals("         O\n" +
            "        O O\n" +
            "       O O O\n" +
            "      O O O O\n" +
            "     O O O O O\n" +
            "    O O O O O O\n" +
            "   O O O O O O O\n" +
            "  O O O O O O O _\n" +
            " O O O O O O O O _\n" +
            "O O O O O O O O O O", this.f1.toString());
    this.f.move(5, 5, 7, 7);
    assertEquals("         O\n" +
            "        O O\n" +
            "       O O O\n" +
            "      O O O O\n" +
            "     O O O O O\n" +
            "    O O O O O _\n" +
            "   O O O O O O _\n" +
            "  O O O O O O O O\n" +
            " O O O O O O O O _\n" +
            "O O O O O O O O O O", this.f1.toString());
    try {
      this.f.move(7, 7, 9, 9);
    } catch (IllegalArgumentException e) {
      assertEquals("         O\n" +
              "        O O\n" +
              "       O O O\n" +
              "      O O O O\n" +
              "     O O O O O\n" +
              "    O O O O O _\n" +
              "   O O O O O O _\n" +
              "  O O O O O O O O\n" +
              " O O O O O O O O _\n" +
              "O O O O O O O O O O", this.f1.toString());
    }
  }
}