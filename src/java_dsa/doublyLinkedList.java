package java_dsa;
public class doublyLinkedList {
    private Node head;
    private Node tail;
    private int length;
    class Node {
        int value;
        Node next;
        Node prev;
        public Node(int value) {
            this.value = value;
        }
    }
    public doublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
       // length = 1;
    }
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void AppendDLL(int value) {
        Node myDLL = new Node(value);
        if (length==0) {
            myDLL.prev = null;
            myDLL.next = null;
            head = tail = myDLL;
        } else {
            myDLL.prev = tail;
            tail.next = myDLL;
            tail = myDLL;
        }
        length++;
    }
    public Node removeLast() {
        Node temp = tail;
        if (length == 0 ) {
            return null;
        }
        if(length == 1) {
            head = tail = null;
        }else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        return temp;
    }
    public void prepend(int value) {
        Node myDLL = new Node(value);
        if (length == 0) {
            head = myDLL;
            tail = myDLL;
        } else {
            myDLL.next = head;
            head.prev = myDLL;
            head = myDLL;
        }
        length++;
    }
//    public boolean insert(int index, int value) {
//        Node myDLL = new Node(value);
//        if(index<0 || index>length) return false;
//        if (index == 0) {
//            prepend(value);
//            return true;
//        } else if (index == length -1) {
//            AppendDLL(value);
//            return true;
//        }else {
//            Node before = get(index -1);
//            Node after = before.next;
//            myDLL.prev = before;
//            myDLL.next = after;
//            before.next = myDLL;
//            after.prev = myDLL;
//            length++;
//            return true;
//        }
//    }
//    public Node remove(int index) {
//        if(index<0 || index>= length) return null;
//        if (index == 0) {
//            Node One = get(index);
//            One.prev = One.next = null;
//            return One;
//        }
//        if (index == length -1) {
//            return removeLast();
//        }
//        else {
//            Node remove = get(index);
//            Node before = get(index -1 );
//            Node after = get (index + 1);
//            before.next = after;
//            after.prev = before;
//            length--;
//            return remove;
//        }
//    }
}