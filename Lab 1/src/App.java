public class App {
    public static void main(String[] args) throws Exception {

        long startTime = System.nanoTime();

        System.out.println("------------- Compulsory -------------");

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

        //HOMEWORK
        System.out.println("------------- Homework -------------");
        
        try  
        {  
            n = Integer.parseInt(args[0]);   
        }  
        catch (NumberFormatException error)  
        {  
            System.out.println("NumberFormatException: " + error.getMessage());  
        } 
        catch(ArrayIndexOutOfBoundsException error)
        {  
            System.out.println("No input from commandline , i will set the matrix size to 5");
            n = 5;  
        } 

        int matrix[][] = new int[n][n];

        for (int i = 0; i < n ; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = ((i + j) % n) + 1;
            }
        }
        
        if(n < 10000){

            System.out.println("Printing every row");
            
            for(int i = 0 ; i < n ; i++){
                StringBuilder row = new StringBuilder();
                for(int j = 0 ; j < n ; j++){
                    row.append(matrix[i][j]);
                }
                System.out.println(row);
            }
            
            System.out.println("Printing every column");
            
            for(int i = 0 ; i < n ; i++){
                StringBuilder column = new StringBuilder();
                for(int j = 0 ; j < n ; j++){
                    column.append(matrix[i][j]);
                }
                System.out.println(column);
            }
        }
        else{            
            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println("The execution time in nanoseconds is : " + totalTime);
        }
        // BONUS
        System.out.println("------------- Bonus -------------");
        n = 10;
        int[][] A = new int[n][n];

        for (int i = 0; i < n; i++) {
            A[i][(i+1) % n] = 1;
            A[(i+1) % n][i] = 1;
        }
        System.out.println("Adjacency matrix A:");
        printMatrix(A);

        // Compute the powers A2, A3, ..., An
        int[][] An = new int[n][n];
        An = A;
        for (int i = 2; i <= n; i++) {
            An = matrixMultiplication(An, A);
        }

        System.out.println("Matrix An:");
        printMatrix(An);
    }

    public static int[][] matrixMultiplication(int[][] A, int[][] B) {
        int len = A.length;
        int[][] C = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
