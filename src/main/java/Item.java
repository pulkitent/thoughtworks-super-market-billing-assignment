
public class Item {
	
	private final Category category;
	private final SubCategory subCategory;
	private final String name;
	private final int price;
	private final UnitOfMeasurement unitOfMeasurement;
	
	public Item(Category category, SubCategory subCategory, String name, int price,UnitOfMeasurement unitOfMeasurement) {
		this.category = category;
		this.subCategory = subCategory;
		this.name = name;
		this.price = price;
		this.unitOfMeasurement = unitOfMeasurement;
	}
	
	public int getTotalPrice(int quantity)
	{
		
		return 0;
		
	}

}
