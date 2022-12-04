package java_concepts;

public class switch1 {
    public static void main (String[] args) {
        char charV = 'E';
        switch(charV) {
            case 'A':
                System.out.println("Selected A");
                break;
            case 'B':
                System.out.println("selected B");
                break;
            case 'C': case 'D' : case 'E':
                System.out.println("selected c | d | e");
                break;
            default:
                System.out.println("selected none");
                break;
        }
    }
}
