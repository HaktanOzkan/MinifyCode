package me.minify;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MinifyCode {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.println("1 - MinifyCSS");
        System.out.println("2 - MinifyJS");
        System.out.println("3 - MinifyHTML");
        System.out.print("Enter your choice (1-3): ");
        int userInputNumber = scanner.nextInt();
        scanner.nextLine();

        String inputFilePath = getUserInput("Küçültülecek dosyanýn yolunu girin: ", scanner);
        String outputFilePath = getUserInput("Küçültülecek dosyanýn kaydedilecek yolunu girin: ", scanner);

        try {
            String minifiedContent = "";
            switch (userInputNumber) {
                case 1:
                    minifiedContent = MinifyCSS.minifyCSS(readFile(inputFilePath));
                    System.out.println("CSS minification completed successfully.");
                    break;
                case 2:
                    minifiedContent = MinifyJS.minifyJavaScript(readFile(inputFilePath));
                    System.out.println("JavaScript minification completed successfully.");
                    break;
                case 3:
                    minifiedContent = MinifyHTML.minifyHTML(readFile(inputFilePath));
                    System.out.println("HTML minification completed successfully.");
                    break;
                default:
                    System.err.println("Invalid choice. Please enter a number between 1 and 3.");
                    break;
            }

            writeFile(outputFilePath, minifiedContent);

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error during minification: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
	
	private static String getUserInput(String message, Scanner scanner) {
        System.out.print(message);
        return scanner.nextLine();
    }

    private static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    private static void writeFile(String filePath, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }

}
