package farm;

/**
 * This class implements the methods for a Farmer in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
public class Farmer {
	
	/**
	 * The name of the Farmer
	 */
	private String farmerName;
	/*
	 * The age of the Farmer
	 */
	private int farmerAge;

	/*
	 * Creates a Farmer
	 * @param farmerName
	 * @param farmerAge
	 */
	public Farmer(String farmerName, int farmerAge) {
		this.farmerName = farmerName;
		this.farmerAge = farmerAge;
	}
	
	/**
	 * Displays Farmer name and age
	 */
	public String toString() {
		return "Farmer Name: " + this.farmerName + ", Farmer Age: " + this.farmerAge;
	}
	
	/**
	 * @return name of Farmer
	 */
	public String getFarmerName() {
		return farmerName;
	}
	
	/**
	 * @return age of Farmer
	 */
	public int getFarmerAge() {
		return farmerAge;
	}

}
