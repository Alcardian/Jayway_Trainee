package se.alcardian.jayway.trainee_test.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Jay_IO {
	/**
	 * Reads a file. Built with the intent of reading '.txt' files.
	 * @param fileName
	 * @return
	 */
	public static ArrayList<String> ReadFile(String fileName){
		ArrayList<String> buffer = new ArrayList<String>();
		Scanner sc;	//scanner, for read from file
		
		try {
			sc = new Scanner(new File(fileName));
			while (sc.hasNext()){
				buffer.add(sc.nextLine());
			}
			sc.close();
		} catch(FileNotFoundException e){
			e.printStackTrace();
			System.out.println("ERROR! Can't find file!");
		}
		return buffer;
	}
	
	public static void writeToFile(ArrayList<String> fileLines, String fileName){
		FileWriter writer;	//FileWriter to write to file 
		try {
			writer = new FileWriter(new File(fileName));	//open file at path named fileName
			int a = 0;	//for the while loop
			
			while (a<fileLines.size()){	//write string from fileLines at position "a" and add \n
				writer.write(fileLines.get(a));
				writer.write("\n");	//write end of line symbol
				a++;
			}
			writer.close();
		}
		catch(IOException e){
			System.out.println("ERROR! IOException while writing to file!");
		}
	}
	/**
	 * @param folderPath
	 * @return True if the folder exists, False if it doesn't.
	 */
	public static boolean folderExists(String folderPath){
		return new File(folderPath).isDirectory();
	}
	
	/**
	 * @param filePath e.g. on Windows 10 "C:\Media\"
	 * @param fileName e.g. on Windows 10 "funnyImage.jpg"
	 * @return True if the file exists, False if it doesn't.
	 */
	public static boolean fileExists(String filePath, String fileName){
		return new File(filePath+fileName).isFile();
	}
}
