package com.example.munafis.Controller;


import com.example.munafis.Model.Company;
import com.example.munafis.Model.Orderr;
import com.example.munafis.Model.Provider;
import com.example.munafis.Service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("get")
    public ResponseEntity getAllCompanies(){
        return ResponseEntity.status(200).body(companyService.getAllCompanies());
    }


    @PostMapping("/add")
    public ResponseEntity addCompany(@Valid @RequestBody Company company ){
        companyService.addCompany(company);
        return ResponseEntity.status(200).body("company added");
    }



    @PutMapping("/update/{id}")
    public ResponseEntity updateCompany(@PathVariable Integer id,@Valid @RequestBody Company company){
        companyService.updateCompany(id, company);
        return ResponseEntity.status(200).body("company updated");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity companyService(@PathVariable Integer id){
        companyService.deleteCompany(id);
        return ResponseEntity.status(200).body("company deleted");
    }



    @GetMapping("/viewMyCompletedOrders{company_id}")
    public ResponseEntity viewMyCompletedOrders(@PathVariable Integer company_id){
        List<Orderr> orders = companyService.viewMyCompletedOrders(company_id);
        return ResponseEntity.status(200).body(orders);
    }

    @GetMapping("/viewMyPendingOrders{company_id}")
    public ResponseEntity viewMyPendingOrders(@PathVariable Integer company_id){
        List<Orderr> orders = companyService.viewMyPendingOrders(company_id);
        return ResponseEntity.status(200).body(orders);
    }

    @GetMapping("/MyAcceptedOrders/{id}")
    public ResponseEntity getMyOrdersByStatusAccepted(@PathVariable Integer id){
        Set<Orderr> orders = companyService.getMyOrdersByStatusAccepted(id);
        return ResponseEntity.status(200).body(orders);
    }
    @GetMapping("/MyCompletedOrders/{id}")
    public ResponseEntity getMyOrdersStatusCompleted(@PathVariable Integer id){
        Set<Orderr> orders = companyService.getMyOrdersStatusCompleted(id);
        return ResponseEntity.status(200).body(orders);
    }
    @GetMapping("/MyPendingOrders/{id}")
    public ResponseEntity getMyOrdersStatusPending(@PathVariable Integer id){
        Set<Orderr> orders = companyService.getMyOrdersStatusPending(id);
        return ResponseEntity.status(200).body(orders);
    }


}
