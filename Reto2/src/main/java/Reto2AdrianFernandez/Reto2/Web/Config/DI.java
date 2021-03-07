package Reto2AdrianFernandez.Reto2.Web.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Reto2AdrianFernandez.Reto2.Services.OrderProductService;
import Reto2AdrianFernandez.Reto2.Services.OrderService;
import Reto2AdrianFernandez.Reto2.Services.ProductService;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DI {

    @Bean
    OrderProductService createOrderProductService() {
        return new OrderProductService();
    }

    @Bean
    ProductService createProductService() {
        return new ProductService();
    }

    @Bean
    OrderService createOrderService() {
        return new OrderService();
    }

    @Bean
    ModelMapper createModelMapper() {
        return new ModelMapper();
    }
}
