package Reto2AdrianFernandez.Reto2.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import Reto2AdrianFernandez.Reto2.Common.NFException;
import Reto2AdrianFernandez.Reto2.Repositories.Interfaces.OrderProductRepository;
import Reto2AdrianFernandez.Reto2.Repositories.Interfaces.OrderRepository;
import Reto2AdrianFernandez.Reto2.Services.Models.OrderDTO;
import Reto2AdrianFernandez.Reto2.Services.Models.OrderProductDTO;

public class OrderService {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private OrderProductRepository orderProductRepository;

  @Autowired
  private ModelMapper modelMapper;

  public List<OrderDTO> getAll() {
    return orderRepository.findAll().stream().map(x -> modelMapper.map(x, OrderDTO.class)).collect(Collectors.toList());
  }

  public List<OrderProductDTO> getOrderProductsByOrderId(Long id) {
    List<OrderProductDTO> ops = orderProductRepository.findOrdersAndProductsByOrderId(id).stream()
        .map(x -> modelMapper.map(x, OrderProductDTO.class)).collect(Collectors.toList());

        if (ops.isEmpty()) {
          throw new NFException();
        }
    return ops;
  }
}
