package Glab303_13_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScanDelimiterdFile {
    public static void main(String[] args) throws FileNotFoundException{
        try {
            String location = "C:\\Users\\kumar\\Development\\RTT-116-Classwork\\Module-303\\Module-303\\src\\cars.csv";
            File file = new File(location);
            Scanner input = new Scanner(file);
            ArrayList<String []> data= new ArrayList<>();
            while(input.hasNextLine()){
                String Line = input.nextLine();
                String [] splittedLine = Line.split(",");
                data.add(splittedLine);
            }

            for(String [] line: data){
                System.out.println("Car Name: "+ line[0]);
                System.out.println("MPG : "+ line[1]);
                System.out.println("Displacement: "+ line[2]);
                System.out.println("Horsepower: "+ line[3]);
                System.out.println("Weight: "+ line[4]);
                System.out.println("Acceleration: "+ line[5]);
                System.out.println("Model :" + line[7]);
                System.out.println("Origin :" + line[8]);
                System.out.println("===============================");


            }

        }catch(FileNotFoundException e){
            System.out.println("File Not Found! ");
            e.printStackTrace();
        }

    }
}
