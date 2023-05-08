package org.example.Customer.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@Entity
@Table(name = "offers")
public class OffersDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "Description")
    private String description;

    @Column(name = "Product")
    private String product;

    @Column(name = "Amount")
    private String amount;

    @Override
    public String toString() {
        return "OfferDb{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", product='" + product + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}