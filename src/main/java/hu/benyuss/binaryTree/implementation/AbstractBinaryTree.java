package hu.benyuss.binaryTree.implementation;

import hu.benyuss.binaryTree.binaryTreeUtils.BinaryTree;
import hu.benyuss.binaryTree.binaryTreeUtils.BinaryTreeNode;
import hu.benyuss.binaryTree.binaryTreeUtils.traversing.TraversTrough;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public abstract class AbstractBinaryTree<T, N, M> implements BinaryTree<T, M> {

    // Every method has the same logics as
    // http://www.inf.unideb.hu/~nbatfai/z3a7.cpp

    private static final Logger logger = (Logger) LogManager.getLogger(AbstractBinaryTree.class.getName());

    protected BinaryTreeNode<N> root;

    @Override
    public String[] depth(M trav) {
        DepthCalculator dc = new DepthCalculator();
        dc.traverseTree(root, trav);
        logger.info("Tree is " + dc.maxDepth + " deep.");

        //We want to return with more data. 1 - The drawed tree, 2 - it's depth.
        String[] results = new String[2];
        results[0] = dc.getLogmsg();
        results[1] = Integer.toString(dc.maxDepth);
        return results;
    }

    @Override
    public double averageDepth(M trav) {
        AverageDepthCalculator adc = new AverageDepthCalculator();
        adc.traverseTree(root, trav);
        double temp = adc.sum / adc.count;
        logger.info("Avarage depth is " + temp);
        return temp;
    }

    @Override
    public double variance(M trav) {
        double avg = averageDepth(trav);
        VarianceCalculator var = new VarianceCalculator(avg);
        var.traverseTree(root, trav);
        double variance;
        if (var.count > 1)
            variance = Math.sqrt(var.sumSqr / (var.count - 1));
        else
            variance = Math.sqrt(var.sumSqr);
        logger.info("Variance is " + variance);
        return variance;
    }

    class DepthCalculator extends TraversTrough<N, M> {
        int currentDepth = -1; // root node should not be counted
        int maxDepth = 0;

        @Override
        public void preProcess() {
            currentDepth++;
            if (currentDepth > maxDepth) {
                maxDepth = currentDepth;
            }
        }

        @Override
        protected void postProcess() {
            currentDepth--;
        }

        @Override
        public String getLogmsg() {
            return super.getLogmsg();
        }
    }

    class AverageDepthCalculator extends DepthCalculator {
        double count = 0;
        double sum = 0;

        @Override
        protected void processNode(BinaryTreeNode<N> current) {
            super.processNode(current);

            if (current.getLeftChild() == null && current.getRightChild() == null) {
                count++;
                sum += currentDepth;
            }
        }
    }

    class VarianceCalculator extends DepthCalculator {
        double sumSqr = 0;
        double count = 0;
        double avg;

        public VarianceCalculator(double avg) {
            this.avg = avg;
        }

        @Override
        protected void processNode(BinaryTreeNode<N> current) {
            super.processNode(current);
            if (current != null) {
                if (current.getRightChild() == null && current.getLeftChild() == null) {
                    count++;
                    sumSqr += ((currentDepth - avg) * (currentDepth - avg));
                }
            }
        }

    }
}