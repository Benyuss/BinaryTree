//import hu.benyuss.binaryTree.implementation.LZWBinaryTree;
//import hu.benyuss.binaryTree.binaryTreeUtils.traversing.TraversConst;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//public class LZWBinaryTreeTest {
//
//    TreeBuilder tree;
//
//    @Before
//    public void initialize() {
//        tree = new TreeBuilder();
//    }
//
//    @After
//    public void terminate() {
//        tree = null;
//    }
//
//    @Test
//    public void testDepth() {
//        tree.add("01010101", TraversConst.INFIX);
//        // /\
//        // 0 1
//        // \
//        // 1
//        // /
//        // 0
//        int depth = tree.depth(TraversConst.INFIX);
//        Assert.assertEquals("Tree 1 depth is wrong", 3, depth);
//    }
//
//    @Test
//    public void testDepth2() {
//        tree.add("01010000", TraversConst.INFIX);
//        // /\
//        // 0 1
//        // / \
//        // 0 1
//        int depth = tree.depth(TraversConst.INFIX);
//        Assert.assertEquals("Tree 2 depth is wrong", 2, depth);
//    }
//
//    @Test
//    public void testDepth3() {
//        tree.add("110110", TraversConst.INFIX);
//        // /\
//        // 0 1
//        // / \
//        // 0 1
//        int depth = tree.depth(TraversConst.INFIX);
//        Assert.assertEquals("Tree 3 depth is wrong", 2, depth);
//    }
//
//    @Test
//    public void testDepth4() {
//        tree.add("01111001001001000111", TraversConst.INFIX);
//        // /\
//        // 0 1
//        // / \
//        // 0 1
//
//        int depth = tree.depth(TraversConst.INFIX);
//
//        Assert.assertEquals("Tree 4 depth is wrong", 4, depth);
//    }
//
//    @Test
//    public void testAvg4() {
//        tree.add("01111001001001000111", TraversConst.INFIX);
//        double avg = tree.averageDepth(TraversConst.INFIX);
//        Assert.assertEquals("Tree 4 avarageDepth is wrong", 2.75, avg, 0.1);
//    }
//
//    @Test
//    public void testVar4() {
//        tree.add("01111001001001000111", TraversConst.INFIX);
//        double var = tree.variance(TraversConst.INFIX);
//        Assert.assertEquals("Tree 4 variance is wrong", 0.957427, var, 0.1);
//    }
//
//    @Test
//    public void traversedDifference() {
//        tree.add("011011", TraversConst.INFIX);
//        int depth = tree.depth(TraversConst.INFIX);
//
//        tree.averageDepth(TraversConst.INFIX);
//        tree.variance(TraversConst.INFIX);
//        tree.hashCode();
//
//        int depthAffected = tree.depth(TraversConst.INFIX);
//
//        Assert.assertEquals("tree has broken", depth, depthAffected);
//    }
//
//}