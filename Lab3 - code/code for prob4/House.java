package prob1;

/**
 * @author kojusujan1111@gmail.com 24/11/21
 */

public class House extends Property {
    private double lotSize;

    public House(double lotSize) {
        this.lotSize = lotSize;
    }

    @Override
    double calculateRent() {
        return 0.1 * this.lotSize;
    }

}
