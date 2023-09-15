package dev.ecommerce.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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
    @ManyToOne
    private Category category;
    private double price;
}
