package Reto2AdrianFernandez.Reto2.Web.API;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Reto2AdrianFernandez.Reto2.Services.OrderService;
import Reto2AdrianFernandez.Reto2.Services.Models.OrderDTO;
import Reto2AdrianFernandez.Reto2.Services.Models.OrderProductDTO;

@RestController
@RequestMapping("orders")
public class OrdersController {

    private final OrderService orderService;

    OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDTO> GetProducts() {
        return orderService.getAll();
    }

    @GetMapping("{id}")
    public List<OrderProductDTO> GetOrderProductsByOrderId(Long id) {
        return orderService.getOrderProductsByOrderId(id);
    }
}
