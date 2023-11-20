package de.telran.market.web;

import de.telran.market.api.ProductApi;
import de.telran.market.dto.ProductDto;
import de.telran.market.service.ProductService;
import java.math.BigDecimal;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
//@RequestMapping("/products")
public class ProductController implements ProductApi {

//  private static final Logger log = LoggerFactory.getLogger(ProductController.class);
  ProductService productService;

  @Override
  public ResponseEntity<ProductDto> create(ProductDto dto) {
    log.debug("Product create called");
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .header("test-header", "CHECK")
        .body(productService.create(dto));
  }

  @Override
  public ResponseEntity<ProductDto> findById(Long id) {
    log.debug("Product search by id {} called", id);
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(productService.findById(id));
  }

  @Override
  public ResponseEntity<List<ProductDto>> findAll() {
//   try {
      log.debug("Product find all called");
      return ResponseEntity
          .status(HttpStatus.OK)
          .body(productService.findAll());
//    } catch(ProductNotFoundException e) {
//     return ResponseEntity.status(HttpStatus.NOT_FOUND)
//         .body(new ErrorDto("Error!", e.getMessage()));
//    } catch (Throwable e) {
//     log.error("Critical error:", throwable);
//     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//         .body(new ErrorDto("Error!", "Something went wrong"));
//   }
  }

  @Override
  public ResponseEntity<Void> deleteById(Long id) {
    log.debug("Product {} delete called", id);
    productService.deleteById(id);
    return ResponseEntity.ok().build();
  }

  @Override
  public ResponseEntity<List<ProductDto>> findByTitle(String title) {
    log.debug("Product search by title {} called", title);
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(productService.findByTitleLike(title));
  }

  @Override
  public ResponseEntity<List<ProductDto>> findByPriceGreaterThan(BigDecimal price) {
    log.debug("Product search by price {} called", price);
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(productService.findByPriceGreaterThan(price));
  }
}
