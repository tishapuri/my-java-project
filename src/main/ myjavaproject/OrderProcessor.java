### Example Java Code with Code Smells

public class OrderProcessor {

    public void processOrder(Order order) {
        validateOrder(order);
        calculateTotal(order);
        applyDiscount(order);
        updateInventory(order);
        generateInvoice(order);
    }

    private void validateOrder(Order order) {
        // validation logic
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        if (order.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order must contain items");
        }
    }

    private void calculateTotal(Order order) {
        double total = 0;
        for (Item item : order.getItems()) {
            total += item.getPrice();
        }
        order.setTotal(total);
    }

    private void applyDiscount(Order order) {
        if (order.getTotal() > 100) {
            order.setTotal(order.getTotal() * 0.9); // 10% discount
        }
    }

    private void updateInventory(Order order) {
        for (Item item : order.getItems()) {
            Inventory.update(item.getId(), item.getQuantity());
        }
    }

    private void generateInvoice(Order order) {
        Invoice invoice = new Invoice(order);
        invoice.generate();
    }
}
