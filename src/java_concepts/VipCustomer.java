package java_concepts;

public class VipCustomer {
    private String name;
    private double creditLimit;
    private String emailID;

    public VipCustomer() {
        this("jon doe", 100.00, "jdoe@abc.com");
    }
    public VipCustomer(String name, double creditLimit, String emailID) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.emailID = emailID;
    }
    public VipCustomer(String name, double creditLimit) {
        this(name,creditLimit,"jdoe@abc.com");
    }

    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }
    public String getEmailID() {
        return emailID;
    }
}