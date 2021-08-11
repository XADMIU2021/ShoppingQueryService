package shippingqueryservice.shippingqueryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shippingqueryservice.shippingqueryservice.service.ShoppingCartService;
import shippingqueryservice.shippingqueryservice.service.dtos.ShoppingCartsDTO;

@RestController
public class ShoppingQueryController {
    @Autowired
    private ShoppingCartService service;

    @GetMapping("/shopping-query/carts")
    public ResponseEntity<ShoppingCartsDTO> getShoppingCarts(@RequestHeader(value="Customer-ID") String customerId) {
        ShoppingCartsDTO result = service.findByCustomerId(customerId);
        return new ResponseEntity<ShoppingCartsDTO>(result, HttpStatus.OK);
    }
}
