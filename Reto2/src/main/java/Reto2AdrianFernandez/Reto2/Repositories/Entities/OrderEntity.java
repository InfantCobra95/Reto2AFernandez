package Reto2AdrianFernandez.Reto2.Repositories.Entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "orders")
@Entity(name = "orders")
public class OrderEntity {

  @Id
  @GeneratedValue
  private Long id;

  private String date;
  private String username;
  private String status;

  public OrderEntity() {}

  public OrderEntity(String username, String status) {
    this.date = CreateDateNow();
    this.username = username;
    this.status = status;
  }

  public OrderEntity(OrderEntity o) {
    this.date = CreateDateNow();
    this.username = o.getUsername();
    this.status = o.getStatus();
  }

  private String CreateDateNow() {
    String date;
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    date = formatter.format(new Date());
    return date;
  }

  public String getDate() {
    return date;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
