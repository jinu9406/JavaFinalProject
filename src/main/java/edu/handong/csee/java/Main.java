package edu.handong.csee.java;

public class Main {

	public static void main(String[] args) {
		int threadNumber= 5;
		
		Thread[] thread= new Thread[threadNumber];
		
		for(int i= 0; i< threadNumber; i++) {
			ZipReader reader= new ZipReader();
			reader.run(args);
			
			thread[i]= new Thread(reader);
			thread[i].start();
		}
	}
	
}
