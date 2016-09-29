package hu.benyuss.binaryTree.webserver.service;

import hu.benyuss.binaryTree.webserver.service.fileParsers.MultiPartResolver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.web.multipart.MultipartFile;

public class BinaryTreeInit {

    private static final Logger logger = (Logger) LogManager.getLogger(BinaryTreeInit.class.getName());

    private MultiPartResolver multipartUtil;
    private String bits = null; //it will store the bits of the given/parsed tree.

    public BinaryTreeInit() {
        multipartUtil = new MultiPartResolver();
    }

    public MultiPartResolver getMultipartUtil() {
        return multipartUtil;
    }

    public String getBits() {
        return bits;
    }

    public void setBits(String bits) {
        this.bits = bits;
    }

    public void fileInput(char inputMode, MultipartFile file) {
        setBits(getMultipartUtil().readFile(file));
        logger.info("Bits of the tree " + getBits());
    }
}
