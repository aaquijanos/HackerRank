import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(int p, int q) {
        String res = "";
        for(long i = (long)p; i < (long)(q+1); i++){
            int originalLength = String.valueOf(i).length();
            long pow = (long)Math.pow(i, 2);
            String powAsStr = String.valueOf(pow);
            int length = powAsStr.length();
            if(length == originalLength){
                powAsStr = "0" + powAsStr;
            }
            long r = Long.valueOf(powAsStr.substring(powAsStr.length() - originalLength));
            long l = Long.valueOf(powAsStr.substring(0, powAsStr.length() - originalLength));
            long result = r + l;
            if(r+l == i){
                res = res + String.valueOf(i) + " ";
            }
        }
        if(res.trim().isEmpty()){
            res = "INVALID RANGE";
        }
        System.out.println(res);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}
