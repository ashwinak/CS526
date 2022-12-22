package java_concepts;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class fileRead {

	public static void main(String[] args) throws IOException {
		try {
			FileWriter proc_Output = new FileWriter("CS526/src/java_concepts/routeDump_output.txt");
			File car_input = new File("CS526/src/java_concepts/routeDump.txt");
					Scanner s = new Scanner(car_input);
			ArrayList<Integer> mask = new ArrayList<>();
			while (s.hasNext()) {
				String eachLine = s.nextLine();
				String[] carParse = eachLine.split(",");
				mask.add(Integer.parseInt(carParse[1]));
			}
			HashSet<Integer> uniqueMask = new HashSet<>(mask);
			ArrayList<Integer> uqMask = new ArrayList<>(uniqueMask);
			for (int i=0;i<uqMask.size();i++) {
				int a = 0;
				for (int j=0;j<mask.size();j++) {
					if (mask.get(j).intValue() == uqMask.get(i).intValue()) {
						a++;
					}
				}
				proc_Output.write("\n");
				proc_Output.write("Mask " + uqMask.get(i) + ": Count " + a);
			}
			proc_Output.close();

		}
		catch (IOException e) {
			System.out.println("File not Found");
		}
	}
}
