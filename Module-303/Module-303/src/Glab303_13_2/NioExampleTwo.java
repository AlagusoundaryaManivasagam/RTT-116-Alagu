package Glab303_13_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class NioExampleTwo {
    public static void main(String[] args) throws IOException {
        String[] inputFiles = {"C:\\Users\\kumar\\Development\\RTT-116-Classwork\\Module-303\\Module-303\\src\\file1.txt",
                "C:\\Users\\kumar\\Development\\RTT-116-Classwork\\Module-303\\Module-303\\src\\file2.txt"};
        String outputFile = "C:\\Users\\kumar\\Development\\RTT-116-Classwork\\Module-303\\Module-303\\src\\OutputExampleTwo.txt";

        FileOutputStream fos = new FileOutputStream(outputFile);
        WritableByteChannel targetChannel = fos.getChannel();

        for( int i=0; i<inputFiles.length; i++){
            FileInputStream fis = new FileInputStream(inputFiles[i]);
            FileChannel inputChannel = fis.getChannel();
            inputChannel.transferTo(0, inputChannel.size(), targetChannel);
            inputChannel.close();;
            fis.close();

        }
        targetChannel.close();
        fos.close();
    }
}
