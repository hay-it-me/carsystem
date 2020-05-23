import java.util.Scanner;
public class TestCar {
	
	public static void main(String[] args){
		Scanner userInput = new Scanner(System.in);
		Car testCar = new Car();

		System.out.print("Input name: ");
		testCar.setCarName(userInput.nextLine());
		
		System.out.print("Input registration: ");
		testCar.setCarRego(userInput.nextLine());
		
		System.out.print("Input colour: ");
		testCar.setCarColour(userInput.nextLine());
		
		System.out.print("Input trips: ");
		testCar.setNumTrips(userInput.nextInt());
		
		//Creates an array to store odometer values, loops to ask 
		//for odometer readings and then stores them within the array. 
		int [] odoArray = new int [testCar.getNumTrips() + 1];
		for (int i = 0; i < testCar.getNumTrips() + 1; i++){
			System.out.print("Odometer reading " + i + ": ");
			odoArray[i] = userInput.nextInt();
		}
		//Transfers array to the car class.
		testCar.setOdoArray(odoArray);
		
		//Returns and prints the car data.
		System.out.println();
		System.out.println(testCar.getCarName() + " | " + testCar.getCarRego() 
						   + " | " + testCar.getCarColour());
		System.out.println(testCar.distTrav());
		
		userInput.close();
	}
}