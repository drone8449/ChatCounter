package edu.handong.csee.java.chatcounter;

import org.apache.commons.cli.*;

public class CommonsCLI {
	private String path ="";
	private String file;
	private boolean help;
	
	public void runCLI(String[] args) {
		Options options = makeOptions();

		if(parseOptions(options, args)) {
			if(help) {
				printHelp(options);
			}
		}
	}
	
	public Options makeOptions() {
		Options options = new Options();

		options.addOption(Option.builder("i")
				.desc("Path for the directory having files.")
				.hasArg().argName("PATH").required().build());

		options.addOption(Option.builder("o")
				.desc("Where output file is to store the result.")
				.hasArg().argName("FILE").required().build());

		options.addOption(Option.builder("h").longOpt("help")
				.desc("Help")
				.build());

		return options;
	}
	
	public boolean parseOptions(Options options, String[] args) {
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
	
	public void printHelp(Options options) {
		HelpFormatter formatter = new HelpFormatter();
		String header = "KakaoTalk ChatCounter";
		String footer = "\nPlease report issues at https://github.com/drone8449/ChatCounter/issues";
		formatter.printHelp("ChatCounter", header, options, footer, true);
	}
	
	public String getPath() {
		return path;
	}
	
	public String getFile() {
		return file;
	}

}
