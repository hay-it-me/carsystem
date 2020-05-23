public class Car {
	private String carName;
	private String carRego;
	private String carColour;
	private int numTrips;
	private int[] odoArray;
	
	//Creating all appropriate getters and setters.
	public void setCarName(String carName){
		this.carName = carName;
	}
	public String getCarName(){
		return carName;
	} 
	public void setCarRego(String carRego){
		this.carRego = carRego;
	}
	public String getCarRego(){
		return carRego;
	}
	public void setCarColour(String carColour){
		this.carColour = carColour;
	}
	public String getCarColour(){
		return carColour;
	} 
	public void setNumTrips(int numTrips){
		this.numTrips = numTrips;
	}
	public int getNumTrips(){
		return numTrips;		
	}
	//Setter for odometer values stored as an array.
	public void setOdoArray(int[] odoArray){
		this.odoArray = odoArray;
	}
	//No-arg constructor
	public Car(){	
	} 		
	//Constructor method to return a string output 
	//with shortest, longest and average distances all at once.
	public String distTrav(){
		//Initialise variables for longest and shortest distances
		int longDist;
		int shortDist;
		//Create an array that shows the distance travelled 
		//for each iteration if array has at least 2 items.
		if (odoArray.length > 1){
			int temp = odoArray[0];
			int [] distTravelArray = new int [odoArray.length-1]; 
			//For loop to fill distance travelled array from odometer array.
			for (int i = 1; i < odoArray.length; i++){
				distTravelArray[i - 1] = odoArray[i] - temp;
				temp = odoArray[i];
			}
			double sum = 0;
			longDist = distTravelArray[0];
			shortDist = distTravelArray[0];
			//For loop to sum the distance travelled and look for highest and lowest values.
			for (int i = 0; i < distTravelArray.length; i++){
				sum += distTravelArray[i];
				if (distTravelArray[i] > longDist){
					longDist = distTravelArray[i];
				}
				if (distTravelArray[i] < shortDist){
					shortDist = distTravelArray[i];
				}
			}
			//If statement to check for decimal places in average distance, 
			//casts int if none, rounds to 2 decimal places if so.
			if ((sum / distTravelArray.length)%1 == 0){
				int averageDist = (int)sum / distTravelArray.length;
				return ("Longest distance travelled: " + longDist 
						+ "\nShortest distance travelled: " + shortDist 
						+ "\nAverage distance travelled: " + averageDist);
			} 
			else {
				double averageDist = sum / distTravelArray.length;
				return ("Longest distance travelled: " + longDist + 
						"\nShortest distance travelled: " + shortDist +
						"\nAverage distance travelled: " + 
						String.format("%.2f",averageDist));
			}
		} 
		else {
			//If there is only one odometer value, then all distances are shown as 0.
			return ("Longest distance travelled: 0"
					+ "\nShortest distance travelled: 0"
					+ "\nAverage distance travelled: 0");
		}
	}
}