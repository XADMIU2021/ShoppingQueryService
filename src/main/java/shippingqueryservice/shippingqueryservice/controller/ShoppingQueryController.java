package shippingqueryservice.shippingqueryservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shippingqueryservice.shippingqueryservice.domain.ShoppingCartData;
import shippingqueryservice.shippingqueryservice.service.CustomLoggerService;
import shippingqueryservice.shippingqueryservice.service.ShoppingAdapter;
import shippingqueryservice.shippingqueryservice.service.ShoppingCartService;
import shippingqueryservice.shippingqueryservice.service.dtos.OrderCreateDTO;
import shippingqueryservice.shippingqueryservice.service.dtos.OrderCreatedDTO;
import shippingqueryservice.shippingqueryservice.service.dtos.OrderLineDTO;
import shippingqueryservice.shippingqueryservice.service.dtos.ShoppingCartsDTO;

import java.util.List;

@RestController
public class ShoppingQueryController {
    @Autowired
    private OrderFeignClient orderClient;

    @Autowired
    private ShoppingCartService service;

    @Autowired
    private ShoppingAdapter adapter;

    @Autowired
    private CustomLoggerService loggerService;

    @GetMapping("/shopping-query/carts")
    public ResponseEntity<ShoppingCartsDTO> getShoppingCarts(@RequestHeader(value="Customer-ID") String customerId) {
        ShoppingCartsDTO result = service.findByCustomerId(customerId);
        return new ResponseEntity<ShoppingCartsDTO>(result, HttpStatus.OK);
    }

    @PostMapping("/shopping-query/{cartNumber}/checkout")
    // @HystrixCommand(fallbackMethod = "createOrderFallBack")
    public ResponseEntity<?> checkOutCart(@PathVariable String cartNumber, @RequestHeader(value="Customer-ID") String customerId) {
        ShoppingCartData cart = service.findByCartNumber(cartNumber);
        if (cart == null) return new ResponseEntity<String>("Cart not found", HttpStatus.NOT_FOUND);

        OrderCreateDTO dto = adapter.getOrderCreateDTOFromCart(cart);
        OrderCreatedDTO result = orderClient.createOrder(customerId, dto);

        service.checkoutCart(cartNumber, customerId);
        loggerService.log("Cart Number : " + cartNumber + " checked out successfully");
        return new ResponseEntity<OrderCreatedDTO>(result, HttpStatus.OK);
    }

    private ResponseEntity<?> createOrderFallBack(String cartNumber, String customerId) {
        return new ResponseEntity<String>("Cannot checkout cart", HttpStatus.BAD_REQUEST);
    }

    @FeignClient(name = "OrderService")
    interface OrderFeignClient {
        @RequestMapping("/order")
        public OrderCreatedDTO createOrder(@RequestHeader("Customer-ID") String customerId, @RequestBody OrderCreateDTO order);
    }
}
