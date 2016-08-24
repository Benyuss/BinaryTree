import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Logger;

class BinaryTreeHelper {

	private static Logger logger = null;

	static {

		try {
			InitLogger.initialize();
		} catch (FileNotFoundException e) {
			logger.log(Level.ERROR,
					"Can't initialize main's constructor due to loggers configuration file hasn't been found.");
			e.printStackTrace();
		} catch (IOException e) {
			logger.log(Level.ERROR,
					"Can't initialize main's constructor due to loggers configuration file hasn't been found.");
			e.printStackTrace();
		}

		logger = InitLogger.logger[0];
	}

	enum Travers {
		PREFIX, INFIX, POSTFIX;
	}

	public Travers traversal() { // returns traversal method which is selected
									// by user.
		int traversal = getTraversalMethod();

		switch (traversal) {
		case 1:
			return Travers.PREFIX;

		case 2:
			return Travers.INFIX;

		case 3:
			return Travers.POSTFIX;

		default:
			logger.log(Level.DEBUG, "Illegal traversing method.");
			throw new IllegalArgumentException("Illegal traversing method. Choose a legal one!");
		}
	}

	private int getTraversalMethod() { // Asks user to select a traversal method
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"Choose the way you want to traverse through the tree!\nOptions are: (1)Prefix[/LR], (2)Infix[L/R], (3)Postfix[LR/].\n"
						+ "Legend\tL-left, R-right, /-root");
		int result = scanner.nextInt();
		logger.log(Level.DEBUG, "User has chose " + result);
		scanner.close();
		return result;
	}

	public String readFile(String filename) throws FileNotFoundException { // reads
																			// bits
																			// from
																			// file
		BufferedReader inf = new BufferedReader(new FileReader(filename));
		StringBuilder sb = new StringBuilder();
		try {
			sb.append(inf.readLine());
		} catch (IOException e) {
			logger.log(Level.DEBUG, "Can't read from file.");
			e.printStackTrace();
		}
		try {
			inf.close();
		} catch (IOException e) {
			logger.log(Level.DEBUG, "Can't close file.");
			e.printStackTrace();
		}
		String appendedString = sb.toString();
		logger.log(Level.DEBUG, appendedString);
		return appendedString;
	}

	@SuppressWarnings("resource")
	public String setInput()
			throws IOException { /*
									 * asks user to write a set of bits into
									 * console or select a file and program will
									 * read from there.
									 */
		Scanner scanner = new Scanner(System.in);
		System.out.println("Will I get data from User / File (u/f)?");
		char input = Character.toLowerCase(scanner.next().charAt(0));
		switch (input) {
		case 'u': {
			System.out.println("Give me the set of bits: ");
			String result = scanner.next();
			logger.log(Level.DEBUG, "User decided USER_INPUT");
			return result;
		}
		case 'f':
			System.out.println("Location of input file [e.g. \"/home/USER/location/filename.txt/\"]: ");
			String fileLocation = scanner.next();
			logger.log(Level.DEBUG, "User decided FILE_INPUT");
			return readFile(fileLocation);
		}
		scanner.close();
		throw new IOException("No method selected.");
	}
}