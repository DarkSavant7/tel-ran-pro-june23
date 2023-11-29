package de.telran.market.service;

import de.telran.market.dto.ProductDto;
import de.telran.market.dto.ProductShortDto;
import de.telran.market.error.ProductNotFoundException;
import de.telran.market.model.Product;
import de.telran.market.repository.ProductRepository;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
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

//  @Autowired
  ProductRepository productRepository;
//  ProductMapstructMapper mapper;

//  public void setProductRepository(@Autowired ProductRepository productRepository) {
//    this.productRepository = productRepository;
//  }


//  public MainProductService(@Autowired ProductRepository productRepository) {
//    this.productRepository = productRepository;
//  }

  @Override
  @Transactional
  public ProductDto create(ProductDto dto) {
    log.debug("Saving new product {}", dto.getTitle());
    var entity = this.toEntity(dto);
    var saved = productRepository.save(entity);
    return this.fromEntity(saved);
  }

  @Override
  public ProductDto findById(Long id) {
    log.debug("Looking for the product with id {}", id);
    return productRepository.findById(id)
        .map(this::fromEntity)
//        .orElse(new ProductDto(0L, "Zero", "", BigDecimal.ZERO));
        .orElseThrow(() -> new ProductNotFoundException(id));
  }

  @Override
  public List<ProductDto> findAll() {
    log.debug("Looking for all the products");
    return productRepository.findAll().stream()
        .map(this::fromEntity)
        .toList();
  }

  @Override
  @Transactional
  public void deleteById(Long id) {
    log.debug("Deleting the product with id {}", id);
    if (!productRepository.existsById(id)) {
      throw new ProductNotFoundException(id);
    }
    productRepository.deleteById(id);
  }

  @Override
  public List<ProductDto> findByTitleLike(String title) {
    return productRepository.findAllByTitleLike(title).stream()
        .map(this::fromEntity)
        .toList();
  }

  @Override
  public ProductDto findByTitleExact(String title) {
    log.debug("Looking for the product with title {}", title);
    return productRepository.findByTitle(title)
        .map(this::fromEntity)
        .orElseThrow(() -> new ProductNotFoundException(title));
  }

  @Override
  public List<ProductDto> findByPriceGreaterThan(BigDecimal price) {
    return productRepository.findAllByPriceIsGreaterThanEqual(price).stream()
        .map(this::fromEntity)
        .toList();
  }

  @Override
  public Set<ProductShortDto> findAllShorts() {
    return productRepository.findAllShorts();
  }

  @Override
  public Set<ProductShortDto> findAllProjections() {
    return productRepository.findAllProjections().stream()
        .map(p -> new ProductShortDto(p.getId(), p.getTitle()))
        .collect(Collectors.toSet());
  }

//  //TODO remove from service, use mapstruct or something else
  private ProductDto fromEntity(Product product) {
    return new ProductDto(product.getId(), product.getTitle(), product.getDescription(),
        product.getPrice());
  }

  private Product toEntity(ProductDto dto) {
    return new Product(dto.getId(), dto.getTitle(), dto.getDescription(),
        dto.getPrice());
  }
}
