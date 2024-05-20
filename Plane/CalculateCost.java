package Plane;

public class CalculateCost {
    private String from;
    private String to;
    private String travelClass;

    public CalculateCost(String from, String to, String travelClass) {
        this.from = from;
        this.to = to;
        this.travelClass = travelClass;
    }

    // Inside the CalculateCost class

public double calculateCost() {
    double baseCost = 100.0;  // Base cost for the journey
    double distanceMultiplier = 0.1;  // Cost increases by 10% for each unit of distance
    // Business class costs 50% more, First Class costs 100% more

    // Calculate the distance between the 'from' and 'to' locations
    int distance = calculateDistance(from, to);

    // Calculate cost based on distance and class
    double cost = baseCost + (distance * distanceMultiplier) ;

    return cost;
}

private int calculateDistance(String from, String to) {
    // Replace this with your actual distance calculation logic
    // For the sake of example, let's assume the following distances:
    // Dhaka to Nepal: 1500 km
    // Dhaka to Thailand: 2500 km
    // Dhaka to Japan: 4000 km
    // Dhaka to Bhutan: 1000 km
    // Dhaka to China: 3000 km
    // Dhaka to India: 2000 km

    if (from.equals("Dhaka") && to.equals("Nepal")) {
        return 1500;
    } else if (from.equals("Dhaka") && to.equals("Thailand")) {
        return 2500;
    } else if (from.equals("Dhaka") && to.equals("Japan")) {
        return 4000;
    } else if (from.equals("Dhaka") && to.equals("Bhutan")) {
        return 1000;
    } else if (from.equals("Dhaka") && to.equals("China")) {
        return 3000;
    } else if (from.equals("Dhaka") && to.equals("India")) {
        return 2000;
    } else {
        return 0; // Return 0 if the combination is not found
    }
}

}
