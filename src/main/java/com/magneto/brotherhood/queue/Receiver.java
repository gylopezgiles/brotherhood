package com.magneto.brotherhood.queue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.magneto.brotherhood.model.DNA;
import com.magneto.brotherhood.services.MutantService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

public class Receiver {

    private Logger logger = LogManager.getLogger(Receiver.class);
    @Autowired
    private MutantService mutantService;

    public static final String RECEIVE_METHOD_NAME = "receiveMessage";

    public void receiveMessage(String message) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        logger.info("Received <" + message + ">");
        DNA dna = mapper.readValue(message, DNA.class);
        mutantService.saveDNA(dna);
    }

}
