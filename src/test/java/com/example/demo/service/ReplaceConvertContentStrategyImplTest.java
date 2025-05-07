package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReplaceConvertContentStrategyImplTest {

    @Autowired
    ReplaceConvertContentStrategyImpl replaceConvertContentStrategyImpl;

    @Test
    void performConvert() {
        String result = replaceConvertContentStrategyImpl.performConvert("abcccbad");
        assertEquals("d", result, "最终为d");
    }
}