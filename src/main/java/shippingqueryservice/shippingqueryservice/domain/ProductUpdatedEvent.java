package shippingqueryservice.shippingqueryservice.domain;

public class ProductUpdatedEvent {
    private String cartNumber;
    private String productNumber;
    private int quantity;
    private String customerId;

    public ProductUpdatedEvent() {}

    public ProductUpdatedEvent(String cartNumber, String productNumber, int quantity, String customerId) {
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
        return "ProductUpdatedEvent{" +
                "cartNumber='" + cartNumber + '\'' +
                ", productNumber='" + productNumber + '\'' +
                ", quantity=" + quantity +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
