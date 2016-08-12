package binarytree.test;

import org.junit.Assert;
import org.junit.Test;

import binarytree.LZWBinaryTree;

public class LZWBinaryTreeTest {

	@Test
	public void testDepth() {
		LZWBinaryTree tree1 = new LZWBinaryTree();
		tree1.add("01010101");
		//     /\
		//    0  1
		//      /
		//     0
		//      \
		//       1
		Assert.assertEquals("Tree1 depth is wrong",3, tree1.depth());
		
		LZWBinaryTree tree2 = new LZWBinaryTree();
		tree2.add("01010000");
		//     /\
		//    0  1
		//   / \
		//  0	1
		Assert.assertEquals("Tree2 depth is wrong", 2, tree2.depth());
		
		LZWBinaryTree tree3 = new LZWBinaryTree();
		tree3.add("110110");
		//     /\
		//    0  1
		//     	/ \ 
		//     0   1
		Assert.assertEquals("Tree 3 depth is wrong", 2, tree3.depth());
		
		LZWBinaryTree tree4 = new LZWBinaryTree();
		tree4.add("011011");
		//     /\
		//    0  1
		//     	/ \ 
		//     0   1
		Assert.assertEquals("Tree 3 depth is wrong", 2, tree4.depth());
		
		Boolean areEquals  = tree3.equals(tree4);
		Assert.assertTrue("They are not equal." , Boolean.valueOf(areEquals));
		
		areEquals  = tree2.equals(tree4);
		Assert.assertFalse("They are equal." , Boolean.valueOf(areEquals));
	}

}
