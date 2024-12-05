import mpi.MPI;

public class ScatterGather {
    public static void main(String args[]) {
        // Initialize MPI execution environment
        MPI.Init(args);

        // Get the id of the process
        int rank = MPI.COMM_WORLD.Rank();
        // Total number of processes is stored in size
        int size = MPI.COMM_WORLD.Size();
        int root = 0;

        // Array which will be filled with data by root process
        int sendbuf[] = null;
        sendbuf = new int[size];

        // Creates data to be scattered
        if (rank == root) {
            sendbuf[0] = 10;
            sendbuf[1] = 20;
            sendbuf[2] = 30;
            sendbuf[3] = 40;

            // Print current process number
            System.out.print("Processor " + rank + " has data: ");
            for (int i = 0; i < size; i++) {
                System.out.print(sendbuf[i] + " ");
            }
            System.out.println();
        }

        // Collect data in recvbuf
        int recvbuf[] = new int[1];

        // Following are the args of Scatter method
        // send, offset, chunk_count, chunk_data_type, recv, offset,
        // chunk_count, chunk_data_type, root_process_id
        MPI.COMM_WORLD.Scatter(sendbuf, 0, 1, MPI.INT, recvbuf, 0,
                1, MPI.INT, root);
        System.out.println("Processor " + rank + " has data: " + recvbuf[0]);
        System.out.println("Processor " + rank + " is doubling the data");
        recvbuf[0] = recvbuf[0] * 2;

        // Following are the args of Gather method
        // Object sendbuf, int sendoffset, int sendcount, Datatype
        // sendtype, Object recvbuf, int recvoffset, int recvcount,
        // Datatype recvtype, int root
        MPI.COMM_WORLD.Gather(recvbuf, 0, 1, MPI.INT, sendbuf, 0,
                1, MPI.INT, root);

        // Display the gathered result
        if (rank == root) {
            System.out.println("Process 0 has data: ");
            for (int i = 0; i < 4; i++) {
                System.out.print(sendbuf[i] + " ");
            }
        }

        // Terminate MPI execution
        MPI.Finalize();
    }
}

// install mpj
// set environmental variable give name as MPJ_HOME 
// and set path of bin

// javac -cp %MPJ_HOME%\lib\mpj.jar ScatterGather.java

// %MPJ_HOME%\bin\mpjrun.bat -np 4 ScatterGather

/*
This Java program demonstrates how to use MPI (Message Passing Interface) to distribute data among multiple processes and gather the results after processing.
The program begins by initializing the MPI environment using MPI.Init(), allowing the processes to communicate with each other. 
Each process is assigned a unique identifier, or rank, and the total number of processes is stored. 
The root process (rank 0) prepares an array of integers and distributes this data among all processes using the MPI.Scatter() function. 
Each process receives one element of the array, doubles its value, and sends the result back to the root process using MPI.Gather(). 
Finally, the root process collects the results from all processes and displays them. 
The program concludes by terminating the MPI environment with MPI.Finalize().


1) Parallel Computing: MPI allows multiple processors to work together on tasks across different nodes in a distributed system.
2) Communication:
Point-to-Point: Direct message exchange between two processes.
Collective: Group communication (e.g., broadcasting, gathering data).
3) Process Management: Each process gets a unique rank, allowing identification and communication within a group (communicator).
4) Data Distribution: Functions for scattering and gathering data across processes, and broadcasting messages.
5) Synchronization: Barriers and locks ensure processes sync and manage shared resources.
6) Efficiency: Supports blocking and non-blocking communication to optimize performance.
7) Fault Tolerance: Basic MPI doesn’t handle failures, but can be extended with fault-tolerant mechanisms.
8) Portability: Runs on various platforms with minimal code changes.
 */