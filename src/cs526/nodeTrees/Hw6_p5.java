package cs526.nodeTrees;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hw6_p5 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<nodeFollow> follower= new ArrayList<>();
        allFollows("A", follower);
    }
    public static void allFollows(String n , ArrayList<nodeFollow> follower)throws FileNotFoundException {
//        ArrayList<nodeFollow> follower = new ArrayList<>();
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
        for (int i=0;i<follower.size();i++) {
            if (n.equals(follower.get(i).getName())) {
                System.out.println(n + " directly follows " + follower.get(i).getFollows());
            }
        }
    }
}
