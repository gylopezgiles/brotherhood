package com.magneto.brotherhood.controllers;

import com.magneto.brotherhood.model.DNARequest;
import com.magneto.brotherhood.services.MutantService;
import com.magneto.brotherhood.validators.DNAValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mutant")
public class MutantController {
    private MutantService mutantService;
    private DNAValidator dnaValidator;

    @Autowired
    public MutantController(MutantService mutantService, DNAValidator dnaValidator) {
        this.mutantService = mutantService;
        this.dnaValidator = dnaValidator;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> analizeDna(@RequestBody DNARequest dnaRequest) {
        try {
            dnaValidator.validate(dnaRequest.getDnaBases());
        } catch (IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        Boolean isMutant = mutantService.checkDNA(dnaRequest.getDnaBases());
        HttpStatus status = isMutant ? HttpStatus.OK : HttpStatus.FORBIDDEN;
        return new ResponseEntity<>("", status);
    }

}
