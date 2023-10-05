package dev.ecommerce.productservice.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Builder
public class Product extends BaseModel {
    private String title;
    private String description;
    private String image;
    //         Prodcut : Category
    //=> L -> R =   1  :  1
    //=> R -> L = Many :  1
    //=> Answer = Many to 1
    //2 step Approach to find the cardinality
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "category")
    private Category category;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Price price;
}
