import java.util.ArrayList;

public class PurchaseLog {

    // ArrayList chosen because we need fast index-based access
    // for looping through all items in the daily report
    private ArrayList<PurchaseItem> items;

    public PurchaseLog() {
        this.items = new ArrayList<>();
    }

    public void addItem(PurchaseItem item) {
        items.add(item); // O(1) amortized - adds to end
    }

    public PurchaseItem findItemByName(String name) {
        // O(n) - must scan through every item
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(name)) {
                return items.get(i);
            }
        }
        return null;
    }

    public void updatePrice(String name, double newPrice) {
        // O(n) - must find the item first
        PurchaseItem item = findItemByName(name);
        if (item != null) {
            item.setPrice(newPrice);
        }
    }

    public void printDailyReport() {
        // O(n) - loops through every item
        double totalRevenue = 0;
        String bestSeller = "";
        double highestPrice = -1;

        System.out.println("\n--- Daily Report ---");
        System.out.println("Total items scanned: " + items.size());

        for (int i = 0; i < items.size(); i++) {
            PurchaseItem item = items.get(i); // O(1) for ArrayList
            totalRevenue += item.getPrice();
            if (item.getPrice() > highestPrice) {
                highestPrice = item.getPrice();
                bestSeller = item.getName();
            }
        }

        System.out.printf("Total revenue: $%.2f%n", totalRevenue);
        System.out.println("Best seller: " + bestSeller + 
            " ($" + highestPrice + ")");
        System.out.println("--------------------");
    }

    public int itemCount() {
        return items.size(); // O(1)
    }
}
