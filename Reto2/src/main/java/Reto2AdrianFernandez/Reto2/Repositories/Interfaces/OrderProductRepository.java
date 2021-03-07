package Reto2AdrianFernandez.Reto2.Repositories.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import Reto2AdrianFernandez.Reto2.Repositories.Entities.OrderProductEntity;

public interface OrderProductRepository extends JpaRepository<OrderProductEntity, Long>{
    
}
