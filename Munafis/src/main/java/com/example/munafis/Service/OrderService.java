package com.example.munafis.Service;

import com.example.munafis.API.ApiException;
import com.example.munafis.DTO.OrderDTO;
import com.example.munafis.Model.Company;
import com.example.munafis.Model.Orderr;
import com.example.munafis.Model.Product;
import com.example.munafis.Model.ProductsDetails;
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

            Product product = productRepository.findProductById(productsDetails1.getProduct().getId());
            if (product == null) {
                throw new ApiException("product id not found");
            }
            Product foundProduct = productRepository.findProductById(product.getId());

            if (foundProduct == null) {
                throw new ApiException("Product not found for id: " + product.getId());
            }
            price += product.getPrice() * productsDetails1.getQuantity();
            ProductsDetails productsDetails2 = new ProductsDetails(null, productsDetails1.getQuantity(), null, foundProduct);
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
        Orderr orderr = new Orderr(null, orderDTO.getStatus(), totalPrice, serviceList, productsDetails, company);
        orderRepository.save(orderr);


        for (ProductsDetails productsDetails1: orderr.getProductsDetails()){
            productsDetails1.setOrder(orderr);
            productsDetailsRepository.save(productsDetails1);
        }


    }
}
//
////
////        List<Product> productList = new ArrayList<>();
////        List<com.example.munafis.Model.Service> serviceList =new ArrayList<>();
//
//        Set<Product> products = new HashSet<>();
//        Set<com.example.munafis.Model.Service> services = new HashSet<>();
//
//        Integer x =0;
//        Integer y =0;
//        for (Product p : orderDTO.getProducts()){
//            products.add(p);
//           x= p.getId();
//        }
//        for (com.example.munafis.Model.Service s : orderDTO.getServices()){
//            services.add(s);
//            y= s.getId();
//        }
//
//
////        for (int i = 0; i < orderDTO.getProducts().size(); i++) {
////        productList.add(orderDTO.getProducts().get(i));
////            products.add(productList.get(i));
////        }
////
////        for (int i = 0; i <orderDTO.getServices().size(); i++) {
////            serviceList.add(orderDTO.getServices().get(i));
////            services.add(serviceList.get(i));
////        }
//
//
//
//        Product product = productRepository.findProductsById(x);
//        com.example.munafis.Model.Service service = serviceRepository.findServiceById(y);
//        Company company = companyRepository.findCompanyById(orderDTO.getCompany_id());
//
//        if (product == null) {
//            throw new ApiException("product not found");
//        }
//        if (service == null) {
//            throw new ApiException("service not found");
//        }
//        if (company == null) {
//            throw new ApiException("company not found");
//        }
//        double totalPriceProduct = 0;
//        double totalPriceService = 0;
//        double totalPrice = 0;
//
//        if (product.getProductsDetails().getQuantity() <= 0) {
//            throw new ApiException("product is not available now");
//        } else {
//
//            //Calculate the total price
//            totalPriceProduct = product.getPrice() * orderDTO.getQuantity();
//            totalPriceService = service.getPrice();
//            totalPrice = totalPriceProduct + totalPriceService;
//
//            //
//            product.getProductsDetails().setQuantity(product.getProductsDetails().getQuantity() - orderDTO.getQuantity());
//            productsDetailsRepository.save(product.getProductsDetails());
//
//            Orderr orderr = new Orderr(null, orderDTO.getStatus(), totalPrice, services, products, company);
//            orderRepository.save(orderr);
//        }
//    }
