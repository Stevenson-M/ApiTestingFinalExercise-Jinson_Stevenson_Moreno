package org.bankAccount.tests;

import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EndpointIsEmptyTest extends BaseTest {

    /**
     * Validate that the endpoint is empty.
     *
     * @param endpoint the endpoint to be validated : String
     */
    @Parameters({"endpoint"})
    @Test
    public void endpointIsEmptyTest(String endpoint) {
       MatcherAssert.assertThat("The data was deleted successfully if there is any", deleteAllBankData(endpoint), is(200));
       MatcherAssert.assertThat("Endpoint is empty", getInitialBankData(endpoint).size(), is(0));
    }

}
