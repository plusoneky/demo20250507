package com.example.demo.domain;

import com.example.demo.service.IConvetContentStrategy;
import org.springframework.stereotype.Service;


public class BaseContent {

    private IConvetContentStrategy converter;

    public String convert(String paramStr){
        return converter.performConvert(paramStr);
    }
}
