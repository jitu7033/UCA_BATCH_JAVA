package Threading;

public class NewThreadExtends  extends Thread{

    NewThreadExtends(){
        // create a new Second thread

        super("Demo Thread");
        System.out.println("Child Thread : "+ this);

        start(); // start the thread
    }
    // this is entry point of the second thread
    public void run(){
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("child Thread  : " + i);
                sleep(500);
            }
        }catch(InterruptedException e){
            System.out.println("Child Interrupted .");
        }
        System.out.println("Exiting Child Thread .");
    }
}

class ExtendsThread{
    public static void main(String[] args) {
        new NewThreadExtends();  // create a new Thread

        try{
            for(int i = 5; i > 0; i--){
                System.out.println("Main Thread : "+ i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("Main Thread Interrupted . ");

        }
        System.out.println("Main Thread Exiting ");
    }
}
