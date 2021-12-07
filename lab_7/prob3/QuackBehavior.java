package lesson7.labs.prob3;

/**
 * @author kojusujan1111@gmail.com 26/11/21
 */

public interface QuackBehavior {
    default void quack() {
        System.out.println("quacking");
    }
}
