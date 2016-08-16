package binarytree;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Logger;

public class BinaryTreeExecute implements initLogger{
	
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
	
	public static void main(String[] args) throws FileNotFoundException, IOException  {
		
		
		String bits = null;
		BinaryTreeHelper util1 = new BinaryTreeHelper();
		try {
			bits = util1.setInput();
			logger.log(Level.INFO, "Bits of first tree " + bits);
		} catch (IOException e) { 
			logger.log(Level.ERROR, "File not found!");
			e.printStackTrace();
		};
		
		LZWBinaryTree lzwTree = new LZWBinaryTree();
		lzwTree.add(bits);
		
		int depth = lzwTree.depth();
		double avg = lzwTree.averageDepth();
		double var = lzwTree.variance();
		int hash = lzwTree.hashCode();
		
		BinaryTreeHelper util2 = new BinaryTreeHelper();
		String bits2 = null;
		try {
			bits2 = util2.setInput();
			logger.log(Level.INFO, "Bits of second tree " + bits2);
		} catch (IOException e) { 
			logger.log(Level.ERROR, "File not found!");
			e.printStackTrace();
		};
		
		LZWBinaryTree lzwTree2 = new LZWBinaryTree();
		lzwTree2.add(bits2);
		
		int depth2 = lzwTree2.depth();
		double avg2 = lzwTree2.averageDepth();
		double var2 = lzwTree2.variance();
		int hash2 = lzwTree2.hashCode();
		
		boolean equals = false;
		if (lzwTree.equals(lzwTree2) == true) {
			logger.log(Level.DEBUG, "equality is true");
			equals = true;
		}
	
		HashSet hm = new HashSet();
		hm.add(lzwTree);
		int size = hm.size();
		logger.log(Level.INFO, "Size is :: " + size + " :: .");
		hm.add(lzwTree2);
		size = hm.size();
		logger.log(Level.INFO, "Size is :: " + size + " :: .");
		System.out.println(depth + " " + avg + " " + var + " " + hash+ "\n" + depth2 + " " + avg2 + " " + var2 + " " + hash2 + " " + equals);
		logger.log(Level.DEBUG, depth + " " + avg + " " + var + " " + hash+ "\n" + depth2 + " " + avg2 + " " + var2 + " " + hash2 + " " + equals);
	}
}
