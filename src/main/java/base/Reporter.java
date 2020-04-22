package base;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporter {
    private static final Logger LOGGER = Logger.getLogger(Reporter.class.getName());

    public static void log(String s) {
        printWithTime(s);
        printStdOut(s);
    }

    private static void printStdOut(String message) {
        BaseTest.getTest().get().info(message);
        LOGGER.info(message);
    }

    public static void logFail(String s) {
        LOGGER.error(s);
    }


    public static void printWithTime(String message) {
        String currentTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
        System.out.println(currentTime + " " + message);
    }
}

