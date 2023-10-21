package dev.ecommerce.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class GetProductTitlesRequestDto {
    private List<UUID> uuids;
}
