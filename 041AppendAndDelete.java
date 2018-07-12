import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
        int matchingChars = 0;
        int minLength = Math.min(s.length(), t.length());
        int sumStringsLength = s.length() + t.length();
        String res = "No";
        for(int i = 0; i < minLength; i++) {
            if(s.charAt(i) != t.charAt(i)){
                break;
            } else {
                matchingChars++;
            }
        }
        int numDifferentStrings = sumStringsLength - 2*matchingChars;
        if(numDifferentStrings > k){
            res = "No";
        } else if(numDifferentStrings%2 == k%2) {
            res = "Yes";
        } else if(sumStringsLength - k < 0) {
            res = "Yes";
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
