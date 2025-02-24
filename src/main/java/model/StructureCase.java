package model;

public class StructureCase {
    private String name;
    private String email;
    private int balance;


    public boolean isValid() {
        return (name != null && !name.isEmpty()) &&
                (email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) &&
                (balance >= 0);
    }
    @Override
    public String toString() {
        return "TestCase{name='" + name + "', email='" + email + "', balance=" + balance + "}";
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
