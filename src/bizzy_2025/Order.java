package bizzy_2025;

public class Order {

	// Attributes
	int orderNumber;
	int quantity;
	double eachPiecePrice;
	
	// Constructors
	public Order(int orderNumber, int quantity, double eachPiecePrice) {
		this.orderNumber = orderNumber;
		this.quantity = quantity;
		this.eachPiecePrice = eachPiecePrice;
	}
	
	public int getOrderNumber() {
		return orderNumber;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public double getEachPiecePrice() {
		return eachPiecePrice;
	}

	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", quantity=" + quantity + ", eachPiecePrice=" + eachPiecePrice
				+ "]";
	}
	
	
	
}
