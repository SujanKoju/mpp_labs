package prob1;

/**
 * @author kojusujan1111@gmail.com 26/11/21
 */

public class DecoyDuck extends Duck{
    public DecoyDuck() {
        super.setFlyBehavior(new CannotFly());
        super.setQuackBehavior(new MuteQuack());
    }

    @Override
    void display() {
        System.out.println("--- " + this.getClass().getSimpleName() + " --- ");
    }
}
