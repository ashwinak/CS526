package java_dsa;

public class hashTable {
    private int size;
    private Node [] dataMap;

    public hashTable(int size) {
        dataMap = new Node[size];
    }

    class Node {
        String key;
        int value;
        Node next;
        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public void printTable() {
        for(int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println("   {" + temp.key + "= " + temp.value + "}");
                temp = temp.next;
            }
        }
    }
    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }
    public int get(String key) {
        int index = hash(key);
        Node temp = dataMap[index];
        while (temp != null){
            if (temp.key == key) {
                System.out.println(key + " found");
                return temp.value;
            }
            temp = temp.next;
        } return 0;
    }
    public void set(String key, int value) {
        int index =hash(key);
        Node newNode = new Node(key,value);
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        }else {
            Node temp = dataMap[index];
            while (temp.next != null) {
                temp= temp.next;
            }
            temp.key = key;
            temp.value = value;
        }

    }
}
