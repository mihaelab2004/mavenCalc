package com.endava.jackson;


import com.endava.google.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class jacksonExample {

    private static final Logger LOGGER = LogManager.getLogger(jacksonExample.class);

    public static void main(String[] args) throws JsonProcessingException {
        Payment p = new Payment();
        p.setAmount(200.0);
        p.setCurrency("EUR");
        p.setCardNumber("222564412545425");
        p.setCustomerName("John Does");

        //deserializare
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(p);
        LOGGER.info(json);

        //serializare
        Payment dP = objectMapper.readValue(json, Payment.class);
        LOGGER.info (dP.equals(p));
    }
}
