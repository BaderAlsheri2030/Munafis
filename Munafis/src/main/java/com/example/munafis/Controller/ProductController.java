package com.example.munafis.Controller;


import com.example.munafis.DTO.ProductDTO;
import com.example.munafis.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;



    //ALL
    @GetMapping("/get")
    public ResponseEntity getAllProducts(){
        return ResponseEntity.status(200).body(productService.getAllProducts());

    }


    //Only provider
    @PostMapping("/add")
    public ResponseEntity addProduct(@Valid @RequestBody ProductDTO productDTO){
        productService.addProduct(productDTO);
        return  ResponseEntity.status(200).body("product added");
    }


    //Only provider
    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable Integer id ,@Valid @RequestBody ProductDTO productDTO){

        productService.updateProduct(id,productDTO);
        return  ResponseEntity.status(200).body("product updated");
    }



    //Only provider
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
        return  ResponseEntity.status(200).body("product deleted");
    }

}
