package shippingqueryservice.shippingqueryservice.domain;

public class ProductRemovedEvent {
    private String cartNumber;
    private String productNumber;
    private String customerId;

    public ProductRemovedEvent() {}

    public ProductRemovedEvent(String cartNumber, String productNumber, String customerId) {
        this.cartNumber = cartNumber;
        this.productNumber = productNumber;
        this.customerId = customerId;
    }

    public String getCartNumber() {
        return cartNumber;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    @Override
    public String toString() {
        return "ProductRemovedEvent{" +
                "cartNumber='" + cartNumber + '\'' +
                ", productNumber='" + productNumber + '\'' +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
