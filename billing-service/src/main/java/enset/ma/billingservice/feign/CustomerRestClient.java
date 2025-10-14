package enset.ma.billingservice.feign;

import enset.ma.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {

    @GetMapping("/customers/{id}")
    Customer findCustomerById(@PathVariable Long id);

    @GetMapping("/customers")
    PagedModel<Customer> getAllCustomers();

}
