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
		
		try {
			for(File input : files) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(input), "UTF-8"));
				
				while(reader.readLine()!=null) {
					String line = reader.readLine();
					message.add(line);
				}
			}
		}
		catch(FileNotFoundException e1) {
			System.out.println(e1.getMessage());
		} catch(IOException e2) {
			System.out.println(e2.getMessage());
		}
		
		return message;
	}
}
