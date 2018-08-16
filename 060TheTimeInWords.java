import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        String res = "";
        List<String> numbers = Arrays.asList(
            "o' clock", 
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "quarter",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen",
            "twenty",
            "twenty one",
            "twenty two",
            "twenty three",
            "twenty four",
            "twenty five",
            "twenty six",
            "twenty seven",
            "twenty eight",
            "twenty nine",
            "half"
        );

        if(m == 0){
            res = numbers.get(h)+ " " + numbers.get(m);
        } else {
            int newMValue = m;
            if(m > 30){
                newMValue = 60 - m;
                ++h;
            }
            res = numbers.get(newMValue);
            if(newMValue == 1) {
                res = res + " minute";
            } else if (newMValue != 15 && newMValue != 30) {
                res = res + " minutes";
            }
            
            if(m >= 1 && m <= 30) {
                res = res + " past ";
            } else {
                res = res + " to ";
            }
            
            res = res + numbers.get(h);
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
