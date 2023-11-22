package de.telran.market.service;

import de.telran.market.dto.ProductDto;
import de.telran.market.dto.ProductShortDto;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface ProductService {

  ProductDto create(ProductDto dto);

  ProductDto findById(Long id);

  List<ProductDto> findAll();

  void deleteById(Long id);

  List<ProductDto> findByTitleLike(String title);
  ProductDto findByTitleExact(String title);

  List<ProductDto> findByPriceGreaterThan(BigDecimal price);
  Set<ProductShortDto> findAllShorts();
  Set<ProductShortDto> findAllProjections();
}
