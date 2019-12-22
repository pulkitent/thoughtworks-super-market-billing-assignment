
public class FreeItemDiscount {
	private final int minimumBuyingQuantity;
	private final int freeQuantity;
	
	public FreeItemDiscount(int minimumBuyingQuantity, int freeQuantity) {
		this.minimumBuyingQuantity = minimumBuyingQuantity;
		this.freeQuantity = freeQuantity;
	}
	
	public int getFreeItemDiscount(int quantity,int pricePerUnit) {
		int discountAmount = 0;
		int totalFreeAmount = 0;
		if(quantity>minimumBuyingQuantity+freeQuantity) {
			 totalFreeAmount = ((minimumBuyingQuantity+freeQuantity)/quantity)*freeQuantity;
			
		}
		else if(quantity>minimumBuyingQuantity){
			totalFreeAmount = minimumBuyingQuantity-quantity;
		}
		
		discountAmount = totalFreeAmount*pricePerUnit;
		
		return discountAmount;
	}
	
	
}
