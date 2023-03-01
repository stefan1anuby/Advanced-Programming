public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Hello, World!");

        String[] languages =  {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);
        System.out.println(n);
        
        n*= 3;
        n += Integer.parseInt("10101",2);
        n += Integer.parseInt("FF",16);
        n*= 6;
        System.out.println(n);

        int sum = n;
        while(sum > 9){
            int s=0;
            n = sum;
            while(n > 0)  
            {      
                int digit = n % 10;  
                s = s + digit;    
                n = n / 10;  
            }  
            sum = s;
        }
        System.out.println(sum);

        int result = sum;
        System.out.println( "Willy-nilly, this semester I will learn " + languages[result]);
    }
}
