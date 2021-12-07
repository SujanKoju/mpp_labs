package prob4;

/**
 * @author kojusujan1111@gmail.com 27/11/21
 */

public class CustomerOrderImpl implements CustomerOrder{
    private Customer customer;

    public CustomerOrderImpl(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }
}
