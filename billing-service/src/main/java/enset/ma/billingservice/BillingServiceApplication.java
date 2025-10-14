package enset.ma.billingservice;

import enset.ma.billingservice.entities.Bill;
import enset.ma.billingservice.entities.ProductItem;
import enset.ma.billingservice.feign.CustomerRestClient;
import enset.ma.billingservice.feign.ProductRestClient;
import enset.ma.billingservice.model.Customer;
import enset.ma.billingservice.model.Product;
import enset.ma.billingservice.repository.BillRepository;
import enset.ma.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner
    commandLineRunner(BillRepository billRepository,
                      ProductItemRepository productItemRepository,
                      CustomerRestClient customerRestClient,
                      ProductRestClient productRestClient) {

 return (args) -> {
        Collection<Customer> customers = customerRestClient.getAllCustomers().getContent();
        Collection<Product> products = productRestClient.getAllProducts().getContent();

        // on va creer des facture pour chaque lient
        customers.forEach(customer ->
                {
                    Bill bill = Bill.builder()
                            .billingDate(new Date())
                            .customerID(customer.getId())
                            .customer(customer)

                            .build();

                    billRepository.save(bill);
                }
        );

        products.forEach(
                product -> {
                    ProductItem productItem = ProductItem.builder()
                            .productID(product.getId())
                            .unitPrice(product.getPrice())
                            .quantity(1 + (int) (Math.random() * 100))
                            .build();
                    productItemRepository.save(productItem);
                }
        );


    }

    ;
}
}
