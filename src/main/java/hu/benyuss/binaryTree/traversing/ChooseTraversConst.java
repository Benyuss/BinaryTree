package hu.benyuss.binaryTree.traversing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class ChooseTraversConst {

    private static final Logger logger = (Logger) LogManager.getLogger(ChooseTraversConst.class.getName());

    public TraversConst chooseTraverCnst(int traversal) {
        // Returns traversal method which is
        // selected by user.

        switch (traversal) {
            case 1:
                return TraversConst.PREFIX;

            case 2:
                return TraversConst.INFIX;

            case 3:
                return TraversConst.POSTFIX;

            default:
                logger.debug("Illegal traversing method.");
                throw new IllegalArgumentException("Illegal traversing method. Choose a legal one!");
        }
    }
}
