package Threading;
// using join to wait for thread

public class UseOfJoinAndIsAlive{
}

class  NewThread implements Runnable{

    String name ; // name of thread
    Thread t;

    NewThread(String threadName){
        name = threadName;
        t = new Thread(this,name); // create a thread using class name
        System.out.println("New Thread :  " + t);
        t.start(); // start the thread

    }

    // this is the entry point of thread
    public void run(){
        try{
            for(int i = 5; i > 0; i--){
                System.out.println(name +"  : " + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println(name + "  Interrupted ");
        }
        System.out.println(name + " Exiting ");
    }
}

class DemoJoin{
    public static void main(String[] args) {
        NewThread obj1 = new NewThread("one");
        NewThread obj2 = new NewThread("two");
        NewThread obj3 = new NewThread("three");

        // check is thread is alive or not
        System.out.println("Thread One is Alive : " + obj1.t.isAlive());
        System.out.println("Thread two is Alive : " + obj2.t.isAlive());
        System.out.println("Thread three is Alive : " + obj3.t.isAlive());

        // wait for thread to finish

        try{
            obj1.t.join();
            obj2.t.join();
            obj3.t.join();
        }
        catch(InterruptedException e){
            System.out.println("Main Thread Interrupted");
        }

        System.out.println("Thread One is Alive : " + obj1.t.isAlive());
        System.out.println("Thread two is Alive : " + obj2.t.isAlive());
        System.out.println("Thread three is Alive : " + obj3.t.isAlive());

        System.out.println("Main Thread Exiting . ");
    }
}
