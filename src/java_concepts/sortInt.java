package java_concepts;

import java.util.Arrays;
import java.util.Scanner;

public class sortInt {
    public static void main(String[] args) {
        String[] sa = {"data", "structures", "and", "algorithms"};
        String[] sb = sa;
        Arrays.sort(sb); //sort strings in the array in alphabetical order
        String[] sc = {"data", "structures", "and", "algorithms"};
        String[] sd = sc.clone();
        Arrays.sort(sd); //sort strings in the array in alphabetical order
        System.out.println("sorted array sa: " + sa[0] +"   "+ sa[1] +"   "+ sa[2]+"   "+ sa[3]);
        System.out.println("sorted array sc: " + sc[0] +"   "+ sc[1] +"   "+ sc[2]+"   "+ sc[3]);

        int[] myInt = getIntegers(5);
        int [] mySortedInt = sortIntegers(myInt);
        printArray(mySortedInt);


    }
    public static int[] getIntegers(int number) {
        int[] val = new int[number];
        System.out.println("Enter " + number + " numbers below: ");
        Scanner scan = new Scanner(System.in);
        for (int i=0; i<val.length; i++) {
            val[i] = scan.nextInt();
        }return val;
    }
    public static void printArray(int [] val) {
        for (int i=0; i<val.length; i++) {
            System.out.println("the array element " + i +" is "+ val[i]);
        }
    }
    public static int[] sortIntegers (int [] val) {
        int[] sortedArray = Arrays.copyOf(val,val.length);
        int swap;
        boolean flag = true;
        while(flag) {
            flag = false;
            for (int i=0;i<sortedArray.length-1; i++) {
                if (sortedArray[i] < sortedArray[i+1]) {
                    swap = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = swap;
                    flag = true;
                }
            }
        }return sortedArray;
    }
}
