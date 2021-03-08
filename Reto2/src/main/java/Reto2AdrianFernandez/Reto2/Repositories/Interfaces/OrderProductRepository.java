package Reto2AdrianFernandez.Reto2.Repositories.Interfaces;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Reto2AdrianFernandez.Reto2.Repositories.Entities.OrderProductEntity;

public interface OrderProductRepository extends JpaRepository<OrderProductEntity, Long> {

    /*  Filtrar por ID NO FUNCIONAL
    @Query(value = "SELECT o FROM orderproducts o WHERE id = :id", nativeQuery = true)
    Optional<OrderProductEntity> findById(@Param("id") Long id);
    */

    @Query(value = "DELETE FROM orderproducts  where order_id = :id", nativeQuery = true)
    public void OrderProductsDeleteByOrderId(@Param("id") Long id);

    @Query(value = "Select * from orderproducts op inner join orders o ON op.order_id = o.id where o.id = :id", nativeQuery = true)
    Collection<OrderProductEntity> findOrdersAndProductsByOrderId(@Param("id") Long id);
}
