import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Solution {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(int[] ar) {
        List<Integer> arList = Arrays.stream(ar).boxed().collect(Collectors.toList());
        List<Integer> ids = Arrays.asList(1, 2, 3, 4, 5);
        int biggestOccurr = 0;
        int idBiggestOccurr = 0;
        for(int i = 0; i < ids.size(); i++){
            int occurrences = Collections.frequency(arList, ids.get(i));
            if(occurrences > biggestOccurr) {
                biggestOccurr = occurrences;
                idBiggestOccurr = ids.get(i);
            } else if (occurrences == biggestOccurr){
                if(ids.get(i) < idBiggestOccurr) {
                    idBiggestOccurr = ids.get(i);
                }
            }
        }
        return idBiggestOccurr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = migratoryBirds(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

