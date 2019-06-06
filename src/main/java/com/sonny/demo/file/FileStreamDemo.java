package com.sonny.demo.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class FileStreamDemo {

	public static void main(String[] args) {

		
		ReadEveryLineOffile();
		
		CopyFileByReadingFileStream();
		
	}
	
	// Read every line of file by using file input stream.
	public static void ReadEveryLineOffile(){
		
		
		try {
			System.out.println("/* ##### ReadEveryLineOffile() Start ##### */");
			
			// open the file stream
			InputStream inputStream = new FileInputStream("d:\\temp\\test.txt");
			
			// read the file stream
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			
			// put the file stream into the buffere
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			
			// read every line of stream.
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			
			inputStream.close();
			inputStreamReader.close();
			bufferedReader.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		System.out.println("/* ##### ReadEveryLineOffile() End ##### */");

	}
	
	// Copy file by reading file stream
	public static void CopyFileByReadingFileStream() {
		
		System.out.println("/* ##### CopyFileByReadingFileStream() Start ##### */");
		
		try {
			// open the file stream
			InputStream inputStream = new FileInputStream("d:\\temp\\setting 5.jpg");
			
			// Create a new file stream
			OutputStream outputStream = new FileOutputStream("d:\\temp\\setting 5_output.jpg");
            
			int bufferSize = -1;	// calculate the size of reading data.
            byte[] buffer = new byte[1024];		// Create the 1024 bytes Buffer
            
            while ((bufferSize = inputStream.read(buffer)) != -1) {
            	outputStream.write(buffer, 0, bufferSize);
            }
			
            inputStream.close();
            outputStream.close();
            
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("/* ##### Complete to copy file by reading file stream ##### */");
		System.out.println("/* ##### CopyFileByReadingFileStream() End ##### */");

	} 

}
