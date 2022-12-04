package cs526;

public class Hw2_p3 {
    // implement reverse method
    // you may want to write a separate method with additional parameters, which is recursive

    /**
     Brief Description of the method : This method takes doublylinkedList as input and performs
     reversal of all integers in the DLL.
     A base case is used to exit the recursion i.e when the list size is empty.
     This method uses recursion to perform reversal of the elements and does not store the DLL in a separate memory.
     In other words, this method performs in-place reversal of the DLL elements.
     */

    public static void reverse(DoublyLinkedList<Integer> intList) {
        /**
        This is the base case to exit from recursion. After the removeFirst() method is executed on every recursive call
        the DoublyLinkedList intList will be empty and there are no elements to process. At this point the control
        is given back method.
        */
        if (intList.size() == 0) {
            return;
        }
        /**
         The next four lines will help to reverse the elements of the DLL(doubleLinkedList).
         Here we store the first element into a variable and then remove the first element from the DLL.
         The 3rd line recursively calls the same method. By now the call stack has temp = first element (say 10)
         at the bottom of the stack.

         Now again the base case is validated, since it is not true, temp variable stores the first element of the DLL
         but this time the DLL first element(previously 2nd element) is after removing first element in the previous call
         from main. The top of stack has temp = new first element(say 20).

         This process continues until when base case is true i.e. intList.size == 0 which is achieved by removing the
         first element of the DLL at every recursive call.

         Finally,  the Stack contains last element of DLL stored in variable temp at the top and first element of DLL
         stored in variable temp at the bottom.
         Stack always executes in LIFO order. So the last stack with temp = 50(last element of DLL) is removed from stack
         and the 4th line is executed with addLast method. This order continues until all stack elements are removed.
         The control is then given back to main function which prints the DLL in reverse order.

         We are effectively using the Stack LIFO operation to perform DLL element reversal.
         */
        int temp = intList.first();
        intList.removeFirst();
        reverse(intList);
        intList.addLast(temp);
    }
    public static void main(String[] args) {

        /**
         The main method is used to test the reverse method with two different DLL elements.
         First a fixed size array is initialized with elements, a for loop is introduced to walk through
         the elements of that array and stored into the DLL using DLL.addLast method.

         */


        DoublyLinkedList<Integer> intList = new DoublyLinkedList<>();

        int[] a = {10, 20, 30, 40, 50};
        for (int i=0; i<a.length; i++) {
            intList.addLast(a[i]);
        }
        System.out.println("Initial list: size = " + intList.size() + ", " + intList.toString());

        /**
         The code above prints the DLL before reversal and code below prints DLL after in-place reversal.
         */
        reverse(intList);

        System.out.println("After reverse: " + intList.toString());

        intList = new DoublyLinkedList<>();
        int[] b = {10, 20, 30, 40, 50, 60};
        for (int i=0; i<b.length; i++) {
            intList.addLast(b[i]);
        }
        System.out.println();
        System.out.println("Initial list: size = " + intList.size() + ", " + intList.toString());

        // Here, invoke the reverse method you implemented above
        reverse(intList);

        System.out.println("After reverse: " + intList.toString());

    }

}
