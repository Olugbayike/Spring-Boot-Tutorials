package com.sot.springTest;

import com.sot.springTest.config.Config;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig(Config.class)
public class CustomBeanTest {

    private final String customBean;

    @Autowired
    CustomBeanTest(String customBean){
        this.customBean = customBean;
    }

    @Test
    void contextLoads(){
        assertThat(customBean).isEqualTo("custom bean");
    }
}
