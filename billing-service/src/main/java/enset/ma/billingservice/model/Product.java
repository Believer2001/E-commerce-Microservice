package enset.ma.billingservice.model;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Product {

    private String id;
    private String name;
    private Double price;
    private int quantity;
}
