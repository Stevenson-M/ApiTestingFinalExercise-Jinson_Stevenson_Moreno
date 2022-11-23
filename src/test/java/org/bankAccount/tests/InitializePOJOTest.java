package org.bankAccount.tests;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;

public class InitializePOJOTest extends BaseTest {

    /**
     * Send a POST request to the endpoint to initialize the POJO.
     *
     * @param endpoint the endpoint to be validated : String
     */
    @Parameters({"endpoint"})
    @Test
    public void initializePOJOTest(String endpoint) {
        MatcherAssert.assertThat("The data is initialized successfully without any duplicates email", createBankData(endpoint), is(201));
    }
}
