package de.telran.market.api;

import de.telran.market.dto.ProductDto;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface ProductApi {

  @PostMapping("/products")
  ResponseEntity<ProductDto> create(@RequestBody ProductDto dto);

  @GetMapping("/products/{id}")
  ResponseEntity<ProductDto> findById(@PathVariable(name = "id") Long id);

  @GetMapping("/products")
  ResponseEntity<List<ProductDto>> findAll();

  @DeleteMapping("/products/{id}")
  ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id);

  @GetMapping("/products/by-title")//url?param1=xxx&param2=yyyy
  ResponseEntity<List<ProductDto>> findByTitle(@RequestParam(name = "title") String title);
}
