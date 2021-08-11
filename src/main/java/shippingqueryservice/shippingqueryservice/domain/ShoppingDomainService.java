package shippingqueryservice.shippingqueryservice.domain;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingDomainService {
    public ShoppingCartData createNewCart(ProductAddedEvent event) {
        ShoppingCartData cart = new ShoppingCartData(event.getCartNumber(), event.getCustomerId());
        CartLine cartLine = new CartLine(event.getProductNumber(), event.getQuantity());
        cart.setCartLines(Arrays.asList(cartLine));
        return cart;
    }

    public ShoppingCartData addToCart(ShoppingCartData cart, ProductAddedEvent event) {
        List<CartLine> cartLines = cart.getCartLines();

        boolean found = false;
        for(CartLine line: cartLines) {
            if (line.getProductNumber().equals(event.getProductNumber())) {
                line.setQuantity(line.getQuantity() + event.getQuantity());
                System.out.println(line.getQuantity() + event.getQuantity());
                found = true;
                break;
            }
        }

        if (!found) {
            CartLine cartLine = new CartLine(event.getProductNumber(), event.getQuantity());
            cartLines.add(cartLine);
        }

        cart.setCartLines(cartLines);
        return cart;
    }

    public ShoppingCartData updateFromCart(ShoppingCartData cart, ProductUpdatedEvent event) {
        List<CartLine> cartLines = cart.getCartLines();
        for(CartLine line: cartLines) {
            if (line.getProductNumber().equals(event.getProductNumber())) {
                line.setQuantity(event.getQuantity());
                break;
            }
        }

        cart.setCartLines(cartLines);
        return cart;
    }

    public ShoppingCartData removeFromCart(ShoppingCartData cart, ProductRemovedEvent event) {
        List<CartLine> cartLines = cart.getCartLines();
        List<CartLine> newCartLines = cartLines.stream().filter(line -> !line.getProductNumber().equals(event.getProductNumber())).collect(Collectors.toList());
        cart.setCartLines(newCartLines);
        return cart;
    }
}
