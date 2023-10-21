package dev.ecommerce.productservice.repositories;

import dev.ecommerce.productservice.models.Category;
import dev.ecommerce.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository
extends JpaRepository<Category, UUID> {

    Optional<Category> findById(UUID uuid);

    List<Category> findAllById(Iterable<UUID> uuids);


}
