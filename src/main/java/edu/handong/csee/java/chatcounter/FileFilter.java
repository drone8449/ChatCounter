package edu.handong.csee.java.chatcounter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Filefilter class
 * It has HashMap<String, Integer> and countMessage(ArrayList)
 * It counts message of people and remove redundancy message
 * return HashMap that has user name and count
 * @author taehyun
 *
 */
public class FileFilter {
	
	/**
	 * countMessage method
	 * It compare method to compare object' feature
	 * @param list(ArrayList)
	 * @return countOfMessage(HashMap<String, Integer>)
	 */
	public HashMap<String,Integer> countMessage(ArrayList<MessageLists> list) {
		
		HashMap<String,Integer> countOfMessage = new HashMap<String,Integer>();
		
		int length = list.size();
		
		for(int i=0 ; i<length ; i++){
			
			int count=0;		
			MessageLists person = list.get(i);
			
			if(countOfMessage.containsKey(person.name)) 
				continue;
			
			for(int j=i+1 ; j<length ; j++) {
				if((person.name).compareTo((list.get(j)).name)==0 && compare(person, list.get(j))==1) {
						count++;		
				}
			}
			
		//	System.out.println(person.name + count);
			countOfMessage.put(person.name, count);
		}
		
		return countOfMessage;
	}
	
	private int compare(MessageLists person, MessageLists other) {
		if((person.message).compareTo(other.message)==0 && person.year == other.year
				&& person.month == other.month && person.date == other.date && person.time == other.time)
			return 0;
		else return 1;
	}
}
