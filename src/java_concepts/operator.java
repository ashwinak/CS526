package src.java_concepts;

public class operator {
    public static void main (String[] args) {
        double v1 = 20.00d;
        double v2 = 80.00d;
        double r1 = (v1 + v2) * 100.00d; // operator precedence.
        System.out.println(r1);
        double rm1 = r1 % 40.00d;
        System.out.println("the remainder is: " + rm1);
        boolean isNoRemainder = (rm1 == 0) ? true : false;
        System.out.println(isNoRemainder);
        if (!isNoRemainder){
            System.out.println("got some remainder");
        }
    }

}
