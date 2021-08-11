package shippingqueryservice.shippingqueryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@SpringBootApplication
@EnableKafka
public class ShippingQueryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShippingQueryServiceApplication.class, args);
    }

}
