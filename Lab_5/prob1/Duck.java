package prob1;

/**
 * @author kojusujan1111@gmail.com 26/11/21
 */

public abstract class Duck {
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    void swim() {
        System.out.println("swimming");
    }

    public void fly() {
        this.flyBehavior.fly();
    }

   public void quack() {
        this.quackBehavior.quack();
    }

    abstract void display();
}
