package shippingqueryservice.shippingqueryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@SpringBootApplication
@EnableKafka
@EnableFeignClients
@EnableHystrix
public class ShippingQueryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShippingQueryServiceApplication.class, args);
    }

}
