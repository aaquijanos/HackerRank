import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {
        int maxTopics = 0;
        int maxNumWays = 1;
        int[][] teams = new int[topic.length][topic[0].length()];
        
        for(int i = 0; i < topic.length; i++){
            int[] team = Arrays.stream(topic[i].split("")).mapToInt(Integer::parseInt).toArray();
            teams[i] = team;
        }
        
        for(int i = 0; i < teams.length - 1; i++){
            int[] team1 = teams[i];
            for(int j = i; j < teams.length; j++){
                int[] team2 = teams[j];
                int topics = 0;
                for(int k = 0; k < team1.length; k++){
                    int sum = team1[k] + team2[k];
                    if(sum != 0){
                        ++topics;
                    }
                }
                if(maxTopics < topics){
                    maxTopics = topics;
                    maxNumWays = 1;
                } else if (maxTopics == topics){
                    ++maxNumWays;
                }
            }
        }
        return new int[]{maxTopics, maxNumWays};

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
