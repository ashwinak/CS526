package cs526.nodeTrees;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Hw6_p5 {
    /**
     * The main function will call the allFollows function with parameters such as
     * follower and its adjaceny list where the search for direct and indirect follower is queried.
     * A new scanner object reads the file and populates arralist of nodes with each node
     * pointing to another array list of followees. This method creates the data structure adjacency list
     * along with a nodeFollow class.
     *
     */
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<nodeFollow> follower= new ArrayList<>();
        ArrayList<String> followEE;
        File graphInput = new File("src/cs526/nodeTrees/follows_input.txt");
        Scanner s = new Scanner(graphInput);
        int countP1 = 0;
        while (s.hasNext()) {
            String eachLine = s.nextLine();
            String[] procParse = eachLine.split(",");
            followEE = new ArrayList<>();
            for (int i=1; i<procParse.length;i++) {
                followEE.add(procParse[i]);
            }
            follower.add(countP1++,new nodeFollow(procParse[0],followEE));
        }
        /**
         * This is the caller of the main function. All tests are done with this input.
         */
        allFollows("D", follower);
    }

    /**
     * The function below does most of the work. For direct followee's, reading the adj list data structure
     * is sufficient. For indirect followee's, a DFS approach is taken along with stack push and pop operation.
     */
    public static void allFollows(String n , ArrayList<nodeFollow> follower)throws FileNotFoundException {
        for (int i=0;i<follower.size();i++) {
            if (n.equals(follower.get(i).getName())) {
                System.out.println(n + " directly follows " + follower.get(i).getFollows());
            }
        }
        ArrayList<String> indirectFollowEE = new ArrayList<>();
        ArrayList<String> visitedNodes = new ArrayList<>();
        Stack<String> backTrack = new Stack<>();
        ArrayList<String> temp = null;

        /**
         *  This while loop ensures the followee's adj list is stored in a seperate arraylist temp.
         *  The temp is sorted in alphabetically so the nodes are chosen based on which alphabet or name
         *  comes first.
         */

        boolean DFS = true;
        while (DFS) {
            for (int i=0;i<follower.size();i++) {
                if (follower.get(i).getName().equals(n)) {
                    temp = follower.get(i).getFollows();
                    Collections.sort(temp);
                }
            }
            /**
             * This for loop ensures the backTrack stack is updated while traversing the graph.
             * the first level of indirectfollowee for given user is updated by this code.
             *
             */
            for (int i=0;i<follower.size();i++) {
                for (int j = 0; j < temp.size(); j++) {
                    if (temp.get(j).strip().equals(follower.get(i).getName())) {
                        backTrack.push(follower.get(j).getName());
                        if (!follower.get(i).getFollows().isEmpty()) {
                            for (int k = 0; k < follower.get(i).getFollows().size(); k++) {
                                backTrack.push(follower.get(i).getName());
                                visitedNodes.add(follower.get(i).getName());
                                indirectFollowEE.add(k, follower.get(i).getFollows().get(k));
                            }
                        }
                    }
                }
            }
            DFS =false;
        }

        /**
         *  This while loop will recursively search for indirectfollowees no matter how far the followee is
         *  in the directed graph.
         *
         *  Hash set is created to remove duplicate names in indirect followee data structure.
         *  Any name in direct followee DS is pruned from indirect followee DS.
         */
        HashSet<String> indrFollow = new HashSet<>(indirectFollowEE);

        while (true) {
            for (int i=0;i<follower.size();i++) {
                if (n.equals(follower.get(i).getName())) {
                    ArrayList<String> temp2 = follower.get(i).getFollows();
                    for (int j=0;j<temp2.size();j++) {
                        if (indrFollow.contains(temp2.get(j))) {
                            indrFollow.remove(temp2.get(j));
                        }
                    }
                }
            }
            String[] indrFollow1 = indrFollow.toArray(new String[indrFollow.size()]);
            for (int i=0;i<indrFollow1.length;i++) {
                for (int j=0; j<follower.size();j++) {
                    if (indrFollow1[i].strip().equals(follower.get(j).getName())) {
                        if(!follower.get(j).getFollows().isEmpty()) {
                            for (int k=0;k<follower.get(j).getFollows().size();k++) {
                                indrFollow.add(follower.get(j).getFollows().get(k));
                            }
                        }
                    }
                }
            }

            /**
             * This for loop does the stack pop and creates an exit point from the while loop
             * once everything is done. The pop occurs only when stack is not empty and adjlist is not empty
             * and name in main function is found in adjlist.
             */

            for (int i=0;i<follower.size();i++) {
                if (n.equals(follower.get(i).getName()) && follower.get(i).getFollows().size() !=0 && !backTrack.isEmpty()) {
                    backTrack.pop();
                }
            }
            if(backTrack.isEmpty()) {
                break;
            }
        }
        System.out.println(n + " indirectly follows " + indrFollow);
    }
}
