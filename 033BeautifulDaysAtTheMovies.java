import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
        int currentNumber = i;
        int beautifulDays = 0;
        while(currentNumber < j){
            String cn = String.valueOf(currentNumber);
            String reverseCn = new StringBuffer(cn).reverse().toString();
            double reverseCurrentNumber = Double.parseDouble(reverseCn);
            double result = Math.abs(((double)currentNumber) - reverseCurrentNumber)%((double)k);
            boolean isBeautiful = (result == 0.0) ? true : false;
            if(isBeautiful){
                ++beautifulDays;
            }
            ++currentNumber;
        }
        return beautifulDays;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

