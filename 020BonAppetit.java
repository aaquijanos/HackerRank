import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static String bonAppetit(int k, int[]bill, int b){
        String res = "Bon Appetit";
        int totalBill = 0;
        for(int i = 0; i < bill.length; i++){
            if(i != k){
                totalBill = totalBill + bill[i];
            }
        }
        int toPay = totalBill/2;
        if(toPay != b){
            res = String.valueOf(b - toPay);
        }
        return res;
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        int[] bill = new int[n];
        String[] billItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for(int i = 0; i < n; i++){
            int billItem = Integer.parseInt(billItems[i]);
            bill[i] = billItem;
        }
        
        int b = scanner.nextInt();
        String output = bonAppetit(k, bill, b);
        System.out.println(output);
        scanner.close();
        
    }
}
