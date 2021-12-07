package prob3;

/**
 * @author kojusujan1111@gmail.com 25/11/21
 */

public class Salaried extends Employee{
    private double salary;

    public Salaried(String empId,double salary) {
        super(empId);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double calcGrossPay(int month, int year) {
        return salary;
    }
}
