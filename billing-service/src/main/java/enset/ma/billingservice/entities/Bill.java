package enset.ma.billingservice.entities;

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
    @OneToMany(mappedBy = "bill",fetch = FetchType.EAGER)
    private List<ProductItem> productItems =new ArrayList<ProductItem>();
    @Transient
    private Customer customer;


}
