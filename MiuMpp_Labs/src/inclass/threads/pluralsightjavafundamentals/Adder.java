package inclass.threads.pluralsightjavafundamentals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Adder implements Runnable {
	private String inFile, outFile;

	Adder(String inFile, String outFile) {
		this.inFile = inFile;
		this.outFile = outFile;
	}

	public void doAdd() throws IOException {
		int total = 0;
		String line = null;

		try (BufferedReader reader = Files.newBufferedReader(Paths.get(inFile))) {
			while ((line = reader.readLine()) != null) {
				total += Integer.parseInt(line);
				// System.out.println(line);
			}
		}

		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outFile))) {
			//writer.write("Total: " + total);
			//writer.write("Total: " + total);
			System.out.print(Thread.currentThread());
			System.out.println("writing to file: " + outFile);
		}
	}

	@Override
	public void run() {
		try {
			doAdd();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		/*
		 * String[] inFiles = { "/file1.txt", "/file2.txt", "./file3.txt",
		 * "./file4.txt", "./file5.txt", "./file6.txt" }; String[] outFiles = {
		 * "/file1.out.txt", "/file2.out.txt", "./file3.out.txt", "./file4.out.txt",
		 * "./file5.out.txt", "./file6.out.txt" };
		 */

		String root = "src/inclass/threads/pluralsightjavafundamentals";
		String[] inFiles = { "/file1.txt", "/file2.txt", "/file3.txt", "/file4.txt", "/file5.txt", "/file6.txt" };
		String[] outFiles = { "/file1.out.txt", "/file2.out.txt", "/file3.out.txt", "/file4.out.txt", "/file5.out.txt",
				"/file6.out.txt" };

		Thread[] threads = new Thread[inFiles.length];
		for (int i = 0; i < inFiles.length; i++) {
			Adder adder = new Adder(root + inFiles[i], root + outFiles[i]);
			
			Thread thread = new Thread(adder);
			thread.start();
			/*threads[i] = new Thread(adder);
			threads[i].start();*/
		}
		
		/*for (Thread thread : threads) {
			thread.join();
		}*/
	}

}
