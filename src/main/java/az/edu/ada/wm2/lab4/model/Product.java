package az.edu.ada.wm2.lab4.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Product {

 private UUID id;
 private String productName;
 private BigDecimal price;
 private LocalDate expirationDate;

 // No-args constructor
 public Product() {
  this.id = UUID.randomUUID();
 }

 // Constructor without id (for create operations)
 public Product(String productName, BigDecimal price, LocalDate expirationDate) {
  this.id = UUID.randomUUID();
  this.productName = productName;
  this.price = price;
  this.expirationDate = expirationDate;
 }

 // Constructor with all fields (for update operations)
 public Product(UUID id, String productName, BigDecimal price, LocalDate expirationDate) {
  this.id = id != null ? id : UUID.randomUUID();
  this.productName = productName;
  this.price = price;
  this.expirationDate = expirationDate;
 }

 // Getters and Setters

 public UUID getId() {
  return id;
 }

 public void setId(UUID id) {
  this.id = id != null ? id : UUID.randomUUID();
 }

 public String getProductName() {
  return productName;
 }

 public void setProductName(String productName) {
  this.productName = productName;
 }

 public BigDecimal getPrice() {
  return price;
 }

 public void setPrice(BigDecimal price) {
  this.price = price;
 }

 public LocalDate getExpirationDate() {
  return expirationDate;
 }

 public void setExpirationDate(LocalDate expirationDate) {
  this.expirationDate = expirationDate;
 }
}