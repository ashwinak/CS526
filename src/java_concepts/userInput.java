package java_concepts;

import java.util.Scanner;

public class userInput {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = 0;
        int sum = 0;
        while (count <=4) {
            System.out.println("Enter number " + count + ":");
            boolean isAnInt = scan.hasNextInt();
            if (isAnInt) {
                int number = scan.nextInt();
                sum +=number;
            }else {
                System.out.println("invalid number");
            }
            scan.nextLine();
            count ++;
        }
        System.out.println("the sum of " + count + " numbers is " + sum);
        scan.close();
    }
}
