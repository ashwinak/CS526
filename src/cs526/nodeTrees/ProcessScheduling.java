package cs526.nodeTrees;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import net.datastructures.Entry;
import net.datastructures.HeapAdaptablePriorityQueue;
//import net.datastructures.Entry;

public class ProcessScheduling {
    public static void main(String[] args) {
        try {
            ArrayList<Process> P1 = new ArrayList<>();
            ArrayList<Process> P1Copy = new ArrayList<>();

            File proc_Input = new File("src/cs526/nodeTrees/process_scheduling_input.txt");
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
                                Integer.parseInt((procParse[3]))));
                P1Copy.add(countP2++, new Process
                    (Integer.parseInt(procParse[0]),
                            Integer.parseInt((procParse[1])),
                            Integer.parseInt((procParse[2])),
                            Integer.parseInt((procParse[3]))));
            }
            System.out.println("// print all processes first ");
            for (int i=0;i<P1.size();i++) {
                System.out.println(P1.get(i));
            }
            int currTime = 0;
            int maxWaitTime = 30;
            int movedToPQPriority = -1;
            int movedToPQPID = -1;
            int minPID = 0;
            int hiPRI = -1;
            int origDuration = 0;
            int origArrivalTime = 0;
            System.out.println("Maximum wait time = " + maxWaitTime +" ");

            HeapAdaptablePriorityQueue<Integer, Process> PQ  = new HeapAdaptablePriorityQueue<>();
            HeapAdaptablePriorityQueue<Integer, Process> PQCopy  = new HeapAdaptablePriorityQueue<>();

//            Entry<Integer, Process> blah = PQ.min();
//            blah.getKey();


            /** The core scheduler function starts here.
             *
             */
            while (P1.size()!=0 || PQ.size() !=0) {
                for (int i=0;i<P1.size();i++) {
//                    System.out.println("currTime is " + currTime);
//                    System.out.println("Arrival Time is " + P1.get(i).getArrival_Time() + " PID " +
//                            P1.get(i).getProcess_id() + " Priority " + P1.get(i).getPriority());
                    if (P1.get(i).getArrival_Time() <= currTime) {
                        if (P1.get(i).getPriority() != movedToPQPriority ||
                                P1.get(i).getProcess_id()!=movedToPQPID) {
//                            System.out.println(">>>>>Inserted Priority " + P1.get(i).getPriority());
                            PQ.insert(P1.get(i).getPriority(), P1.get(i));
//                            System.out.println("current hiPri PID is " + PQ.min().getKey());
                            movedToPQPriority = P1.get(i).getPriority();
                            movedToPQPID = P1.get(i).getProcess_id();
//                            System.out.println("moved to PQ " + movedToPQPriority);
//                            System.out.println("Size before remove is " + P1.size());
                            P1.remove(i);
                        }
                    }
                    if(PQ.size()!=0 && PQ.min().getKey() != hiPRI) {
                        hiPRI = PQ.min().getKey();
                        System.out.println("Now running Process id = " + PQ.min().getValue().getProcess_id());
                        for (i=0;i< P1Copy.size();i++) {
                            if (P1Copy.get(i).getProcess_id() == PQ.min().getValue().getProcess_id()) {
                                System.out.println("Arrival = " + P1Copy.get(i).getArrival_Time());
                                System.out.println("Duration = " + P1Copy.get(i).getDuration());
                            }
                        }
                        System.out.println("Run time left = " + PQ.min().getValue().getDuration());
                        System.out.println("at time " + currTime);
                    }
                }
//                if (PQ.size() !=0 && PQ.min().getValue().getDuration() == 0) {
//                    break;
//                }
                if(PQ.size() !=0 && PQ.min().getValue().getArrival_Time() <=currTime) {
                    for(Entry<Integer,Process> walkPQ : PQ) {
//                        System.out.println("Arr time for PID " + walkPQ.getValue().getProcess_id() + " is  " +
//                                walkPQ.getValue().getArrival_Time());
//                        System.out.println("currTime is " + currTime);
                        if(walkPQ.getValue().getArrival_Time() + maxWaitTime == currTime) {
                            walkPQ.getValue().setPriority(walkPQ.getValue().getPriority()-1);
                            System.out.println("MinPID before replace is " + PQ.min().getValue().getProcess_id());
                            Entry<Integer,Process> top = PQ.min();
                            System.out.println("topPID is " + top.getValue().getProcess_id());
                            System.out.println("pri reduced for PID " + walkPQ.getValue().getProcess_id() +
                                    " with new priority " + walkPQ.getValue().getPriority());
                            PQ.replaceKey(top,walkPQ.getKey());
                            System.out.println("MinPID after replace is " + PQ.min().getValue().getProcess_id() +
                                    " having Priority " +PQ.min().getValue().getPriority());
                            System.out.println("Updated list is PID PRI "+walkPQ.getValue().getProcess_id() +"  " + walkPQ.getValue().getPriority());
                            System.out.println("Process " + walkPQ.getValue().getProcess_id()
                                    +" reached maximum wait time..." +" decreasing priority to " +
                                    walkPQ.getValue().getPriority());
//                            PQ.remove(Entry<Integer,Process> PQCopy);
//                            PQ.remove(PQ.min().getValue().getPriority(),blah);
                        }
                    }
                    System.out.println("min PID is " + PQ.min().getValue().getProcess_id());
                    System.out.println("Executed process ID:" + PQ.min().getValue().getProcess_id()
                            + ", at time " +currTime + " Remaining: " +
                            (PQ.min().getValue().getDuration()-1));

                    PQ.min().getValue().setDuration(PQ.min().getValue().getDuration()-1);
                    PQ.min().getValue().setArrival_Time(currTime);
                }
                if(PQ.size() !=0) {
                    if (PQ.min().getValue().getDuration()==0) {
                        System.out.println("Finished running Process id = " + PQ.min().getValue().getProcess_id());
                        for (int i=0;i<P1Copy.size();i++) {
                            if (P1Copy.get(i).getProcess_id() == PQ.min().getValue().getProcess_id()) {
                                System.out.println("Arrival = " + P1Copy.get(i).getArrival_Time());
                                System.out.println("Duration = " + P1Copy.get(i).getDuration());
                            }
                        }
                        System.out.println("Run time left = " + PQ.min().getValue().getDuration());
                        System.out.println("at time "  + (currTime));
                        PQ.removeMin();
                    }
                }
                currTime++;
            }
            System.out.println("Finished running all processes at time " + (currTime-1));
//            System.out.println("Average wait time: " + );
//             41.3
        }
        catch (IOException e) {
            System.out.println("File not Found");
        }
    }
 }
