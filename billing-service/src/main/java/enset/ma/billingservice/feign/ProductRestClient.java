package enset.ma.billingservice.feign;

import enset.ma.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface ProductRestClient {

    @GetMapping("/products/{id}")
     Product getProductById(@PathVariable String id);

    @GetMapping("/products")
    PagedModel<Product> getAllProducts();
}
