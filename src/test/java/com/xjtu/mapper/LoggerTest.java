package com.xjtu.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerTest {

    @Test
    public void Test() {
        Logger logger = LoggerFactory.getLogger(Test.class);
        logger.trace("Hello World");
        logger.info("哈哈哈");
    }


}
