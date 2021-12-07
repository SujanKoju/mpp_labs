package prob1;

/**
 * @author kojusujan1111@gmail.com 26/11/21
 */

public class RedHeadDuck extends Duck{
    public RedHeadDuck() {
        super.setFlyBehavior(new FlyWithWings());
        super.setQuackBehavior(new Quack());
    }

    @Override
    void display() {
        System.out.println("--- " + this.getClass().getSimpleName() + " --- ");
    }
}
