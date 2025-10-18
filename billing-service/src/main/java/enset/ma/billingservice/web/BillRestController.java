package enset.ma.billingservice.web;

import enset.ma.billingservice.entities.Bill;
import enset.ma.billingservice.feign.CustomerRestClient;
import enset.ma.billingservice.feign.ProductRestClient;
import enset.ma.billingservice.model.Customer;
import enset.ma.billingservice.repository.BillRepository;
import enset.ma.billingservice.repository.ProductItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {

    private ProductItemRepository productItemRepository;
    private BillRepository billRepository;

    private CustomerRestClient customerRestClient;
    private ProductRestClient productRestClient;


    // pour faire l'injection de dépendance
    public BillRestController(ProductItemRepository productItemRepository,
                              BillRepository billRepository,
                             CustomerRestClient customerRestClient,
                             ProductRestClient productRestClient) {
        this.productItemRepository = productItemRepository;
        this.billRepository = billRepository;
        this.customerRestClient = customerRestClient;
        this.productRestClient = productRestClient;
    }

    @GetMapping("/bills/{id}")
    public Bill getBillRepository(@PathVariable  Long id) {
    Bill bill = billRepository.findById(id).get();
    Customer customer = customerRestClient.findCustomerById(bill.getCustomerID());
    bill.setCustomer(customer);
    bill.getProductItems().forEach(
            pi -> {
                pi.setProduct(productRestClient.getProductById(pi.getProductID()));
            }
    );

    return  bill;
    }
}
