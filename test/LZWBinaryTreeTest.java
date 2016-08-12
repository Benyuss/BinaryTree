package binarytree.test;

import org.junit.Assert;
import org.junit.Test;

import binarytree.LZWBinaryTree;

public class LZWBinaryTreeTest {

	@Test
	public void testDepth() {
		LZWBinaryTree tree = new LZWBinaryTree();
		tree.add("U");	// 01010101 -> 10101010
		//     /\
		//    0  1
		//      /
		//     0
		//      \
		//       1
		Assert.assertEquals(3, tree.depth());
	}

}
