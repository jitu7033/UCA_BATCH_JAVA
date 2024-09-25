package CpuScheduling;

import java.util.Scanner;

public class roundRobin {
    public static class  Process{
        int id;
        int arrivalTime;
        int burstTime;
        int completionTime;
        int turnAroundTime;
        int waitingTime;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,quantum;
        System.out.println("Enter your process");
        n = sc.nextInt();
        System.out.println("Enter Your Time Quantum");
        quantum = sc.nextInt();
        Process []process = new Process[n];

        System.out.println("Enter Process Details ");
        for(int i = 0; i < n; i++){
            process[i] = new Process();
            System.out.println("Your process");
            process[i].id = i+1;
            System.out.println("Enter arrival time of Process Id: "+ (i+1));
            process[i].arrivalTime = sc.nextInt();
            System.out.println("Enter Burst time of Process Id: "+ (i+1));
            process[i].burstTime = sc.nextInt();
        }

        calculateTime(process,n,quantum);
        calculateTurnAroundTime(process,n);
        calculateWaitingTime(process,n);
        printTable(process,n);
    }

    private static void calculateTime(Process[] process, int n, int quantum) {
        int []remainingTime = new int[n];
        for(int i = 0; i < n; i++){
           remainingTime[i] = process[i].burstTime;
        }
        int ct = 0;
        boolean allDone = false;
        while(!allDone){
            /* Code */
            allDone = true;
            for(int i = 0; i < n; i++) {
                if (remainingTime[i] > 0) {
                    allDone = false;
                    if(remainingTime[i] > quantum){
                        ct = ct+quantum;
                       remainingTime[i] -= quantum;
                    }
                    else{
                        ct = ct + remainingTime[i];
                        process[i].completionTime = ct;
                        remainingTime[i] = 0;
                    }
                }
            }
        }
    }

    private static void calculateTurnAroundTime(Process[] process, int n) {
        for(int i = 0; i < n; i++){
            process[i].turnAroundTime = process[i].completionTime - process[i].arrivalTime;
        }
    }
    private static void calculateWaitingTime(Process[] process, int n) {
        for(int i = 0; i < n; i++){
            process[i].waitingTime = process[i].turnAroundTime - process[i].burstTime ;
        }
    }

    private static void printTable(Process[] process, int n) {
        for(int i = 0; i < n; i++){
            System.out.println("PID AT BT CT TAT WT ");
            System.out.println(" "+process[i].id + "  "+process[i].arrivalTime +"  "+process[i].burstTime +"  "+   process[i].completionTime+ "  "+ process[i].turnAroundTime +"  " + process[i].waitingTime);
        }
    }


}
