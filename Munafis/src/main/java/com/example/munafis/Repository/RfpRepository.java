package com.example.munafis.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.munafis.Model.Rfp;



@Repository
public interface RfpRepository extends JpaRepository<Rfp,Integer> {
    Rfp findRfpById(Integer id);
}
