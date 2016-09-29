package hu.benyuss.binaryTree.implementation;

import hu.benyuss.binaryTree.binaryTreeUtils.BinaryTreeNode;
import hu.benyuss.binaryTree.binaryTreeUtils.traversing.TraversConst;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class TreeBuilder extends AbstractBinaryTree<String, Character, TraversConst> {
    // Builds a LZW tree. If current node has a child, currentNode will point
    // to that. If not, it will create one and jump back to root.

    private static final Logger logger = (Logger) LogManager.getLogger(TreeBuilder.class.getName());

    private int depth;
    private double avg;
    private double var;

    public TreeBuilder() {
        root = new BinaryTreeNode<Character>('/');
    }

    @Override
    public void add(String value, TraversConst trav) {
        // value is the bitset.
        // only 1 / 0 chars will be parsed.

        BinaryTreeNode<Character> currentNode = root;
        BinaryTreeNode<Character> nextNode = root;
        currentNode.setDepth(0);
        for (int i = 0; i < value.length(); i++) {
            int c = value.charAt(i);
            if ((c) == '1') {
                nextNode = currentNode.getRightChild();
                // if it's null, it will create a child.
                if (nextNode == null) {
                    BinaryTreeNode<Character> newNode = new BinaryTreeNode<Character>('1');
                    //new node should be one more deeper than it's parent
                    newNode.setDepth(currentNode.getDepth() + 1);
                    currentNode.setRightChild(newNode);
                    nextNode = root;
                }
            } else if ((c) == '0') {
                nextNode = currentNode.getLeftChild();
                if (nextNode == null) {
                    BinaryTreeNode<Character> newNode = new BinaryTreeNode<Character>('0');
                    newNode.setDepth(currentNode.getDepth() + 1);
                    currentNode.setLeftChild(newNode);
                    nextNode = root;
                }
            }
            currentNode = nextNode;
        }
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public double getVar() {
        return var;
    }

    public void setVar(double var) {
        this.var = var;
    }
}