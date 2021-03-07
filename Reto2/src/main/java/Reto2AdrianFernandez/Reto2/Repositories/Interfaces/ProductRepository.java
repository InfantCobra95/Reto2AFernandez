package Reto2AdrianFernandez.Reto2.Repositories.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import Reto2AdrianFernandez.Reto2.Repositories.Entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
