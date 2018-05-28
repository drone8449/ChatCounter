package edu.handong.csee.java.chatcounter;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CsvParser implements MessageParser {
	
	static ArrayList<String> messageMac = new ArrayList<String>();
	
	public void parsing(String line) {
		String name = "";
		String message = "";
		String date = "";
		String time = "";
		
		Pattern namePattern = Pattern.compile("(\\[)((?:\\D|\\d)+)(\\])(\\s\\[(.*)\\])((\\s)(.*))");
		
		Matcher nameMatcher = namePattern.matcher(line);
		
		if(nameMatcher.find()) {
			String getName = nameMatcher.group();
			int nameStart = nameMatcher.start(2);
			int nameEnd = nameMatcher.end(2);
			name = getName.substring(nameStart, nameEnd);
			
			String getDay = nameMatcher.group();
			int dayStart = nameMatcher.start(5);
			int dayEnd = nameMatcher.end(5);
			date = getDay.substring(dayStart, dayEnd);
			
			String getMessage = nameMatcher.group();
			int messageStart = nameMatcher.start(8);
			int messageEnd = nameMatcher.end(8);
			message = getMessage.substring(messageStart, messageEnd);
		}
		
		
	}
}
