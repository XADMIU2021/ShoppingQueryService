package shippingqueryservice.shippingqueryservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingQueryController {
    @GetMapping("/shopping-query")
    public String defaultMethod() {
        return "shopping query service";
    }
}
