package org.bankAccount.tests;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;

public class UpdateAccountNumberTest extends BaseTest {

    /**
     * Validate that the account number is updated.
     *
     * @param endpoint the endpoint to be validated : String
     */
    @Parameters({"endpoint"})
    @Test
    public void updateAccountNumberTest(String endpoint) {
        MatcherAssert.assertThat("The data is updated successfully", updateBankData(endpoint,1,999997), is(200));
    }
}

