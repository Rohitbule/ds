import java.util.Scanner;

public class Berkeley {
    public static void main(String[] args) {
        System.out.println("Program Started");
        Scanner sc = new Scanner(System.in);

        System.out.print("\n Enter the number of processes: ");
        int n = sc.nextInt();

        int[] times = new int[n];
        System.out.println("Enter the clock times of processes:");
        for (int i = 0; i < n; i++) {
            System.out.print("Process " + (i + 1) + ": ");
            times[i] = sc.nextInt();
        }

        int sum = 0;
        for (int time : times) {
            sum += time;
        }

        int average = sum / n;
        System.out.println("Average time: " + average);

        System.out.println("Adjusted times:");
        for (int i = 0; i < n; i++) {
            int adjustment = average - times[i];
            System.out.println("Process " + (i + 1) + ": " + (times[i] + adjustment));
        }

        sc.close();
    }
}






























/*PS C:\Users\HP\Desktop\chitu\Assignment 7> javac BerkeleyAlgorithm.java
PS C:\Users\HP\Desktop\chitu\Assignment 7> java BerkeleyAlgorithm
Enter the number of processes: 4
Enter the clock times of processes:
Process 1: 100
Process 2: 200
Process 3: 150
Process 4: 180
Average time: 157
Adjusted times:
Process 1: 157
Process 2: 157
Process 3: 157
Process 4: 157
PS C:\Users\HP\Desktop\chitu\Assignment 7>  */






/*
 * 
 * 
 Berkeley Algorithm (Simple Explanation)
The Berkeley Algorithm is a clock synchronization technique used in distributed systems. When multiple devices or processes run on different clocks,
 their times may drift apart. Berkeley Algorithm adjusts these clocks to synchronize them based on their average time.

Key Features
Centralized Control:
    One process (called the "coordinator") collects the times from all processes.
Adjustment:
    The coordinator calculates the average time and tells each process how to adjust its clock.
No Absolute Time:
    It doesn’t rely on a single true time but instead finds a consensus among all processes.
Steps in the Algorithm

Coordinator Collects Times:
    The central process asks all other processes for their current clock times.
Calculate Average Time:

The coordinator calculates the average time from all collected times:
Average Time =    Sum of Times / Number of Processes

 
Adjust Times:
    Each process adjusts its clock to the average by adding or subtracting the difference.

Berkeley Algorithm in Simple Steps
1. Start with different clocks for each process.
2. Select a coordinator process.
3. Coordinator:
    Asks each process for its clock time.
    Computes the average time.
    Sends the adjustment values to all processes.
4.Each process adjusts its clock based on the coordinator’s instructions.
Theory with Diagram
Example:

Process	ClockTime	Adjustment Needed	New Time
P1	    100	            +57	                157
P2	    200	            -43	                157
P3	    150	            +7	                157
P4	    180	            -23	                157

Advantages
Simple to Implement: Only needs basic time-sharing communication.
Consensus-Based: Ensures fairness as all clocks align to the average.
Real-World Analogy
Imagine a classroom where everyone’s watch shows a slightly different time. The teacher (coordinator) collects the times, calculates the average, and asks everyone to adjust their watches to the average time.


 */