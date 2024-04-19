/***************************************************
* File:Controls the functions of file processing
* Author:C21474374
* OOP Assignment 2024
*********************************/

package Chess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class file {

    // Attempts to create a file and prints a message indicating whether it was newly created or already exists.
    public void makefile(String filename) {
        try {
            File myfile = new File(filename);
            if (myfile.createNewFile()) {  // createNewFile returns true if the file did not exist and was successfully created.
                System.out.println("The new file is created.");
            } else {
                System.out.println("This file already exists.");
            }
        } catch (Exception e) {  // Catching general Exception to handle any type of exception thrown during file creation.
            e.printStackTrace();
        }
    }

    // Writes text to a file, appending it, and ensures that each new text starts on a new line.
    public void writefile(String filename, String text) {
        try (FileWriter writer = new FileWriter(filename, true)) {  // FileWriter constructor with 'true' to append text to the file instead of overwriting it.
            writer.write(text + "\n");  // "\n" ensures that the next write will start on a new line.
            System.out.println("The writing has been done.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Reads the entire file and prints each line to the console.
    public void readfile(String filename) {
        File myfile = new File(filename);
        if (!myfile.exists()) {  // Check if the file exists before attempting to read.
            System.err.println("File does not exist.");
            return;
        }

        if (!myfile.canRead()) {  // Checks if the file is readable.
            System.err.println("Cannot read from the file.");
            return;
        }

        try (Scanner reader = new Scanner(myfile)) {
            String s = "";
            while (reader.hasNextLine()) {
                s += reader.nextLine() + "\n";  // Accumulates each line in s and adds a newline character for proper formatting.
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Searches the file for a name and checks if it exists.
    public boolean nameExists(String filename, String name) {
        File myfile = new File(filename);
        try (Scanner scanner = new Scanner(myfile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(", ");  // Assumes the file stores data as "name, score".
                if (parts.length > 0 && parts[0].equals(name)) {  // Checking if the first part of the line is the name.
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        }
        return false;
    }

    // Updates the score for a name by adding to the existing score.
    public void updateScore(String filename, String name, int additionalScore) {
        File myfile = new File(filename);
        List<String> lines = new ArrayList<>();
        boolean found = false;

        try (Scanner reader = new Scanner(myfile)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line.contains(name)) {
                    String[] parts = line.split(", ");
                    if (parts[0].equals(name)) {
                        int score = Integer.parseInt(parts[1]) + additionalScore;  // Parse the score and add the additionalScore.
                        line = name + ", " + score;  // Update the line with the new score.
                        found = true;
                    }
                }
                lines.add(line);  // Collecting all lines, including the updated ones, to rewrite back to the file.
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        if (!found) {
            System.out.println("Name not found, no score updated.");
            return;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(myfile))) {
            for (String line : lines) {
                writer.println(line);  // Writing each line back to the file.
            }
            System.out.println("Score updated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class FileProcessor {
    public static void main(String[] args) {
        
    }
}