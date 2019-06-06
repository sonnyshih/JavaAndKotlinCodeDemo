package com.sonny.demo.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FileInputStringDemo {

	public static void main(String[] args) {

		String string = "";

		// reading
		try {
			InputStream inputStream = new FileInputStream("d:\\temp\\test.txt");
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
				string += line + "\n";
			}
			bufferedReader.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		// writing
		try {
			FileWriter fileWriter = new FileWriter("d:\\temp\\test_output.txt");
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			PrintWriter fileOut = new PrintWriter(bufferedWriter);
			fileOut.println(string + "\n test of read and write !!");
			fileOut.close();
			System.out.println("the file test_output.txt is created!");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
