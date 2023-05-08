package org.example.Customer.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Setter
@Getter


public class Offer {
   // @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String product;
    private String description;
    private String amount;
    private String operationType;
 @Override
 public String toString() {
  return "Offer{" +
          "id=" + id +
          ", description='" + description + '\'' +
          ", product='" + product + '\'' +
          ", amount='" + amount + '\'' +
          ", operationType='" + operationType + '\'' +
          '}';
 }
}
