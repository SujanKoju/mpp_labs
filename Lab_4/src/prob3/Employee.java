package prob3;

/**
 * @author kojusujan1111@gmail.com 25/11/21
 */

public abstract class Employee {
    protected String empId;

    public Employee(String empId) {
        this.empId = empId;
    }

    public PayCheck calcCompensation(int month, int year) {
        double grossPay = calcGrossPay(month, year);
        return new PayCheck(grossPay, 0.23, 0.05, 0.01, 0.03, 0.075);
    }

    public abstract double calcGrossPay(int month, int year);

    public void print(int month, int year) {
        PayCheck payCheck = this.calcCompensation(month, year);
        System.out.println("Employee ID = " + this.empId);
        System.out.println(payCheck);
        System.out.println("Net Pay = " + payCheck.getNetPay());
        System.out.println("----- -----");
    }
}
