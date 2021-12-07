package lesson7.labs.prob4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class ForEachExample {
    private class MyConsumer implements Consumer<String> {
        @Override
        public void accept(String s) {
            System.out.print(s.toUpperCase()+" ");
        }
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon",
                "Away", "On Vacation", "Everywhere you want to be");
        MyConsumer myConsumer = new ForEachExample().new MyConsumer();
        list.forEach(myConsumer);
    }
}
