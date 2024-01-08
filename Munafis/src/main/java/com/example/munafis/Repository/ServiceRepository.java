package com.example.munafis.Repository;


import com.example.munafis.Model.Orderr;
import com.example.munafis.Model.Service;
import com.example.munafis.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Integer> {




    Service findServiceById(Integer id);
    List<Service> findAllByOrderByPrice();
    List<Service> findServicesByServiceName(String name);
    List<Service> findAllByProviderId(Integer id);




}
