public class ThreadExperiment implements Runnable {
    private final String ThreadName;
    private final int Reps;
    public ThreadExperiment(String ThreadName, int Reps){
        this.ThreadName = ThreadName;
        this.Reps = Reps;
    }

    @Override
    public void run(){
        for(int i = 0; i < this.Reps; i++){
            System.out.println(this.ThreadName + " : " + i);

            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                System.out.println("Sleep has been interrupted");
            }
        }
    }
}
