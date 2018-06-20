package edu.handong.csee.java.chatcounter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TxtParser extends MessageParser {
	
	public void run(int count, String s, int year, int month, int day) {
		String name="";
		String ampm="";
		int time;
		int hour =0;
		int minute =0;
		String message="";


		String pattern = "\\[(.+)\\]\\s\\[(.+)\\s([0-9]+)\\:([0-9]+)\\]\\s(.+)";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(s);

		if(m.find()) {
			name = m.group(1);
			ampm = m.group(2);
			hour = Integer.parseInt(m.group(3));
			minute = Integer.parseInt(m.group(4));
			message = m.group(5);
		}

		time= hour*60 + minute;
		if(ampm=="오후") time+=12*60;

		list.add(count, new MessageLists(name, message, year, month, day, time));
	}
}
