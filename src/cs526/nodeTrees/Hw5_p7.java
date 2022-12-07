package cs526.nodeTrees;

import java.util.*;

public class Hw5_p7 {

    public static void main(String[] args) {
        int n = 10000;
        for (int i=0;i<10;i++) {
            int[] randomArr = Rand(1000000, n);

            /** Insertion Sort
             *
             */
            long startTime = System.currentTimeMillis();
            insertionSort(randomArr);
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;

            System.out.println();
            System.out.println("Time taken for insertion Sort of size " + n + " is "
                    +elapsedTime);

            /** Merge Sort
             *
             *
             */

            Comparator<Integer> Comp= new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            };
            Integer[] randomArrMerge = RandInteger(1000000, n);

            long startTime1 = System.currentTimeMillis();
            mergeSort(randomArrMerge,Comp);
            long endTime1 = System.currentTimeMillis();
            long elapsedTime1 = endTime1 - startTime1;

            System.out.println("Time taken for merge Sort of size " + n + " is "
                    +elapsedTime1);

            /**
             *  Quick Sort
             */
            Comparator<Integer> Comp1= new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            };
            Integer[] randomArrQuick = RandInteger(1000000, n);

            long startTime3 = System.currentTimeMillis();
            quickSort(randomArrQuick,Comp,0,randomArrQuick.length-1);
            long endTime3 = System.currentTimeMillis();
            long elapsedTime3 = endTime3 - startTime3;

            System.out.println("Time taken for quick Sort of size " + n + " is "
                    +elapsedTime3);

            /**
             * Heap Sort
             */
            int[] randomArrHeap = Rand(1000000, n);
            long startTime2 = System.currentTimeMillis();
            heapSort(randomArrHeap);
            long endTime2 = System.currentTimeMillis();
            long elapsedTime2 = endTime2 - startTime2;

            System.out.println("Time taken for heap Sort of size " + n + " is "
                    +elapsedTime2);

            n=n+10000;
        }

    }
    public static int [] insertionSort(int [] data) {
        int n = data.length;
        for (int k = 1; k < n; k++) {
            int cur = data[k];
            int j = k;
            while (j>0 && data[j-1]>cur) {
                data[j] = data[j-1];
                j--;
            }
            data[j] = cur; // this is the proper place for cur
        }
        return data;
    }

    public static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp ) {
        int i=0,j=0;
        while (i+j < S.length) {
            if (j==S2.length || (i<S1.length && comp.compare(S1[i],S2[j]) <0)) {
                S[i + j] = S1[i++];
            }
            else {
                S[i+j] = S2[j++];
            }
        }
    }

    public static <K> void mergeSort(K[] S, Comparator<K> comp) {
        int n = S.length;
        if (n<2) return;;
        int mid = n/2;
        K[] S1 = Arrays.copyOfRange(S,0,mid);
        K[] S2 = Arrays.copyOfRange(S,mid,n);
        mergeSort(S1,comp);
        mergeSort(S2,comp);
        merge(S1,S2,S,comp);
    }

    //* Source : https://stackabuse.com/heap-sort-in-java/
    public static void heapify(int[] array, int length, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < length && array[left] > array[largest]) {
            largest = left;
        }
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            int tmp = array[i];
            array[i] = array[largest];
            array[largest] = tmp;
            heapify(array, length, largest);
        }
    }
    public static void heapSort(int[] array) {
        if (array.length == 0) {
            return;
        }
        int length = array.length;
        // Moving from the first element that isn't a leaf towards the root
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);

        }

        for (int i = length - 1; i >= 0; i--) {
            int tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;
            heapify(array, i, 0);
        }
    }
    public static <K> void quickSort(K[] S, Comparator<K> comp, int a , int b) {
        if(a>=b) return;
        int left = a;
        int right = b-1;
        K pivot = S[b];
        K temp;
        while (left <= right) {
            while (left <= right && comp.compare(S[left], pivot)<0) left++;
            while (left <= right && comp.compare(S[right],pivot)>0) right--;
            if (left <= right) {
                temp = S[left]; S[left] = S[right];S[right] = temp;
                left++;right--;
            }
        }
        temp = S[left]; S[left] = S[b]; S[b] = temp;
        quickSort(S, comp, a, left - 1);
        quickSort(S, comp, left + 1, b);
    }

    public static int[] Rand(int range, int size){
        Random rd = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(range);
//            System.out.println(arr[i]);
        }
        return arr;
    }

    public static Integer[] RandInteger(int range, int size){
        Random rd = new Random();
        Integer[] arr = new Integer[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(range)+1;
//            System.out.println(arr[i]);
        }
        return arr;
    }
}
