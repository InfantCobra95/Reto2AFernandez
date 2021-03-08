package Reto2AdrianFernandez.Reto2.Repositories.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Reto2AdrianFernandez.Reto2.Repositories.Entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query("SELECT p FROM products p WHERE id = :id")
    ProductEntity findId(@Param("id") Long id);
}
