package Reto2AdrianFernandez.Reto2.Services.Models;

public class ProductDTO {

    private Long id;
    private String nombre;
    private double precio;
    private String img;
  
    public void setId(Long id) {
      this.id = id;
    }
  
    public Long getId() {
      return id;
    }
  
    public String getNombre() {
      return nombre;
    }
  
    public void setNombre(String nombre) {
      this.nombre = nombre;
    }
  
    public double getPrecio() {
      return precio;
    }
  
    public void setPrecio(double precio) {
      this.precio = precio;
    }
  
    public String getImg() {
      return img;
    }
  
    public void setImg(String img) {
      this.img = img;
    }
  }
