public class App {
    public static void main(String[] args) throws Exception {

        Person stefan = new Person("Stefan");
        Programmer alex = new Programmer("Alex");
        Designer mircea = new Designer("Mircea");

        Company bitdefender = new Company("BitDefender");
        Company capicom = new Company("Capicom");
        Company amazon = new Company("Amazon");
        
        mircea.addRelationship(stefan, "best-frienddd");

        stefan.addRelationship(mircea, "best-friend");
        stefan.addRelationship(alex, "boss");

        alex.addRelationship(amazon, "company-1");
        alex.addRelationship(bitdefender, "company-2");
        alex.addRelationship(capicom, "company-3");

        Network network = new Network();

        network.addNode(stefan);
        network.addNode(alex);
        network.addNode(mircea);

        network.addNode(bitdefender);
        network.addNode(capicom);
        network.addNode(amazon);

        network.print();
    }
}
