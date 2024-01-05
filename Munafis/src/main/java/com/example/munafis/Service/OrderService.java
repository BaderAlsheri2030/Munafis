package com.example.munafis.Service;

import com.example.munafis.API.ApiException;
import com.example.munafis.DTO.OrderDTO;
import com.example.munafis.Model.Company;
import com.example.munafis.Model.Orderr;
import com.example.munafis.Model.Product;
import com.example.munafis.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor

public class OrderService   {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final ServiceRepository serviceRepository;
    private final CompanyRepository companyRepository;
    private final ProductsDetailsRepository productsDetailsRepository;


    //Admin
    public List getAllOrders(){
        return orderRepository.findAll();
    }


    public void addOrder(OrderDTO orderDTO){

        Product product = productRepository.findProductsById(orderDTO.getProduct_id());
        com.example.munafis.Model.Service service =serviceRepository.findServiceById(orderDTO.getService_id());
        Company company =companyRepository.findCompanyById(orderDTO.getCompany_id());

        if(product==null){
            throw new ApiException("product not found");
        }
        if(service==null){
            throw new ApiException("service not found");
        }
        if(company==null){
            throw new ApiException("company not found");
        }
        double totalPriceProduct=0;
        double totalPriceService=0;
        double totalPrice=0;

        if(product.getProductsDetails().getQuantity() <= 0){
            throw new ApiException("product is not available now");
        }

        //Calculate the total price
        totalPriceProduct = product.getPrice() * orderDTO.getQuantity();
        totalPriceService = service.getPrice();
        totalPrice = totalPriceProduct + totalPriceService;

        //
        product.getProductsDetails().setQuantity(product.getProductsDetails().getQuantity() - orderDTO.getQuantity());

        productsDetailsRepository.save(product.getProductsDetails());


//        Orderr orderr = new Orderr(null,orderDTO.getStatus(),totalPrice,service,product,company);
//        orderRepository.save(orderr);
    }
}
