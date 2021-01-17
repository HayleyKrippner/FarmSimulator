package generalStore;

/**
 * This class implements all the methods for the items in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
public class Item{
	/**
	 * The purchase price of the Item.
	 */
	private int purchasePrice;
	/**
	 * The Item's benefit information.
	 */
	private String itemBenefitInfo;
	/**
	 * The type of the Item.
	 */
	private String farmObjectType;
	
	/**
	 * This method creates an Item.
	 * @param farmObjectType This the type of the Item.
	 * @param purchasePrice This is the purchase price of the Item.
	 * @param itemBenefitInfo This is the Item's benefit information.
	 */
	public Item(String farmObjectType, int purchasePrice, String itemBenefitInfo) {
		this.farmObjectType = farmObjectType;
		this.purchasePrice = purchasePrice;
		this.itemBenefitInfo = itemBenefitInfo;
	}

	public String getItemBenefitInfo() {
		return itemBenefitInfo;
	}
	
	public String getItemType() {
		return this.farmObjectType;
	}
	
	public int getPurchasePrice() {
		return purchasePrice;
	}

}
