package bizzy_2025;

public class Order {

	// Attributes
	private int orderNumber;
	private int quantity;
	private double price;

	public Order(int orderNumber, int quantity, double price) {
		this.orderNumber = orderNumber;
		this.quantity = quantity;
		this.price = price;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Order #" + orderNumber + " | Quantity: " + quantity + " | Price per piece: $" + price
				+ " | Total Price: $" + (quantity * price);
	}
}
