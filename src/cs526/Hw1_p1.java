package cs526;

public class Hw1_p1 {
	
	public static void find(int[] a, int x) {
		// implement this method
		// Description and i/o for the Method : This method takes array of int and int as inputs. This method determines if the 2nd
		// argument of type int is found in the first argument of type array of ints. No returns from this method, only print the relevant portion after the
		// if condition is true.
		int count =0;
		for (int i=0; i<a.length;i++) {
			if (a[i] == x) {
				System.out.println(x + " is in a[" +i+ "]");
				count++;
			}
		}
		if (count == 0) {
			System.out.println(x + " does not exist");
		}
	}
	
	public static boolean isPrefix(String s1, String s2) {
		// Description and i/o for the Method : This method takes two str as inputs and compares if the first str is a prefix of 2nd str.
		// If true, then it returns boolean result to the caller method.
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s2.charAt(i)) {
				i++;
			}
			if (i == s1.length()) {
				return true;
			}
		}
	 return false;
	}

	
	public static void main(String[] args) {

		// Description and i/o for the Method : This is the main method that declares and creates array a of type int.
		// invokes the other two methods find and isPrefix and prints the relevant output.
		
		int[] a = {5, 3, 5, 6, 1, 2, 12, 5, 6, 1};

		find(a, 5);
		find(a, 10);
//		find(a, 1); //edge case
//		find(a, 6); //additional case

		System.out.println();

		String s1 = "abc";
		String s2 = "abcde";
		String s3 = "abdef";
//		String s3 = "dabc"; //edge case
//		String s3 = "abdc"; //edge case
//		String s3 = "ab c"; //edge case
//		String s2 = "a bcde"; //edge case

		if (isPrefix(s1,s2)) {
			System.out.println(s1 + " is a prefix of " + s2);
		}
		else {
			System.out.println(s1 + " is not a prefix of " + s2);
		}

		if (isPrefix(s1,s3)) {
			System.out.println(s1 + " is a prefix of " + s3);
		}
		else {
			System.out.println(s1 + " is not a prefix of " + s3);
		}
	}
}
