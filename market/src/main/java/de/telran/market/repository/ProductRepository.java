package de.telran.market.repository;

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

  @Query(value = "select new de.telran.market.dto.ProductShortDto(p.id, p.title) from Product p")
  Set<ProductShortDto> findAllShorts();

  @Query(value = "select p.id as id, p.title as title from products p", nativeQuery = true)
  Set<ProductProjection> findAllProjections();
}
