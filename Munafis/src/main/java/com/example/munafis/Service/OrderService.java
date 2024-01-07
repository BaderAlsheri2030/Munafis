package com.example.munafis.Service;

import com.example.munafis.API.ApiException;
import com.example.munafis.DTO.OrderDTO;
import com.example.munafis.Model.*;
import com.example.munafis.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor

public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final ServiceRepository serviceRepository;
    private final CompanyRepository companyRepository;
    private final ProductsDetailsRepository productsDetailsRepository;
    private final AuthRepository authRepository;


    //Admin
    public List getAllOrders() {

        return orderRepository.findAll();
    }


    public void addOrder(OrderDTO orderDTO) {
        double totalPriceProduct = 0;
        double totalPriceService = 0;
        double totalPrice = 0;
        double price = 0;


        Company company = companyRepository.findCompanyById(orderDTO.getCompany_id());

        if(company==null){
            throw new ApiException("company id nit found");
        }

        Set<ProductsDetails> productsDetails = new HashSet<>();
        Set<com.example.munafis.Model.Service> serviceList = new HashSet<>();

//     Set<Product> products = new HashSet<>();
//     Set<com.example.munafis.Model.Service> services = new HashSet<>();


        for (ProductsDetails productsDetails1 : orderDTO.getProductsDetails()) {

            Product product = productRepository.findProductById(productsDetails1.getId());
            if (product == null) {
                throw new ApiException("product id not found");
            }
            Product foundProduct = productRepository.findProductById(product.getId());

            if (foundProduct == null) {
                throw new ApiException("Product not found for id: " + product.getId());
            }
            if(foundProduct.getStock() < productsDetails1.getQuantity()){
                throw new ApiException("product is not available now");
            }
            foundProduct.setStock(foundProduct.getStock()-productsDetails1.getQuantity());
            productsDetailsRepository.save(productsDetails1);
            price += product.getPrice() * productsDetails1.getQuantity();
            ProductsDetails productsDetails2 = new ProductsDetails(null, productsDetails1.getQuantity(), null, null);
            totalPriceProduct += price;
            productsDetailsRepository.save(productsDetails2);
            productsDetails.add(productsDetails2);
        }

        for (com.example.munafis.Model.Service s : orderDTO.getServices()) {

            com.example.munafis.Model.Service service = serviceRepository.findServiceById(s.getId());
            if (service == null) {
                throw new ApiException("service not found");
            }
            totalPriceService += s.getPrice();
            serviceList.add(s);
        }
        totalPrice = totalPriceProduct + totalPriceService;
        Orderr orderr = new Orderr(null, "pending", totalPrice, serviceList, productsDetails, company);
        orderRepository.save(orderr);


        for (ProductsDetails productsDetails1: orderr.getProductsDetails()){
            productsDetails1.setOrder(orderr);
            productsDetailsRepository.save(productsDetails1);
        }
        for(com.example.munafis.Model.Service service: orderr.getServices()){
            service.setOrder(orderr);
            serviceRepository.save(service);
        }


    }

    public void updateOrder(OrderDTO orderDTO , Integer id){
        Orderr order = orderRepository.findOrderrById(id);
        if(order==null){
            throw new ApiException("order not found");
        }
        if(!order.getStatus().equals("pending")){
            throw new ApiException("th order cannot updated");
        }

        order.setServices(orderDTO.getServices());
        order.setProductsDetails(orderDTO.getProductsDetails());
        orderRepository.save(order);
    }


    public void deleteOrder(Integer id){
        Orderr order = orderRepository.findOrderrById(id);
        if(order==null){
            throw new ApiException("order not found");
        }
        if(!order.getStatus().equals("pending")){
            throw new ApiException("th order cannot deleted");
        }
        orderRepository.delete(order);
    }

    public String invoice(Integer order_id){
        Orderr order = orderRepository.findOrderrById(order_id);
        if(order==null){
            throw new ApiException("order not found");
        }
        if(!order.getStatus().equals("accepted")){
            throw new ApiException("invoice cannot be issued before the order is accepted");
        }
        List<ProductsDetails> productsDetails = new ArrayList<>(order.getProductsDetails());
        List<com.example.munafis.Model.Service> serviceList = new ArrayList<>(order.getServices());
        for (com.example.munafis.Model.Service service : order.getServices()){
            serviceList.add(service);

        }

        for (ProductsDetails p : order.getProductsDetails()){
            productsDetails.add(p);
        }

        return "invoice details " + '\n' +
                "Company Name: " + order.getCompany().getCompanyName()  + '\n' +
                "Total Price: " + order.getTotalPrice() +   '\n' +
                "Services: " + serviceList  +   '\n' +
                 "Products: " + productsDetails + '\n';

    }

    public void acceptOrder(Integer user_id, Integer order_id){
        User user = authRepository.findUserById(user_id);
        Orderr order = orderRepository.findOrderrById(order_id);
        if(user==null){
            throw new ApiException("user not found");
        }
        if(order==null){
            throw new ApiException("order not found");
        }
        if(!user.getRole().equals("Admin")){
            throw new ApiException("not authorised");
        }
        else {
            order.setStatus("accepted");
            orderRepository.save(order);
        }
    }


}

