package cs3500.marblesolitaire;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

/**
 * This class allows you to play the MarbleSolitaire game and pick what type of MarbleSolitaire
 * game you want to play.
 */
public final class MarbleSolitaire {
  /**
   * This runs the method in the terminal.
   *
   * @param args are the Array of Strings that get passed through the main method to run the game.
   */
  public static void main(String[] args) {
    String s = "";
    String q = "";
    int[] x = new int[3];
    boolean b = true;
    if (args[0].equals("english") || args[0].equals("european")) {
      q = args[0];
      x[0] = 3;
      x[1] = 3;
      x[2] = 3;
    }
    if (args[0].equals("triangular")) {
      q = args[0];
      x[0] = 5;
      x[1] = 0;
      x[2] = 0;
    }
    for (int i = 1; i < args.length; i++) {
      s = args[i];
      switch (s) {
        case "-size":
          if (q.equals("triangular")) {
            x[0] = Integer.parseInt(args[i + 1]);
            i = i + 1;
          }
          if (q.equals("english") || q.equals("european")) {
            x[0] = Integer.parseInt(args[i + 1]);
            if (b) {
              x[1] = (x[0] * 3 - 2) / 2;
              x[2] = (x[0] * 3 - 2) / 2;
            }
            i = i + 1;
          }
          break;
        case "-hole":
          if (q.equals("triangular")) {
            x[1] = Integer.parseInt(args[i + 1]);
            x[2] = Integer.parseInt(args[i + 2]);
            i = i + 2;
          }
          if (q.equals("english") || q.equals("european")) {
            x[1] = Integer.parseInt(args[i + 1]);
            x[2] = Integer.parseInt(args[i + 2]);
            b = false;
            i = i + 2;
          }
          break;
        default:
          break;
      }

    }
    switch (q) {
      case "european":
        EuropeanSolitaireModel model1 = new EuropeanSolitaireModel(x[0], x[1], x[2]);
        MarbleSolitaireControllerImpl control1 = new MarbleSolitaireControllerImpl(model1,
                new MarbleSolitaireTextView(model1, System.out), new InputStreamReader(System.in));
        control1.playGame();
        break;
      case "english":
        EnglishSolitaireModel model2 = new EnglishSolitaireModel(x[0], x[1], x[2]);
        MarbleSolitaireControllerImpl control2 = new MarbleSolitaireControllerImpl(model2,
                new MarbleSolitaireTextView(model2, System.out), new InputStreamReader(System.in));
        control2.playGame();
        break;
      case "triangular":
        TriangleSolitaireModel model3 = new TriangleSolitaireModel(x[0], x[1], x[2]);
        MarbleSolitaireControllerImpl control3 = new MarbleSolitaireControllerImpl(model3,
                new TriangleSolitaireTextView(model3, System.out), new InputStreamReader(
                System.in));
        control3.playGame();
        break;
      default:
        break;
    }
  }


}