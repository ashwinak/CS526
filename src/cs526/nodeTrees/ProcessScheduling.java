/**
 * Diff checker analysis for sample 1 : https://www.diffchecker.com/fwSkahlb
 * Diff checker analysis for sample 2 : https://www.diffchecker.com/q9avMxW7
 * Diff checker analysis for sample 3 : https://www.diffchecker.com/Xf4863Op
 */
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
            ArrayList<Entry<Integer,Process>> heapPriChange = new ArrayList<>();

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
                                Integer.parseInt((procParse[3])),
                                0));
                P1Copy.add(countP2++, new Process
                    (Integer.parseInt(procParse[0]),
                            Integer.parseInt((procParse[1])),
                            Integer.parseInt((procParse[2])),
                            Integer.parseInt((procParse[3])),
                            0));
            }
            System.out.println("// print all processes first ");
            for (int i=0;i<P1.size();i++) {
                System.out.println(P1.get(i));
            }
            int currTime = 0;
            int maxWaitTime = 30;
            int movedToPQPriority = -1;
            int movedToPQPID = -1;
            int hiPRI = -1;
            int PQWaitTime =0;
            int totalPQWaitTime = 0;
            int preEmpt = -1;
            boolean print = false;
            System.out.println("Maximum wait time = " + maxWaitTime +" ");

            HeapAdaptablePriorityQueue<Integer, Process> PQ  = new HeapAdaptablePriorityQueue<>();
//            HeapAdaptablePriorityQueue<Integer, Process> PQCopy  = new HeapAdaptablePriorityQueue<>();

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
                    if (P1.get(i).getArrival_Time() == currTime) {
                        if (P1.get(i).getPriority() != movedToPQPriority ||
                                P1.get(i).getProcess_id()!=movedToPQPID) {
//                            System.out.println(">>>>>Inserted Priority " + P1.get(i).getPriority());
                            preEmpt = P1.get(i).getProcess_id();
                            PQ.insert(P1.get(i).getPriority(), P1.get(i));
//                            System.out.println("current hiPri PID is " + PQ.min().getKey());
                            movedToPQPriority = P1.get(i).getPriority();
                            movedToPQPID = P1.get(i).getProcess_id();
//                            System.out.println("moved to PQ " + movedToPQPriority);
//                            System.out.println("Size before remove is " + P1.size());
                            P1.remove(i);
                        }
                    }
                    for (int x =0;x< P1Copy.size();x++) {
                        if(P1Copy.get(x).getArrival_Time()==currTime &&
                                P1Copy.get(x).getProcess_id()==PQ.min().getValue().getProcess_id()) {
                            print = false;
                        }
                    }
                    if(PQ.size()!=0 && PQ.min().getKey() != hiPRI && !print) {
                        hiPRI = PQ.min().getKey();
                        System.out.println("Now running Process id = " + PQ.min().getValue().getProcess_id());
                        for (int j=0;j< P1Copy.size();j++) {
                            if (P1Copy.get(j).getProcess_id() == PQ.min().getValue().getProcess_id()) {
                                System.out.println("Arrival = " + P1Copy.get(j).getArrival_Time());
                                System.out.println("Duration = " + P1Copy.get(j).getDuration());
                            }
                        }
                        System.out.println("Run time left = " + PQ.min().getValue().getDuration());
                        System.out.println("at time " + currTime);
                        print = true;

                    }
                }
//                if (PQ.size() !=0 && PQ.min().getValue().getDuration() == 0) {
//                    break;
//                }

                if(PQ.size() !=0) { //&& PQ.min().getValue().getArrival_Time() <=currTime
                    for(Entry<Integer,Process> walkPQ : PQ) {
//                        System.out.println("Arr time for PID# " +walkPQ.getValue().getProcess_id()+ " "
//                                + walkPQ.getValue().getArrival_Time());
//                        System.out.println("debug 0: walkPQ list" + walkPQ.getValue());
                        if(walkPQ.getValue().getWait_Time() == maxWaitTime) {
                            walkPQ.getValue().setPriority(walkPQ.getValue().getPriority()-1);
                            heapPriChange.add(walkPQ);
//                            System.out.println("size of heappriChange is " + heapPriChange.size());
                            for (int i=0;i<heapPriChange.size();i++) {
//                                System.out.println("The key is " + heapPriChange.get(i).getValue());
//                                System.out.println("currTime is "+currTime);
                                if(heapPriChange.get(i).getValue().getDuration() !=0) {
                                    PQ.replaceKey(heapPriChange.get(i),heapPriChange.get(i).getValue().getPriority());
                                }
                            }

//                            System.out.println("Process  PID  " +walkPQ.getValue().getProcess_id() +
//                                    " arrtime: " + walkPQ.getValue().getArrival_Time());


                            System.out.println("Process " + walkPQ.getValue().getProcess_id()
                                    + " reached maximum wait time..." + " decreasing priority to " +
                                    walkPQ.getValue().getPriority());
                            walkPQ.getValue().setWait_Time(walkPQ.getValue().getWait_Time()-maxWaitTime);
                            if(walkPQ.getValue().getProcess_id() != PQ.min().getValue().getProcess_id()) {
                                PQWaitTime = walkPQ.getValue().getArrival_Time()+maxWaitTime;
//                                System.out.println("PQwt time is " +PQWaitTime);
                                walkPQ.getValue().setArrival_Time(PQWaitTime);
                                totalPQWaitTime++;
//                                System.out.println("new arr time " + walkPQ.getValue().getArrival_Time());
                            }
//                            System.out.println("debug 3...");
//                            System.out.println(print);
//                            System.out.println(PQ.min().getValue().getProcess_id());
//                            System.out.println(hiPRI);

                            if(PQ.size()!=0 && PQ.min().getValue().getProcess_id() != hiPRI && !print) {
                                hiPRI = PQ.min().getValue().getProcess_id();
                                System.out.println("Now running Process id = " + PQ.min().getValue().getProcess_id());
                                for (int i=0;i< P1Copy.size();i++) {
                                    if (P1Copy.get(i).getProcess_id() == PQ.min().getValue().getProcess_id()) {
                                        System.out.println("Arrival = " + P1Copy.get(i).getArrival_Time());
                                        System.out.println("Duration = " + P1Copy.get(i).getDuration());
                                    }
                                }
                                System.out.println("Run time left = " + PQ.min().getValue().getDuration());
                                System.out.println("at time " + currTime);
                                print = true;
                            }
                        }
//                        System.out.println("debug 1: walkPQ list" + walkPQ.getValue());
//                        System.out.println("debug 2: min key is " + PQ.min().getValue());
                        if (PQ.min().getValue().getProcess_id() != walkPQ.getValue().getProcess_id() ) {
                            walkPQ.getValue().setWait_Time(walkPQ.getValue().getWait_Time()+1);
                        }
                    }
                    System.out.println("Executed process ID:" + PQ.min().getValue().getProcess_id()
                            + ", at time " +currTime + " Remaining: " +
                            (PQ.min().getValue().getDuration()-1));
                    PQ.min().getValue().setDuration(PQ.min().getValue().getDuration()-1);
//                    PQ.min().getValue().setArrival_Time(currTime+1);
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
//                        System.out.println("PQ min is  " + PQ.min().getValue());
//                        System.out.println("min key is : " + PQ.min().getValue());
//                        System.out.println("hipri is :" + hiPRI);
//                        System.out.println("PQ size " + PQ.size());
                        if(PQ.size()!=0) {
                            print = true;
                            System.out.println("Now running Process id = " + PQ.min().getValue().getProcess_id());
                            for (int i=0;i< P1Copy.size();i++) {
                                if (P1Copy.get(i).getProcess_id() == PQ.min().getValue().getProcess_id()) {
                                    System.out.println("Arrival = " + P1Copy.get(i).getArrival_Time());
                                    System.out.println("Duration = " + P1Copy.get(i).getDuration());
                                }
                            }
                            System.out.println("Run time left = " + PQ.min().getValue().getDuration());
                            System.out.println("at time " + (currTime + 1));
                        }
                    }
                }
                currTime++;
            }
            System.out.println("Finished running all processes at time " + (currTime-1));
//            System.out.println("Average wait time: " + (totalPQWaitTime*maxWaitTime)/totalPQWaitTime);
//             41.3
        }
        catch (IOException e) {
            System.out.println("File not Found");
        }
    }
 }
