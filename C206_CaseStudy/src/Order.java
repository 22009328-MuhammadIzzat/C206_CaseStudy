import java.util.ArrayList;

public class Order {
	private String orderId;
    private String date;
    private ArrayList<String> menuItems;
 

    public Order(String orderId, String date, ArrayList<String> menuItems) {
        this.orderId = orderId;
        this.date = date;
        this.menuItems = menuItems;
    }

    public String getorderId() {
        return orderId;
    }

    public String getDate() {
        return date;
    }

    public ArrayList<String> getMenuItems() {
        return menuItems;
    }
    
    public String toStringOrder() {
		String itemInfo =  String.format("%-30s %-30s %-10s\n", orderId,
				date, menuItems);
		
		return itemInfo;
    
}

}
