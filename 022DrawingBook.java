import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        /*
         * Write your code here.
         */
        int pageReached = 1;
        int pagesForward = 0;
        int pagesBackward = 0;
        
        if(p == pageReached || p == n){
            return 0;
        } else {
            for(int i = 0; i < n/2; i++){
                ++pagesForward;
                pageReached = pageReached + 2;
                if(p <= pageReached){
                    break;
                }
            }
            pageReached = n;
            for(int i = 0; i < n/2; i++){
                if(((double)n)%2.0 != 0.0 && i == 0){
                    pageReached = pageReached - 1;
                } else {
                   ++pagesBackward;
                    pageReached = pageReached - 2; 
                }
                if(p >= pageReached){
                    break;
                }
            }
            if(pagesForward < pagesBackward){
                return pagesForward;
            } else {
                return pagesBackward;
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

