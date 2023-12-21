public class Customer {
    private int id;
    private String name;
    private String address;
    private String contact;
    private ElectricMeter meter;

    public Customer(int id, String name, String address, String contact) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public void setMeter(ElectricMeter meter) {
        this.meter = meter;
    }

    public ElectricMeter getMeter() {
        return meter;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    // Additional setters for other customer details
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    // Additional getters for other customer details

    public int getId() {
        return id;
    }
}