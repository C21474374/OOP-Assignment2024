package Chess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class file {


	public void makefile(String filename) {
		try {
			File myfile = new File(filename);
			if (myfile.createNewFile())
			{
				System.out.println("the new file is created");
			}
			else {
				System.out.println("this file is already existed");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writefile(String filename,String text) {
		try {
			FileWriter writer = new FileWriter(filename,true);
			writer.write(text+"\n");
			System.out.println("the writing has been done");
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void readfile (String filename) {
		File myfile = new File(filename);
		if (!myfile.exists()) {
	        System.err.println("File does not exist.");
	        return;
	    }


	    if (!myfile.canRead()) {
	        System.err.println("Cannot read from the file.");
	        return;
	    }
		Scanner reader;
		String s="";
		try {
			reader = new Scanner(myfile);
			while(reader.hasNextLine()) {

				s+=reader.nextLine();

				s+="\n";
				System.out.println(s);
			}


		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		if (myfile.exists()) {
			System.out.println(myfile.getName());
			System.out.println(myfile.canRead());
			System.out.println(myfile.canWrite());
			System.out.println(myfile.getAbsolutePath());
		}
	}
}

public class FileProcessor {

	public static void main(String[] args) {


	}

}
