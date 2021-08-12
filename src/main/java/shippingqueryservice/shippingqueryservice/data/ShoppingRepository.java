package shippingqueryservice.shippingqueryservice.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import shippingqueryservice.shippingqueryservice.domain.ShoppingCartData;

import java.util.List;

@Repository
public interface ShoppingRepository extends MongoRepository<ShoppingCartData, String> {
    List<ShoppingCartData> findByCustomerId(String customerId);
    List<ShoppingCartData> findByCartNumber(String cartNumber);

    @Query("{'$or':[ {'customerId':?0}, {'cartNumber':?1} ] }")
    List<ShoppingCartData> findByCustomerIdAndCartNumber(String customerId, String cartNumber);

    void deleteByCartNumber(String cartNumber);
}
