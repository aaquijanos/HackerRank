import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {
        String res = "YES";
        //Obedeciendo a la ecuacion: (x1-x2)/(v2-v1)
        if(v1 == v2 || v2 > v1){
            res = "NO";
        } else {
            double modulo = ((double) (x1-x2))%((double)(v2-v1));
            if(modulo != 0){
                res = "NO";
            }
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
