package com.example.munafis.Service;

import com.example.munafis.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class OrderService   {

    private final OrderRepository orderRepository;
}
