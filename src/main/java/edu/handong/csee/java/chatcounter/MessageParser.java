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
		int length = message.size();
		int key = length-1;
		
		String txtLinePattern = "-+\\s([0-9]+).\\s([0-9]).\\s([0-9]+).";
		String txtPattern = "\\[(.+)\\]\\s\\[(.+)\\s([0-9]+)\\:([0-9]+)\\]\\s(.+)";
		String csvPattern ="([0-9]+)\\-([0-9]+)\\-([0-9]+)\\s([0-9]+)\\:([0-9]+)\\:..\\,\\\"(.+)\\\"\\,\\\"(.+)\\\"";
		Pattern p1 = Pattern.compile(txtLinePattern);
		Pattern p2 = Pattern.compile(txtPattern);
		Pattern p3 = Pattern.compile(csvPattern);
		
		while(key>=0) {
			String s = message.get(key);
			
			if(s==null) {
				message.remove(key);
				key--;
				continue;
			}
			
			Matcher m1 = p1.matcher(s);
			Matcher m2 = p2.matcher(s);
			Matcher m3 = p3.matcher(s);
			
			if (!m1.find() && !m2.find() && !m3.find()) {
				String preLine = message.get(key-1);
				preLine = preLine.concat(s);
				message.remove(key);
				key--;
				continue;
			}
			
			key--;
		}
		
		return message;
	}
	
	public void parsing(ArrayList<String> message) {
		
		TxtParser parsetxt = new TxtParser();
		CsvParser parsecsv = new CsvParser();
		
		int year = 0;
		int month = 0;
		int day = 0;
		
		for(String s : message) {
			int count=0;
			char c = s.charAt(0);
			if(c=='-') {

				String firstLine = s;
				String pattern = "-+\\s([0-9]+).\\s([0-9]).\\s([0-9]+).";
				Pattern p = Pattern.compile(pattern);
				Matcher m = p.matcher(firstLine);

				if(m.find()) {
					year = Integer.parseInt(m.group(1));
					month = Integer.parseInt(m.group(2));
					day = Integer.parseInt(m.group(3));
				}
			}
			if(c=='[') {
				parsetxt.run(count,s,year,month,day);
				count++;
			}
			
			if(c=='2') {
				parsecsv.run(count,s);
				count++;
			}
	
		}
	}
}
