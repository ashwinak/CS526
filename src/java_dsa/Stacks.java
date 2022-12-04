package java_dsa;

public class Stacks {
    private Node top;
    private int height;

    class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
    }
    public Stacks(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }
    public void printStack () {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
    public void push ( int value){
        Node myDLL = new Node(value);
        if (height == 0) {
            top = myDLL;
        } else {
            myDLL.next = top;
            top = myDLL;
        }
        height++;
    }
    public Node pop () {
        Node temp = top;
        if (height == 0) {
            return null;
        }
        if (height == 1) {
            top = null;
        } else {
            top = top.next;
            temp.next = null;
            temp = null;
            height--;
        } return temp;
    }
}



