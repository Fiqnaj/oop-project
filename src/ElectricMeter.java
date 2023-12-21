public class ElectricMeter {
    private int meterId;
    private double previousReading;
    private double currentReading;

    public ElectricMeter(int meterId, double previousReading, double currentReading) {
        this.meterId = meterId;
        this.previousReading = previousReading;
        this.currentReading = currentReading;
    }

    public double calculateConsumption() {
        return currentReading - previousReading;
    }

    public int getMeterId() {
        return meterId;
    }

    public double getPreviousReading() {
        return previousReading;
    }

    public double getCurrentReading() {
        return currentReading;
    }

    // Setters for readings
    public void setPreviousReading(double previousReading) {
        this.previousReading = previousReading;
    }

    public void setCurrentReading(double currentReading) {
        this.currentReading = currentReading;
    }
}
