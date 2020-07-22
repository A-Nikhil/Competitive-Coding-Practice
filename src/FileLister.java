// Puts content of all the codes into a single file

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLister {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(
				new FileReader("D:\\projects\\placements-2020\\src\\files.txt"));
		String x = reader.readLine();
		PrintWriter writer = new PrintWriter(
				new BufferedWriter(
						new FileWriter("allCodex.txt")
				)
		);
		int count = 0;
		while (x != null) {
			if (x.equals("D:\\projects\\placements-2020\\src\\FileLister.java") ||
					x.equals("D:\\projects\\placements-2020\\src\\test.java")) {
				x = reader.readLine();
				continue;
			}
			if (x.endsWith("java")) {
				BufferedReader reader1 = new BufferedReader(
						new FileReader(x));
				writer.println();
				writer.println();
				writer.println(x.substring(x.lastIndexOf('\\') + 1));
				writer.println();
				writer.println();
				String z = reader1.readLine();
				System.out.println("Printing => " + x);
				while (z != null) {
					writer.println(z);
					z = reader1.readLine();
				}
				reader1.close();

				writer.println();
				writer.println();
				writer.println(" ===================================================== ");
				count++;
			}
			x = reader.readLine();
		}
		writer.close();
		reader.close();
		System.out.println(count);
	}
}
