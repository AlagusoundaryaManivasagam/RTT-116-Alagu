package Glab303_13_2;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioExample {
    public static void main(String[] args) throws IOException {
        String[] inputFiles = {"C:\\Users\\kumar\\Development\\RTT-116-Classwork\\Module-303\\Module-303\\src\\file1.txt",
                "C:\\Users\\kumar\\Development\\RTT-116-Classwork\\Module-303\\Module-303\\src\\file2.txt"};
        String outputFile = "C:\\Users\\kumar\\Development\\RTT-116-Classwork\\Module-303\\Module-303\\src\\nioOutput.txt";

        FileOutputStream fos = new FileOutputStream(outputFile);
        FileChannel targetChannel = fos.getChannel();

        for(int i=0; i< inputFiles.length; i++){
            FileInputStream fis = new FileInputStream(inputFiles[i]);
            FileChannel inputChannel = fis.getChannel();
            long size = inputChannel.size();
            ByteBuffer buf = ByteBuffer.allocate((int)size);
            System.out.println((char)buf.get());
            while (inputChannel.read(buf)>0){
                buf.flip();
                while (buf.hasRemaining()){
                    System.out.println((char)buf.get());
                    targetChannel.write(buf);
                }
            }
        }

    }
}
