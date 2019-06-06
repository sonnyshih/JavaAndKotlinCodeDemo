package com.sonny.demo.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {

	public static void main(String[] args) {

		BufferedReader bufferedReader = null;
		FileReader fileReader = null;

		try {
			fileReader = new FileReader("d:\\temp\\test.txt");
					
			String currentLine;

			bufferedReader = new BufferedReader(fileReader);
			
			// print each line data
			while ((currentLine = bufferedReader.readLine()) != null) {
				System.out.println(currentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			
		}

	}
}
