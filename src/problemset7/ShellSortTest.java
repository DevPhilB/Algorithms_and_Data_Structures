package problemset7;

/**
 * Program should calculate all insertionSorth calls for n (natural number) and for understanding
 * Shell Sort find a mathematical function for best/worst case runtime for a call of insertionSorth
 * if char[n] and h is distance parameter.
 * 
 * @author Philipp Backes, 191710
 *
 */
public class ShellSortTest {

  public static int counter = 0;
  
  /**
   * Main method
   * 
   * @param args
   */
  public static void main(String[] args) {
    //
    char[] chain = new char[]{'2', '6', '3'};
    shellSort(chain);
    System.out.println("Number of calls of insertionSort: " + counter);
  }

  /**
   * Insertion Sort
   * @param a
   * @param h
   */
  private static void insertionSortH(char[] a, int h) {
    int i, hi = a.length - 1;
    for (int k = h; k <= hi; k++) // Start with h
      if (a[k - h] > a[k]) { // Compare with distance h
        char x = a[k];
        a[k] = a[k - h];
        for (i = k - h; (i >= h) && (a[i - h] > x); i -= h) {
          a[i] = a[i - h]; // Transport over distance h
        }
        a[i] = x; // Insert
      }
  }
  
  /**
   * Shell Sort
   * @param a
   */
  public static void shellSort(char[] a) {
    int h, hmax, hi = a.length - 1;
    // hmax = 1, 4, 13, 40, 121, 364, 1093 .., 3*hmax+1
    for (hmax = 1; hmax < hi; hmax = 3 * hmax + 1);
    for (h = hmax / 3; h > 0; h /= 3) {
      counter++;
      insertionSortH(a, h);
    }
  }

}
