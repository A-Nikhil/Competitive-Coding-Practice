import java.io.File;
import java.util.function.Consumer;

public class FileIterator {
	public static void fetchFiles(File dir, Consumer<File> fileConsumer) {

		if (dir.isDirectory()) {
			for (File file1 : dir.listFiles()) {
				fetchFiles(file1, fileConsumer);
			}
		} else {
			fileConsumer.accept(dir);
		}
	}

	public static void main(String[] args) {
		File file = new File("D:\\projects\\placements-2020\\src");
		fetchFiles(file, f -> System.out.println(f.getAbsolutePath()));
	}

	private void printFiles(File dir, int tabSpace) {
		for (File file1 : dir.listFiles()) {
			if (file1.isDirectory()) {

			}
		}
	}
}
