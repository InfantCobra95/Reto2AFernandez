package Reto2AdrianFernandez.Reto2.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

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
}
