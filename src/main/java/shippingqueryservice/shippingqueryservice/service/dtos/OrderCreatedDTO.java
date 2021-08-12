package shippingqueryservice.shippingqueryservice.service.dtos;

public class OrderCreatedDTO extends OrderCreateDTO {
    private String id;
    private String status;
    private String timeStamp;

    public OrderCreatedDTO(String id, String status, String timeStamp) {
        this.id = id;
        this.status = status;
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "OrderCreatedDTO{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getTimeStamp() {
        return timeStamp;
    }
}
