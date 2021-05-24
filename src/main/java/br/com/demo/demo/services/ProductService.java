package br.com.demo.demo.services;

import br.com.demo.demo.entities.ProductEntity;
import br.com.demo.demo.models.Product;
import br.com.demo.demo.models.mapper.ProductMapper;
import br.com.demo.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product create(Product product) {
        ProductEntity productEntity = ProductMapper.marshall(product);
        ProductEntity persistenceEntity = productRepository.save(productEntity);
        return ProductMapper.unmarshall(persistenceEntity);
    }

    public Product update(Product product) {
        ProductEntity productEntity = ProductMapper.marshall(product);
        ProductEntity ModifiedEntity = productRepository.save(productEntity);
        return ProductMapper.unmarshall(ModifiedEntity);
    }

    public void delete(Long idProduct) { productRepository.deleteById(idProduct); }

    public Product findById(Long idProduct) {
        ProductEntity productEntity= productRepository.findById(idProduct).get();
        Product product = ProductMapper.unmarshall(productEntity);
        return product;
    }

    public List<Product> findAll() { return new ArrayList<>(ProductMapper.unmarshall(productRepository.findAll()));}
}
