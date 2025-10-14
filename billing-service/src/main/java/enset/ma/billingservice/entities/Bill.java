package enset.ma.billingservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import enset.ma.billingservice.model.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;
    private Long customerID;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "bill",fetch = FetchType.EAGER)
    private List<ProductItem> productItems =new ArrayList<ProductItem>();
    @Transient
    private Customer customer;


}
