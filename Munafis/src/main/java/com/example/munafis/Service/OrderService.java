package com.example.munafis.Service;

import com.example.munafis.API.ApiException;
import com.example.munafis.DTO.OrderDTO;
import com.example.munafis.Model.Company;
import com.example.munafis.Model.Orderr;
import com.example.munafis.Model.Product;
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


        List<Product> productList = new ArrayList<>();
        List<com.example.munafis.Model.Service> serviceList =new ArrayList<>();

        Set<Product> products = new HashSet<>();
        Set<com.example.munafis.Model.Service> services = new HashSet<>();

        for (int i = 0; i < orderDTO.getProducts().size(); i++) {
        productList.add(orderDTO.getProducts().get(i));
            products.add(productList.get(i));
        }

        for (int i = 0; i <orderDTO.getServices().size(); i++) {
            serviceList.add(orderDTO.getServices().get(i));
            services.add(serviceList.get(i));
        }

        Product product = productRepository.findProductsById(orderDTO.getProducts().get(0).getId());
        com.example.munafis.Model.Service service = serviceRepository.findServiceById(orderDTO.getServices().get(0).getId());
        Company company = companyRepository.findCompanyById(orderDTO.getCompany_id());

        if (product == null) {
            throw new ApiException("product not found");
        }
        if (service == null) {
            throw new ApiException("service not found");
        }
        if (company == null) {
            throw new ApiException("company not found");
        }
        double totalPriceProduct = 0;
        double totalPriceService = 0;
        double totalPrice = 0;

        if (product.getProductsDetails().getQuantity() <= 0) {
            throw new ApiException("product is not available now");
        } else {

            //Calculate the total price
            totalPriceProduct = product.getPrice() * orderDTO.getQuantity();
            totalPriceService = service.getPrice();
            totalPrice = totalPriceProduct + totalPriceService;

            //
            product.getProductsDetails().setQuantity(product.getProductsDetails().getQuantity() - orderDTO.getQuantity());
            productsDetailsRepository.save(product.getProductsDetails());

            Orderr orderr = new Orderr(null, orderDTO.getStatus(), totalPrice, services, products, company);
            orderRepository.save(orderr);
        }
    }
}