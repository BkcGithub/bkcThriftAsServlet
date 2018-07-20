package com.bkc.service.impl;

import com.bkc.service.GreetingService;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {
    @Override public void sayMessage(String message) {
        System.out.println("GreetingService.sayMessage " + message);
    }
}
