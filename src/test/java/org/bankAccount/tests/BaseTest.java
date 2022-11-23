package org.bankAccount.tests;

import org.bankAccount.reporting.Reporter;
import org.bankAccount.utils.Methods.ApiMethods;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.*;

import static org.hamcrest.CoreMatchers.is;

public class BaseTest extends ApiMethods {

    @Parameters({"endpoint"})
    @BeforeTest
    public void beforeClass(String endpoint) {
        Reporter.info("Endpoint: " + endpoint);
        MatcherAssert.assertThat("Endpoint is working", checkEndpoint(endpoint), is(200));
        Reporter.info("Starting the test..");
    }

    @AfterTest
    public void afterClass() {
        Reporter.info("Test finished...");
    }



}
