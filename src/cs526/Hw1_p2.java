package cs526;
import java.io.IOException;
import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class Hw1_p2 {

	// Description and i/o for the Method : This method takes object Array of cars as input and returns only rows that match the 2nd argument "make.
	// Enters a for loop and compares each object to see if it matches the 2nd argument of this method "make". If match found
	// then print only those objects accessed via the indices of cars array. Returns none and only prints after the if condition is true.

	public static void findByMake(Car[] cars, String make) {
		// implement this method
		for (int i=0;i<cars.length;i++) {
			if (Objects.equals(cars[i].getMake(), "Honda")) {
				System.out.println("	"+ "Make = " + cars[i].getMake() + "	" + " Year = " + cars[i].getYear() + "	"+ " Price = " + cars[i].getPrice());
			}
		}
	}

	public static void olderThan(Car[] cars, int year) {
		// implement this method

		// Description and i/o for the Method : This method takes cars object array as input and outputs only objects whose year is less than the 2nd
		// argument "year". Again this method enters a loop and uses compare operator to see if objects getyear() is less than 2nd argument "year".
		// Returns none and only prints after the if condition is true.

		for (int i=0;i<cars.length;i++) {
			if (cars[i].getYear() < year) {
				System.out.println("	"+ "Make = " + cars[i].getMake() + " "+" Year = " + cars[i].getYear() + " "+" Price = " + cars[i].getPrice());
			}
		}
	}


	public static void main(String[] args) throws IOException {

		// complete this part
		// create an array of Car objects, cars, of size 10
		// read input file and store 10 car Objects in the array

		//Description and i/o for the Method : This is the main method that initializes array of Cars object of size 10.
		// Reads the text file car_input.txt and scans each line with a delimiter of "," in a while loop.
		// each line with a split function is stored in another string array called carParse.
		// Now the contents of string Array carParse is iterated and stored as an object in the object array cars. The object array index
		// is incremented on every while loop iteration so that each element of the string array is stored as seperate object in the object
		// array cars.
		// After reading this text file, there exist a cars object array of size 10 that has object pointers to each line of the txt file.
		// The Car object is instantiated in this process for each line using the constructor defined in car.java class.
		// Finally this method outputs all cars in the object array cars and invokes the other two methods findByMake and olderThan.
		// The entire code is executed in a try catch block. The try block is executed if the file path is correct, if not "file not found"
		// exception is thrown at the user.
		try {
			Car[] cars = new Car[10];
			File car_input = new File("src/cs526/car_input.txt");
					Scanner s = new Scanner(car_input);
			int count =0;
			while (s.hasNext()) {
				String eachLine = s.nextLine();
				String[] carParse = eachLine.split(",");
				System.out.println(carParse[1]);
				cars[count++] = new Car(carParse[0],Integer.parseInt((carParse[2]).trim()),Integer.parseInt((carParse[1]).trim()));
			}
			System.out.println("\nAll cars:");
			for (int i=0; i<cars.length; i++) {
				System.out.println(cars[i]);
			}

			String make = "Honda";
			int year = 2017;

			System.out.println("\nAll cars made by " + make);
			findByMake(cars, make);
			System.out.println("\nAll cars made before " + year);
			olderThan(cars, year);

		}
		catch (IOException e) {
			System.out.println("File not Found");
		}
	}
}
