package hu.benyuss.binaryTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import hu.benyuss.binaryTree.implementation.LZWBinaryTree;
import hu.benyuss.binaryTree.traversing.ChooseTraversConst;
import hu.benyuss.binaryTree.traversing.TraversConst;
import hu.benyuss.binaryTree.universalUtils.AreEquals;
import hu.benyuss.binaryTree.universalUtils.IOUtils;

public class BinaryTreeExecute {

	private static final Logger logger = (Logger) LogManager.getLogger(BinaryTreeExecute.class.getName());

	public static void main(String[] args) {

		IOUtils utils = new IOUtils();
		Scanner scanner = new Scanner(System.in);

		ArrayList<LZWBinaryTree> trees = new ArrayList<LZWBinaryTree>();

		int numberOfTrees = utils.setNumberOfTrees(scanner);

		for (int i = 1; i < (numberOfTrees + 1); i++) {
			// creates as many trees as the user wants.
			String bits = null;
			try {
				bits = utils.setInput(scanner);
				logger.info("Bits of first tree " + bits);
			} catch (IOException e) {
				logger.error("File not found!", e);
			}

			TraversConst travWay = utils.getTraversalMethod(scanner);

			LZWBinaryTree lzwTree = new LZWBinaryTree();
			lzwTree.add(bits, travWay);
			
			lzwTree.setDepth(lzwTree.depth(travWay));
			lzwTree.setAvg(lzwTree.averageDepth(travWay));
			lzwTree.setVar(lzwTree.variance(travWay));
			lzwTree.setHash(lzwTree.hashCode());
			
			trees.add(lzwTree);

			logger.debug("new tree");
		}

		if (utils.checkEquality(scanner) == true) {
			AreEquals equalityChecker = new AreEquals(trees);
			int [] ids = new int [2];
			
			ids = utils.checkThese(scanner, numberOfTrees);
			
			try {
			equalityChecker.checkEquality(ids[0], ids[1]);
			}
			catch (IndexOutOfBoundsException e) {
				logger.error("Given ID's were illegal.", e);
			}
		}

		scanner.close();

	}
}