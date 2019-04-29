package com.magneto.brotherhood.controllers;

import com.magneto.brotherhood.model.Stats;
import com.magneto.brotherhood.services.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatisticsController {

    private StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService){
        this.statisticsService = statisticsService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Stats> getDNAStats(){
        return new ResponseEntity<>(statisticsService.obtainStats(), HttpStatus.OK);
    }

}
