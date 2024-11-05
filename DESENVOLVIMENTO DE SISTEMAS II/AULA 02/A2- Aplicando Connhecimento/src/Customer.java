public class Customer {
    private String customerId;
    private String name;
    private String email;
    private String phoneNumber;

    public Customer(String customerId, String name, String email, String phoneNumber) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    
    public void printCustomerSummary() {
        printCustomerId();
        printCustomerName();
        printCustomerEmail();
        printCustomerPhone();
    }

    private void printCustomerId() {
        System.out.println("Customer ID: " + customerId);
    }

    private void printCustomerName() {
        System.out.println("Name: " + name);
    }

    private void printCustomerEmail() {
        System.out.println("Email: " + email);
    }

    private void printCustomerPhone() {
        System.out.println("Phone Number: " + phoneNumber);
    }

    
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}