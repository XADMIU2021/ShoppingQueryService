package shippingqueryservice.shippingqueryservice.domain;

import org.springframework.data.annotation.Id;

import java.util.List;

public class ShoppingCartData {
    @Id
    private String id;
    private String cartNumber;
    private List<CartLine> cartLines;
    private String customerId;

    public ShoppingCartData(String cartNumber, String customerId) {
        this.cartNumber = cartNumber;
        this.customerId = customerId;
    }

    public String getId() {
        return id;
    }

    public String getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(String cartNumber) {
        this.cartNumber = cartNumber;
    }

    public List<CartLine> getCartLines() {
        return cartLines;
    }

    public void setCartLines(List<CartLine> cartLines) {
        this.cartLines = cartLines;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        customerId = customerId;
    }
}
