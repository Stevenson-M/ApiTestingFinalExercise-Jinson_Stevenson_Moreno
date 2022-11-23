package org.bankAccount.reporting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class that contains the methods to generate the reports.
 *
 * @author Jinson.Moreno
 */
public class Reporter {

    public Reporter() {
    }

    private static Logger getLogger() {
        return LoggerFactory.getLogger(Reporter.class);
    }

    /**
     * Method that generates the report.
     *
     * @param text the message to be displayed in the report : String
     */
    public static void info(String text) {
        getLogger().info(text);
    }

    /**
     * Method that generates the report.
     *
     * @param text the message to be displayed in the report : String
     */
    public static void error(String text) {
        getLogger().error(text);
    }

}
