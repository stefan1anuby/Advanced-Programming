public class App {
    public static void main(String[] args) throws Exception {
        
        //Compulsory
        City city = new City("Vaslui", 100, 200);
        Airport airport = new Airport("Baneasa", 1500, 2300);

        System.out.println(city.toString());
        System.out.println(airport.toString());

        Highway highway = new Highway("Filaturii", airport, city, 100 , 150);
        Country country = new Country("Mircea cel batran", city, airport, 200 , 150);

        System.out.println(highway.toString());
        System.out.println(country.toString());

        //Homework
        //TO DO: Write doc comments in your source code and generate the class documentation using javadoc.
        Problem problem = new Problem();
        problem.addLocation(airport);
        problem.addLocation(city);
        problem.addRoad(country);
        problem.addRoad(highway);

        /*
        DONT DO THIS :

        problem.addRoad(highway);

        DONT COMMENT problem.addLocation

        */
        
        problem.checkIfProblemIsValid();

        //Bonus
        Algorithm alg = new BFS(problem);
        Solution sol = alg.solve();
        System.out.println(sol);

    }
}
