package Reto2AdrianFernandez.Reto2.Repositories.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "products")
@Entity(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private double precio;
    private String img;

    public ProductEntity() {
    }

    public ProductEntity(String nombre, double precio, String img) {
        this.nombre = nombre;
        this.precio = precio;
        this.img = img;
    }

    public ProductEntity(ProductEntity p) {
        this.nombre = p.getNombre();
        this.precio = p.getPrecio();
        this.img = p.getImg();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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