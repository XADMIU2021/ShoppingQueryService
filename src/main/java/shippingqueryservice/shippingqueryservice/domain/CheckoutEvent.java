package shippingqueryservice.shippingqueryservice.domain;

public class CheckoutEvent {
    private String customerId;
    private String cartNumber;

    public CheckoutEvent() {
    }

    public CheckoutEvent(String customerId, String cartNumber) {
        this.customerId = customerId;
        this.cartNumber = cartNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCartNumber() {
        return cartNumber;
    }
}
