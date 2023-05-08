package org.example.Customer.Repository;

import org.example.Customer.Domain.Offer;
import org.example.Customer.entity.OffersDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<OffersDB,Long> {

}
