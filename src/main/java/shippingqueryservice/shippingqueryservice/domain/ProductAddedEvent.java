package shippingqueryservice.shippingqueryservice.domain;

public class ProductAddedEvent {
    private String cartNumber;
    private String productNumber;
    private int quantity;
    private String customerId;

    public ProductAddedEvent() {}

    public ProductAddedEvent(String cartNumber, String productNumber, int quantity, String customerId) {
        this.cartNumber = cartNumber;
        this.productNumber = productNumber;
        this.quantity = quantity;
        this.customerId = customerId;
    }

    public String getCartNumber() {
        return cartNumber;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCustomerId() {
        return customerId;
    }

    @Override
    public String toString() {
        return "ProductAddedEvent{" +
                "cartNumber='" + cartNumber + '\'' +
                ", productNumber='" + productNumber + '\'' +
                ", quantity=" + quantity +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
