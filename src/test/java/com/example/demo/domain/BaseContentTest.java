package com.example.demo.domain;

import com.example.demo.service.IConvetContentStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BaseContentTest {

    @Autowired
    @Qualifier("removeConvertContentStrategyImpl")
    private IConvetContentStrategy converter1;

    @Autowired
    @Qualifier("replaceConvertContentStrategyImpl")
    private IConvetContentStrategy converter2;

    @Test
    void convert() {
        String result1 = converter1.performConvert("aabcccbbad");
        assertEquals("d", result1, "最终为d");

        String result2 = converter2.performConvert("abcccbad");
        assertEquals("d", result2, "最终为d");
    }
}