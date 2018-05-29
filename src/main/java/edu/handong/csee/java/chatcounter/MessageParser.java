package edu.handong.csee.java.chatcounter;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageParser {
	ArrayList<MessageLists> list = new ArrayList<MessageLists>();
	
	public ArrayList<MessageLists> runParser(ArrayList<String> message) {
		message = remakeMessage(message);
		parsing(message);		
	    
		return list;
	}
	
	public ArrayList<String> remakeMessage(ArrayList<String> message) {
		
		
		return message;
	}
	
	public void parsing(ArrayList<String> message) {
		
	}
}
