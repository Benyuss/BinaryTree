package hu.benyuss.binaryTree;

import hu.benyuss.binaryTree.universalUtils.CustomIOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.web.multipart.MultipartFile;

public class BinaryTreeExecute {

    private static final Logger logger = (Logger) LogManager.getLogger(BinaryTreeExecute.class.getName());

    private CustomIOUtils utils;
    private String bits = null;

    public BinaryTreeExecute() {
        utils = new CustomIOUtils();
    }

    public CustomIOUtils getUtils() {
        return utils;
    }

    public String getBits() {
        return bits;
    }

    public void setBits(String bits) {
        this.bits = bits;
    }

    public void fileInput(char inputMode, MultipartFile file) {

        setBits(getUtils().readFile(file));
        logger.info("Bits of the tree " + getBits());
    }
}
