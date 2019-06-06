package com.sonny.demo.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

	public static void main(String[] args) {
		
		File file = new File("d:\\temp\\test.txt");
		RandomAccessFile randomAccessFile = null;

		String tempRanomAccessFileString;
		try {
			
			randomAccessFile = new RandomAccessFile(file, "rw");
			tempRanomAccessFileString = randomAccessFile.readLine();
			while (tempRanomAccessFileString != null) {
				System.out.println("tempRAFStr: " + tempRanomAccessFileString);
				tempRanomAccessFileString = randomAccessFile.readLine();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			// Read the file from the start
			randomAccessFile.seek(0);
			tempRanomAccessFileString = randomAccessFile.readLine();

			while (tempRanomAccessFileString != null) {
				System.out.println("tempRAFStr2: " + tempRanomAccessFileString);
				tempRanomAccessFileString = randomAccessFile.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
