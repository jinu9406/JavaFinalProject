package edu.handong.csee.java.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class Utils {
	public static void makeFile(ArrayList<String> lines, String objectFile) throws IOException {
		
		CSVPrinter printer= new CSVPrinter(new FileWriter(objectFile), CSVFormat.DEFAULT);
		
		try(printer){
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
