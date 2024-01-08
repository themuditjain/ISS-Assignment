package mudit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWrite {

    public static void main(String[] args) {
        // Specify the file paths
        String inputFile = "C:\\Users\\MUDIT JAIN\\eclipse-workspace\\Students_data\\src\\mudit\\input.txt";
        String outputFile = "C:\\Users\\MUDIT JAIN\\eclipse-workspace\\Students_data\\src\\mudit\\output.txt";

        // Writing to a file
        writeToFile(outputFile, "Hello, this is a test content.");

        // Reading from a file
        String content = readFromFile(inputFile);
        System.out.println("Content read from file: " + content);
    }

    private static void writeToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("Content written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFromFile(String filePath) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }
}

