package problemset2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Exercise 2: Program reads Doubles from User input and return the sequence as a subsequence Then
 * find the minimum product of the subsequence
 * 
 * Expected time complexity: O(n)
 * 
 * @author Philipp Backes, 191710
 * @author Homa Alavi, 191720
 * @author Jannis Scholz, 191481
 *
 */
public class MinProduct {

  /**
   * Main method
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("Insert Array-Length:");
    Scanner scanner = new Scanner(System.in);
    int anzahl = scanner.nextInt();
    double startTime = System.nanoTime();
    double array[] = new double[anzahl];
    for (int i = 0; i < array.length; i++) {
      Random r = new Random();
      int zahl;
      if (r.nextInt(1000) > 500) {
        zahl = -1;
      } else {
        zahl = 1;
      }
      int random = r.nextInt(1000) * zahl;
      array[i] = r.nextDouble() + 0.1 * random;
    }
    scanner.close();
    System.out.println("Random Array: " + Arrays.toString(array));
    System.out.println("Minimal Product: " + findSmallestNumber(array));
    double endTime = System.nanoTime();
    double tD = endTime - startTime;
    double seconds = (double) tD / 1000000000.0;
    System.out.println("Runtime in Seconds: " + seconds);
  }

  /**
   * Method to find smallest number
   * @param x Double Array
   */
  public static double findSmallestNumber(double[] x) {
    List<Double> collectionList = new LinkedList<>(); // Collection
    List<Double> tempList = new LinkedList<>(); // Temp
    double minSum = 0, minLeft = 0, minRight = 0, currentMin = 0, left = 0, right = 0;
    for (int i = 0; i < x.length; i++) {
      currentMin += x[i];
      tempList.add(x[i]);
      if (currentMin < minSum) {
        minSum = currentMin;
        collectionList.clear();
        collectionList.addAll(tempList);
        right = i;
        minLeft = left;
        minRight = right;
      }
      if (currentMin > 0) {
        currentMin = 0;
        tempList.clear();
        left = i + 1;
        right = i + 1;
      }
    }
    System.out.println("Subarray: " + collectionList.toString());
    return minSum;
  }
}
