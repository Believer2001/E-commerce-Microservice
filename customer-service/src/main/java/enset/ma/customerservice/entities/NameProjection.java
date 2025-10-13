package enset.ma.customerservice.entities;


import org.springframework.data.rest.core.config.Projection;

@Projection(name = "name", types = Customer.class)
public interface NameProjection {

    String getName();
}
