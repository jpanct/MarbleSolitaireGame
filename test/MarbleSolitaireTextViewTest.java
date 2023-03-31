import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

import static org.junit.Assert.assertEquals;

/**
 * This is a class used for testing the MarbleSolitaireTests.
 */
public class MarbleSolitaireTextViewTest {

  MarbleSolitaireModel a;
  MarbleSolitaireModel b;
  MarbleSolitaireModel c;
  MarbleSolitaireModel d;
  MarbleSolitaireModel e;
  MarbleSolitaireModel k;
  MarbleSolitaireTextView f;
  MarbleSolitaireModel g;
  MarbleSolitaireTextView h;
  MarbleSolitaireTextView i;
  MarbleSolitaireTextView j;
  MarbleSolitaireTextView q;
  MarbleSolitaireTextView z;
  MarbleSolitaireTextView y;
  MarbleSolitaireModel p1;
  MarbleSolitaireTextView p2;
  MarbleSolitaireModel a1;
  MarbleSolitaireTextView a2;
  MarbleSolitaireModel b1;
  MarbleSolitaireTextView b2;
  MarbleSolitaireModel c1;
  MarbleSolitaireTextView c2;
  MarbleSolitaireModel d1;
  MarbleSolitaireTextView d2;

  /**
   * This creates examples of EnglishSolitaireModels and MarbleSolitaireTextViews.
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
    this.f = new MarbleSolitaireTextView(g);
    this.h = new MarbleSolitaireTextView(b);
    this.j = new MarbleSolitaireTextView(c);
    this.i = new MarbleSolitaireTextView(d);
    this.q = new MarbleSolitaireTextView(k);
    this.z = new MarbleSolitaireTextView(g);
    this.y = new MarbleSolitaireTextView(a);
    this.p1 = new EuropeanSolitaireModel(3, 1, 1);
    this.p2 = new MarbleSolitaireTextView(p1);
    this.a1 = new EuropeanSolitaireModel(5);
    this.a2 = new MarbleSolitaireTextView(a1);
    this.b1 = new EuropeanSolitaireModel(13, 15,11);
    this.b2 = new MarbleSolitaireTextView(b1);
    this.c1 = new EuropeanSolitaireModel(7,5,5);
    this.c2 = new MarbleSolitaireTextView(c1);
    this.d1 = new EuropeanSolitaireModel(5, 7, 1);
    this.d2 = new MarbleSolitaireTextView(d1);
  }

  /**
   * A test for a null MarbleSolitaireModelState passing through MarbleSolitaireTextView.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testContructorNull() {
    MarbleSolitaireModelState o = null;
    MarbleSolitaireTextView test = new MarbleSolitaireTextView(o);
  }

  /**
   * Tests the toString method to make sure that the view is correct for each European Solitaire
   * Model passed into MarbleSolitaireTextView for display.
   */
  @Test
  public void testToStringEuropeanSolitaireModel() {
    assertEquals("    O O O\n" +
            "  _ O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O",this.p2.toString());
    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O",this.a2.toString());
    assertEquals("                        O O O O O O O O O O O O O\n" +
            "                      O O O O O O O O O O O O O O O\n" +
            "                    O O O O O O O O O O O O O O O O O\n" +
            "                  O O O O O O O O O O O O O O O O O O O\n" +
            "                O O O O O O O O O O O O O O O O O O O O O\n" +
            "              O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "            O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "          O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "        O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "      O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "    O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O _ O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "    O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "      O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "        O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "          O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "            O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "              O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "                O O O O O O O O O O O O O O O O O O O O O\n" +
            "                  O O O O O O O O O O O O O O O O O O O\n" +
            "                    O O O O O O O O O O O O O O O O O\n" +
            "                      O O O O O O O O O O O O O O O\n" +
            "                        O O O O O O O O O O O O O",this.b2.toString());
    assertEquals("            O O O O O O O\n" +
            "          O O O O O O O O O\n" +
            "        O O O O O O O O O O O\n" +
            "      O O O O O O O O O O O O O\n" +
            "    O O O O O O O O O O O O O O O\n" +
            "  O O O O _ O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O O O O O O O\n" +
            "    O O O O O O O O O O O O O O O\n" +
            "      O O O O O O O O O O O O O\n" +
            "        O O O O O O O O O O O\n" +
            "          O O O O O O O O O\n" +
            "            O O O O O O O",this.c2.toString());
    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O _ O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O",this.d2.toString());
  }


  /**
   * Tests to make sure the toString method works after a player makes a move for EuropeanSolitaire
   * Model.
   */
  @Test
  public void viewBoardAfterOneMoveEuropeanSolitaireModel() {
    assertEquals("    O O O\n" +
            "  _ O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O",this.p2.toString());
    this.p1.move(3,1,1,1);
    assertEquals(
            "    O O O\n" +
                    "  O O O O O\n" +
                    "O _ O O O O O\n" +
                    "O _ O O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O",this.p2.toString());
    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O",this.a2.toString());
    this.a1.move(4,6,6,6);
    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O",this.a2.toString());
    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O _ O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O",this.d2.toString());
    this.d1.move(5,1,7,1);
    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O _ O O O O O O O O O O O\n" +
            "O _ O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O",this.d2.toString());
  }

  /**
   * Tests the toString method to make sure that the view is correct for each English Solitaire
   * Model passed into MarbleSolitaireTextView for display.
   */
  @Test
  public void testToStringEnglishSolitaireModel() {
    assertEquals("                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "O O O O O O O O _ O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O", this.f.toString());

    assertEquals("            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O _ O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O", this.i.toString());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", this.h.toString());
    assertEquals("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O", this.j.toString());
    assertEquals("                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "O O O O O O O O _ O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O", this.z.toString());

  }

  /**
   * Tests to make sure the toString method works after a player makes a move for EnglishSolitaire
   * Model.
   */
  @Test
  public void viewBoardAfterOneMoveEnglishSolitaireModel() {
    assertEquals("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O", this.j.toString());
    this.c.move(6, 4, 6, 6);
    assertEquals("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O _ _ O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O", this.j.toString());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", this.h.toString());
    this.b.move(3, 5, 3, 3);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", this.h.toString());
  }


}
