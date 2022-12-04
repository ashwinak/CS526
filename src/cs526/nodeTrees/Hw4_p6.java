package cs526.nodeTrees;

import java.util.*;

public class Hw4_p6 {
    public static void main(String[] args) {
        /**
         *  This is the main function which creates three different data structures and each data structure
         *  is expected to store 100K elements.
         */
        int size = 100000;
        HashMap myMap = new HashMap(size);
        ArrayList myArrayList = new ArrayList(size);
        LinkedList myLinkedList = new LinkedList<>();

        /**
         *  Experiment 1 : Time taken to insert keys in a given data structure.
         */

        /**
         * A new array insertKeys is created that stores 100K unique elements in the range of 0 to 1Mil.
         * A new function Rand returns an array of 100K unique elements in range 0 to 1Mil.
         * The function Rand takes two inputs range and size. It returns an array of size = size and
         * elements in the array can be between the range specified.
         */

        Integer[] insertKeys = Rand(1000000, size);
        System.out.println("Number of keys = " + insertKeys.length); //Prints number of keys in the array insertKeys
        System.out.println(); // Prints empty line for better readability.

        /**
         * The code below is for inserting elements into hashmap and the time
         * taken to insert all 100K elements from insertKeys array to the hash map. This experiment is
         * performed using a for loop. The first for loop is for insertion time of 10 iterations.
         * The 2nd for loop will insert the keys into the map.
         * The system current time is saved before entering the 2nd for loop and after exiting the 2nd for loop.
         * The elapsed time is the timestamp after exiting 2nd loop minus before entering the 2nd loop gives the total time
         * it took to insert all keys into the data structure hashmap.
         * Another array of type long is created to store the elapsed time for each iteration of insertion.
         * This array is then used to calculate the average of 10 insertions into the data structure hashmap.
         */
        long totalMap = 0;
        long[] timeMap = new long[10];
        for (int j = 0; j < 10; j++) {
            long startTimeMap = System.currentTimeMillis();
            for (int i = 0; i < insertKeys.length; i++) {
                myMap.put(insertKeys[i], i);
            }
            long endTimeMap = System.currentTimeMillis();
            long elapsedTimeMap = endTimeMap - startTimeMap;
            timeMap[j] = elapsedTimeMap;
            totalMap = totalMap + timeMap[j];
        }
        System.out.println("HashMap average total insert time = " + Math.round(totalMap / timeMap.length));


        /**
         * The code below is for inserting elements into ArrayList and the time
         * taken to insert all 100K elements from insertKeys array to the ArrayList. This experiment is
         * performed using a for loop. The first for loop is for insertion time of 10 iterations.
         * The 2nd for loop will insert the keys into the ArrayList.
         * The system current time is saved before entering the 2nd for loop and after exiting the 2nd for loop.
         * The elapsed time is the timestamp after exiting 2nd loop minus before entering the 2nd loop gives the total time
         * it took to insert all keys into the data structure ArrayList.
         * Another array of type long is created to store the elapsed time for each iteration of insertion.
         * This array is then used to calculate the average of 10 insertions into the data structure ArrayList.
         */

        long totalArrayList = 0;
        long[] timeArrayList = new long[10];
        for (int j = 0; j < 10; j++) {
            long startTimeArrayList = System.currentTimeMillis();
            for (int i = 0; i < insertKeys.length; i++) {
                myArrayList.add(insertKeys[i]);
            }
            long endTimeArrayList = System.currentTimeMillis();
            long elapsedTimeArrayList = endTimeArrayList - startTimeArrayList;
            timeArrayList[j] = elapsedTimeArrayList;
            totalArrayList = totalArrayList + timeArrayList[j];
        }
        System.out.println("ArrayList average total insert time = " + Math.round(totalArrayList / timeArrayList.length));


        /**
         * The code below is for inserting elements into LinkedList and the time
         * taken to insert all 100K elements from insertKeys array to the LinkedList. This experiment is
         * performed using a for loop. The first for loop is for insertion time of 10 iterations.
         * The 2nd for loop will insert the keys into the ArrayList.
         * The system current time is saved before entering the 2nd for loop and after exiting the 2nd for loop.
         * The elapsed time is the timestamp after exiting 2nd loop minus before entering the 2nd loop gives the total time
         * it took to insert all keys into the data structure LinkedList.
         * Another array of type long is created to store the elapsed time for each iteration of insertion.
         * This array is then used to calculate the average of 10 insertions into the data structure LinkedList.
         */
        long totalLinkedList = 0;
        long[] timeLinkedList = new long[10];
        for (int j = 0; j < 10; j++) {
            long startTimeLinkedList = System.currentTimeMillis();
            for (int i = 0; i < insertKeys.length; i++) {
                myLinkedList.add(insertKeys[i]);
            }
            long endTimeLinkedList = System.currentTimeMillis();
            long elapsedTimeLinkedList = endTimeLinkedList - startTimeLinkedList;
            timeLinkedList[j] = elapsedTimeLinkedList;
            totalLinkedList = totalLinkedList + timeLinkedList[j];
        }
        System.out.println("LinkedList average total insert time = " + Math.round(totalLinkedList / timeLinkedList.length));

        /**
         *  Experiment 2 : Time taken to Search keys in a given data structure.
         */

        Integer[] searchKeys = Rand(2000000, 100000);
        System.out.println();

        /**
         * The code below is  for searching elements into hashMap and the time
         * taken to search all 100K elements from myMap to the array searchKeys. This experiment is
         * performed using a for loop. The first for loop is to search 10 times and store the elapsed time on each
         * iteration to a array of type long. The second for loop performs the actual search.
         * The array of type long is then used later to calculate the average search time for a given data structure.
         * The array of type long will have 10 entries for elapsedTime, each one representing the time taken to
         * complete full search of elements of myMap  into searchKeys.
         * The system current time is saved before entering the 2nd for loop and after exiting the 2nd loop.
         * The elapsed time is the timestamp after exiting 2nd loop minus before entering the 2nd loop gives the total time
         * it took to search all keys into the data structure hashMap.
         */
        long totalSearchMap = 0;
        long[] timeSearchMap = new long[10];
        for (int j = 0; j < 10; j++) {
            long startTimeSearchMap = System.currentTimeMillis();
            for (int i = 0; i < searchKeys.length; i++) {
                myMap.containsKey(searchKeys[i]);
            }
            long endTimeSearchMap = System.currentTimeMillis();
            long elapsedTimeSearchMap = endTimeSearchMap - startTimeSearchMap;
            timeSearchMap[j] = elapsedTimeSearchMap;
            totalSearchMap = totalSearchMap + timeSearchMap[j];
        }
        System.out.println("HashMap average total search time = " + Math.round(totalSearchMap / timeSearchMap.length));


        /**
         * The code below is  for searching elements into ArrayList and the time
         * taken to search all 100K elements from myArrayList  to the array searchKeys. This experiment is
         * performed using a for loop. The first for loop is to search 10 times and store the elapsed time on each
         * iteration to an array of type long. The second for loop performs the actual search.
         * The array of type long is then used later to calculate the average search time for a given data structure.
         * The array of type long will have 10 entries for elapsedTime, each one representing the time taken to
         * complete full search of elements of myArrayList  into searchKeys.
         * The system current time is saved before entering the 2nd for loop and after exiting the 2nd loop.
         * The elapsed time is the timestamp after exiting 2nd loop minus before entering the 2nd loop gives the total time
         * it took to search all keys into the data structure ArrayList.
         */

        long totalArrayListSearch = 0;
        long[] timeArrayListSearch = new long[10];
        for (int j = 0; j < 10; j++) {
            long startTimeArrayListSearch = System.currentTimeMillis();
            for (int i = 0; i < searchKeys.length; i++) {
                myArrayList.contains(searchKeys[i]);
            }
            long endTimeArrayListSearch = System.currentTimeMillis();
            long elapsedTimeArrayListSearch = endTimeArrayListSearch - startTimeArrayListSearch;
            timeArrayListSearch[j] = elapsedTimeArrayListSearch;
            totalArrayListSearch = totalArrayListSearch + timeArrayListSearch[j];
        }
        System.out.println("ArrayList average total search time = " + Math.round(totalArrayListSearch / timeArrayListSearch.length));

        /**
         * The code below is  for searching elements into LinkedList and the time
         * taken to search all 100K elements from myLinkedList  to the array searchKeys. This experiment is
         * performed using a for loop. The first for loop is to search 10 times and store the elapsed time on each
         * iteration to an array of type long. The second for loop performs the actual search.
         * The array of type long is then used later to calculate the average search time for a given data structure.
         * The array of type long will have 10 entries for elapsedTime, each one representing the time taken to
         * complete full search of elements of myLinkedList  into searchKeys.
         * The system current time is saved before entering the 2nd for loop and after exiting the 2nd loop.
         * The elapsed time is the timestamp after exiting 2nd loop minus before entering the 2nd loop gives the total time
         * it took to search all keys into the data structure LinkedList.
         */

        long totalLinkedListSearch = 0;
        long[] timeLinkedListSearch = new long[10];
        for (int j = 0; j < 10; j++) {
            long startTimeLinkedListSearch = System.currentTimeMillis();
            for (int i = 0; i < searchKeys.length; i++) {
                myLinkedList.contains(searchKeys[i]);
            }
            long endTimeLinkedListSearch = System.currentTimeMillis();
            long elapsedTimeLinkedListSearch = endTimeLinkedListSearch - startTimeLinkedListSearch;
            timeLinkedListSearch[j] = elapsedTimeLinkedListSearch;
            totalLinkedListSearch = totalLinkedListSearch + timeLinkedListSearch[j];
        }
        System.out.println("LinkedList average total search time = " + Math.round(totalLinkedListSearch / timeLinkedListSearch.length));
    }

    public static Integer[] Rand (int range, int size){
        /**
         *  This function takes two inputs, range and size and returns an array of unique elements of length = size.
         *  A new Random instance r is created with seed = current time in ms.
         *  A Set data structure is used so that duplicate elements do not exist while generating random numbers.
         *  Using a for loop all generated random numbers  are stored into the set datastructures using 'set.add' method.
         *
         *  Since set data structure removes duplicates, it is possible that size of the set data structure 'a'
         *   be less than size given as parameter for the Rand function.
         *  To fix size issue with set data structure, a while loop is created to generate random numbers with a new
         *  seed and to fill the empty spaces that was removed due to "no duplicate element" property of set.
         *  The while loop runs until the size of set is = size input parameter of the Rand function.
         *
         *  This while loop ensures the set datastructures have size same as size given as parameter in Rand function.
         *
         *  Now this set datastructures 'a' is copied into array 'b' and now array 'b' is returned to the caller in main.
         */
        Random r = new Random(System.currentTimeMillis());
        Set<Integer>a = new LinkedHashSet<>(size);
        for (int i=0;i<size;i++) {
            a.add(r.nextInt(range)+1);
        }
        while (a.size() < size) {
            r.setSeed(System.currentTimeMillis());
            a.add(r.nextInt(a.size())+1);
        }
        Integer[] b = Arrays.copyOf(a.toArray(),a.size(),Integer[].class);
        return b;
    }
}
