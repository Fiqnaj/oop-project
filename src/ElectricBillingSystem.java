import java.util.ArrayList;
import java.util.Scanner;

public class ElectricBillingSystem {
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Menu-driven loop for user interaction
        int choice;
        do {
            System.out.println("\nElectric Billing System Menu:");
            System.out.println("1. Add Customer");
            System.out.println("2. Enter Meter Reading");
            System.out.println("3. Generate Bill");
            System.out.println("4. Display All Customers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCustomer(customers, scanner);
                    break;
                case 2:
                    enterMeterReading(customers, scanner);
                    break;
                case 3:
                    generateBill(customers, scanner);
                    break;
                case 4:
                    displayAllCustomers(customers);
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 5);

        scanner.close();
    }

    // Method to add a new customer
    private static void addCustomer(ArrayList<Customer> customers, Scanner scanner) {
        System.out.println("\nAdding a new customer...");
        System.out.print("Enter Customer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Customer Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Customer Contact: ");
        String contact = scanner.nextLine();

        Customer customer = new Customer(id, name, address, contact);
        customers.add(customer);
        System.out.println("Customer added successfully!");
    }

    // Method to enter meter readings for a customer
    private static void enterMeterReading(ArrayList<Customer> customers, Scanner scanner) {
        System.out.println("\nEnter Meter Reading for a Customer...");
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        Customer foundCustomer = findCustomerById(customers, customerId);

        if (foundCustomer != null) {
            System.out.print("Enter Meter ID: ");
            int meterId = scanner.nextInt();
            System.out.print("Enter Previous Reading: ");
            double previousReading = scanner.nextDouble();
            System.out.print("Enter Current Reading: ");
            double currentReading = scanner.nextDouble();

            ElectricMeter meter = new ElectricMeter(meterId, previousReading, currentReading);
            foundCustomer.setMeter(meter);
            System.out.println("Meter reading added successfully!");
        } else {
            System.out.println("Customer not found!");
        }
    }

    // Method to generate a bill for a customer
    private static void generateBill(ArrayList<Customer> customers, Scanner scanner) {
        System.out.println("\nGenerate Bill for a Customer...");
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        Customer foundCustomer = findCustomerById(customers, customerId);

        if (foundCustomer != null && foundCustomer.getMeter() != null) {
            ElectricMeter meter = foundCustomer.getMeter();
            ElectricBill bill = new ElectricBill(foundCustomer, meter);
            bill.displayBill();
        } else {
            System.out.println("Customer or meter details not found!");
        }
    }

    // Method to display all customers and their details
    private static void displayAllCustomers(ArrayList<Customer> customers) {
        System.out.println("\nAll Customers:");
        for (Customer customer : customers) {
            System.out.println("Customer ID: " + customer.getId());
            System.out.println("Name: " + customer.getName());
            System.out.println("Address: " + customer.getAddress());
            System.out.println("Contact: " + customer.getContact());
            System.out.println("--------------------------------");
        }
    }

    // Method to find a customer by ID
    private static Customer findCustomerById(ArrayList<Customer> customers, int id) {
        for (Customer customer : customers) {
            if (id == customer.getId()) {
                return customer;
            }
        }
        return null;
    }
}
