package de.telran.market.mapper;

import de.telran.market.dto.ProductDto;
import de.telran.market.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapstructMapper {

    ProductDto fromEntity(Product product);
    Product toEntity(ProductDto dto);

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
