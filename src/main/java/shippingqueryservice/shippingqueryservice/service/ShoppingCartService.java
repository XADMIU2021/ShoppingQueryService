package shippingqueryservice.shippingqueryservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shippingqueryservice.shippingqueryservice.data.ShoppingRepository;
import shippingqueryservice.shippingqueryservice.domain.*;
import shippingqueryservice.shippingqueryservice.service.dtos.ShoppingCartDTO;
import shippingqueryservice.shippingqueryservice.service.dtos.ShoppingCartsDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartService {
    @Autowired
    private ShoppingRepository repository;

    @Autowired
    private ShoppingAdapter adapter;

    @Autowired
    private ShoppingDomainService domainService;

    public ShoppingCartsDTO findByCustomerId(String customerId) {
        List<ShoppingCartData> carts = repository.findByCustomerId(customerId);

        List<ShoppingCartDTO> dtos = new ArrayList<ShoppingCartDTO>();
        for (ShoppingCartData cart: carts) {
            dtos.add(adapter.getDTOFromShoppingCart(cart));
        }

        ShoppingCartsDTO cartsDTO = new ShoppingCartsDTO();
        cartsDTO.setCarts(dtos);
        return cartsDTO;
    }

    public void addToCart(ProductAddedEvent event) {
        List<ShoppingCartData> carts = repository.findByCustomerIdAndCartNumber(event.getCustomerId(), event.getCartNumber());
        ShoppingCartData cart = null;
        if (carts == null || carts.size() == 0) {
            // TODO log not found / creating new one
            // create new one
            cart = domainService.createNewCart(event);
        } else {
            cart = domainService.addToCart(carts.get(0), event);
        }

        // TODO log adding product to cart
        repository.save(cart);
    }

    public void updateFromCart(ProductUpdatedEvent event) {
        List<ShoppingCartData> carts = repository.findByCustomerIdAndCartNumber(event.getCustomerId(), event.getCartNumber());
        if (carts == null || carts.size() == 0) {
            // TODO log not found / throwing error
            // throw error / send to error service
            return;
        }

        ShoppingCartData cart = domainService.updateFromCart(carts.get(0), event);
        // TODO log updating product from cart
        repository.save(cart);
    }

    public void removeFromCart(ProductRemovedEvent event) {
        List<ShoppingCartData> carts = repository.findByCustomerIdAndCartNumber(event.getCustomerId(), event.getCartNumber());
        if (carts == null || carts.size() == 0) {
            // TODO log not found / throwing error
            // throw error / send to error service
            return;
        }

        ShoppingCartData cart = domainService.removeFromCart(carts.get(0), event);
        // TODO log removing product from cart
        repository.save(cart);
    }
}
