package Threading;

// here is the example of create a new thread and start it running


// create a second thread
public class NewThreadRunnable  implements Runnable{

    Thread t;
    NewThreadRunnable(){
        // create a new second Thread
        t = new Thread(this,"Demo Thread");

        System.out.println("child Thread : "+ t);
        t.start();  // start the thread

    }

    @Override
    // This the Entry point of the second thread
    public void run() {
        try{
            for(int i = 5; i > 0; i--){
                System.out.println("Child Thread : " + i);
                Thread.sleep(500);
            }
        }catch(InterruptedException e){
            System.out.println("child Interrupted");
        }
        System.out.println("Exiting Child Thread");
    }
}

class ThreadDemo{
    public static void main(String[] args) {
        new NewThreadRunnable(); // create a new Thread;

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main Thread : " + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("Main Thread Interrupted");
        }
        System.out.println("Main Thread Exiting .");
    }
}
