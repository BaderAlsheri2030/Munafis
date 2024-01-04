package com.example.munafis.Service;


import com.example.munafis.Repository.OfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OffersService {

    private final OfferRepository offerRepository;
}
