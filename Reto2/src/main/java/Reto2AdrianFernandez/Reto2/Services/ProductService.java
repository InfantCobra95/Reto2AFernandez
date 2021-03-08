package Reto2AdrianFernandez.Reto2.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import Reto2AdrianFernandez.Reto2.Common.NFException;
import Reto2AdrianFernandez.Reto2.Repositories.Entities.ProductEntity;
import Reto2AdrianFernandez.Reto2.Repositories.Interfaces.ProductRepository;
import Reto2AdrianFernandez.Reto2.Services.Models.ProductDTO;


public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ModelMapper modelMapper;

  public List<ProductDTO> getAll() {
    return productRepository.findAll().stream().map(x -> modelMapper.map(x, ProductDTO.class)).collect(Collectors.toList());
  }

  public ProductDTO getById(Long id){
    Optional<ProductEntity> product = productRepository.findById(Long.valueOf(id));
    if(product.isPresent()){
        return modelMapper.map(product.get(), ProductDTO.class);
    }else{
      throw new NFException();
    }
    
}
}