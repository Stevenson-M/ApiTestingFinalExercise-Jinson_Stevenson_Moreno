package org.bankAccount.utils.Methods;

import com.sun.deploy.security.SelectableSecurityManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.bankAccount.pojo.BankPojo;
import org.bankAccount.reporting.Reporter;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import com.github.javafaker.Faker;


import java.util.ArrayList;
import java.util.List;
import static java.lang.String.format;


import static io.restassured.RestAssured.given;

public class ApiMethods {


    /**
     * Method that cheak if the endpoint is working.
     *
     * @param endpoint the endpoint to be checked : String
     * @return the status code of the endpoint : int
     */
    public int checkEndpoint(String endpoint) {
        RestAssured.baseURI = endpoint;
        RequestSpecification httpRequest = given();
        Response response = httpRequest.get("");
        int statusCode = response.getStatusCode();
        return statusCode;
    }

    /**
     * Method that gets all the initial data from the endpoint.
     *
     * @param endpoint the endpoint to be checked : String
     * @return list of all the data from the endpoint : List
     */
    public List<BankPojo> getInitialBankData(String endpoint) {
        RestAssured.baseURI = endpoint;
        RequestSpecification httpRequest = given();
        Response response = httpRequest.get("");

        JsonPath jsonPathEvaluator = response.jsonPath();

        List<BankPojo> allBankData = new ArrayList<>();

        try {
            allBankData = jsonPathEvaluator.getList(".", BankPojo.class);
        } catch (Exception e) {
            Reporter.error(String.valueOf(e));
        }

        return allBankData;
    }

    /**
     * Method that deletes all the data from the endpoint if the endpoint is not empty.
     *
     * @param endpoint the endpoint to be checked : String
     * @return treu if the endpoint is empty : boolean
     */
    public int deleteAllBankData(String endpoint) {
        List<BankPojo> allBankData = getInitialBankData(endpoint);
        if (allBankData.size() > 0) {
            for (BankPojo bankPojo : allBankData) {
                RestAssured.baseURI = endpoint;
                RequestSpecification httpRequest = given();
                Response response = httpRequest.delete("/" + bankPojo.getId());
                int statusCode = response.getStatusCode();
                if (statusCode != 200) {
                    return 400;
                } else {
                    Reporter.info("The data was deleted successfully");
                }

            }
        }
        return 200;
    }

    /**
     * Method that creates new data and sends it to the endpoint validating that there is no an empty duplicate.
     *
     * @param endpoint the endpoint to be checked : String
     * @return status code of the request : int
     */
    public int createBankData(String endpoint) {
        List<BankPojo> bankData = new ArrayList<>();
        List<Boolean> createdBankDataStatus = new ArrayList<>();

        Faker faker = new Faker();


        bankData.add(new BankPojo(faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(6000000, 9000000), faker.number().numberBetween(1000, 1000000), faker.options().option("withdrawal","payment","invoice","deposit"), faker.internet().emailAddress(), faker.random().nextBoolean().toString(), faker.address().country(), faker.phoneNumber().cellPhone()));
        bankData.add(new BankPojo(faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(6000000, 9000000), faker.number().numberBetween(1000, 1000000), faker.options().option("withdrawal","payment","invoice","deposit"), faker.internet().emailAddress(), faker.random().nextBoolean().toString(), faker.address().country(), faker.phoneNumber().cellPhone()));
        bankData.add(new BankPojo(faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(6000000, 9000000), faker.number().numberBetween(1000, 1000000), faker.options().option("withdrawal","payment","invoice","deposit"), faker.internet().emailAddress(), faker.random().nextBoolean().toString(), faker.address().country(), faker.phoneNumber().cellPhone()));
        bankData.add(new BankPojo(faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(6000000, 9000000), faker.number().numberBetween(1000, 1000000), faker.options().option("withdrawal","payment","invoice","deposit"), faker.internet().emailAddress(), faker.random().nextBoolean().toString(), faker.address().country(), faker.phoneNumber().cellPhone()));
        bankData.add(new BankPojo(faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(6000000, 9000000), faker.number().numberBetween(1000, 1000000), faker.options().option("withdrawal","payment","invoice","deposit"), faker.internet().emailAddress(), faker.random().nextBoolean().toString(), faker.address().country(), faker.phoneNumber().cellPhone()));
        bankData.add(new BankPojo(faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(6000000, 9000000), faker.number().numberBetween(1000, 1000000), faker.options().option("withdrawal","payment","invoice","deposit"), faker.internet().emailAddress(), faker.random().nextBoolean().toString(), faker.address().country(), faker.phoneNumber().cellPhone()));
        bankData.add(new BankPojo(faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(6000000, 9000000), faker.number().numberBetween(1000, 1000000), faker.options().option("withdrawal","payment","invoice","deposit"), faker.internet().emailAddress(), faker.random().nextBoolean().toString(), faker.address().country(), faker.phoneNumber().cellPhone()));
        bankData.add(new BankPojo(faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(6000000, 9000000), faker.number().numberBetween(1000, 1000000), faker.options().option("withdrawal","payment","invoice","deposit"), faker.internet().emailAddress(), faker.random().nextBoolean().toString(), faker.address().country(), faker.phoneNumber().cellPhone()));

        bankData.add(new BankPojo(faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(6000000, 9000000), faker.number().numberBetween(1000, 1000000), faker.options().option("withdrawal","payment","invoice","deposit"), "prueba@hotmail.com", faker.random().nextBoolean().toString(), faker.address().country(), faker.phoneNumber().cellPhone()));
        bankData.add(new BankPojo(faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(6000000, 9000000), faker.number().numberBetween(1000, 1000000), faker.options().option("withdrawal","payment","invoice","deposit"), "prueba@hotmail.com", faker.random().nextBoolean().toString(), faker.address().country(), faker.phoneNumber().cellPhone()));


        for (int i = 0; i < bankData.size(); i++) {
            for (int j = 0; j < bankData.size(); j++) {
                if (bankData.get(i).getEmail().equals(bankData.get(j).getEmail()) && i != j) {
                    bankData.remove(j);
                    Reporter.info("Se eliminó el registro " + j + " porque el email ya existe");
                }
            }
        }

        for (BankPojo bankPojo : bankData) {
            RestAssured.baseURI = endpoint;
            RequestSpecification httpRequest = given();
            httpRequest.header("Content-Type", "application/json");
            httpRequest.body(bankPojo);
            Response response = httpRequest.post("");
            int statusCode = response.getStatusCode();
            if (statusCode == 201) {
                createdBankDataStatus.add(true);
            } else {
                createdBankDataStatus.add(false);
            }
        }
        return 201;
    }

    /**
     * Method that verifies the data in the endpoint and verifies there is no a duplicate email.
     *
     * @param endpoint the endpoint to be checked : String
     * @return status code of the request : int
     */
    public int getAllBankDataAndVerifyEmail(String endpoint) {
        RestAssured.baseURI = endpoint;
        RequestSpecification httpRequest = given();
        Response response = httpRequest.get("");
        int statusCode = response.getStatusCode();

            List<BankPojo> bankData = response.jsonPath().getList("", BankPojo.class);
            for (int i = 0; i < bankData.size(); i++) {
                for (int j = 0; j < bankData.size(); j++) {
                    if (bankData.get(i).getEmail().equals(bankData.get(j).getEmail()) && i != j) {
                        Reporter.info("El email " + bankData.get(i).getEmail() + " se repite en los registros " + j);
                        statusCode = 400;
                    }
                }
            }
        return statusCode;
    }


    /**
     * Method that update the account Number of a bank data.
     *
     * @param endpoint the endpoint to be checked : String
     * @param newAccountNumber the account number to be updated : String
     * @param id the id of the bank data to be updated : String
     * @return status code of the request : int
     */
    public int updateBankData(String endpoint,int id, int newAccountNumber) {
        RestAssured.baseURI = endpoint;
        RequestSpecification httpRequest = given();
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body("{\"accountNumber\":\""+newAccountNumber+"\"}");
        Response response = httpRequest.put("/"+id);
        int statusCode = response.getStatusCode();
        return statusCode;
    }

}
