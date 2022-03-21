package com.example.demo.api;

import com.example.demo.services.NumberProcessingException;
import com.example.demo.services.NumberProcessingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {
    private final Logger log = LoggerFactory.getLogger(DemoController.class);
    private final NumberProcessingService numberProcessingService;

    public DemoController(NumberProcessingService numberProcessingService) {
        this.numberProcessingService = numberProcessingService;
    }

    @GetMapping("/filter")
    public String filter(@RequestParam(name = "number") String numberString) {
        log.info("received number: " + numberString);
        String processedNumber = null;
        try {
            processedNumber = numberProcessingService.processNumber(numberString);
        } catch (NumberProcessingException e) {
            log.error("invalid number: " + numberString);
            return e.getMessage() + "\n";
        }
        return String.format("result: %s \n!", processedNumber);
    }
}
