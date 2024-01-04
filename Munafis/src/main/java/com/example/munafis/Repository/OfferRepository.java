package com.example.munafis.Repository;


import com.example.munafis.Model.Offers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offers,Integer> {
}
