// ProductController.java
package store.product;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "product-service", url = "${product.service.url:http://product-service:8080}")
public interface ProductController {

    @PostMapping("/produto")
    public ResponseEntity<ProdutoOut> create(
        @RequestBody ProdutoIn produtoIn
    );

    @GetMapping("/produto")
    public ResponseEntity<List<ProdutoOut>> findAll();
    
    @GetMapping("/produto/{id}")
    public ResponseEntity<ProdutoOut> findById(
        @PathVariable("id") String id
    );
    
    @DeleteMapping("/produto/{id}")
    public ResponseEntity<Void> deleteById(
        @PathVariable("id") String id
    );
    
    @GetMapping("/produto/whoami")
    public ResponseEntity<ProdutoOut> whoami(
        @RequestHeader(value = "id-product", required = true) String idProduct
    );
}