import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
    public static void main(String[] args) {
        final Scanner Read = new Scanner(System.in);

        try{
            System.out.print("How many threads would you like ? ");
            int numberOfThreads = Read.nextInt();
            for(int i = 0; i < numberOfThreads; i++){
                Thread t = new Thread(new ThreadExperiment("Thread " + i, 5));
                t.start();
            }

            System.out.println("From Main Thread");
        }catch(InputMismatchException e){
            System.out.println("Please input an integer");
        }
    }
}