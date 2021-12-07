package prob1;

import java.util.ArrayList;

/**
 * @author kojusujan1111@gmail.com 26/11/21
 */

public class MallardDuck extends Duck {
    public MallardDuck() {
        super.setFlyBehavior(new FlyWithWings());
        super.setQuackBehavior(new Quack());
        ArrayList
    }

    @Override
    void display() {
        System.out.println("--- " + this.getClass().getSimpleName() + " --- ");
    }
}
