import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Customer implements Comparable<Customer> {
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private String phoneNumber;
    private String creditCardNumber;
    private String bankAccountNumber;

    public Customer(String lastName, String firstName, String middleName, String address,
                    String phoneNumber, String creditCardNumber, String bankAccountNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.creditCardNumber = creditCardNumber;
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + middleName + " - " + creditCardNumber;
    }

    @Override
    public int compareTo(Customer other) {
        return this.lastName.compareTo(other.lastName);
    }
}

class CustomerList {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Андрій", "Автомат", "Андрійович", "Львів", "0956431255", "44411122231223", "3333333333333333"));
        customers.add(new Customer("Богдан", "Баротрумович", "Богданович", "Львів", "0987654321", "444112337878", "2222222222222222"));
        customers.add(new Customer("Валентин", "Iнвокер", "Валентинович", "Львів", "0996643009", "441144223321", "1111111111111111"));

        Collections.sort(customers);

        System.out.println("(10.1) Список покупцiв у алфавiтному порядку:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        String startCardNumber = "4441000000000000";
        String endCardNumber = "4442000000000000";

        System.out.println("\n(10.2) Список покупцiв з номером кредитной картки у заданому iнтервалi:");
        for (Customer customer : customers) {
            String cardNumber = customer.getCreditCardNumber();
            if (cardNumber.compareTo(startCardNumber) >= 0 && cardNumber.compareTo(endCardNumber) <= 0) {
                System.out.println(customer);
            }
        }
    }
}