import java.util.ArrayList;

public class CheckoutLineArray {
    private ArrayList<Customer> line;

    public CheckoutLineArray() {
        this.line = new ArrayList<>();
    }

    public void addToFront(Customer c) {
        line.add(0, c); // O(n) - shifts all elements right
    }

    public void addToBack(Customer c) {
        line.add(c); // O(1) amortized
    }

    public Customer removeFromFront() {
        if (line.isEmpty()) return null;
        return line.remove(0); // O(n) - shifts all elements left
    }

    public Customer removeFromBack() {
        if (line.isEmpty()) return null;
        return line.remove(line.size() - 1); // O(1)
    }

    public int size() {
        return line.size(); // O(1)
    }
}
