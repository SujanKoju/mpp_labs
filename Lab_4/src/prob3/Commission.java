package prob3;

import java.util.List;

/**
 * @author kojusujan1111@gmail.com 25/11/21
 */

public class Commission extends Employee {
    private double commission;
    private double baseSalary;
    private List<Order> orders;

    public Commission(String empId, double commission, double baseSalary, List<Order> orders) {
        super(empId);
        this.commission = commission;
        this.baseSalary = baseSalary;
        this.orders = orders;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }


    @Override
    public double calcGrossPay(int month, int year) {
        return baseSalary + calculateCommissionAmount(month, year, commission, orders);
    }

    private double calculateCommissionAmount(int month, int year, double commissionPercentage, List<Order> orders) {
        double commissionAmount = 0;
        for (Order order : orders) {
            if (year == order.getOrderDate().getYear() && month - 1 == order.getOrderDate().getMonthValue()) {
                commissionAmount += order.getOrderAmount() * commissionPercentage;
            }
        }
        return commissionAmount;
    }
}
