package edu.handong.csee.java.chatcounter;

import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.cli.*;

public class ChatCounter {
	
	String path;
	String file;
	boolean help;
	
	public static void main(String[] args) {
		
		ArrayList<String> message = new ArrayList<String>();
		ArrayList<MessageLists> list = new ArrayList<MessageLists>();
		HashMap<String,Integer> countOfMessage = new HashMap<String,Integer>();
		
		FileLoader reader = new FileLoader();
		MessageParser parser = new MessageParser();
		FileFilter filter = new FileFilter();
	    FileWriter outer = new FileWriter();
		
		message = reader.getFile(args[0]);
		list = parser.runParser(message);
		countOfMessage = filter.countMessage(list);
		outer.getOutput(countOfMessage);
		}
	
	private void runCLI(String[] args) {
		Options options = makeOptions();

		if(parseOptions(options, args)) {
			if(help) {
				printHelp(options);
			}
		}
	}
	
	private Options makeOptions() {
		Options options = new Options();

		options.addOption(Option.builder("i")
				.desc("Path for the directory having files.")
				.hasArg()
				.argName("PATH")
				.required()
				.build());

		options.addOption(Option.builder("o")
				.desc("Where output file is to store the result.")
				.hasArg()
				.argName("FILE")
				.required()
				.build());

		options.addOption(Option.builder("h").longOpt("help")
				.desc("Help")
				.build());

		return options;
	}
	
	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();

		try {
			CommandLine cmd = parser.parse(options, args);
			
			path = cmd.getOptionValue("i");
			file = cmd.getOptionValue("o");
			help = cmd.hasOption("h");
		}catch(Exception e) {
			printHelp(options);
			System.out.println();
			
			return false;
		}

		return true;
	}
	
	private void printHelp(Options options) {
		HelpFormatter formatter = new HelpFormatter();
		String header = "KakaoTalk ChatCounter";
		String footer = "\nPlease report issues at https://github.com/drone8449/ChatCounter/issues";
		formatter.printHelp("ChatCounter", header, options, footer, true);
	}
}
		
