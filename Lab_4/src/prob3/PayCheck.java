package prob3;

/**
 * @author kojusujan1111@gmail.com 25/11/21
 */

public final class PayCheck {
    private final double grossPay;
    private final double fica;
    private final double state;
    private final double local;
    private final double medicare;
    private final double socialSecurity;

    public PayCheck(double grossPay, double fica, double state, double local, double medicare, double socialSecurity) {
        this.grossPay = grossPay;
        this.fica = fica;
        this.state = state;
        this.local = local;
        this.medicare = medicare;
        this.socialSecurity = socialSecurity;
    }

    @Override
    public String toString() {
        return "PayCheck{" +
                "grossPay=" + grossPay +
                ", fica=" + fica +
                ", state=" + state +
                ", local=" + local +
                ", medicare=" + medicare +
                ", socialSecurity=" + socialSecurity +
                '}';
    }

    public double getNetPay() {
        return grossPay - fica * grossPay - state * grossPay - local * grossPay - medicare * grossPay - socialSecurity * grossPay;
    }
}
