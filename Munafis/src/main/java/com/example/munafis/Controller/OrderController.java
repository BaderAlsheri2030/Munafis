package com.example.munafis.Controller;


import com.example.munafis.DTO.OrderDTO;
import com.example.munafis.Service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {


    private final OrderService orderService;




    @GetMapping("/get")
    public ResponseEntity getAllOrder(){
        return ResponseEntity.status(200).body(orderService.getAllOrders());
    }
    @PostMapping("/add")
    public ResponseEntity addOrder(@Valid @RequestBody OrderDTO orderDTO){
        orderService.addOrder(orderDTO);
        return ResponseEntity.status(200).body("order added");
    }

    @DeleteMapping("/update/{id}")
    public ResponseEntity updateOrder(@Valid @RequestBody OrderDTO orderDTO,@PathVariable Integer id){
        orderService.updateOrder(orderDTO,id);
        return ResponseEntity.status(200).body("order updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOrder(@PathVariable Integer id){
        orderService.deleteOrder(id);
        return ResponseEntity.status(200).body("order deleted");
    }

//    @GetMapping("/invoice/{id}")
//    public ResponseEntity invoice(@PathVariable Integer id){
//
//        String invoice = orderService.invoice(id);
//        return ResponseEntity.status(200).body(invoice);
//    }

    @PutMapping("/acceptOrder/{user_id}/{order_id}")
    public ResponseEntity acceptOrder(@PathVariable Integer user_id, @PathVariable Integer order_id){
        orderService.acceptOrder(user_id,order_id);
        return ResponseEntity.status(200).body("order accepted");

    }
}
