import java.util.LinkedList;

public class CheckoutLine {

    // LinkedList chosen - O(1) add/remove at front and back
    private LinkedList<Customer> line;

    public CheckoutLine() {
        this.line = new LinkedList<>();
    }

    public void addToBack(Customer c) {
        line.addLast(c); // O(1)
    }

    public void addToFront(Customer c) {
        line.addFirst(c); // O(1)
    }

    public Customer removeFromFront() {
        if (line.isEmpty()) return null;
        return line.removeFirst(); // O(1)
    }

    public Customer removeFromBack() {
        if (line.isEmpty()) return null;
        return line.removeLast(); // O(1)
    }

    public int size() {
        return line.size(); // O(1)
    }
}