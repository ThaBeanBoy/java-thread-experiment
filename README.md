# Java Thread Experiment
- [Description](#description)
- [Threads](#threads)
    + [ThreadExperiment Class](#threadexperiment-class)
    + [Executing Threads](#executing-threads)
    + [Explanation of Threads Execution](#explanation-of-threads-execution)
- [Exception Handling](#exception-handling)
    + [Throwing Exceptions](#throwing-exceptions)
    + [Handling Exceptions](#handling-exceptions)
## Description
I wanted to experiment with threads in Java. I also went through some other things that I found interesting such as exception handling.

In this, you'll find the following:

- Threads
- Exception Handling

## Threads

### ThreadExperiment Class
```java
public class ThreadExperiment implements Runnable {
    private String ThreadName;
    private int Reps;
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

```

At first, I decided to make the ThreadExperiment class inherit from the Thread class, but I then decided to implement the Runnable interface. The reason I decided to implement the Runnable interface was that it's possible for a class to implement multiple interfaces. The reason I think this is good practice is that in the event I may want other classes to inherit from a class that has threads. Honestly, I'm not sure if there's a scenario that I've mentioned above, but I firmly believe this is better than inheriting from the Thread class.

### Executing Threads

For context, ```numberOfThreads``` is an integer that's inputted by the user. It's supposed to represent the amount if threads the user wants to make.

```java
public class Main {
    public static void main(String[] args) {
        //Rest of Main function
        
        for(int i = 0; i < numberOfThreads; i++){
            Thread t = new Thread(new ThreadExperiment("Thread " + i, 5));
            t.start();
        }

        System.out.println("From Main Thread");
        
        //Rest of Main function
    }
}
```
Result (Input was 2):
```
How many threads would you like ? 2
From Main Thread
Thread 1 : 0
Thread 0 : 0
Thread 0 : 1
Thread 1 : 1
Thread 0 : 2
Thread 1 : 2
```

### Explanation of Threads Execution

In the loop of the ```ThreadExperiment``` class, there's a 1-second gap between each cycle because of the ```Thread. sleep(1000);``` method.

Although the Thread objects are instantiated & executed first (by the start method), **"From Main Thread"** will be displayed first, because of the 1-second delay in the Thread objects & because the Threads' run methods are being executed on a different thread.

## Exception Handling

```java
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
            
            // Multi thread part, (Already discussed above)
        }catch(InputMismatchException e){
            System.out.println("Please input an integer");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
```

I wanted to accomplish 2 main things with exception handling:
- Throwing Exceptions
- Handling Exceptions

### Throwing Exceptions
To make multiple threads, the user has to input a positive integer. In the try block, if the user inputs a negative number, an Exception will be thrown and tugged along with an error message. 

### Handling Exceptions
There were 2 exception that could occur:
- InputMismatchException - This exception would be thrown if the user doesn't input the an integer
- Exception - When catching this exception, it would catch an excepetion that I throw & would catch any unforeseen exceptions