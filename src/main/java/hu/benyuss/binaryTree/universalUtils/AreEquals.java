package hu.benyuss.binaryTree.universalUtils;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import hu.benyuss.binaryTree.implementation.LZWBinaryTree;

public class AreEquals {

	private static final Logger logger = (Logger) LogManager.getLogger(AreEquals.class.getName());

	private ArrayList<LZWBinaryTree> trees;

	public AreEquals(ArrayList<LZWBinaryTree> trees) {
		this.trees = trees;
	}

	public void checkEquality(int first, int second) {
		@SuppressWarnings("unused")
		boolean equals = false;

		logger.debug("First tree:\n" + trees.get(first).getDepth() + " " + trees.get(first).getAvg() + " "
				+ trees.get(first).getVar() + " " + trees.get(first).getHash() + "\n" +

				"Second tree:\n" + trees.get(second).getDepth() + " " + trees.get(second).getAvg() + " "
				+ trees.get(second).getVar() + " " + trees.get(second).getHash() + " " + "are ");

		if ((trees.get(first)).equals(trees.get(second)) == true) {
			logger.debug("equals.");
			equals = true;
		} else {
			logger.debug("not equals.");
		}
	}
}
