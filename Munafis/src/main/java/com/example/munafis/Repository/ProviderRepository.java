package com.example.munafis.Repository;


import com.example.munafis.Model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider,Integer> {

    Provider getProvidersById(Integer id);
}
