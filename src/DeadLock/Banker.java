package DeadLock;

import java.util.Scanner;

public class Banker {
    int numberOfProcess;
    int numberOfResource;
    int[] process;
    int[] available;
    int[][] allocation;
    int[][] maxNeed;
    int[][] remaining;

    Banker(int n, int m){
        this.numberOfProcess = n;
        this.numberOfResource = m;
        this.process = new int[n];
        this.available = new int[m];
        this.allocation = new int[n][m];
        this.maxNeed = new int[n][m];
        this.remaining = new int[n][m];
    }

    public void inputData(int n, int m){
        Scanner sc = new Scanner(System.in);
        // input available resources
        System.out.println("Enter all available resources ");
        for(int i = 0; i < m; i++) {
            available[i] = sc.nextInt();
        }

        // input first your allocation
        System.out.println("Enter allocation resources ");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                allocation[i][j] = sc.nextInt();
            }
        }

        // input max need;
        System.out.println("Enter maxNeed resources");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                maxNeed[i][j] = sc.nextInt();
                remaining[i][j] = maxNeed[i][j] - allocation[i][j];
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(remaining[i][j]+" ");
            }
            System.out.println();
        }
    }

    public boolean bankerAlgo(){
        boolean progress = true;
        boolean []finish = new boolean[numberOfProcess];
        int k = 0;
        int count = 0;
        while(count < numberOfProcess && progress) {
            progress = false;
            for (int i = 0; i < numberOfProcess; i++) {
                boolean flag = true;
                if(!finish[i]){
                    for(int j = 0; j < numberOfResource; j++){
                        if(available[j] < remaining[i][j]){
                            flag = false;
                            break;
                        }
                    }
                    if(flag) {
                        for (int j = 0; j < numberOfResource; j++) {
                            this.available[j] += allocation[i][j];
                        }
                        finish[i] = true;
                        process[k++] = i;
                        progress = true;
                        count++;
                    }
                }
            }
        }
        // check deadlock occur or not
        for(int i = 0; i < numberOfProcess; i++){
            if(!finish[i])return false;
        }
        // print which process execute first
      for(int i = 0; i < numberOfProcess; i++){
          System.out.print(process[i]+" ");
      }
      System.out.println();
      return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Banker b = new Banker(n,m);
        b.inputData(n,m);
        System.out.println(b.bankerAlgo());
    }
}
