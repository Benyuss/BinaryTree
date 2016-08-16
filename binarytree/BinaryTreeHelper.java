package binarytree;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.config.xml.XmlConfigurationFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;

class BinaryTreeHelper implements initLogger{
	
private static Logger logger = null;
	
	
	static {
		
		try {
			initLogger.initialize();
		} catch (FileNotFoundException e) {
			logger.log(Level.ERROR, "Can't initialize main's constructor due to loggers configuration file hasn't been found.");
			e.printStackTrace();
		} catch (IOException e) {
			logger.log(Level.ERROR, "Can't initialize main's constructor due to loggers configuration file hasn't been found.");
			e.printStackTrace();
		}
		
		logger = initLogger.logger[0];
	}
	
	enum Travers {
		PREFIX, INFIX, POSTFIX;
	}
	
	public Travers traversal() { //returns traversal method which is selected by user.
		int traversal = getTraversalMethod();
		
		switch (traversal) {
		case 1: 
			return Travers.PREFIX;
			
		case 2:
			return Travers.INFIX;
			
		case 3:
			return Travers.POSTFIX;
			
		default:
			throw new IllegalArgumentException("Illegal traversing method. Choose a legal one!");
		}
	}

	private int getTraversalMethod() { //Asks user to select a traversal method
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"Choose the way you want to traverse through the tree!\nOptions are: (1)Prefix[0LR], (2)Infix[L0R], (3)Postfix[LR0].\n"
						+ "Legend\tL-left, R-right, 0-root");
		int result = scanner.nextInt();
		scanner.close();
		return result;
	}

	public String readFile(String filename) throws FileNotFoundException { //reads bits from file
		BufferedReader inf = new BufferedReader(new FileReader(filename));
		StringBuilder sb = new StringBuilder();
		int x = 0;
		try {
			sb.append(inf.readLine());
		} catch (IOException e) {
			logger.log(Level.DEBUG, "Can't read from file.");
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	@SuppressWarnings("resource")
	public String setInput() throws IOException { /*asks user to write a set of bits into console
	 														or select a file and program will read from there.*/
		Scanner scanner = new Scanner(System.in);
		System.out.println("Will I get data from User / File (u/f)?");
		char input = Character.toLowerCase(scanner.next().charAt(0));
		switch (input) {
		case 'u': {
			System.out.println("Give me the set of bits: ");
			String result = scanner.next();
			logger.log(Level.INFO, "User decided USER_INPUT");
			return result;
		}
		case 'f':
			System.out.println("Location of input file [e.g. \"/location/filename.txt/\"]: ");
			String fileLocation = scanner.next();
			logger.log(Level.INFO, "User decided FILE_INPUT");
			return readFile(fileLocation);
		}
		scanner.close();
		throw new IOException("No method selected.");
	}
}
