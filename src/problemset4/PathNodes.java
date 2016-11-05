package problemset4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Program takes a natural number (n) from user input, calculates the amount of all points on the
 * path to (0, 0) from (n, n) and prints it out.
 * 
 * @author Philipp Backes, 191710
 * @author Homa Alavi, 191720
 * @author Jannis Scholz, 191481
 *
 */
public class PathNodes {
  public static int n = 0;
  public static BigInteger amountOfPoints = BigInteger.valueOf(0);
  public static BigInteger finishedPathes = BigInteger.valueOf(0);

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
    BigInteger pathsForN = recursivePointDetermination(n, n, 0, "");
    if (n != 0) {
      amountOfPoints = amountOfPoints.subtract(finishedPathes);
    } else {
      amountOfPoints = BigInteger.ONE;
    }
    System.out.println("For n = " + n + ": " + pathsForN + " Pathes with " + amountOfPoints + " Points");
  }

  /**
   * Recursive method for finding the number of points from n,n to 0,0 and the amount of paths
   * @param x Start X
   * @param y Start Y
   * @param t Use 0 as start value - internal usage
   * @param s Use "" as start value - internal usage
   * @return Amount of paths
   */
  public static BigInteger recursivePointDetermination(int x, int y, int t, String s) {
    if (x < 0 || y < 0) {
      return BigInteger.ZERO;
    }
    if (x == 0 && y == 0) {
      amountOfPoints = amountOfPoints.add(BigInteger.valueOf(s.length() + 2));
      finishedPathes = finishedPathes.add(BigInteger.ONE);
      return BigInteger.ONE;
    }
    BigInteger r = BigInteger.ZERO;
    if (y < x) {
      r = r.add(recursivePointDetermination(x - 1, y, 0, "R" + s));
    }
    if (y <= x) {
      r = r.add(recursivePointDetermination(x, y - 1, 0, "U" + s));
    }
    if (y >= x) {
      r = r.add(recursivePointDetermination(x - 1, y - 1, 0, "F" + s));
    }
    if (y > x + 1 && t != 2) {
      r = r.add(recursivePointDetermination(x + 1, y - 1, 1, "L" + s));
    }
    if (y >= x && t != 1) {
      r = r.add(recursivePointDetermination(x - 1, y + 1, 2, "D" + s));
    }
    return r;
  }

}
