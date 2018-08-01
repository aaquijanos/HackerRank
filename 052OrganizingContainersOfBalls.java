import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Solution {

    // Complete the organizingContainers function below.
    static String organizingContainers(int[][] container) {
        String res = "Impossible";
        Long[] numBalls = new Long[container[0].length];
        Long[] containerCapacity = new Long[container.length];
        Arrays.fill(numBalls, 0L);
        Arrays.fill(containerCapacity, 0L);
        for(int i = 0; i < container.length; i++) {
            for(int j = 0; j < container[0].length; j++){
                numBalls[j] = numBalls[j] + container[i][j];
                containerCapacity[i] = containerCapacity[i] + container[i][j];
            }
        }
        List<Long> numBallsList = Arrays.stream(numBalls).collect(Collectors.toList());
        Collections.sort(numBallsList);
        List<Long> containerCapacityList = Arrays.stream(containerCapacity).collect(Collectors.toList());
        Collections.sort(containerCapacityList);
        if(containerCapacityList.equals(numBallsList)){
            res = "Possible";
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
