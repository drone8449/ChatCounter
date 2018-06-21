package edu.handong.csee.java.chatcounter;

/**
 * MessageLists class
 * Using for Messagelists
 * @author taehyun
 *
 */
public class MessageLists {
	String name = "";
	String message = "";
	int year = 0;
	int month = 0;
	int date = 0;
	int time = 0;
	
	/**
	 * constructor
	 * @param name(String)
	 * @param message(String)
	 * @param year(int)
	 * @param month(int)
	 * @param date(int)
	 * @param time(int)
	 */
	public MessageLists(String name, String message, int year, int month, int date, int time) {
		this.name = name;
		this.message = message;
		this.year = year;
		this.month = month;
		this.date = date;
		this.time = time;
	}
	
	/**
	 * case of all data is null
	 * @return 0(null), 1(not null)
	 */
	public int nullData() {
		if(name=="" && message=="" && year==0 && month==0 && date==0 && time==0) {
			return 0;
		} else return 1;
	}
	
	public String getName() {
		return name;
	}
	
	public String getMessage() {
		return message;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getDate() {
		return date;
	}
	
	public int getTime() {
		return time;
	}
}
