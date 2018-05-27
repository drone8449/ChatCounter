package edu.handong.csee.java.chatcounter;

import java.io.*;
import java.util.ArrayList;

public class FileLoader {
	
	public ArrayList<String> getFile(String strDir) {
		File myDir = getDirectory(strDir);
		
		File[] file = getListOfFiles(myDir);
		
		ArrayList<String> message = readFiles(file);
		
		return message;
	}
	
	private File getDirectory(String strDir) {
		File myDirectory = new File(strDir);
		
		return myDirectory;
	}
	
	private File[] getListOfFiles(File dataDir) {
		for(File file : dataDir.listFiles()) {
			System.out.println(file.getAbsolutePath());
		}
		
		return dataDir.listFiles();
	}
	
	private ArrayList<String> readFiles(File[] files) {
		ArrayList<String> message = new ArrayList<String>();
		
		for(File file : files) {
			String name = file.toString();
			
			if(name.contains(".txt")) {
				
			}
			else if(name.contains(".csv")) {
				
			}
		}		
		
		return message;
	}
}
