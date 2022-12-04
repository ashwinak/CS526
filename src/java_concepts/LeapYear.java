package java_concepts;

public class LeapYear {
    public static void main (String[] args) {
        System.out.println(isLeapYear(9999));
    }
    public static boolean isLeapYear (int year) {
        if (year <=0 || year > 9999) {
        return false;
        } else if (year % 4 == 0 && year % 100 == 0 && year % 400 == 0 ){
            return true;
        } else {
            return false;
        }
    }
}
