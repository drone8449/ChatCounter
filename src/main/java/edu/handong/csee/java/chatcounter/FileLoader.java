package edu.handong.csee.java.chatcounter;

import com.opencsv.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileLoader {
	private ArrayList<String> messages;
	
	public void readDirectory(String path) {
		ArrayList<File> fileNames = getFileNames(path);
		
		for(File fileName:fileNames) {
			
		}
	}
	
	private ArrayList<File> getFileNames(String path) {
		ArrayList<File> fileNames = new ArrayList<File>();
		
		File myPath = new File(path);
		myPath.listFiles();
		
		for(File fileName:myPath.listFiles()) {
			fileNames.add(fileName);
		}
		
		return fileNames;
	}
	
	public void getMessages() {
		Scanner readfile = new Scanner(System.in);
		int lineCount = 0;
		
		while(readfile.hasNext()) {
			readfile.nextLine();
			lineCount++;
		}
		
		for(int i = 0; i < lineCount; i++) {
			String str = readfile.nextLine();
		}
	}
}
