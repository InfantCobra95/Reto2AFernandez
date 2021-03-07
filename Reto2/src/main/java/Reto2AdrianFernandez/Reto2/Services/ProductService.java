package Reto2AdrianFernandez.Reto2.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import Reto2AdrianFernandez.Reto2.Repositories.Interfaces.ProductRepository;
import Reto2AdrianFernandez.Reto2.Services.Models.ProductDTO;
import javassist.NotFoundException;

public class ProductService {

    @Autowired
    private ProductRepository productRepository;
  
    @Autowired
    private ModelMapper modelMapper;
  
    public List<ProductDTO> getAll() {
      return productRepository
        .findAll()
        .stream()
        .map(x -> modelMapper.map(x, ProductDTO.class))
        .collect(Collectors.toList());
    }
  
    public ProductDTO getById(Long id){
      var p = productRepository.findById(id);
      return modelMapper.map(p, ProductDTO.class);
    }
  }