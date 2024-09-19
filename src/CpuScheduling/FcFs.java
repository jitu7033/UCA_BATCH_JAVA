package CpuScheduling;

import java.util.ArrayList;
import java.util.Scanner;

public class FcFs {

    static class fCFS {
        int process;
        int[] PID;
        int[] AT;
        int[] BT;
        int[] CT;
        int[] TAT;
        int[] WT;

        fCFS(int data) {
            this.process = data;
            PID = new int[process];
            AT = new int[process];
            BT = new int[process];
            CT = new int[process];
            TAT = new int[process];
            WT = new int[process];
        }

        Scanner sc = new Scanner(System.in);

        public void Input() {
            System.out.println("Enter your process Id: ");
            for (int i = 0; i < process; i++) {
                PID[i] = sc.nextInt();
            }
            System.out.println("Enter Your Arrival Time: ");
            for (int i = 0; i < process; i++) {
                AT[i] = sc.nextInt();
            }
            System.out.println("Enter Your Burst Time: ");
            for (int i = 0; i < process; i++) {
                BT[i] = sc.nextInt();
            }
        }

        private void fill() {
            int prevTime = 0;
            for (int i = 0; i < process; i++) {
                prevTime += BT[i];
                CT[i] = prevTime;
                TAT[i] = CT[i] - AT[i];
                WT[i] = TAT[i] - BT[i];
            }
        }

        public void calculateTimes() {
            fill();
        }

        public int getAvgWaitingTime() {
            int totalWT = 0;
            for (int i = 0; i < process; i++) {
                totalWT += WT[i];
            }
            return totalWT / process;
        }

        public int getAvgTAT() {
            int totalTAT = 0;
            for (int i = 0; i < process; i++) {
                totalTAT += TAT[i];
            }
            return totalTAT / process;
        }

        public int getAvgCompleteTime() {
            int totalCT = 0;
            for (int i = 0; i < process; i++) {
                totalCT += CT[i];
            }
            return totalCT / process;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of processes: ");
        int n = sc.nextInt();

        fCFS scheduler = new fCFS(n);
        scheduler.Input();
        scheduler.calculateTimes();

        System.out.println("Average Waiting Time: " + scheduler.getAvgWaitingTime());
        System.out.println("Average Turnaround Time: " + scheduler.getAvgTAT());
        System.out.println("Average Completion Time: " + scheduler.getAvgCompleteTime());
    }
}
