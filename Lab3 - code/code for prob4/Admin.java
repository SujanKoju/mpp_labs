package prob1;

public class Admin {
    public static double computeTotalRent(Property[] properties) {
        double totalRent = 0;
        for (Property property : properties) {
            totalRent += property.calculateRent();
        }
        return totalRent;
    }

    public static void  listPropertyLiesInCity(Property[] properties,String city) {
        for (Property property : properties) {
           if (property.address.getCity().equalsIgnoreCase(city)){
               System.out.println("Property Type : " + property.getClass().getSimpleName() + "  " + property.address.toString());
           }
        }
    }
}
