package problemset3;

import java.math.BigInteger;
/**
 * It is required to use the VM Argument: -Xmx12G
 * to see the results for 63245986 and 102334155!
 */
public class FibonacciChange {
  static BigInteger possibilityArray[];
  static int coins[] = {1, 3, 7, 31, 47};

  public static void main(String arg[]) {
    BigInteger possibilities = BigInteger.valueOf(1);
    int first = 0;
    int second = 1;
    int sum = 1;
    int amount = 0;
    sum = first + second;
    System.out.println("Fibonacci-Zahl: 0  | Möglichkeiten: " + possibilities);
    System.out.println("Fibonacci-Zahl: 1  | Möglichkeiten: " + possibilities);
    for (int i = 0; i < 39; i++) {
      sum = first + second;
      System.out.print("Fibonacci-Zahl: " + sum);
      first = second;
      second = sum;
      amount = sum;
      possibilityArray = new BigInteger[amount + 1];
      possibilities = w(amount);
      System.out.print(" | Möglichkeiten: " + possibilities);
      System.out.println();
    }
  }

  public static BigInteger w(int amount) {
    for (int i = 0; i < possibilityArray.length; i++)
      possibilityArray[i] = BigInteger.ZERO;
    possibilityArray[0] = BigInteger.ONE;
    int j;
    for (int c : coins)
      for (j = c; j <= amount; j++)
        possibilityArray[j] = possibilityArray[j].add(possibilityArray[j - c]);
    return possibilityArray[amount];
  }
}
