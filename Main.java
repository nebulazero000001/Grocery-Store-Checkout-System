public class Main {
    public static void main(String[] args) {

        // ---- Purchase Log Testing ----
        PurchaseItem[] sampleItems = {
            new PurchaseItem("Bread", 3.49),
            new PurchaseItem("Milk", 2.99),
            new PurchaseItem("Eggs", 4.29),
            new PurchaseItem("Coffee", 8.99),
            new PurchaseItem("Bananas", 1.29),
            new PurchaseItem("Cereal", 4.79),
            new PurchaseItem("Chicken Breast", 9.99),
            new PurchaseItem("Paper Towels", 6.49)
        };

        PurchaseLog log = new PurchaseLog();

        // Load all items into the log
        for (int i = 0; i < sampleItems.length; i++) {
            log.addItem(sampleItems[i]);
        }

        System.out.println("Purchase Log loaded with " + 
            log.itemCount() + " items.");

        // Test findItemByName
        PurchaseItem found = log.findItemByName("Coffee");
        System.out.println("Looked up 'Coffee', found: " +
            (found != null ? found.getName() + 
            " $" + found.getPrice() : "NOT FOUND"));

        // Test updatePrice
        log.updatePrice("Milk", 3.49);
        PurchaseItem updated = log.findItemByName("Milk");
        System.out.println("Updated Milk price, new price: $" + 
            updated.getPrice());

        // Test printDailyReport
        log.printDailyReport();

        // ---- Checkout Line Testing ----
        Customer[] sampleCustomers = {
            new Customer("Alvarez", 12),
            new Customer("Chen", 3),
            new Customer("Patel", 27),
            new Customer("O'Brien", 1)
        };

        CheckoutLine line = new CheckoutLine();

        // Load all customers into the line
        for (int i = 0; i < sampleCustomers.length; i++) {
            line.addToBack(sampleCustomers[i]);
        }

        System.out.println("\nCheckout Line loaded, size = " + 
            line.size());

        // Test addToFront - express lane
        Customer express = new Customer("Nguyen", 1);
        System.out.println("Waving " + express.getName() + 
            " to the front...");
        line.addToFront(express);
        System.out.println("Line size after adding Nguyen to front: " + 
            line.size());

        // Test removeFromFront - should be Nguyen
        Customer served = line.removeFromFront();
        System.out.println("Served customer at front: " + 
            served.getName() + " (should be Nguyen)");

        // Test removeFromBack
        Customer left = line.removeFromBack();
        System.out.println("Customer left from back: " + 
            left.getName() + " (should be O'Brien)");

        // Confirm size changed correctly
        System.out.println("Line size after two removals: " + 
            line.size() + " (should be 3)");

        // ---- Part 3: Performance Comparison ----
        System.out.println("\n--- Performance Comparison ---");
        performanceTest();
    }

    public static void performanceTest() {

        // --- Purchase Log: ArrayList vs LinkedList findItemByName ---
        PurchaseLog arrayLog = new PurchaseLog();
        PurchaseLogLinked linkedLog = new PurchaseLogLinked();

        // Load 1000 items into both
        for (int i = 0; i < 1000; i++) {
            arrayLog.addItem(new PurchaseItem("Item" + i, i * 0.99));
            linkedLog.addItem(new PurchaseItem("Item" + i, i * 0.99));
        }

        // Time 1000 findItemByName on ArrayList version
        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayLog.findItemByName("Item999");
        }
        long end = System.nanoTime();
        System.out.println("ArrayList - 1000 findItemByName: " + 
            (end - start) + " ns");

        // Time 1000 findItemByName on LinkedList version
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedLog.findItemByName("Item999");
        }
        end = System.nanoTime();
        System.out.println("LinkedList - 1000 findItemByName: " + 
            (end - start) + " ns");

        // --- Checkout Line: LinkedList vs ArrayList addToFront ---
        CheckoutLine linkedLine = new CheckoutLine();
        CheckoutLineArray arrayLine = new CheckoutLineArray();

        // Time 1000 addToFront on LinkedList version
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedLine.addToFront(new Customer("Customer" + i, i));
        }
        end = System.nanoTime();
        System.out.println("LinkedList - 1000 addToFront: " + 
            (end - start) + " ns");

        // Time 1000 addToFront on ArrayList version
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayLine.addToFront(new Customer("Customer" + i, i));
        }
        end = System.nanoTime();
        System.out.println("ArrayList - 1000 addToFront: " + 
            (end - start) + " ns");
    }
}