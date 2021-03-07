package Reto2AdrianFernandez.Reto2.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import Reto2AdrianFernandez.Reto2.Repositories.Entities.OrderEntity;
import Reto2AdrianFernandez.Reto2.Repositories.Entities.OrderProductEntity;
import Reto2AdrianFernandez.Reto2.Repositories.Entities.ProductEntity;
import Reto2AdrianFernandez.Reto2.Repositories.Interfaces.OrderProductRepository;
import Reto2AdrianFernandez.Reto2.Repositories.Interfaces.OrderRepository;
import Reto2AdrianFernandez.Reto2.Repositories.Interfaces.ProductRepository;
import Reto2AdrianFernandez.Reto2.Services.Models.OrderProductDTO;

public class OrderProductService {

  @Autowired
  private OrderProductRepository orderProductRepository;

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ModelMapper modelMapper;

  public List<OrderProductDTO> getAll() {
    return orderProductRepository.findAll().stream().map(x -> modelMapper.map(x, OrderProductDTO.class))
        .collect(Collectors.toList());
  }

  public List<OrderProductDTO> getOrdersAndProductsByOrderId(Long id) {
    var op = orderProductRepository.findOrdersAndProductsByOrderId(id).stream()
        .map(x -> modelMapper.map(x, OrderProductDTO.class)).collect(Collectors.toList());

    return op;
  }

  /*  Filtrar por ID NO FUNCIONAL
  public OrderProductDTO getById(Long id){
    Optional<OrderProductEntity> orderProduct = orderProductRepository.findById(Long.valueOf(id));
    if(orderProduct.isPresent()){
        return modelMapper.map(orderProduct.get(), OrderProductDTO.class);
    }else{
        return null;
    }
  }
  */

  public Long InsertOrderProducts(List<OrderProductDTO> newOrderProducts) {
    Long oderId = null;
    boolean firstTime = false;
    for (OrderProductDTO newOrderProduct : newOrderProducts) {
      ProductEntity p = null;
      OrderEntity o = null;
      if (newOrderProduct.getProductEntity() != null) {
        p = new ProductEntity(newOrderProduct.getProductEntity());
        productRepository.save(p);
      }

      if (newOrderProduct.getOrderEntity() != null) {
        o = new OrderEntity(newOrderProduct.getOrderEntity());
        orderRepository.save(o);
      }

      OrderProductEntity op = new OrderProductEntity(p, o, newOrderProduct.getQuantity());
      if (!firstTime) {
        oderId = op.getOrderEntity().getId();
      }
      orderProductRepository.save(op);
    }
    return oderId;
  }

}
