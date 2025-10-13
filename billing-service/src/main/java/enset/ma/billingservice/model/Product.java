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
    private String price;
    private int quantity;
}
