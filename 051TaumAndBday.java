import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the taumBday function below.
    static long taumBday(int b, int w, int bc, int wc, int z) {
        int wcChanging = wc + z;
        int bcChanging = bc + z;
        long res = 0;
        
        if (wcChanging < bc){
            res = (long)w*wc + (long)b*wcChanging;
        } else if (bcChanging < wc){
            res = (long)w*bcChanging + (long)b*bc;
        } else {
            res = (long)b*bc + (long)w*wc;
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] bw = scanner.nextLine().split(" ");

            int b = Integer.parseInt(bw[0]);

            int w = Integer.parseInt(bw[1]);

            String[] bcWcz = scanner.nextLine().split(" ");

            int bc = Integer.parseInt(bcWcz[0]);

            int wc = Integer.parseInt(bcWcz[1]);

            int z = Integer.parseInt(bcWcz[2]);

            long result = taumBday(b, w, bc, wc, z);
            
            String resultString = String.valueOf(result);
            bufferedWriter.write(resultString);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

