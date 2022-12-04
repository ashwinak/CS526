package java_dsa;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    private HashMap<String, ArrayList<String>> myHashMap = new HashMap();

    public void printGraph() {
        System.out.println(myHashMap);
    }
    public boolean addVertex(String vertex) {
        if (myHashMap.get(vertex) == null) {
            myHashMap.put(vertex, new ArrayList<>());
            return true;
        } else {
            return false;
        }
    }
    public boolean addEdge(String vertex1, String vertex2) {
        if (myHashMap.get(vertex1) != null && myHashMap.get(vertex2) !=null ) {
            myHashMap.get(vertex1).add(vertex2);
            myHashMap.get(vertex2).add(vertex1);
            return true;
        } return false;
    }
    public boolean removeEdge(String vertex1, String vertex2) {
        if (myHashMap.get(vertex1) != null && myHashMap.get(vertex2) !=null ) {
            myHashMap.get(vertex1).remove(vertex2);
            myHashMap.get(vertex2).remove(vertex1);
            return true;
        } return false;
    }
    public boolean removeVertex(String vertex) {
        if (myHashMap.get(vertex) != null) {
            for (String vremove : myHashMap.get(vertex)) {
                myHashMap.get(vremove).remove(vertex);
            }
            System.out.println(myHashMap.get(vertex));
            myHashMap.remove(vertex);
            return true;
        } return false;
    }

}

