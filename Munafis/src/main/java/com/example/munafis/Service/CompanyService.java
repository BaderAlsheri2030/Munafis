package com.example.munafis.Service;


import com.example.munafis.API.ApiException;
import com.example.munafis.Model.Company;
import com.example.munafis.Model.Orderr;
import com.example.munafis.Model.Provider;
import com.example.munafis.Repository.CompanyRepository;
import com.example.munafis.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final OrderRepository orderRepository;



    public List getAllCompanies(){

        return companyRepository.findAll();
    }

    //Register
    public void addCompany(Company company){

        companyRepository.save(company);
    }

    public void updateCompany(Integer id, Company company){
        Company oldCompany=companyRepository.findCompanyById(id);
        if(oldCompany==null){
            throw new ApiException("company id not found");
        }
        oldCompany.setAddress(company.getAddress());
        oldCompany.setBusinessNumber(company.getBusinessNumber());
        oldCompany.setOrders(company.getOrders());
        oldCompany.setCompanyName(company.getCompanyName());

        oldCompany.setRfps(company.getRfps());

        companyRepository.save(oldCompany);

    }



    public void deleteCompany(Integer id){
        Company company=companyRepository.findCompanyById(id);
        if(company==null){
            throw new ApiException("company id not found");
        }
        companyRepository.delete(company);
    }

    public List<Orderr> viewMyCompletedOrders(Integer company_id){
        Company company=companyRepository.findCompanyById(company_id);
        if(company==null){
            throw new ApiException("company id not found");
        }
        List<Orderr> orders = orderRepository.findAllByStatusEqualsAndCompanyId("completed",company_id);
        if (orders.isEmpty()){
            throw new ApiException("there is no completed orders");
        }
        return orders;
    }
    public List<Orderr> viewMyPendingOrders(Integer company_id){
        Company company=companyRepository.findCompanyById(company_id);
        if(company==null){
            throw new ApiException("company id not found");
        }
        List<Orderr> orders = orderRepository.findAllByStatusEqualsAndCompanyId("pending",company_id);
        if (orders.isEmpty()){
            throw new ApiException("there is no pending orders");
        }
        return orders;
    }


    //Only Company
    public Set<Orderr> getMyOrdersByStatusAccepted(Integer id){
        Company company =companyRepository.findCompanyById(id);
        if(company==null){
            throw new ApiException("company not found");
        }
        Set<Orderr> orders = orderRepository.getMyOrdersByStatusAccepted();
        if(orders.isEmpty()){
            throw new ApiException("You have no accepted orders");
        }
        return orders;
    }

    //Only Company
    public Set<Orderr> getMyOrdersStatusPending(Integer id){
        Company company =companyRepository.findCompanyById(id);
        if(company==null){
            throw new ApiException("company not found");
        }
        Set<Orderr> orders = orderRepository.getMyOrdersStatusPending();
        if(orders.isEmpty()){
            throw new ApiException("You have no pending orders");
        }
        return orders;
    }


    //Only Company
    public Set<Orderr> getMyOrdersStatusCompleted(Integer id){
        Company company =companyRepository.findCompanyById(id);
        if(company==null){
            throw new ApiException("company not found");
        }
        Set<Orderr> orders = orderRepository.getMyOrdersStatusCompleted();
        if(orders.isEmpty()){
            throw new ApiException("You have no Completed orders");
        }
        return orders;
    }
}
