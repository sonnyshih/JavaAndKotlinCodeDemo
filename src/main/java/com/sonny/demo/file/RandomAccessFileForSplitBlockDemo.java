package com.sonny.demo.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class RandomAccessFileForSplitBlockDemo {

	// private static int BLOCK_SIZE = 64 * 1024; // Every Block is 64k
	private static int BLOCK_SIZE = 10; // Every Block is 64k

	public static void main(String[] args) {

		File file = new File("d:\\temp\\setting 5.jpg");
		RandomAccessFile randomAccessFile = null;
		FileChannel fileChannel = null;
		long fileSize = 0;

		long startPosition = 0;
		long endPosition = BLOCK_SIZE * 1;

		// Read the data - Sonny Shih 2014/07/09
		MappedByteBuffer mappedByteBuffer;

		try {

			randomAccessFile = new RandomAccessFile(file, "r");
			fileChannel = randomAccessFile.getChannel();
			fileSize = fileChannel.size(); // file size (bytes)

			mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY,
					startPosition, endPosition);
			mappedByteBuffer.load();

			byte[] bytes = new byte[BLOCK_SIZE];
			for (int j = 0; j < mappedByteBuffer.limit(); j++) {
				bytes[j] = mappedByteBuffer.get();
				System.out.println("ASCII: " + bytes[j] + " Char: "+ (char) bytes[j]);
			}

			// Byte array translates to string 
			String decoded = new String(bytes, "UTF-8");
			System.out.println(decoded);

			mappedByteBuffer.clear();
			fileChannel.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}



		

	}

}
