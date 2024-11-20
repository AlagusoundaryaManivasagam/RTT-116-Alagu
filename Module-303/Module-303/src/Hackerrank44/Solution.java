package Hackerrank44;

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = Result.getMinDeletions(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int result = Result.getMinDeletions(s);
        System.out.println(result);
        scanner.close();
    }
}
