package Bank;

public class BankAccount {
    private String accountNumber;
    private int pin;
    private double balance;
    private String firstName;
    private String lastName;
    private String address;
    private String contact;
    private String gender;
    private String email;
    private String accountType;

    public BankAccount(String accountNumber, int pin, double balance, String firstName, String lastName, String address, String contact, String gender, String email, String accountType) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contact = contact;
        this.gender = gender;
        this.email = email;
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
