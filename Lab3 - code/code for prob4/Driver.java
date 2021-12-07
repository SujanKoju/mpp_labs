package prob1;

public class Driver {

    public static void main(String[] args) {
        House house1 = new House(9000);
        house1.address = new Address("100th Street", "Fairfield", "IOWA", 52557);

        House house2 = new House(9000);
        house2.address = new Address("40th Street", "Fairfield", "IOWA", 52557);


        Condo condo = new Condo(2);
        condo.address = new Address("30th Street", "Fairfield", "IOWA", 52557);

        Trailer trailer = new Trailer();
        trailer.address = new Address("100th Street", "Autombwa", "IOWA", 52557);

        Property[] properties = {house1,house2, condo, trailer};

        double totalRent = Admin.computeTotalRent(properties);
        System.out.println("--- TOTAL RENT = " + totalRent);
        System.out.println("----------");
        Admin.listPropertyLiesInCity(properties,"Fairfield");

    }
}
