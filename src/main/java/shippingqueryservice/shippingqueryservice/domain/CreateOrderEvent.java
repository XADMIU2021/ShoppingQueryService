package shippingqueryservice.shippingqueryservice.domain;

import java.util.List;

public class CreateOrderEvent {
    private String customerId;
    private String cartNumber;
    private List<CartLine> cartLines;

    public CreateOrderEvent() {
    }

    public CreateOrderEvent(String customerId, String cartNumber, List<CartLine> cartLines) {
        this.customerId = customerId;
        this.cartNumber = cartNumber;
        this.cartLines = cartLines;
    }
}
