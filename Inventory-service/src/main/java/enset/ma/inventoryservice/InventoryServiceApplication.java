package enset.ma.inventoryservice;

import enset.ma.inventoryservice.entities.Product;
import enset.ma.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.rmi.server.UID;
import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner CommandLineRunner(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Computer")
                    .price(650.0)
                    .quantity(22)
                    .build());
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Printer")
                    .price(220.)
                    .quantity(12)
                    .build());
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Smartphone")
                    .price(620.)
                    .quantity(32)
                    .build());
            productRepository.findAll().forEach(p -> {
                System.out.println("==========================");
                System.out.println(p.getName());
                System.out.println(p.getPrice());
                System.out.println(p.getQuantity());
                System.out.println("==========================");
            });
        };
    }

}
