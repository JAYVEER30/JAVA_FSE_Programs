package com.cognizant.spring_learn;

import com.cognizant.springlearn.SpringLearnApplication; // ✅ Make sure this import is correct
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringLearnApplication.class)
class SpringLearnApplicationTests {

    @Test
    void contextLoads() {
    }

}
