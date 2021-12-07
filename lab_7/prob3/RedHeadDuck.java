package lesson7.labs.prob3;

/**
 * @author kojusujan1111@gmail.com 26/11/21
 */

public class RedHeadDuck extends Duck {

    @Override
    void display() {
        System.out.println("--- " + this.getClass().getSimpleName() + " --- ");
    }
}
