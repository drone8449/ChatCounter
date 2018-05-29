package edu.handong.csee.java.chatcounter;

import java.util.ArrayList;
import java.util.HashMap;

public class ChatCounter {
	public static void main(String[] args) {
		ArrayList<String> message = new ArrayList<String>();
		ArrayList<MessageLists> list = new ArrayList<MessageLists>();
		HashMap<String,Integer> countOfMessage = new HashMap<String,Integer>();
		
		CommonsCLI cc = new CommonsCLI();
		FileLoader reader = new FileLoader();
		MessageParser parser = new MessageParser();
		FileFilter filter = new FileFilter();
	    FileWriter outer = new FileWriter();
		
	    cc.runCLI(args);
		message = reader.getFile(cc.getPath());
		list = parser.runParser(message);
		countOfMessage = filter.countMessage(list);
		outer.getOutput(countOfMessage, cc.getFile());
		}
	}
		
