import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        String ampm = s.substring(s.length()-2, s.length());
        String time = s.substring(0, s.length()-2);
        String[] timeArray = time.split(":");
        if(("PM".equalsIgnoreCase(ampm))){
            if (!(timeArray[0].equals("12"))){
                Long hour = Long.valueOf(timeArray[0]) + 12L;
                timeArray[0] = String.format("%02d", hour);
            }
        } else if ("AM".equalsIgnoreCase(ampm)){
            if(timeArray[0].equals("12")){
                timeArray[0] = "00";
            } 
        }
        String res = String.join(":",timeArray);
        return res;               
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}

