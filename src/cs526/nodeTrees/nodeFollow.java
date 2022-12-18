package cs526.nodeTrees;


import java.util.ArrayList;

public class nodeFollow {
    private String name ;
    private ArrayList<String> follows;

    public nodeFollow(String name, ArrayList<String> follows) {
        this.name = name;
        this.follows = follows;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getFollows() {
        return follows;
    }
    @Override
    public String toString() {
        return ("Name: " + this.getName()+  " " + "followEE "+ " " +this.getFollows().toString());
    }
}
