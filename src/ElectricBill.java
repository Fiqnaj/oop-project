public class ElectricBill {
    private Customer customer;
    private ElectricMeter meter;
    private double totalAmount;

    public ElectricBill(Customer customer, ElectricMeter meter) {
        this.customer = customer;
        this.meter = meter;
        this.totalAmount = calculateBillAmount();
    }

    private double calculateBillAmount() {
        double consumption = meter.calculateConsumption();
        double rate = 0.10; // Example rate per unit
        return consumption * rate;
    }

    public void displayBill() {
        System.out.println("\nBill Details:");
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Address: " + customer.getAddress());
        System.out.println("Contact: " + customer.getContact());
        System.out.println("Meter ID: " + meter.getMeterId());
        System.out.println("Previous Reading: " + meter.getPreviousReading());
        System.out.println("Current Reading: " + meter.getCurrentReading());
        System.out.println("Total Amount: $" + totalAmount);
    }
}