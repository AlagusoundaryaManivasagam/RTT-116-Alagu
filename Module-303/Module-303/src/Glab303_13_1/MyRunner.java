package Glab303_13_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyRunner {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            String location = "C:\\Users\\kumar\\Development\\RTT-116-Classwork\\Module-303\\Module-303\\src\\CourseData.csv";
            File file = new File(location);
            Scanner input = new Scanner(file);
            ArrayList<course> data = new ArrayList<course>();
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] splittedLine = line.split(",");
                course cObj = new course();
                cObj.setCode(splittedLine[0]);
                cObj.setCourse_name(splittedLine[1]);
                cObj.setInstructor_name(splittedLine[2]);
                data.add(cObj);
            }
            for (course c : data) {
                System.out.println(c.getCode() + "|" + c.getCourse_name() + "|" + c.getInstructor_name());
                System.out.println("===============================================");

            }
        }catch(FileNotFoundException e){
            System.out.println("File not found! ");
            e.printStackTrace();
        }
    }
}
