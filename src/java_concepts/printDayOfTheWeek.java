package java_concepts;

public class printDayOfTheWeek {
    public static void main(String[] args) {
        printDayOfTheWeek(5);
        System.out.println("prime : "+ isPrime(15));
    }
    public static void printDayOfTheWeek(int day) {
        switch (day) {
            case 0:
                System.out.println("Sunday");
                break;
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thur");
                break;
            case 5:
                System.out.println("Fri");
                break;
            case 6:
                System.out.println("Sat");
                break;
        }
    }
    public static boolean isPrime(int n) {
        if (n ==1) {
            return false;
        }
        for (int i =2; i<n/2;i++) {
            if (n%i==0) {
                return false;
            }
        }
        return true;

    }
    

}
