package org.example.Marketer.Domain;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
@Data
@Setter
@Getter
  public class Offer {
  private long id;
  private String product;
  private String amount;
  private String description;
  private String operationType;
}
