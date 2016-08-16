package binarytree.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import binarytree.LZWBinaryTree;

public class LZWBinaryTreeTest {

	LZWBinaryTree tree;
	
	@Before
	public void initialize () {
		tree = new LZWBinaryTree();
	}
	
	@After
	public void terminate () {
		tree = null;
	}
	
	
	@Test
	public void testDepth() {
		tree.add("01010101");
		//     /\
		//    0  1
		//	   \    
		//      1
		//     /
		//    0
		int depth = tree.depth();
		Assert.assertEquals("Tree 1 depth is wrong", 3, depth);
	}
	
	@Test
	public void testDepth2() {
		tree.add("01010000");
		//     /\
		//    0  1
		//   / \
		//  0	1
		int depth = tree.depth();
		Assert.assertEquals("Tree 2 depth is wrong", 2, depth);
	}
	
	@Test
	public void testDepth3() {
		tree.add("110110");
		//     /\
		//    0  1
		//     	/ \ 
		//     0   1
		int depth = tree.depth();
		Assert.assertEquals("Tree 3 depth is wrong", 2, depth);
	}
	
	@Test
	public void testDepth4() {
		tree.add("01111001001001000111");
		//     /\
		//    0  1
		//     	/ \ 
		//     0   1
		
		int depth = tree.depth();
		
		
		Assert.assertEquals("Tree 4 depth is wrong", 4, depth);
	}
	
	@Test
	public void testAvg4() {
		tree.add("01111001001001000111");
		double avg = tree.averageDepth();
		Assert.assertEquals("Tree 4 avarageDepth is wrong", 2.75, avg, 0.1);
	}
	
	@Test
	public void testVar4() {
		tree.add("01111001001001000111");
		double var = tree.variance();
		Assert.assertEquals("Tree 4 variance is wrong", 0.957427, var, 0.1);
	}
	
	@Test
	public void traversedDifference() {
		tree.add("011011");
		int depth = tree.depth();
		
		tree.averageDepth();
		tree.variance();
		tree.hashCode();
		
		int depthAffected = tree.depth();
		
		Assert.assertEquals("tree has broken" ,depth, depthAffected);
	}
	
}
