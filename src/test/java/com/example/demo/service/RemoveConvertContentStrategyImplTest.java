package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RemoveConvertContentStrategyImplTest {

    @Autowired
    RemoveConvertContentStrategyImpl removeConvertContentStrategyImpl;

    @Test
    void performConvert() {
        String result = removeConvertContentStrategyImpl.performConvert("aabcccbbad");
        assertEquals("d", result, "最终为d");
    }

}