package org.FileOps.text_file;

import java.io.*;

public class FileOps {
    public static void main(String[] args) {
        try {
            File file = new File("src/main/java/org/FileOps/text_file/file.txt");

            file.createNewFile();
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bwriter = new BufferedWriter(writer);
            bwriter.write(" Man");

            bwriter.close();
            writer.close();

            FileReader reader = new FileReader(file);
            BufferedReader breader = new BufferedReader(reader);
            String line;
            while ((line = breader.readLine()) != null) {
                System.out.println(line);
            }
            breader.close();
            reader.close();

            FileInputStream fis = new FileInputStream(file);
            byte[] arr =  fis.readAllBytes();
            int i = 0;
            while(i < arr.length) {
                System.out.print((char) arr[i]);
                i++;
            }
            fis.close();

        } catch(IOException e) {
            System.out.println("Msg: " +e.getMessage()+ "\nCause: " + e.getCause());
        }
    }
}
