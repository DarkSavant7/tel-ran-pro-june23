package de.telran.market.mapper;

import de.telran.market.dto.ProductDto;
import de.telran.market.model.Product;
import de.telran.market.repository.ProductRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
//@RequiredArgsConstructor
//@Service
//@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class ProductMapstructAbstractClassMapper {

  @Autowired
  ProductRepository productRepository;

//  public ProductMapstructAbstractClassMapper(@Autowired ProductRepository productRepository) {
//    this.productRepository = productRepository;
//  }

  public abstract ProductDto fromEntity(Product product);

  public abstract Product toEntity(ProductDto dto);

  //https://www.baeldung.com/spring-expression-language
  //https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/expressions.html
//    @Mappings({
//            @Mapping(source = "name", target = "tag"),
////            @Mapping(target = "description", expression = ("java(getProducts().get(0).getDescription()"))
//    })
//    ProductTagDto tagToDto(ProductTag productTag);

//    @Mappings({
//            @Mapping(target = "productId", expression = ("java(getProduct().getId())")),
//            @Mapping(target = "productName", expression = ("java(getProduct().getName())"))
//    })
//    OrderItemFlatDto orderItemToFlat(OrderItem orderItem);
}
