package java_dsa;

import java.util.Arrays;

public class sort {
    public static void main(String[] args) {
        int[] myArray1 = {1,3,7,8};
        int[] myArray2 = {2,4,5,6};
        int[] myArray3 = {4,2,6,5,1,3};
        int[] myArray4 = {14,12,16,15,11,13};
        int[] myArray5 = {4,2,6,5,1,3,14,12,16,15,11,13};
        int[] myArray6 = {4,6,1,7,3,2,5};
        //System.out.println(pivot(myArray1));
//        bubbleSort(myArray);
//        System.out.println(Arrays.toString(myArray));
//        insertionSort(myArray1);
//        System.out.println (Arrays.toString(merge(myArray1,myArray2)));
//        System.out.println (Arrays.toString(merge(myArray3,myArray4)));
//        int [] sortedArray = mergeSort(myArray5);
//        System.out.println ("Sorted Array is " +Arrays.toString(sortedArray));


    }
    public static void bubbleSort (int[] a) {
        for (int i = a.length -1; i >0 ; i--) {
            for (int j=0;j<i;j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
//    public static void selectionSort (int[] a) { //{4,2,6,5,1,3}
//        for (int i=0; i<a.length; i++){
//            int minIdx = i;
//            for (int j=i+1; j<a.length;j++) {
//                if(a[j] < a[minIdx]) {
//                    minIdx = j;
//                }
//            }
//            if(i !=minIdx) {
//                int temp = a[i];
//                a[i] = a[minIdx];
//                a[minIdx] = temp;
//            }
//        }
//    }
    public static void insertionSort(int[] a) {//{4,2,6,5,1,3}
        for (int i=1;i<a.length;i++) { //Starting at idx 1
            for (int j=0;j<a.length;j++) {
                if (a[i] < a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.println("sorted via insertion");
    }

    public static int [] merge(int [] a, int[] b) {
        int [] combined= new int[a.length + b.length];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i<a.length && j <b.length) {
            if (a[i] < b[j]) {
                combined[index] = a[i];
                index++;
                i++;
            } else {
                combined[index] = b[j];
                index++;
                j++;
            }
        }
        while (i<a.length) {
            combined[index] = a[i];
            index++;
            i++;
        }
        while (j<b.length) {
            combined[index] = b[j];
            index++;
            j++;
        }
        return combined;
    }
    public static int[] mergeSort(int [] a) { // this method uses recursion.
        if (a.length == 1 ) return a;
        int minIdx = a.length/2;
        int left [] = mergeSort(Arrays.copyOfRange(a,0,minIdx));
        int right [] = mergeSort(Arrays.copyOfRange(a,minIdx,a.length));
        return merge(left,right);
    }
//    public static int pivot(int [] a) {
//
//    }


    public static void quickSort(int [] a) {

    }
}
