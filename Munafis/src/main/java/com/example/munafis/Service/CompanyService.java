package com.example.munafis.Service;


import com.example.munafis.API.ApiException;
import com.example.munafis.DTO.CompanyDTO;
import com.example.munafis.Model.Company;
import com.example.munafis.Model.Orderr;
import com.example.munafis.Model.Provider;
import com.example.munafis.Model.User;
import com.example.munafis.Repository.AuthRepository;
import com.example.munafis.Repository.CompanyRepository;
import com.example.munafis.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final OrderRepository orderRepository;
    private final AuthRepository authRepository;


    public List getAllCompanies(){

        return companyRepository.findAll();
    }

    //Register
    public void register(CompanyDTO companyDTO){
        String hash = new BCryptPasswordEncoder().encode(companyDTO.getPassword());
        companyDTO.setPassword(hash);
        User user = new User(null,companyDTO.getUsername(),companyDTO.getPassword(),companyDTO.getEmail(),companyDTO.getRole(),null,null);
        authRepository.save(user);


        user.setRole("Company");

        Company company = new Company(null,companyDTO.getCompanyName(),companyDTO.getBusinessNumber(),companyDTO.getAddress(),user,null,null);
        companyRepository.save(company);

    }

    public void updateCompany(CompanyDTO companyDTO,Integer id){
        User user = authRepository.findUserById(id);
        Company oldCompany = companyRepository.findCompanyById(user.getCompany().getId());
        if(oldCompany==null){
            throw new ApiException("company id not found");
        }
        else if (!oldCompany.getUser().getId().equals(id)){
            throw new ApiException("Sorry, You cannot update this Company");
        }
        oldCompany.setAddress(companyDTO.getAddress());

        companyRepository.save(oldCompany);

    }


    //admin
    public void deleteCompany(Integer id){
        Company company=companyRepository.findCompanyById(id);
        if(company==null){
            throw new ApiException("company id not found");
        }
        companyRepository.delete(company);
    }

    public List<Orderr> viewMyCompletedOrders(Integer user_id){
        User user = authRepository.findUserById(user_id);
        Company company=companyRepository.findCompanyById(user.getCompany().getId());
        if(company==null){
            throw new ApiException("company  not found");
        }else if (!company.getUser().getId().equals(user_id)){
            throw new ApiException("You cannot view this company details");
        }
        List<Orderr> orders = orderRepository.findAllByStatusEqualsAndCompanyId("completed",company.getId());
        if (orders.isEmpty()){
            throw new ApiException("there is no completed orders");
        }
        return orders;
    }
    public List<Orderr> viewMyPendingOrders(Integer user_id){
        User user = authRepository.findUserById(user_id);
        Company company=companyRepository.findCompanyById(user.getCompany().getId());
        if(company==null){
            throw new ApiException("company id not found");
        }
        else if (!company.getUser().getId().equals(user_id)){
            throw new ApiException("You cannot view this company details");
        }
        List<Orderr> orders = orderRepository.findAllByStatusEqualsAndCompanyId("pending",company.getId());
        if (orders.isEmpty()){
            throw new ApiException("there is no pending orders");
        }
        return orders;
    }

    //Only Company
    public List<Orderr> viewMyAcceptedOrders(Integer user_id){
        User user = authRepository.findUserById(user_id);
        Company company=companyRepository.findCompanyById(user.getCompany().getId());
        if(company==null){
            throw new ApiException("company  not found");
        }else if (!company.getUser().getId().equals(user_id)){
            throw new ApiException("You cannot view this company details");
        }
        List<Orderr> orders = orderRepository.findAllByStatusEqualsAndCompanyId("completed",company.getId());
        if (orders.isEmpty()){
            throw new ApiException("there is no Accepted orders");
        }
        return orders;
    }

}
