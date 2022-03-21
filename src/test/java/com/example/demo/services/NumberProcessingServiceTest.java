package com.example.demo.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberProcessingServiceTest {

    @Test
    void processNumber() throws NumberProcessingException {
        NumberProcessingService numberProcessingService = new NumberProcessingService();
        String result = numberProcessingService.processNumber("43256791");
        Assertions.assertEquals(result, "11331545");
    }

    @Test
    void invalidArgument() {
        NumberProcessingService numberProcessingService = new NumberProcessingService();
        Assertions.assertThrows(NumberProcessingException.class, () -> numberProcessingService.processNumber("432r56791"));
    }

    @Test
    void resultConversionError() {
        NumberProcessingService numberProcessingService = new NumberProcessingService();
        Assertions.assertThrows(NumberProcessingException.class, () -> numberProcessingService.processNumber("7"));
    }
}
