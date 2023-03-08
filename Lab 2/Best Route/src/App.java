public class App {
    public static void main(String[] args) throws Exception {
        //Locations
        City city = new City("Vaslui", 100, 200);
        Airport airport = new Airport("Baneasa", 1500, 2300);

        System.out.println(city.toString());
        System.out.println(airport.toString());

        //Roads
        Highway highway = new Highway("Filaturii", airport, city, 100 , 150);
        Country country = new Country("Mircea cel batran", city, airport, 200 , 150);

        System.out.println(highway.toString());
        System.out.println(country.toString());

    }
}
