import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        final Scanner Read = new Scanner(System.in);

        try{
            System.out.print("How many threads would you like ? ");
            int numberOfThreads = Read.nextInt();

            if(numberOfThreads < 0)
                throw new Exception("Invalid positive integer");
            else if( numberOfThreads == 0)
                System.out.println("NB: There won't be any threads");

            for(int i = 0; i < numberOfThreads; i++){
                Thread t = new Thread(new ThreadExperiment("Thread " + i, 3));
                t.start();
            }

            System.out.println("From Main Thread");
        }catch(InputMismatchException e){
            System.out.println("Please input an integer");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}