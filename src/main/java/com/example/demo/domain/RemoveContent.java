package com.example.demo.domain;

import com.example.demo.service.IConvetContentStrategy;
import com.example.demo.service.RemoveConvertContentStrategyImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RemoveContent extends BaseContent {

    @Autowired
    @Qualifier("removeConvertContentStrategyImpl")
    private IConvetContentStrategy converter;
}
