package edu.handong.csee.java.chatcounter;

import java.io.*;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * FileWriter class
 * Make file
 * @author taehyun
 *
 */
public class FileWriter {
	
	/**
	 * getOutput method
	 * Write lines to file
	 * @param countOfMessage(HashMap<String, Integer>)
	 * @param filename(String)
	 */
	public void getOutput(HashMap<String,Integer> countOfMessage, String filename) {

		PrintWriter output = null;

		try {
			output = new PrintWriter(filename);
		
			for(Entry<String, Integer> entry : countOfMessage.entrySet()) {
				output.print(entry.getKey());
				output.print(",");
				output.println(entry.getValue());
				System.out.println(entry.getValue());
			}
		} catch(FileNotFoundException e) {
			System.out.println("Error opening the file " + filename);
			System.exit(0);
		}

		output.close();
	}
}
