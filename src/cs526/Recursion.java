package cs526;

public class Recursion {

    public static void recur (int n) {
        if (n==0) {
            return;
        }
        n--;
        System.out.println("Pre recur " + n);
        recur(n);
        System.out.println("Post recur " + n);

    }

    public static void main(String[] args) {
        recur(2);
    }
}
