import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the solve function below.
    static String solve(int year) {
        String yearStr = String.valueOf(year);
        String res = "13.09." + yearStr;
        boolean divisible4 = (((double)year) % 4.0) == 0;
        boolean divisible100 = (((double)year) % 100.0) == 0;
        boolean divisible400 = (((double)year) % 400.0) == 0;
        if(year != 1918){
            if(year <= 1917 && divisible4){
                res = "12.09."+ yearStr;
            } else if(year >= 1918){
                if((divisible4 && !divisible100) || divisible400){
                    res = "12.09."+ yearStr;
                }
            }
        } else {
            res = "26.09.1918";
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = solve(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

