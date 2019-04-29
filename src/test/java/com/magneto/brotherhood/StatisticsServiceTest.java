package com.magneto.brotherhood;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.magneto.brotherhood.model.Stats;
import com.magneto.brotherhood.services.CacheService;
import com.magneto.brotherhood.services.StatisticsCacheService;
import net.spy.memcached.MemcachedClient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class StatisticsServiceTest {

    @Mock
    private CacheService cacheService;

    @InjectMocks
    @Autowired
    private StatisticsCacheService statisticsCacheService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        when(cacheService.getContentInMemCache("mutant-amount", Long.class)).thenReturn(40L);
        when(cacheService.getContentInMemCache("human-amount", Long.class)).thenReturn(100L);
    }

    @Test
    public void obtainStatsTest(){
        Stats stats = statisticsCacheService.fetchStats();
        Assert.assertTrue(stats.getRatio() == 0.4);
    }


}
