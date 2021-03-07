package Reto2AdrianFernandez.Reto2.Services.Models;

public class OrderDTO {

    private String date;
    private String username;
    private String status;
  
    public String getUsername() {
      return username;
    }
  
    public void setUsername(String username) {
      this.username = username;
    }
  
    public String getStatus() {
      return status;
    }
  
    public void setStatus(String status) {
      this.status = status;
    }
  
    public String getDate() {
      return date;
    }
  
    public void setDate(String date) {
      this.date = date;
    }
  }
