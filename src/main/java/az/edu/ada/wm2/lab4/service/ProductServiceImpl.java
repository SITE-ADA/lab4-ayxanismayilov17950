package az.edu.ada.wm2.lab4.service;

import az.edu.ada.wm2.lab4.model.Product;
import az.edu.ada.wm2.lab4.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product createProduct(Product product) {
        if (product.getId() == null) {
            product.setId(UUID.randomUUID());
        }
        return repository.save(product);
    }

    @Override
    public Product getProductById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product updateProduct(UUID id, Product product) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        product.setId(id);
        return repository.save(product);
    }

    @Override
    public void deleteProduct(UUID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public List<Product> getProductsExpiringBefore(LocalDate date) {
        return repository.findAll().stream()
                .filter(p -> p.getExpirationDate().isBefore(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductsByPriceRange(BigDecimal min, BigDecimal max) {
        return repository.findAll().stream()
                .filter(p -> p.getPrice().compareTo(min) >= 0 &&
                        p.getPrice().compareTo(max) <= 0)
                .collect(Collectors.toList());
    }
}