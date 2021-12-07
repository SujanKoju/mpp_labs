package prob1;

/**
 * @author kojusujan1111@gmail.com 24/11/21
 */

public class Condo extends Property {
    private int noOfFloors;
    public Condo(int noOfFloors) {
        this.noOfFloors = noOfFloors;
    }

    @Override
    double calculateRent() {
        return 400 * this.noOfFloors;
    }
}
