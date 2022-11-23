package org.bankAccount.utils;

import org.bankAccount.reporting.Reporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


/**
 * Class that contains the methods to generate the reports.
 *
 * @author Jinson.Moreno
 */
public class Listener implements ITestListener {

    /**
     * Method that generates the report.
     *
     * @param iTestResult the result of the test : ITestResult
     */
    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    /**
     * Method that generates the report.
     *
     * @param result the result of the test : ITestResult
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.info("Test: " + result.getName() + " [PASSED]");
    }

    /**
     * Method that generates the report.
     *
     * @param result the result of the test : ITestResult
     */
    @Override
    public void onTestFailure(ITestResult result) {
        Reporter.error("Test: " + result.getName() + " [FAILED]");
    }

    /**
     * Method that generates the report.
     *
     * @param iTestResult the result of the test : ITestResult
     */
    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    /**
     * Method that generates the report.
     *
     * @param iTestResult the result of the test : ITestResult
     */
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {}

    /**
     * Method that generates the report.
     *
     * @param iTestContext the context of the test : ITestContext
     */
    @Override
    public void onStart(ITestContext iTestContext) {}

    /**
     * Method that generates the report.
     *
     * @param iTestContext the context of the test : ITestContext
     */
    @Override
    public void onFinish(ITestContext iTestContext) {}
}
