package se.alcardian.jayway.trainee_test;

import java.util.ArrayList;

import se.alcardian.jayway.trainee_test.gui.SToolFrame;
import se.alcardian.jayway.trainee_test.io.Jay_IO;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length == 1){
			// Check if the folder (args[0] path) exists
			if(Jay_IO.folderExists(args[0])){
				SToolFrame frame = new SToolFrame(args[0]);
				frame.setVisible(true);
			}else{
				System.out.println("Error, path doesn't lead to a folder!");
			}
		}else{
			System.out.println("Error, no path to a save folder exists!");
		}
	}
	public static ArrayList<STool> loadSTool(String filePath){
		// If the file exists
		String fileName = "STool.txt";
		if(Jay_IO.fileExists(filePath+"\\", fileName)){
			ArrayList<String> buffer = Jay_IO.ReadFile(filePath+"\\"+fileName);
			ArrayList<STool> stool = new ArrayList<STool>();
			for(int i=0; i<buffer.size(); i++){
				String[] bufferParts = buffer.get(i).split(",");
				if(bufferParts.length == 5){
					// TODO add checks for if bufferParts [2][3][4], isNumber
					
					// Name, isFramework, languageID, intrusive, openSource
					stool.add(new STool(bufferParts[0], bufferParts[1].equals("true"), Integer.parseInt(bufferParts[2]),
							Integer.parseInt(bufferParts[3]), Integer.parseInt(bufferParts[4])));
				}else{
					// Bad data?
					// TODO add code here!
				}
			}
			return stool;
		}else{
			// The file for STool doesn't exist!
			// TODO add code here
			return null;
		}
	}
	
	public static ArrayList<Language> loadLanguage(String filePath, ArrayList<STool> stool){
		// If the file exists
		String fileName = "Language.txt";
		if(Jay_IO.fileExists(filePath+"\\", fileName)){
			ArrayList<String> buffer = Jay_IO.ReadFile(filePath+"\\"+fileName);
			ArrayList<Language> lang = new ArrayList<Language>();
			for(int i=0; i<buffer.size(); i++){
				String[] bufferParts = buffer.get(i).split(",");
				if(bufferParts.length == 2){
					// TODO add checks for if bufferParts[1] isNumber
					// Name, ID
					lang.add(new Language(bufferParts[0], Integer.parseInt(bufferParts[1]), stool, null));
				}else{
					// Bad data?
					// TODO add code here!
				}
			}
			return lang;
		}else{
			// The file for Language doesn't exist!
			// TODO add code here
			return null;
		}
	}

	public static String toVal(int val){
		if(val == 0){
			return "Unknown";
		}else if(val == 1){
			return "Yes";
		}else{
			return "No";
		}
	}
}
