import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import org.apache.commons.lang.StringUtils;

public class Solution {

    // Complete the encryption function below.
    static String encryption(String s) {
        int l = s.length();
        int rows = (int)Math.floor(Math.sqrt(l));
        int cols = (int)Math.ceil(Math.sqrt(l));
        
        if(rows * cols < l){
            rows = rows + 1;
        }
        char[][] grid = new char[rows][cols];
   
        if(rows * cols > l){
            s = s + StringUtils.repeat(" ", rows*cols - l);
        }
        char[] strAsArr = s.toCharArray();
        
        for(int i = 0; i < rows; i++){
            int end = (i+1)*cols;
            grid[i] = Arrays.copyOfRange(strAsArr, i*cols, end);
        }
        
        String res = "";
        for(int i = 0; i < cols; i++){
            for(int j = 0; j < rows; j++){
                if(grid[j][i] != ' ')
                    res = res + grid[j][i];
            }
            res = res + " ";
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
