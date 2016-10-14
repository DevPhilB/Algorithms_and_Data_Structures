package problemset2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.TreeMap;
import java.util.SortedMap;

/**
 * Exercise 1:
 * Program to find a(n) which is the amount of all possible pairs
 * Creates also a specific list with (n, a(n))
 * Rules: 
 * Char combinations of '0', '1', '2', '3' 
 * Index i of combination; For every char in the combination is defined: 
 * Value on i+1 can not be value of char on i added with 1
 * 
 * @author Philipp Backes, 191710
 * @author Homa Alavi, 191720
 * @author Jannis Scholz, 191481
 *
 */
public class Quaternstrings {

  // Public members
  public static String userInput = "";
  // List with pairs as SortedMap
  public static SortedMap<Integer, BigInteger> pairList = new TreeMap<Integer, BigInteger>();
  public static BigInteger allCombinations;
  public static BigInteger combinationsOfZero; // Combinations of char '0'
  public static BigInteger combinationsOfOne; // Combinations of char '1'
  public static BigInteger combinationsOfTwo; // Combinations of char '2'
  public static BigInteger combinationsOfThree; // Combinations of char '3'

  /**
   * Main method
   * 
   * @param args
   */
  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("n = ");
    try {
      userInput = br.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    int n = Integer.parseInt(userInput);
    calculateAmount(n);
    System.out.println("a(" + n + ")" + " = " + allCombinations);
    System.out.println();
    
    // List creation and printing
    createPairList();
    for (Integer nValue : pairList.keySet()) {
      System.out.println("(" + nValue + ", " + pairList.get(nValue) + ")");
    }
  }
  
  /**
   * Method to calculate the combination amount of n
   * @param n 
   */
  public static void calculateAmount(int n){
    allCombinations = BigInteger.ZERO;
    combinationsOfZero = BigInteger.ONE;
    combinationsOfOne = BigInteger.ONE;
    combinationsOfTwo = BigInteger.ONE;
    combinationsOfThree = BigInteger.ONE;
    for (int i = 1; i < n; i++) {
      addPossibleCombinations();
    }
    if (n == 0) {
      allCombinations = BigInteger.ZERO;
    } else {
      allCombinations = allCombinations.add(combinationsOfZero).add(combinationsOfOne)
          .add(combinationsOfTwo).add(combinationsOfThree);
    }
  }

  /**
   * Method to add all possible combinations
   */
  public static void addPossibleCombinations() {
    // Without 1
    BigInteger tmpComb0 = combinationsOfZero.add(combinationsOfTwo).add(combinationsOfThree);
    // Without 2
    BigInteger tmpComb1 = combinationsOfOne.add(combinationsOfZero).add(combinationsOfThree);
    // Without 3
    BigInteger tmpComb2 = combinationsOfTwo.add(combinationsOfZero).add(combinationsOfOne);
    // All characters
    BigInteger tmpComb3 = combinationsOfThree.add(combinationsOfTwo)
        .add(combinationsOfOne).add(combinationsOfZero);
    combinationsOfZero = tmpComb0;
    combinationsOfOne = tmpComb1;
    combinationsOfTwo = tmpComb2;
    combinationsOfThree = tmpComb3;
  }
  
  /**
   * Method to create the list with pairs
   */
  public static void createPairList(){
    for(int i = 0; i < 21; i++)
    {
      calculateAmount(i);
      pairList.put(i, allCombinations);
    }
    calculateAmount(100);
    pairList.put(100, allCombinations);
  }

}
