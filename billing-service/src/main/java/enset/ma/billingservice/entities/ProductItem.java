package enset.ma.billingservice.entities;


import enset.ma.billingservice.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String productID;

@ManyToOne
private  Bill bill;
private int quantity;
private  double unitPrice;
@Transient
private Product product;


}
