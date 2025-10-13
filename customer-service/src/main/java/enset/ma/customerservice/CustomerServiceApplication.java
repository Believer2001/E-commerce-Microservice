package enset.ma.customerservice;

import enset.ma.customerservice.entities.Customer;
import enset.ma.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(Customer.builder()
                    .name("benoit").email("benoit@gmail.com").build());

            customerRepository.save(Customer.builder().name("youssouf")
                    .email("tangara@gmail.com").build());
            customerRepository.save(Customer.builder()
                    .name("alassane").email("toure@gmail.com").build());
            customerRepository.findAll().forEach(c -> {
                System.out.println("==========================");
                System.out.println(c.getName());
                System.out.println(c.getEmail());
                System.out.println("==========================");
            });
        };
    }
}


