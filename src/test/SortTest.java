/**
 * 
 */
package test;import java.nio.charset.IllegalCharsetNameException;

/**
 * @author Philipp
 *
 */
public class SortTest {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] test = new int[10];
    test[0] = 4;
    test[1] = 2;
    test[2] = 5;
    test[3] = 9;
    test[4] = 1;
    test[5] = 0;
    test[6] = 8;
    test[7] = 7;
    test[8] = 3;
    test[9] = 6;
    printArray(test);
    insertionSorth(test, 3);
    printArray(test);
  }

  private static void insertionSorth(int[] a, int h) {
    int i, hi = a.length - 1;
    for (int k = h; k <= hi; k++) // Start bei h
      if (a[k - h] > a[k]) { // Vergleich ueber Distanz h
        int x = a[k];
        printArray(a);
        a[k] = a[k - h];
        printArray(a);
        for (i = k - h; (i >= h) && (a[i - h] > x); i -= h) {
          a[i] = a[i - h]; // Transport ueber Distanz h
          printArray(a);
        }
        a[i] = x; // einfuegen
        printArray(a);
      }
  } //
  
  public static void printArray(int[] a) {
    System.out.println("Array: ");
    for(int i = 0; i < a.length; i++) {
      System.out.print(" " + a[i] + " ");
    }
    System.out.println();
  }
}
