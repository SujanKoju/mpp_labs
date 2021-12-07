package prob3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kojusujan1111@gmail.com 26/11/21
 */

public class Test {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList();
        orders.add(new Order("100", LocalDate.of(2019, 9, 1),200));
        orders.add(new Order("100",LocalDate.of(2019, 9, 10),100));
        Employee[] employees = {
                new Salaried("121",4000),
                new Hourly("122",15.67,20),
                new Commission("123",0.8,500,orders)};
        for(Employee employee :employees){
            employee.print(10,2019);}
    }
}
