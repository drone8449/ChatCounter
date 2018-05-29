package edu.handong.csee.java.chatcounter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CsvParser extends MessageParser {
	public void run(int count,String s) {
		String name="";
		String message="";
		int year=0;
		int month=0;
		int day=0;
		int hour=0;
		int minute=0;
		int time=0;

		String line = s;
		String pattern ="([0-9]+)\\-([0-9]+)\\-([0-9]+)\\s([0-9]+)\\:([0-9]+)\\:..\\,\\\"(.+)\\\"\\,\\\"(.+)\\\"";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(line);

		if(m.find()) {
			year = Integer.parseInt(m.group(1));
			month = Integer.parseInt(m.group(2));
			day = Integer.parseInt(m.group(3));
			hour = Integer.parseInt(m.group(4));
			minute = Integer.parseInt(m.group(5));
			name = m.group(6);
			message = m.group(7);
		}
		time=hour*60+minute;

		list.add(count,new MessageLists(name,message,year,month, day, time));
	}
}
