package prob4;

/**
 * @author kojusujan1111@gmail.com 27/11/21
 */

public class Customer {
    private String name;
    private Order order;

     Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
