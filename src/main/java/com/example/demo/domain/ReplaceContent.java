package com.example.demo.domain;

import com.example.demo.service.IConvetContentStrategy;
import com.example.demo.service.RemoveConvertContentStrategyImpl;
import com.example.demo.service.ReplaceConvertContentStrategyImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ReplaceContent extends BaseContent {

    @Autowired
    @Qualifier("replaceConvertContentStrategyImpl")
    private IConvetContentStrategy converter;
}
