package com.davi.learning_spring.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLogController {

    private Logger logger = LoggerFactory.getLogger(TestLogController.class.getName());


    @GetMapping("/test")
    public String testLog(){
        logger.debug("This is a debug log message");
        logger.info("This is an info log message");
        logger.warn("This is a warn log message");
        logger.error("This is an error log message");
        return "Logging test completed. Check the logs for messages.";
    }

}
