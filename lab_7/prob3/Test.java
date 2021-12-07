package lesson7.labs.prob3;

/**
 * @author kojusujan1111@gmail.com 26/11/21
 */

public class Test {
    public static void main(String[] args) {
        Duck[] ducks = {new MallardDuck(), new DecoyDuck(), new RedHeadDuck(), new RubberDuck()};
        for (Duck duck : ducks) {
            duck.display();
            duck.fly();
            duck.quack();
            duck.swim();
        }
    }
}
