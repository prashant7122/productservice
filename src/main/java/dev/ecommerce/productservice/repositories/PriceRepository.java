package dev.ecommerce.productservice.repositories;

import dev.ecommerce.productservice.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository
extends JpaRepository<Price, Long> {
}
