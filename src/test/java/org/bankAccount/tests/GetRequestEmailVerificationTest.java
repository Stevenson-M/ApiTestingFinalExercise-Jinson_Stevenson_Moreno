package org.bankAccount.tests;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class GetRequestEmailVerificationTest extends BaseTest {

    /**
     * Validate that there is data in the endpoint without duplicates emails.
     *
     * @param endpoint the endpoint to be validated : String
     */
    @Parameters({"endpoint"})
    @Test
    public void getRequestEmailVerificationTest(String endpoint) {
        MatcherAssert.assertThat("There is no duplicate email in the endpoint", getAllBankDataAndVerifyEmail(endpoint), is(200));
    }
}

