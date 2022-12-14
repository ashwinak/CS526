/**
 * Diff checker analysis for sample 1 : https://www.diffchecker.com/OTSQYvtR
 * Diff checker analysis for sample 2 : https://www.diffchecker.com/tfufM1M5
 * Diff checker analysis for sample 3 : https://www.diffchecker.com/5Z1hjCgZ
 */
package cs526.nodeTrees;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import net.datastructures.Entry;
import net.datastructures.HeapAdaptablePriorityQueue;
import java.io.FileWriter;

public class ProcessScheduling {

    /**
     * The main function creates all the data structures required for this project.
     * P1 is the arraylist that is going to read input file and store as process objects with
     * different variables defined in the process class.
     * P1copy is used to access the original elements of the P1, because when a process is moved from
     * P1 to PQ a heap adaptable PQ, then the object is removed from P1.
     *
     * P1 is the arraylist that reads the input file and stores all the processes as objects.
     *
     * PQ is the heap adaptable PQ that will run the highest priority job when it has elements in it.
     *
     * The output of the scheduler is also sent as I/O and also sent to a file for write.
     *
     * @param args
     */

    public static void main(String[] args) {
        try {
            ArrayList<Process> P1 = new ArrayList<>();
            ArrayList<Process> P1Copy = new ArrayList<>();
            ArrayList<Entry<Integer,Process>> heapPriChange = new ArrayList<>();
            File proc_Input = new File("src/cs526/nodeTrees/process_scheduling_input.txt");
            FileWriter proc_Output = new FileWriter("src/cs526/nodeTrees/process_scheduling_output.txt");
            Scanner s = new Scanner(proc_Input);
            int countP1 = 0;
            int countP2 = 0;
            while (s.hasNext()) {
                String eachLine = s.nextLine();
                String[] procParse = eachLine.split(" ");
                P1.add(countP1++, new Process
                        (Integer.parseInt(procParse[0]),
                                Integer.parseInt((procParse[1])),
                                Integer.parseInt((procParse[2])),
                                Integer.parseInt((procParse[3])),
                                0));
                P1Copy.add(countP2++, new Process
                    (Integer.parseInt(procParse[0]),
                            Integer.parseInt((procParse[1])),
                            Integer.parseInt((procParse[2])),
                            Integer.parseInt((procParse[3])),
                            0));
            }
            proc_Output.write("// print all processes first ");
            proc_Output.write("\n");
            System.out.println("// print all processes first ");
            for (int i=0;i<P1.size();i++) {
                proc_Output.write("" + P1.get(i));
                proc_Output.write("\n");
                System.out.println(P1.get(i));
            }
            /**
             * Initialzing all the variables that will be used in the while loop scheduler.
             */
            int currTime = 0;
            int maxWaitTime = 30;
            int movedToPQPriority = -1;
            int movedToPQPID = -1;
            int hiPRI = -1;
            int PQWaitTime =0;
            int totalPQWaitTime = 0;
            boolean print = false;
            int oldMin = -1;
            int oldMinDuration = -1;
            int totalwaitTime = 0;
            proc_Output.write("Maximum wait time = " + maxWaitTime +" ");
            proc_Output.write("\n");
            System.out.println("Maximum wait time = " + maxWaitTime +" ");
            HeapAdaptablePriorityQueue<Integer, Process> PQ  = new HeapAdaptablePriorityQueue<>();

            /** The core scheduler function starts here. The while loop runs as long as both
             * PQ and P1 is not empty. P1 will have element removed when the arrival time = curr time.
             * PQ will execute the process if a given process has the highest priority in the queue.
             * Once the duration for the given process is ticked down to 0, it will be removed from PQ.
             * A new hipri process will be selected for execution.
             *
             */
            while (P1.size()!=0 || PQ.size() !=0) {
                for (int i=0;i<P1.size();i++) {
                    if (P1.get(i).getArrival_Time() == currTime) {
                        if (P1.get(i).getPriority() != movedToPQPriority ||
                                P1.get(i).getProcess_id()!=movedToPQPID) {
                            PQ.insert(P1.get(i).getPriority(), P1.get(i));
                            movedToPQPriority = P1.get(i).getPriority();
                            movedToPQPID = P1.get(i).getProcess_id();
                            P1.remove(i);
                        }
                    }
                    /**
                     * The P1Copy DS is used to access the original elements of the input file
                     * Since P1 DS will be pruned as and when the process moves to PQ for execution.
                     */
                    for (int x =0;x< P1Copy.size();x++) {
                        if(P1Copy.get(x).getArrival_Time()==currTime &&
                                P1Copy.get(x).getProcess_id()==PQ.min().getValue().getProcess_id()) {
                            print = false;
                        }
                    }
                    /**
                     * The print boolean variable is used in an attempt to avoid duplicate prints.
                     * A hiPRI variable is instantiated and assigned the minkey of the PQ.
                     */
                    if(PQ.size()!=0 && PQ.min().getKey() != hiPRI && !print) {
                        hiPRI = PQ.min().getKey();
                        proc_Output.write("Now running Process id = " + PQ.min().getValue().getProcess_id());
                        proc_Output.write("\n");
                        System.out.println("Now running Process id = " + PQ.min().getValue().getProcess_id());
                        for (int j=0;j< P1Copy.size();j++) {
                            if (P1Copy.get(j).getProcess_id() == PQ.min().getValue().getProcess_id()) {
                                proc_Output.write("Arrival = " + P1Copy.get(j).getArrival_Time());
                                proc_Output.write("\n");
                                System.out.println("Arrival = " + P1Copy.get(j).getArrival_Time());
                                proc_Output.write("Duration = " + P1Copy.get(j).getDuration());
                                proc_Output.write("\n");
                                System.out.println("Duration = " + P1Copy.get(j).getDuration());
                            }
                        }
                        proc_Output.write("Run time left = " + PQ.min().getValue().getDuration());
                        proc_Output.write("\n");
                        System.out.println("Run time left = " + PQ.min().getValue().getDuration());
                        proc_Output.write("at time " + currTime);
                        proc_Output.write("\n");
                        System.out.println("at time " + currTime);
                        print = true;

                    }
                }
                /**
                 * The function below checks for the process that are ticking their wait times
                 * when waiting in PQ without being executed. When their wait times are = max wait times,
                 * then the priority of that process is reduced by 1.
                 */
                if(PQ.size() !=0) { //&& PQ.min().getValue().getArrival_Time() <=currTime
                    for(Entry<Integer,Process> walkPQ : PQ) {
                        if(walkPQ.getValue().getWait_Time() == maxWaitTime) {
                            oldMin = PQ.min().getValue().getProcess_id();
                            walkPQ.getValue().setPriority(walkPQ.getValue().getPriority()-1);
                            heapPriChange.add(walkPQ);
                            for (int i=0;i<heapPriChange.size();i++) {
                                if(heapPriChange.get(i).getValue().getDuration() !=0) {
                                    PQ.replaceKey(heapPriChange.get(i),heapPriChange.get(i).getValue().getPriority());
                                }
                            }
                            proc_Output.write("Process " + walkPQ.getValue().getProcess_id()
                                    + " reached maximum wait time..." + " decreasing priority to " +
                                    walkPQ.getValue().getPriority());
                            proc_Output.write("\n");
                            System.out.println("Process " + walkPQ.getValue().getProcess_id()
                                    + " reached maximum wait time..." + " decreasing priority to " +
                                    walkPQ.getValue().getPriority());
                            walkPQ.getValue().setWait_Time(walkPQ.getValue().getWait_Time()-maxWaitTime);
                            if(walkPQ.getValue().getProcess_id() != PQ.min().getValue().getProcess_id()) {
                                PQWaitTime = walkPQ.getValue().getArrival_Time()+maxWaitTime;
                                walkPQ.getValue().setArrival_Time(PQWaitTime);
                                totalPQWaitTime++;
                            }
                            /**
                             * The code below is to ensure the print happens at the right place during premption
                             * also tries to avoid duplicate prints.
                             */
                            if(PQ.size()!=0 && PQ.min().getValue().getProcess_id() != hiPRI && !print) {
                                hiPRI = PQ.min().getValue().getProcess_id();
                                proc_Output.write("Now running Process id = " + PQ.min().getValue().getProcess_id());
                                proc_Output.write("\n");
                                System.out.println("Now running Process id = " + PQ.min().getValue().getProcess_id());
                                for (int i=0;i< P1Copy.size();i++) {
                                    if (P1Copy.get(i).getProcess_id() == PQ.min().getValue().getProcess_id()) {
                                        proc_Output.write("Arrival = " + P1Copy.get(i).getArrival_Time());
                                        proc_Output.write("\n");
                                        System.out.println("Arrival = " + P1Copy.get(i).getArrival_Time());
                                        proc_Output.write("Duration = " + P1Copy.get(i).getDuration());
                                        proc_Output.write("\n");
                                        System.out.println("Duration = " + P1Copy.get(i).getDuration());
                                    }
                                }
                                proc_Output.write("Run time left = " + PQ.min().getValue().getDuration());
                                proc_Output.write("\n");
                                System.out.println("Run time left = " + PQ.min().getValue().getDuration());
                                proc_Output.write("at time " + currTime);
                                proc_Output.write("\n");
                                System.out.println("at time " + currTime);
                                print = true;
                            }
                        }
                        /**
                         *  The code below ensures the wait times are incremented during every while loop run.
                         *  This is core function that ensures all waiting processes in PQ bump up their priority
                         *  when its wait time is greater or equal to max wait times.
                         */
                        if (oldMin !=PQ.min().getValue().getProcess_id() && oldMinDuration !=0 ) {
                            walkPQ.getValue().setWait_Time(walkPQ.getValue().getWait_Time()+1);
                            oldMin = PQ.min().getValue().getProcess_id();
                            totalwaitTime++;
                        }
                        if (PQ.min().getValue().getProcess_id() != walkPQ.getValue().getProcess_id() ) {
                            walkPQ.getValue().setWait_Time(walkPQ.getValue().getWait_Time()+1);
                            totalwaitTime++;
                        }
                    }

                    proc_Output.write("Executed process ID:" + PQ.min().getValue().getProcess_id()
                            + ", at time " +currTime + " Remaining: " +
                            (PQ.min().getValue().getDuration()-1));
                    proc_Output.write("\n");

                    System.out.println("Executed process ID:" + PQ.min().getValue().getProcess_id()
                            + ", at time " +currTime + " Remaining: " +
                            (PQ.min().getValue().getDuration()-1));
                    PQ.min().getValue().setDuration(PQ.min().getValue().getDuration()-1);
                }
                /**
                 * If the duration of the current min process is 0, this means the process is run to completion.
                 * Its time to print the final stats of that process and remove it from PQ so that the next
                 * hipri Process executes.
                 */
                if(PQ.size() !=0) {
                    if (PQ.min().getValue().getDuration()==0) {
                        proc_Output.write("Finished running Process id = " + PQ.min().getValue().getProcess_id());
                        proc_Output.write("\n");
                        System.out.println("Finished running Process id = " + PQ.min().getValue().getProcess_id());
                        for (int i=0;i<P1Copy.size();i++) {
                            if (P1Copy.get(i).getProcess_id() == PQ.min().getValue().getProcess_id()) {
                                proc_Output.write("Arrival = " + P1Copy.get(i).getArrival_Time());
                                proc_Output.write("\n");
                                System.out.println("Arrival = " + P1Copy.get(i).getArrival_Time());
                                proc_Output.write("Duration = " + P1Copy.get(i).getDuration());
                                proc_Output.write("\n");
                                System.out.println("Duration = " + P1Copy.get(i).getDuration());
                            }
                        }
                        proc_Output.write("Run time left = " + PQ.min().getValue().getDuration());
                        proc_Output.write("\n");
                        System.out.println("Run time left = " + PQ.min().getValue().getDuration());
                        proc_Output.write("at time "  + (currTime));
                        proc_Output.write("\n");
                        System.out.println("at time "  + (currTime));
                        oldMinDuration = PQ.min().getValue().getDuration();
                        PQ.removeMin();
                        /**
                         * The code below is a check to ensure the print happens properly during premption or when
                         * a old process is finished and a new process begins execution.
                         */
                        if(PQ.size()!=0) {
                            print = true;
                            proc_Output.write("Now running Process id = " + PQ.min().getValue().getProcess_id());
                            proc_Output.write("\n");
                            System.out.println("Now running Process id = " + PQ.min().getValue().getProcess_id());
                            for (int i=0;i< P1Copy.size();i++) {
                                if (P1Copy.get(i).getProcess_id() == PQ.min().getValue().getProcess_id()) {
                                    proc_Output.write("Arrival = " + P1Copy.get(i).getArrival_Time());
                                    proc_Output.write("\n");
                                    System.out.println("Arrival = " + P1Copy.get(i).getArrival_Time());
                                    proc_Output.write("Duration = " + P1Copy.get(i).getDuration());
                                    proc_Output.write("\n");
                                    System.out.println("Duration = " + P1Copy.get(i).getDuration());
                                }
                            }
                            proc_Output.write("Run time left = " + PQ.min().getValue().getDuration());
                            proc_Output.write("\n");
                            System.out.println("Run time left = " + PQ.min().getValue().getDuration());
                            proc_Output.write("at time " + (currTime + 1));
                            proc_Output.write("\n");
                            System.out.println("at time " + (currTime + 1));
                        }
                    }
                }
                currTime++;
            }
            /**
             * The below code summarizes the full run time of all processes.
             */
            proc_Output.write("Finished running all processes at time " + (currTime-1));
            proc_Output.write("\n");
            System.out.println("Finished running all processes at time " + (currTime-1));
            proc_Output.write("Average wait time: " +  ((double)totalwaitTime/(double)P1Copy.size()));
            proc_Output.write("\n");
            System.out.println("Average wait time: " +  ((double)totalwaitTime/(double)P1Copy.size()));
            proc_Output.close();
        }
        catch (IOException e) {
            System.out.println("File not Found");
        }
    }
 }