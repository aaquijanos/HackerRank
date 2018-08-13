import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Solution {

    // Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {
        List<Integer> aList =Arrays.stream(a).boxed().collect(Collectors.toList()); 
        List<Integer> uniqueValues = aList.stream().distinct().collect(Collectors.toList());
        int res = -1;
        
        for(int i = 0; i < uniqueValues.size(); i++){
            int firstIdx = aList.indexOf(uniqueValues.get(i));
            int lastIdx = aList.lastIndexOf(uniqueValues.get(i));
            if(firstIdx != lastIdx){
                if(res != -1 && Math.abs(firstIdx - lastIdx) < res){
                    res = Math.abs(firstIdx - lastIdx);
                } else if (res == -1){
                    res = Math.abs(firstIdx - lastIdx);
                }
            }
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
