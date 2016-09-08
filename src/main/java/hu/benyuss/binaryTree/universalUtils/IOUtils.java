package hu.benyuss.binaryTree.universalUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import hu.benyuss.binaryTree.traversing.ChooseTraversConst;
import hu.benyuss.binaryTree.traversing.TraversConst;

public class IOUtils {

	private static final Logger logger = (Logger) LogManager.getLogger(IOUtils.class.getName());

	public String setInput(Scanner scanner) throws IOException {
		/*
		 * asks user to write a set of bits into console or select a file and
		 * program will read from there.
		 */
		System.out.println("Will I get data from User / File (u/f)?");
		char input = Character.toLowerCase(scanner.next().charAt(0));
		switch (input) {
		case 'u': {
			logger.debug("User decided USER_INPUT");
			System.out.println("Give me the set of bits: ");
			String manualInput = scanner.next();
			return manualInput;
		}
		case 'f':
			logger.debug("User decided FILE_INPUT");
			System.out.println("Location of input file [e.g. \"/home/USER/location/filename.txt/\"]: ");
			String fileLocation = scanner.next();
			return readFile(fileLocation);
		}
		throw new IOException("No method selected.");
	}

	public String readFile(String filename) throws FileNotFoundException {
		// This method reads every character from files. Illegal (not 0/1)
		// will not get into the tree.

		BufferedReader inf = new BufferedReader(new FileReader(filename));

		StringBuilder sb = new StringBuilder();
		try {
			sb.append(inf.readLine());
		} catch (IOException e) {
			logger.debug("Can't read from file.");
			e.printStackTrace();
		}
		try {
			inf.close();
		} catch (IOException e) {
			logger.debug("Can't close file.");
			e.printStackTrace();
		}
		String stringParsedFromFile = sb.toString();
		logger.debug(stringParsedFromFile);
		return stringParsedFromFile;
	}

	public TraversConst getTraversalMethod(Scanner scanner) {
		// Asks user to select a
		// traversal method

		System.out.println("Choose the way you want to traverse through the tree!\n"
				+ "Options are: (1) Prefix [/ L R], (2) Infix [L / R], (3) Postfix [L R /].\n"
				+ "Legend\tL-left, R-right, /-root");

		int travresult = 0;

		if (scanner.hasNextInt()) {
			travresult = scanner.nextInt(); // if next token isn't int...
		} else {
			throw new IllegalArgumentException("Given value must be int.");
		}

		logger.debug("User has chose " + travresult);

		ChooseTraversConst travCnstUtil = new ChooseTraversConst();

		// choose an enumCnst by the given int and return it.
		return travCnstUtil.chooseTraverCnst(travresult);
	}

	public int setNumberOfTrees(Scanner scanner) {

		System.out.println("How many trees do you want to process? (given input must be a number)");

		int numberOfTrees = 0;
		if (scanner.hasNextInt()) {
			numberOfTrees = scanner.nextInt(); // if next token isn't int...
			logger.debug("Number of trees: " + numberOfTrees);
		} else {
			throw new IllegalArgumentException("Given value must be int.");
		}

		return numberOfTrees;
	}

	public boolean checkEquality(Scanner scanner) {

		System.out.println("Do you want to check equality 2 of the given trees?(y/n)");

		Character answer = Character.toLowerCase(scanner.next().charAt(0));

		if (answer == 'y') {
			logger.debug("User wants to check equality.");
			return true;
		} else if (answer == 'n') {
			logger.debug("User doesn't wants to check equality.");
			return false;
		} else {
			throw new IllegalArgumentException("Answer must be y/n");
		}
	}

	public int[] checkThese(Scanner scanner, int numOfTrees) {
		int[] ids = new int[2];
		
		if (numOfTrees < 2) {
			throw new IllegalArgumentException("You have to define atleast 2 trees.");
		}
		else if (numOfTrees == 2) {
			ids[0] = 0;
			ids[1] = 1;
		}
		else {
			System.out.println(
					"Choose 2 trees! 1-" + numOfTrees + " Tree ID's are calculated when they are added.\n" + "First ID: ");

			if (scanner.hasNextInt()) {
				ids[0] = (scanner.nextInt()-1);
				logger.debug("First id: " + ids[0]);
			} else {
				throw new IllegalArgumentException("Given value must be int.");
			}

			System.out.println("Second ID: ");

			if (scanner.hasNextInt()) {
				ids[1] = (scanner.nextInt()-1);
				logger.debug("Second id: " + ids[1]);
			} else {
				throw new IllegalArgumentException("Given value must be int.");
			}
		}
		
		return ids;
	}
}