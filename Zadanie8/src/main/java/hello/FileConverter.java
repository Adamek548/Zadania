package hello;

import java.io.*;
import java.util.Scanner;

public class FileConverter {

    public void convert(String filePath) {
        StringBuilder output = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                output.append(line.toUpperCase()).append("\n");
            }
            scanner.close();
            PrintWriter out = new PrintWriter(filePath);
            out.println(output);
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
