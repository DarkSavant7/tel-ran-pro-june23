package de.telran.market.web;

import de.telran.market.api.ProductApi;
import de.telran.market.dto.ProductDto;
import de.telran.market.service.ProductService;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProductController implements ProductApi {

  ProductService productService;

  @Override
  public ResponseEntity<ProductDto> create(ProductDto dto) {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(productService.create(dto));
  }

  @Override
  public ResponseEntity<ProductDto> findById(Long id) {
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(productService.findById(id));
  }

  @Override
  public ResponseEntity<List<ProductDto>> findAll() {
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(productService.findAll());
  }

  @Override
  public ResponseEntity<Void> deleteById(Long id) {
    productService.deleteById(id);
    return ResponseEntity.ok().build();
  }

  @Override
  public ResponseEntity<ProductDto> findByTitle(String title) {
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(productService.findByTitle(title));
  }
}
