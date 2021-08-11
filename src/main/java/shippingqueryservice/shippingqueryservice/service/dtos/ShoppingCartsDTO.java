package shippingqueryservice.shippingqueryservice.service.dtos;

import java.util.List;

public class ShoppingCartsDTO {
    private List<ShoppingCartDTO> carts;

    public List<ShoppingCartDTO> getCarts() {
        return carts;
    }

    public void setCarts(List<ShoppingCartDTO> carts) {
        this.carts = carts;
    }
}
