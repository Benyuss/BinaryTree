package hu.benyuss.binaryTree.webserver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class Application {

    private static final Logger logger = (Logger) LogManager.getLogger(Application.class.getName());

    public static void main(String[] args) throws Exception {
        // start Spring server.
        SpringApplication.run(Application.class, args);//NOSONAR //SonarQube marks that line as a false-positive. "nosonar" blocks inspection for that line.
        logger.debug("Server started properly");
    }
}