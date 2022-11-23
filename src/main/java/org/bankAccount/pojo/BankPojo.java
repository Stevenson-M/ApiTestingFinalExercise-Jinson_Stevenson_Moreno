package org.bankAccount.pojo;

public class BankPojo {
    private int id;
    private String name;
    private String lastName;
    private int  accountNumber;
    private int amount;
    private String transactionType;
    private String email;
    private String active;
    private String country;
    private String telephone;

    /**
     * Constructor method.
     *
     */
    public BankPojo() {
    }

    /**
     * Constructor method.
     *
     * @param name  the name of the user in the bank : String
     * @param lastName the last name of the user in the bank : String
     * @param accountNumber the account number of the user in the bank : int
     * @param amount the amount of the user in the bank : int
     * @param transactionType the transaction type of the user in the bank : String
     * @param email the email of the user in the bank : String
     * @param active the active of the user in the bank : String
     *                                                                                                      @param country the country of the user in the bank : String
     *                                                                                                                     @param telephone the telephone of the user in the bank : String
     */
    public BankPojo(String name, String lastName, int accountNumber, int amount, String transactionType, String email, String active, String country, String telephone) {
        this.name = name;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionType = transactionType;
        this.email = email;
        this.active = active;
        this.country = country;
        this.telephone = telephone;
    }

    /**
     * Getter method for the id.
     * @return  id of the user in the bank : int
     */
    public int getId() {
        return id;
    }

    /**
     * Setter method for the id.
     * @param id the id of the user in the bank : int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter method for the name.
     * @return  name of the user in the bank : String
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for the name.
     * @param name the name of the user in the bank : String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for the last name.
     * @return  last name of the user in the bank : String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter method for the last name.
     * @param lastName the last name of the user in the bank : String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter method for the account number.
     * @return  account number of the user in the bank : int
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Setter method for the account number.
     * @param accountNumber the account number of the user in the bank : int
     */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Getter method for the amount.
     * @return  amount of the user in the bank : int
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Setter method for the amount.
     * @param amount the amount of the user in the bank : int
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * Getter method for the transaction type.
     * @return  transaction type of the user in the bank : String
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * Setter method for the transaction type.
     * @param transactionType the transaction type of the user in the bank : String
     */
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * Getter method for the email.
     * @return  email of the user in the bank : String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for the email.
     * @param email the email of the user in the bank : String
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter method for the active.
     * @return  active of the user in the bank : String
     */
    public String getActive() {
        return active;
    }

    /**
     * Setter method for the active.
     * @param active the active of the user in the bank : String
     */
    public void setActive(String active) {
        this.active = active;
    }

    /**
     * Getter method for the country.
     * @return  country of the user in the bank : String
     */
    public String getCountry() {
        return country;
    }

    /**
     * Setter method for the country.
     * @param country the country of the user in the bank : String
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Getter method for the telephone.
     * @return  telephone of the user in the bank : String
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Setter method for the telephone.
     * @param telephone the telephone of the user in the bank : String
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}

