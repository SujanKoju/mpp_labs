package lesson7.labs.prob3;

/**
 * @author kojusujan1111@gmail.com 26/11/21
 */

public class DecoyDuck extends Duck implements CannotFly, MuteQuack {
    @Override
    void display() {
        System.out.println("--- " + this.getClass().getSimpleName() + " --- ");
    }
}
