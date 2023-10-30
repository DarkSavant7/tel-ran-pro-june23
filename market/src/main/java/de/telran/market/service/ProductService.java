package de.telran.market.service;

import de.telran.market.dto.ProductDto;
import java.util.List;

public interface ProductService {

  ProductDto create(ProductDto dto);

  ProductDto findById(Long id);

  List<ProductDto> findAll();

  void deleteById(Long id);

  ProductDto findByTitle(String title);
}
