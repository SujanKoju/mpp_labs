package lesson7.labs.prob3;

/**
 * @author kojusujan1111@gmail.com 26/11/21
 */

public interface MuteQuack extends QuackBehavior{
     default void quack() {
        System.out.println("cannot quack");
    }
}
