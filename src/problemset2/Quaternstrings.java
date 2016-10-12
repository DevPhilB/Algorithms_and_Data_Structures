package problemset2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Exercise 1:
 * 
 * @author Philipp Backes, 191710
 * @author Homa Alavi, 191720
 * @author Jannis Scholz, 191481
 *
 */
public class Quaternstrings {

  /**
   * @param args
   */
  public static void main(String[] args) {
    String userInput = "";
    String possibleChars[] = {"0", "1", "2", "3"};
    ArrayList<String> combinationStrings = new ArrayList<>();
    BigInteger result = BigInteger.ZERO;    // Result is the sum of all combination of possibleChars 
    BigInteger bigZero = BigInteger.ZERO;   // Combination of char '0'
    BigInteger bigOne = BigInteger.ZERO;    // Combination of char '1'
    BigInteger bigTwo = BigInteger.ZERO;    // Combination of char '2'
    BigInteger bigThree = BigInteger.ZERO;  // Combination of char '3'
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("n = ");
    try {
      userInput = br.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    int n = Integer.parseInt(userInput);
    
    // Problem should be solved with recursive function
    for(int i = 0; i < n; i++){
      combinationStrings.add(possibleChars[0]);
      bigZero = bigZero.add(BigInteger.ONE);
      combinationStrings.add(possibleChars[1]);
      bigOne = bigOne.add(BigInteger.ONE);
      combinationStrings.add(possibleChars[2]);
      bigTwo = bigOne.add(BigInteger.ONE);
      combinationStrings.add(possibleChars[3]);
      bigThree = bigOne.add(BigInteger.ONE);
      result = result.add(bigZero).add(bigTwo).add(bigThree);
    }
    
    
    System.out.println("a(" + n + ")" + " = " + result);

  }

}
