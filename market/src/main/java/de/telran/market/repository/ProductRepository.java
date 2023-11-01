package de.telran.market.repository;

import de.telran.market.model.Product;
import java.util.List;
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
}
