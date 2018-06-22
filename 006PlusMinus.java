import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        double arrLength = (double)arr.length;
        double positives = 0.000000;
        double negatives = 0.000000;
        double zeros = 0.000000;
        for(int i = 0; i < arr.length; i++){
            int num = arr[i];
            if(num == 0){
                zeros++;
            } else if(num > 0){
                positives++;
            } else{
                negatives++;
            }
        }
        System.out.println(positives/arrLength);
        System.out.println(negatives/arrLength);
        System.out.println(zeros/arrLength);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}

