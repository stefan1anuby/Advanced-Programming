public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Person stefan = new Person("Stefan");
        Person alex = new Person("Alex");
        Person mircea = new Person("Mircea");

        Company bitdefender = new Company("BitDefender");
        Company capicom = new Company("Capicom");
        Company amazon = new Company("Amazon");

        Network network = new Network();

        network.addNode(stefan);
        network.addNode(alex);
        network.addNode(mircea);

        network.addNode(bitdefender);
        network.addNode(capicom);
        network.addNode(amazon);

        System.out.println(network.toString());
    }
}
