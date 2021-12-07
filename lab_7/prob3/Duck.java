package lesson7.labs.prob3;

/**
 * @author kojusujan1111@gmail.com 26/11/21
 */

public abstract class Duck implements FlyBehavior,QuackBehavior {
    void swim() {
        System.out.println("swimming");
    }
    abstract void display();
}
