package com.example.munafis.Repository;


import com.example.munafis.Model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffersRepository extends JpaRepository<Offer,Integer> {
    Offer findOfferById(Integer id);
}
