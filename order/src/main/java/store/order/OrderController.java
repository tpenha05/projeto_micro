// OrderController.java
package store.order;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "order-service", url = "${order.service.url:http://order-service:8080}")
public interface OrderController {

    @PostMapping("/order")
    public ResponseEntity<OrderOut> create(
        @RequestBody OrderIn orderIn,
        @RequestHeader(value = "id-account", required = true) String idAccount
    );

    @GetMapping("/order")
    public ResponseEntity<List<OrderOut>> findAll(
        @RequestHeader(value = "id-account", required = true) String idAccount
    );
    
    @GetMapping("/order/{id}")
    public ResponseEntity<OrderOut> findById(
        @PathVariable("id") String id,
        @RequestHeader(value = "id-account", required = true) String idAccount
    );
}