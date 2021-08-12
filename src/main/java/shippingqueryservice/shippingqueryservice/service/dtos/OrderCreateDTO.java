package shippingqueryservice.shippingqueryservice.service.dtos;

import java.util.List;

public class OrderCreateDTO {
    private List<OrderLineDTO> orderLines;

    public List<OrderLineDTO> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLineDTO> orderLines) {
        this.orderLines = orderLines;
    }

    @Override
    public String toString() {
        return "OrderCreateDTO{" +
                "orderLines=" + orderLines +
                '}';
    }
}

