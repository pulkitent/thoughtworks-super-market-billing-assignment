
public class FlatDiscount {

	private final int discountPercent;

	public FlatDiscount(int discountPercent) {
		this.discountPercent = discountPercent;
	}
	
	public int getFlatDiscount(int totalCost) {
		int flatDiscount=discountPercent*totalCost/100;
		return flatDiscount;
	}

}
