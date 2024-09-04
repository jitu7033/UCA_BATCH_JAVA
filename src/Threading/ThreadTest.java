package Threading;

import java.util.ArrayList;
import java.util.List;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {


            long startTime = System.currentTimeMillis();
            List<Integer> l = new ArrayList<>();


            Thread t1 = new Thread(new TestThread.ListAdder(l, 1), "First");
            Thread t2 = new Thread(new TestThread.ListAdder(l, 2), "Second");
            Thread t3 = new Thread(new TestThread.ListAdder(l, 3), "Third");
            Thread t4 = new Thread(new TestThread.ListAdder(l, 4), "Fourth");

            t1.start();
            t2.start();
            t3.start();
            t4.start();

            System.out.println(Thread.currentThread().getName() + " is adding number 5");

            l.add(5);


            t1.join();
            t2.join();
            t3.join();
            t4.join();


            System.out.println(l);


            System.out.println("Total Time Taken :- " + (System.currentTimeMillis() - startTime));



    }
    private static class ListAdder extends  Thread{
        private int i;
        private List<Integer> l;
        ListAdder(List<Integer>l, int i){
            this.i = i;
            this.l = l;
        }
        public void run(){

            // mutex

            synchronized (this.l){
                this.l.add(i);
                System.out.println(Thread.currentThread().getName() + " is adding number 5");
            }


            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }

    }
}
