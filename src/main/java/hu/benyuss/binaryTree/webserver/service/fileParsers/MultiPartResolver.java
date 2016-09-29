package hu.benyuss.binaryTree.webserver.service.fileParsers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class MultiPartResolver {

    private static final Logger logger = (Logger) LogManager.getLogger(MultiPartResolver.class.getName());

    public String readFile(MultipartFile file) {

        StringBuilder string = new StringBuilder();

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                InputStream inputStream = new ByteArrayInputStream(bytes);
                Scanner scanner = new Scanner(inputStream);
                //Parses file as a bytearray.
                // While it's next char is not null, it appends these bytes into a String.
                while (scanner.hasNext()) {
                    string.append(scanner.next());
                }
            } catch (IOException e) {
                logger.error("Can't parse data. Full stack trace: ", e);
            }
        }
        return string.toString();
    }
}