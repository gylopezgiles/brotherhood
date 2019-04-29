package com.magneto.brotherhood.services;

import com.magneto.brotherhood.model.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    @Autowired
    private StatisticsCacheService statisticsCacheService;

    public Stats obtainStats(){
        return statisticsCacheService.fetchStats();
    }

}
