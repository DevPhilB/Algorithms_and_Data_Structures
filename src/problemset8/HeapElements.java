package problemset8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Program should find the amount of different heaps for n n is a natural number
 * 
 * @author Philipp Backes, 191710
 *
 */
public class HeapElements {
  public static int n = 0;
  public static double h = 0, b = 0, r = 0, r1 = 0, r2 = 0;
  public static long result = 0;

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
    h = (Math.log(n + 1.0d) / Math.log(2.0d) - 1.0d);
    b = (2.0d * h - 1.0d);
    r = (n - 1.0d - 2.0d * b);
    r1 = (r - Math.floor(r / Math.pow(2.0d, h)) * (r - Math.pow(2.0d, h)));
    r2 = (r - r1);
    result = findDifferentHeaps(n);
    System.out.println("Result: " + result);
  }

  /**
   * Find different heaps for n
   * h = log2(n+1)-1: 
   * b = 2^h-1: 
   * r = n-1-2*b: 
   * r1 = r-floor(r/2^h)*(r-2^h): 
   * r2 = r-r1: 
   * a[n] = binomial(n-1, b+r1)*a[b+r1]*a[b+r2]:
   */
  public static long findDifferentHeaps(int n) {
    if(n < 2) {
      return 1;
    }
    else {
      return binomial((long) ((double) n - 1.0d), (long) (b + r1)) * findDifferentHeaps((int) (b + r1))
          * findDifferentHeaps((int) (b + r2));
    }
  }

  /**
   * Binomial coefficient method
   * @param n
   * @param k
   * @return 
   */
  public static long binomial(long n, long k) {
    if (k > n - k) {
      k = n - k;
    }
    long b = 1;
    for (long i = 1, m = n; i <= k; i++, m--) {
      b = b * m / i;
    }
    return b;
  }

}
