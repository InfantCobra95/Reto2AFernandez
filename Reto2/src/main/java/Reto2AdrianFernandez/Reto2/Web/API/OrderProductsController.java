package Reto2AdrianFernandez.Reto2.Web.API;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Reto2AdrianFernandez.Reto2.Services.OrderProductService;
import Reto2AdrianFernandez.Reto2.Services.Models.OrderProductDTO;

@RestController
@RequestMapping("orderproducts")
public class OrderProductsController {

    private final OrderProductService orderProductService;

    OrderProductsController(OrderProductService orderProductService) {
        this.orderProductService = orderProductService;
    }

    @GetMapping()
    public List<OrderProductDTO> GetOrderProducts() {
        return orderProductService.getAll();
    }

    @GetMapping("order/{id}")
    public List<OrderProductDTO> GetOrderProductsByOrderId(@PathVariable("id") Long id) {
        return orderProductService.getOrdersAndProductsByOrderId(id);
    }

    /*
     * Filtrar por ID NO FUNCIONAL
     * 
     * @GetMapping("{id}") public List<OrderProductDTO>
     * GetOrderProductsByID(@PathVariable("id") Long id) { return
     * orderProductService.getById(id); }
     */

    @PostMapping()
    public Long InsertOrderProducts(@RequestBody List<OrderProductDTO> newOrderProduct) {
        return orderProductService.InsertOrderProducts(newOrderProduct);
    }

    @DeleteMapping("{id}")
    public void DeleteOrderProduct(@PathVariable("id") Long id) {
        orderProductService.DeleteOrderProducts(id);
    }

}
