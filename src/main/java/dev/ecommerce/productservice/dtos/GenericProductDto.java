package dev.ecommerce.productservice.dtos;

import dev.ecommerce.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class GenericProductDto {
    private UUID id;
    private String title;
    private  String description;
    private String image;
    private String category;
    private double price;
}
