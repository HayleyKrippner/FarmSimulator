package animals;

/**
 * This class implements the methods for an Animal in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
public class Animal{
	
	/**
	 * The type of the FarmObject.
	 */
	private String farmObjectType;
	/**
	 * The health level of the Animal.
	 */
	private int health;
	/**
	 * The happiness level of the Animal.
	 */
	private int happiness;
	/**
	 * The purchase price of the Animal.
	 */
	private int purchasePrice;
	
	/**
	 * This method creates an Animal.
	 * Animal health and happiness levels are initialised to the maxium level of 100.
	 * @param farmObjectType This is the type of Animal to create.
	 * @param purchasePrice This is the purchase cost of the Animal.
	 */	
	public Animal(String farmObjectType, int purchasePrice){
		this.setFarmObjectType(farmObjectType);        
		this.setPurchasePrice(purchasePrice);
		this.setHealth(100);                 
		this.setHappiness(100);   
	}


	public String getFarmObjectType() {
		return farmObjectType;
	}


	public void setFarmObjectType(String farmObjectType) {
		this.farmObjectType = farmObjectType;
	}


	public int getPurchasePrice() {
		return purchasePrice;
	}


	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}


	public int getHealth() {
		return health;
	}


	public void setHealth(int health) {
		this.health = health;
	}


	public int getHappiness() {
		return happiness;
	}


	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}
	
	/**
	 * Reduces the Animal's happiness level by 10 units.
	 */
	public void reduceAnimalHappiness() {
		happiness -= 10;
	}
	
	/**
	 * Reduces the Animal's health level by 10 units.
	 */
	public void reduceAnimalHealth() {
		health -= 10;
	}
	
	/**
	 * Feeds the Animal, ensuring that the maximum health level of 100 is not breached.
	 * The Animal's health level is increased by 20 units.
	 */
	public void feed() {
		if (health + 20 > 100) {
			health = 100;
		} else {
			health += 20;
		}
	}
	
	/**
	 * Play with the Animal, ensuring that the maximum happiness level of 100 is not breached.
	 * The Animal's happiness level is increased by 10 units.
	 */
	public void play() {
		if (happiness + 10 > 100) {
			happiness = 100;
		} else {
			happiness += 10;
		}
	}

}
