package shippingqueryservice.shippingqueryservice.service;

import org.springframework.stereotype.Service;
import shippingqueryservice.shippingqueryservice.domain.CartLine;
import shippingqueryservice.shippingqueryservice.domain.ShoppingCartData;
import shippingqueryservice.shippingqueryservice.service.dtos.CartLineDTO;
import shippingqueryservice.shippingqueryservice.service.dtos.ShoppingCartDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingAdapter {
    public ShoppingCartDTO getDTOFromShoppingCart(ShoppingCartData cart) {
        ShoppingCartDTO dto = new ShoppingCartDTO(cart.getId(), cart.getCartNumber(), cart.getCustomerId());
        List<CartLineDTO> cartLineDTOS = new ArrayList<CartLineDTO>();
        for (CartLine cartLine : cart.getCartLines()) {
            cartLineDTOS.add(this.getDTOFromCartLine(cartLine));
        }

        dto.setCartLines(cartLineDTOS);
        return dto;
    }

    private CartLineDTO getDTOFromCartLine(CartLine cartLine) {
        return new CartLineDTO(cartLine.getProductNumber(), cartLine.getQuantity());
    }
}
