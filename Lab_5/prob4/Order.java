package prob4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kojusujan1111@gmail.com 27/11/21
 */

public class Order {
    private String name;
    private List<Item> items;

    Order(String name) {
        this.name = name;
        items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
