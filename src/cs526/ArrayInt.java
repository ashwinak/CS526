package cs526;

import java.util.ArrayList;

public class ArrayInt {
    public static void main(String[] args) {
        ArrayList N = new ArrayList<Integer>();
        N.add(1);
        N.add(2);
        N.add(3);
        N.add(1);
        N.add(5);
        N.add(6);
        System.out.println("Does the array have duplicate elements : " + isduplicates(N));

    }
    public static boolean isduplicates(ArrayList<Integer> arrlist) {
        for (int i=0; i<arrlist.size()-1;i++) {
            for (int j=i+1; j<arrlist.size()-1; j++) {
                if(arrlist.get(i) == arrlist.get(j+1)) {
//                    System.out.println(arrlist.get(i));
//                    System.out.println(arrlist.get(j));
                    return true;
                }
            }
        } return false;
    }
}
