package lesson7.labs.prob3;

/**
 * @author kojusujan1111@gmail.com 26/11/21
 */

public interface FlyBehavior {
    default void fly() {
        System.out.println("fly with wings");
    }
}
