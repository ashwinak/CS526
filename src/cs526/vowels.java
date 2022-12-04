package cs526;

import java.util.Scanner;

public class vowels {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String temp = scan.next();
        System.out.println(countVowels(temp));
    }
    public static int countVowels(String temp) {
        String temp1 = "AEIOUaeiou";
        int count = 0;
        for (int i=0;i<temp.length(); i++) {
            for (int j=0; j<temp1.length();j++) {
                if(temp.charAt(i) == temp1.charAt(j)) {
                    count++;
                }
            }
        } return count;
    }
}
