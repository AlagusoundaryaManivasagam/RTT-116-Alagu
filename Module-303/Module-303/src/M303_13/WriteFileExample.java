package M303_13;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class WriteFileExample {
    public static void main(String[] args){
        File file = new File("src/Temp1.txt");
        try {
            //false will make it overwrite
            BufferedWriter bw = new BufferedWriter(new FileWriter(file,false));
            bw.write("Line 1\n");
            bw.write("Line 2\n");
            bw.write("Line 3\n");
            bw.write("more on line\n");
            //as we are writing to file we are writing in a buffer in memory
            //when buffer is fill it will automatically write to the file as a chunk
            //mostly the buffer will not be full
            // so we should flush that buffer
            bw.flush();
            //for best practise the close should be in finally block
            // this closes the writter and releases the resources at os level
            bw.close();
        }catch(Exception e){
            e.printStackTrace();

        }
    }
}
