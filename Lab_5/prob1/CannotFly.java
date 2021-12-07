package prob1;

/**
 * @author kojusujan1111@gmail.com 26/11/21
 */

public class CannotFly implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("cannot fly");
    }
}
