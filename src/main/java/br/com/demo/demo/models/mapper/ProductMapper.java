package br.com.demo.demo.models.mapper;

import br.com.demo.demo.validations.NullSafe;
import br.com.demo.demo.entities.ProductEntity;
import br.com.demo.demo.models.Product;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class ProductMapper {
    public static Collection<Product> unmarshall(Collection<ProductEntity> entities) {
        return NullSafe.of(entities).getOrDefault(Collections.emptyList()).stream().map(entity -> ProductMapper.unmarshall(entity))
                .collect(Collectors.toList());
    }

    public static Collection<ProductEntity> marshall(Collection<Product> models) {
        return NullSafe.of(models).getOrDefault(Collections.emptyList()).stream().map(ProductMapper::marshall)
                .collect(Collectors.toList());
    }

    public static Product unmarshall(ProductEntity entity){
        return Product.builder().build();
    }

    public static ProductEntity marshall(Product model){
        return ProductEntity.builder().build();
    }
}
