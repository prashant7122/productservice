package dev.ecommerce.productservice.dtos;

import dev.ecommerce.productservice.models.Price;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDto {
    private String name;

    private List<ProductDto> products;
}
