package M303_13;

import java.io.File;

public class FileExample {
    public static void main(String [] args){
        //File absolute = new File();
        File file = new File("src/temp.txt");
        System.out.println(file.getAbsolutePath());
        System.out.println("is directory"+file.isDirectory());
        System.out.println("is hidden"+ file.isHidden());
        System.out.println("can read"+file.canRead());
        System.out.println("can write"+ file.canWrite());
        System.out.println("can execute"+file.canExecute());
        System.out.println("size"+file.length());
        System.out.println("is exists"+ file.exists());

        if(file.isDirectory()){
            File files[] = file.listFiles();
            for(File f:files){
                System.out.println("=======>"+f.getName());
            }
        }

        File newDirectory = new File("asdf");
        if(! newDirectory.exists()) {
            newDirectory.mkdir();
        }
    }
}
