package org.example.Customer.Service;

import lombok.extern.slf4j.Slf4j;
import org.example.Customer.Domain.Offer;
import org.example.Customer.entity.OffersDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.Customer.Repository.Repository;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class CostumerService {
    @Autowired
    private Repository repository;

    public CostumerService(Repository repository)
    {this.repository=repository;}
    public void persistOffer(Offer offer){
        OffersDB offersDB=new OffersDB();
        offersDB.setAmount(offer.getAmount());
        offersDB.setDescription(offer.getDescription());
        offersDB.setProduct(offer.getProduct());

        repository.save(offersDB);


        log.info("offer persisted{}",offersDB.toString());
    }

    public OffersDB updateOffer(Offer newOffer) {
        Optional<OffersDB> oldOffer = repository.findById(newOffer.getId());
        if (oldOffer.isPresent()) {
            OffersDB offer = oldOffer.get();

            offer.setId(newOffer.getId());
            offer.setDescription(newOffer.getDescription());
            offer.setProduct(newOffer.getProduct());
            offer.setAmount(newOffer.getAmount());

            log.info("offer updated{}", offer.toString());
            return repository.save(offer);
        } else {

            log.info("An offer doesn't exist in database");
            return null;
        }

    }

    public void deleteOffer(long id){
        log.info("An offer is deleted {}", id);
        repository.deleteById(id);
    }


    public List<OffersDB> getAllOffers(){
        List<OffersDB>offers=repository.findAll();
        log.info("offers size{}",offers.size());
        return offers;
    }



    public OffersDB retrieveOffer(long id){
        Optional<OffersDB> offerDb = repository.findById(id);
        log.info("the offer selected :");
        return offerDb.orElse(null);
    }

}
