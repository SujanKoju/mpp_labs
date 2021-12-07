package lesson7.labs.test;

/**
 * @author kojusujan1111@gmail.com 06/12/21
 */

public interface Duck {
    default void swim() {
        System.out.println("Swimming");
    }

    void display();
}
