package com.lly.demo.service;

import org.springframework.stereotype.Service;

@Service
public class AopService {

    public int div(int a, int b) {
        return a / b;
    }

}
