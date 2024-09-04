public class priorityQueue {
    private Integer []pq;
    private int n;

    priorityQueue(int capacity){
        this.pq = new Integer[capacity+1];

    }

    public void insert(int x){
        this.pq[++n] = x;
        swim(n);
    }

    public Integer delMax(){
        int max = this.pq[1];
        exch(1, n--);
        sink(1);
        this.pq[n+1] = null;
        return max;
    }

    private void sink(int k) {
        while(2*k <= n){
            int j = 2*k;
            if(j < n && this.pq[j] < this.pq[j+1]) j++;
            if(this.pq[j] >= this.pq[j+1])break;
            exch(k , j);
            k = j;
        }
    }

    boolean isEmpty(){
        return this.n == 0;
    }

    public  Integer size(){
        return this.n;
    }

    private void swim(int k) {
        while(k > 1 && this.pq[k/2] < this.pq[k]){
            this.exch(k, k/2);
            k = k/2;
        }
    }

    private void exch(int i,  int j) {
        Integer temp = this.pq[i];
        this.pq[i] = this.pq[j];
        this.pq[j] = temp;
    }

    public void printPq(){
        for(int i = 1; i<=n; i++){
            System.out.print(this.pq[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        priorityQueue pq = new priorityQueue(5);
        pq.insert(10);
        pq.insert(23);
        pq.insert(2);
        pq.insert(34);
        pq.printPq();

        pq.delMax();
        pq.printPq();

        // it is working good
    }
}

