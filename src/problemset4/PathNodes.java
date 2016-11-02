package problemset4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Program takes a natural number (n) from user input, calculates the amount of all points on the
 * path to this point (0, 0) -> (n, n) and prints it out.
 * 
 * @author Philipp Backes, 191710
 * @author Homa Alavi, 191720
 * @author Jannis Scholz, 191481
 *
 */
public class PathNodes {
  public static BigInteger amountOfPoints = BigInteger.valueOf(0);
  public static int n = 0;

  /**
   * Main method
   * 
   * @param args
   */
  public static void main(String[] args) {
    String userInput = "";
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("n = ");
    try {
      userInput = br.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    n = Integer.valueOf(userInput);
    BigInteger nResult = b(n, n, 0, "");
    System.out.println("For n = " + n + ": " + nResult + " Pathes with " + amountOfPoints + " Points");
  }

  public static BigInteger b(int x, int y, int t, String s) {
    // Think about this implementation
    if (x < 0 || y < 0) {
      return BigInteger.ZERO;
    } else if (x == 0 && y == 0) {
      amountOfPoints = amountOfPoints.add(BigInteger.valueOf(s.length() + 1));
      return BigInteger.ONE;
    }

    if (x < 0 || y < 0) {
      return BigInteger.ZERO;
    }
    if (x == 0 && y == 0) {
      System.out.println(" " + s + " . "); // print path
      return BigInteger.ONE;
    }
    BigInteger r = BigInteger.ZERO;
    if (y < x) {
      r = r.add(b(x - 1, y, 0, "R" + s));
    }
    if (y <= x) {
      r = r.add(b(x, y - 1, 0, "U" + s));
    }
    if (y >= x) {
      r = r.add(b(x - 1, y - 1, 0, "F" + s));
    }
    if (y > x + 1 && t != 2) {
      r = r.add(b(x + 1, y - 1, 1, "L" + s));
    }
    if (y >= x && t != 1) {
      r = r.add(b(x - 1, y + 1, 2, "D" + s));
    }
    return r;
  }

}
