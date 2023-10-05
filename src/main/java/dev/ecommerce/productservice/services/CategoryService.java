package dev.ecommerce.productservice.services;

import dev.ecommerce.productservice.models.Category;
import dev.ecommerce.productservice.models.Product;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    Category getCategory(UUID uuid);
}
