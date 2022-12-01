public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(new ThreadExperiment("Secondary", 5));

        t.start();
        System.out.println("From Main Thread");
    }
}