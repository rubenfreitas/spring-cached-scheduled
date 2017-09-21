package org.rfreitas.springcachedscheduled.tasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static javax.management.timer.Timer.ONE_MINUTE;

@Slf4j
@Component
public class CacheTasks {

    @CacheEvict(value = "quotes", allEntries = true)
    @Scheduled(fixedRate = ONE_MINUTE)
    public void clearQuotesCache() {
        log.info("clearing cache=quotes entries=all");
    }
}
