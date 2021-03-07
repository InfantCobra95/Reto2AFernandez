package Reto2AdrianFernandez.Reto2.Web.Config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Reto2AdrianFernandez.Reto2.Common.PayedCancelled;
import Reto2AdrianFernandez.Reto2.Repositories.Entities.OrderEntity;
import Reto2AdrianFernandez.Reto2.Repositories.Entities.OrderProductEntity;
import Reto2AdrianFernandez.Reto2.Repositories.Entities.ProductEntity;
import Reto2AdrianFernandez.Reto2.Repositories.Interfaces.OrderProductRepository;
import Reto2AdrianFernandez.Reto2.Repositories.Interfaces.OrderRepository;
import Reto2AdrianFernandez.Reto2.Repositories.Interfaces.ProductRepository;

@Configuration
public class InitDB {

    private OrderEntity orderEntity1 = new OrderEntity("Pipo 1", PayedCancelled.Estado.Cancelado.toString());
    private OrderEntity orderEntity2 = new OrderEntity("Pipo 2", PayedCancelled.Estado.Pagado.toString());

    private ProductEntity productEntity1 = new ProductEntity("Dunsparce", 25000.50, "dunsparce.jpg");
    private ProductEntity productEntity2 = new ProductEntity("Umbreon", 2000.75, "umbreon.png");
    private ProductEntity productEntity3 = new ProductEntity("Pipo", 250000000.00, "pipo.jpg");
    private ProductEntity productEntity4 = new ProductEntity("Ledyba", 1551.51, "ledyba.png");
    

    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository, OrderRepository orderRepository,
            OrderProductRepository orderProductRepository) {
        return args -> {
            productRepository.save(productEntity1);
            productRepository.save(productEntity2);
            productRepository.save(productEntity3);
            productRepository.save(productEntity4);
            
            orderRepository.save(orderEntity1);
            orderRepository.save(orderEntity2);

            orderProductRepository.save(new OrderProductEntity(productEntity1, orderEntity1, 1));
            orderProductRepository.save(new OrderProductEntity(productEntity2, orderEntity1, 2));
            orderProductRepository.save(new OrderProductEntity(productEntity3, orderEntity2, 3));
            orderProductRepository.save(new OrderProductEntity(productEntity4, orderEntity2, 4));

        };
    }
}
