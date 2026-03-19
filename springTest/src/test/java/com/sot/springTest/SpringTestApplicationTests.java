package com.sot.springTest;

import com.sot.springTest.config.Config;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Config.class)
class SpringTestApplicationTests {

    private final ApplicationContext applicationContext;

    @Autowired
    SpringTestApplicationTests(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }

	@Test
	void contextLoads() {
        assertThat(applicationContext).isNotNull();
        assertThat(applicationContext.getBeanDefinitionNames())
                .contains("customBean", "config");
	}

}
