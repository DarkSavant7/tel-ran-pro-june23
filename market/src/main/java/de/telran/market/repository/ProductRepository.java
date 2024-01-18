package de.telran.market.repository;

import de.telran.market.dto.DemoProductWithUserDto;
import de.telran.market.dto.ProductShortDto;
import de.telran.market.model.Product;
import de.telran.market.model.projection.ProductProjection;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

//  @Query("select p from Product p where p.title like concat('%', :title, '%') ")
//  List<Product> findAllByTitleLike(@Param("title") String title);

//  List<Product> findAllByTitleLike(@Param("title") String title);

  @Query(value = "select p.* from products p where p.title like concat('%', :title, '%') ", nativeQuery = true)
  List<Product> findAllByTitleLike(@Param("title") String title);

  List<Product> findAllByPriceIsGreaterThanEqual(@Param("price") BigDecimal price);

  Optional<Product> findByTitle(@Param("title") String title);

  Optional<Product> findOneByTitleAndDescriptionOrPriceIsLessThanEqual(@Param("title") String title,
      @Param("description") String description, @Param("price") BigDecimal price);

  @Query(value = "select new de.telran.market.dto.ProductShortDto(prod.id, prod.title) from Product prod", nativeQuery = false)
  Set<ProductShortDto> findAllShorts();

  @Query(value = "select p.id as id, p.title as title from products p", nativeQuery = true)
  Set<ProductProjection> findAllProjections();

  @Query("""
             SELECT * FROM products
             OFFSET :offset_value
             LIMIT :limit_value
      """)
  Set<Product> selectWithPagination(@Param("offset_value") long offset,
      @Param("limit_value") int limit);

//  String EXAMPLE = "    select new de.telran.market.dto.DemoProductWithUserDto(prod.id, prod.title, u.email, u.firstName)"
//      + "        from Product prod"
//      + "        join User u on u.id = prod.id";

  @Query(value = """
              select new de.telran.market.dto.DemoProductWithUserDto(prod.id, prod.title, u.email, u.firstName)
              from Product prod
              join User u on u.id = prod.id
      """, nativeQuery = false)
  Set<DemoProductWithUserDto> demoFindAllJoiningUsers();

//->>, -> "name"
//  @>
  @Query(value = "select prod from Product prod")
  Set<Product> findAllExample();
}
