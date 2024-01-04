package com.example.munafis.Service;


import com.example.munafis.Repository.RFPRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RFPService {
    private final RFPRepository rfpRepository;
}
