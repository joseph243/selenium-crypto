package automation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CoinReporter {

	private static String path = "C:\\Users\\Joseph\\Documents\\CryptoReport\\";
	private static File file;
	private static final String BORDER60CHAR = "============================================================\n";
	private static String headerPrefix = "Report: ";
	private static List<String> lines = new ArrayList<String>();
	private static boolean reportNamePresent = false;

	public static boolean reportDay() throws Throwable {
		createFile(LocalDate.now().toString());
		return writeLines();
	}

	public static boolean addLine(String reportID, String content) {
		lines.add(content);
		if (!reportNamePresent) {
			headerPrefix = headerPrefix + reportID;
			reportNamePresent = true;
		}
		return true;
	}

	private static void resetHeaderPrefix() {
		headerPrefix = "Report: ";
		reportNamePresent = false;
	}

	private static boolean createFile(String name) throws Throwable {
		file = new File(path + name + ".txt");
		return (file.createNewFile());
	}

	private static boolean writeLines() throws Throwable {
		FileWriter writer = new FileWriter(file);
		try {
			writer.write(headerPrefix + "\n");
			writer.write(BORDER60CHAR);
			for (String line : lines) {
				writer.write(line + "\n");
			}
			writer.write(BORDER60CHAR);
			writer.write("\n\n\n");
			resetHeaderPrefix();
			lines.clear();
			return true;
		} catch (IOException e) {
			return false;
		} finally {
			writer.close();
		}
	}
}
