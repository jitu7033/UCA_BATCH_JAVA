package Threading;

public class currentThreadDemo {
    public static void main(String[] args) {

        Thread t = Thread.currentThread();
        System.out.println("current Thread : "+ " "+ t);

        // change the name of the thread
        t.setName("my Thread");

        System.out.println("After Name change : "+ t);



        try{
            for(int n = 5; n > 0; n--){
                System.out.println(n);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            System.out.println("Main Thread Interrupted");
        }
    }
}
