package binarytree;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class BinaryTreeHelper {
	
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
//		Scanner in = new Scanner(new FileReader(filename));
		StringBuilder sb = new StringBuilder();
		int x = 0;
		try {
			sb.append(inf.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		while (in.hasNext() == true) {
//			String next = in.next();
//			for (int i = 0; i < next.length(); i++) {
//				char nextChar = next.charAt(x);
//				if (nextChar == '0' || nextChar == '1') {
//					sb.append(nextChar);
//				}
//			}
//		}
//		in.close();
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
			return result;
		}
		case 'f':
			System.out.println("Location of input file [e.g. \"/location/filename.txt/\"]: ");
			String fileLocation = scanner.next();
			return readFile(fileLocation);
		}
		scanner.close();
		throw new IOException("No method selected.");
	}
}
