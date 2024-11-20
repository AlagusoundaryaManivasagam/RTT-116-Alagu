package M303_13;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class ScannerWritter {
    public static void main(String[] args){
        //system.in is character input stream
        Scanner scanner = new Scanner(System.in);
        try{
            File file = new File("src/temp2.txt");
            PrintWriter pw = new PrintWriter(new FileWriter(file,true));

            System.out.println("Enter a string to write to the file");
            String input = scanner.nextLine();
            //this is writing on a stream to a file
            pw.print(input);
            // this is writing same variable to console
            System.out.println(input);
            pw.flush();
            // always remember to flush the stream
        }catch( Exception e){

        }
    }
}
