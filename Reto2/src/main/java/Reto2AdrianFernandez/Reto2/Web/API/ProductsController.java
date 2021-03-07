package Reto2AdrianFernandez.Reto2.Web.API;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Reto2AdrianFernandez.Reto2.Services.ProductService;
import Reto2AdrianFernandez.Reto2.Services.Models.ProductDTO;

@RestController
@RequestMapping("products")
public class ProductsController {

    private final ProductService productService;

    ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDTO> GetProducts() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ProductDTO GetOrderProductsByOrderId(Long id) {
        return productService.getById(id);
    }
}
