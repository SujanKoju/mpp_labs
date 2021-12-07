package prob1;

/**
 * @author kojusujan1111@gmail.com 26/11/21
 */

public class RubberDuck extends Duck {
    public RubberDuck() {
        super.setFlyBehavior(new CannotFly());
        super.setQuackBehavior(new Squeak());
    }

    @Override
    void display() {
        System.out.println("--- " + this.getClass().getSimpleName() + " --- ");
    }
}
