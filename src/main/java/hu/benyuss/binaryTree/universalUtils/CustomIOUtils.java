package hu.benyuss.binaryTree.universalUtils;

import hu.benyuss.binaryTree.traversing.ChooseTraversConst;
import hu.benyuss.binaryTree.traversing.TraversConst;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class CustomIOUtils {

    private static final Logger logger = (Logger) LogManager.getLogger(CustomIOUtils.class.getName());

    public String readFile(MultipartFile file) {

        StringBuilder string = new StringBuilder();

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                InputStream inputStream = new ByteArrayInputStream(bytes);
                Scanner scanner = new Scanner(inputStream);

                while (scanner.hasNext()) {
                    string.append(scanner.next());
                }
            } catch (IOException e) {
                logger.error("Can't parse data. Full stack trace: ", e);
            }
        }
        return string.toString();
    }

    public TraversConst getTraversalMethod(Scanner scanner) {
        // Asks user to select a
        // traversal method

        System.out.println("Choose the way you want to traverse through the tree!\n"
                + "Options are: (1) Prefix [/ L R], (2) Infix [L / R], (3) Postfix [L R /].\n"
                + "Legend\tL-left, R-right, /-root");

        int travresult = 0;

        if (scanner.hasNextInt()) {
            travresult = scanner.nextInt(); // if next token isn't int...
        } else {
            throw new IllegalArgumentException("Given value must be int.");
        }

        logger.debug("User has chose " + travresult);

        ChooseTraversConst travCnstUtil = new ChooseTraversConst();

        // choose an enumCnst by the given int and return it.
        return travCnstUtil.chooseTraverCnst(travresult);
    }

    public int setNumberOfTrees(Scanner scanner) {

        System.out.println("How many trees do you want to process? (given input must be a number)");

        int numberOfTrees = 0;
        if (scanner.hasNextInt()) {
            numberOfTrees = scanner.nextInt(); // if next token isn't int...
            logger.debug("Number of trees: " + numberOfTrees);
        } else {
            throw new IllegalArgumentException("Given value must be int.");
        }

        return numberOfTrees;
    }

    public boolean checkEquality(Scanner scanner) {

        System.out.println("Do you want to check equality 2 of the given trees?(y/n)");

        Character answer = Character.toLowerCase(scanner.next().charAt(0));

        if (answer == 'y') {
            logger.debug("User wants to check equality.");
            return true;
        } else if (answer == 'n') {
            logger.debug("User doesn't wants to check equality.");
            return false;
        } else {
            throw new IllegalArgumentException("Answer must be y/n");
        }
    }

    public int[] checkThese(Scanner scanner, int numOfTrees) {
        int[] ids = new int[2];

        if (numOfTrees < 2) {
            throw new IllegalArgumentException("You have to define atleast 2 trees.");
        } else if (numOfTrees == 2) {
            ids[0] = 0;
            ids[1] = 1;
        } else {
            System.out.println(
                    "Choose 2 trees! 1-" + numOfTrees + " Tree ID's are calculated when they are added.\n" + "First ID: ");

            if (scanner.hasNextInt()) {
                ids[0] = (scanner.nextInt() - 1);
                logger.debug("First id: " + ids[0]);
            } else {
                throw new IllegalArgumentException("Given value must be int.");
            }

            System.out.println("Second ID: ");

            if (scanner.hasNextInt()) {
                ids[1] = (scanner.nextInt() - 1);
                logger.debug("Second id: " + ids[1]);
            } else {
                throw new IllegalArgumentException("Given value must be int.");
            }
        }

        return ids;
    }
}