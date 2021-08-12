package shippingqueryservice.shippingqueryservice.service;

import org.springframework.stereotype.Service;
import shippingqueryservice.shippingqueryservice.domain.CartLine;
import shippingqueryservice.shippingqueryservice.domain.ShoppingCartData;
import shippingqueryservice.shippingqueryservice.service.dtos.CartLineDTO;
import shippingqueryservice.shippingqueryservice.service.dtos.OrderCreateDTO;
import shippingqueryservice.shippingqueryservice.service.dtos.OrderLineDTO;
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

    public OrderCreateDTO getOrderCreateDTOFromCart(ShoppingCartData cart) {
        OrderCreateDTO dto = new OrderCreateDTO();
        List<OrderLineDTO> orderLineDTOs = new ArrayList<OrderLineDTO>();
        for (CartLine line: cart.getCartLines()) {
            orderLineDTOs.add(this.getOrderLineDTOFromCartLine(line));
        }

        dto.setOrderLines(orderLineDTOs);
        return dto;
    }

    private OrderLineDTO getOrderLineDTOFromCartLine(CartLine line) {
        return new OrderLineDTO(line.getProductNumber(), line.getQuantity());
    }

    private CartLineDTO getDTOFromCartLine(CartLine cartLine) {
        return new CartLineDTO(cartLine.getProductNumber(), cartLine.getQuantity());
    }
}
