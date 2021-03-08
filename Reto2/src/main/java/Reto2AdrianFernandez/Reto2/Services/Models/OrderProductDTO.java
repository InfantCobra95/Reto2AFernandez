package Reto2AdrianFernandez.Reto2.Services.Models;

import Reto2AdrianFernandez.Reto2.Repositories.Entities.OrderEntity;
import Reto2AdrianFernandez.Reto2.Repositories.Entities.ProductEntity;

public class OrderProductDTO {

    private Long id;
    private OrderEntity orderEntity;
    private ProductEntity productEntity;
    private int quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
