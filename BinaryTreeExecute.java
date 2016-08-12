package binarytree;

import java.io.IOException;

public class BinaryTreeExecute {
	public static void main(String[] args) {
		String bits = null;
		BinaryTreeHelper util1 = new BinaryTreeHelper();
		try {
			bits = util1.setInput();
		} catch (IOException e) { 
			e.printStackTrace();
		};
		
		LZWBinaryTree lzwTree = new LZWBinaryTree();
		lzwTree.add(bits);
		
		int depth = lzwTree.depth();
		double avg = lzwTree.averageDepth();
		double var = lzwTree.variance();
//		System.out.println(depth + " " + avg + " " + var);
		
		BinaryTreeHelper util2 = new BinaryTreeHelper();
		String bits2 = null;
		try {
			bits2 = util2.setInput();
		} catch (IOException e) { 
			e.printStackTrace();
		};
		
		LZWBinaryTree lzwTree2 = new LZWBinaryTree();
		lzwTree2.add(bits2);
		
		int depth2 = lzwTree2.depth();
		double avg2 = lzwTree2.averageDepth();
		double var2 = lzwTree2.variance();
		System.out.println(depth + " " + avg + " " + var +"\n" + depth2 + " " + avg2 + " " + var2);
	}
}
