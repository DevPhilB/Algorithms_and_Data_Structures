package problemset1;

/**
 * @author Philipp Backes
 *
 */
public class StringManipulation {

    /**
     * @param args
     */
    public static void main(String[] args) {
	String input1 = randomString(1024);
	String input2 = randomString(2048);
	String input3 = randomString(4096);
	String input4 = randomString(8192);
	String result1, result2;
	long timerMethod1, timerMethod2;
	timerMethod1 = System.nanoTime();
	result1 = rekm(input4);
	timerMethod1 = System.nanoTime() - timerMethod1;
	System.out.println("Rekm Time: " + timerMethod1 + "ns");
	timerMethod2 = System.nanoTime();
	result2 = rekl(input4);
	timerMethod2 = System.nanoTime() - timerMethod2;
	System.out.println("Rekl Time: " + timerMethod2 + "ns");
    }

    /**
     * @param length Length of new String
     * @return Random String
     */
    public static String randomString(int length) {
	String newString = "";
	for (int i = 0; i < length; i++) {
	    if (i % 2 == 0) {
		newString += "a";
	    } else if (i % 3 == 0) {
		newString += "q";
	    } else {
		newString += "u";
	    }
	}
	return newString;
    }

    /**
     * @param s
     */
    public static String rekm(String s) {
	int m = s.length() / 2;
	return m == 0 ? s : rekm(s.substring(m)) + rekm(s.substring(0, m));
    }

    /**
     * @param s
     */
    public static String rekl(String s) {
	return s.length() <= 1 ? s : rekl(s.substring(1)) + s.charAt(0);
    }

}
