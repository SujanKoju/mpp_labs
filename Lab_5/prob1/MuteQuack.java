package prob1;

/**
 * @author kojusujan1111@gmail.com 26/11/21
 */

public class MuteQuack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("cannot quack");
    }
}
