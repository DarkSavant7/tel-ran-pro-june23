package de.telran.market.service;

import de.telran.market.dto.ProductDto;
import de.telran.market.model.Product;
import de.telran.market.repository.ProductRepository;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MainProductService implements ProductService {

  ProductRepository productRepository;

  @Override
  public ProductDto create(ProductDto dto) {
    log.debug("Saving new product {}", dto.getTitle());
    var entity = toEntity(dto);
    var saved = productRepository.save(entity);
    return fromEntity(saved);
  }

  @Override
  public ProductDto findById(Long id) {
    log.debug("Looking for the product with id {}", id);
    var result = productRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Product not found"));
    return fromEntity(result);
  }

  @Override
  public List<ProductDto> findAll() {
    log.debug("Looking for all the products");
    return productRepository.findAll().stream()
        .map(this::fromEntity)
        .toList();
  }

  @Override
  public void deleteById(Long id) {
    log.debug("Deleting the product with id {}", id);
    productRepository.deleteById(id);
  }

  //TODO make yourself
  @Override
  public ProductDto findByTitle(String title) {
    return null;
  }

  //TODO remove from service, use mapstruct or something else
  private ProductDto fromEntity(Product product) {
    return new ProductDto(product.getId(), product.getTitle(), product.getDescription(),
        product.getPrice());
  }

  private Product toEntity(ProductDto dto) {
    return new Product(dto.getId(), dto.getTitle(), dto.getDescription(),
        dto.getPrice());
  }
}
