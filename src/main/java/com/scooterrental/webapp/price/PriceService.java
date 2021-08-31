package com.scooterrental.webapp.price;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;



}
