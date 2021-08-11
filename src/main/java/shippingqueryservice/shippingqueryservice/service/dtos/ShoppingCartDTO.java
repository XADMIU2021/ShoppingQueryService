package shippingqueryservice.shippingqueryservice.service.dtos;

import shippingqueryservice.shippingqueryservice.domain.CartLine;

import java.util.List;

public class ShoppingCartDTO {
    private String id;
    private String cartNumber;
    private List<CartLineDTO> cartLines;
    private String CustomerId;

    public ShoppingCartDTO(String id, String cartNumber, String customerId) {
        this.id = id;
        this.cartNumber = cartNumber;
        CustomerId = customerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(String cartNumber) {
        this.cartNumber = cartNumber;
    }

    public List<CartLineDTO> getCartLines() {
        return cartLines;
    }

    public void setCartLines(List<CartLineDTO> cartLines) {
        this.cartLines = cartLines;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }
}
