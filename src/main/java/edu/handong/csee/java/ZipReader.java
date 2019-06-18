package edu.handong.csee.java;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;

import edu.handong.csee.java.utils.CustomizedException;

public class ZipReader extends Thread {
	
	private boolean help;
	private String inputPath;
	private String outputPath;
	private String outputPathSec;

	public void run(String[] args) {
		Options options= new Options();
		
		createOption(options);
		
		if(parseOption(options, args)) {
			if(help) {
				printHelp(options);
				System.exit(0);
			}
		}else {
			
		}
		
	}
	
	private void createOption(Options options) {
		options.addOption(Option.builder("i").longOpt("input")
				.desc("Enter the input file path")
				.hasArg()
				.argName("Input path")
				.required()
				.build());
		
		options.addOption(Option.builder("o").longOpt("output path")
				.desc("Enter the output file path")
				.hasArg()
				.argName("Output path")
				.required()
				.build());
		
		options.addOption(Option.builder("O").longOpt("second output path")
				.desc("Enter the second output file path")
				.hasArg()
				.argName("Second output path")
				.required()
				.build());
		
		options.addOption(Option.builder("h").longOpt("help")
				.desc("Show a help page")
				.argName("Help")
				.build());
		
	}

	private void printHelp(Options options) {
		HelpFormatter formatter= new HelpFormatter();
		String header= "JavaFinalProject";
		String footer= "This is Java Final Proect!";
		formatter.printHelp("Final java HW", header, options, footer, true);
	}

	private boolean parseOption(Options options, String[] args) {
		DefaultParser parser= new DefaultParser();
		
		try {
			CommandLine cmd= parser.parse(options, args);
			
			inputPath= cmd.getOptionValue("i");
			outputPath= cmd.getOptionValue("o");
			outputPathSec= cmd.getOptionValue("o2");
			help= cmd.hasOption("h");
			
		}catch(Exception e) {
			printHelp(options);
			return false;
		}
		
		return true;
	}



	public void readFileZip(String path) throws CustomizedException {
		ZipFile zipFile;
		
		try {
			zipFile= new ZipFile(path);
			Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();
			
			while(entries.hasMoreElements()) {
				ZipArchiveEntry entry= entries.nextElement();
				InputStream stream = zipFile.getInputStream(entry);
				
				ExcelReader myReader = new ExcelReader();
				
				for(String value:myReader.getData(stream)) {
		        	
		        }
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
