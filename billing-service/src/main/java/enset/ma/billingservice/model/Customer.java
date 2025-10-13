package enset.ma.billingservice.model;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
    private Long id ;
    private String name ;
    private String email ;
}
