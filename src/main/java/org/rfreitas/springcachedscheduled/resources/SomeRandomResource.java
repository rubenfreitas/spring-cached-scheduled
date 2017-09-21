package org.rfreitas.springcachedscheduled.resources;

import lombok.extern.slf4j.Slf4j;
import org.rfreitas.springcachedscheduled.services.SomeRandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Slf4j
@RestController
public class SomeRandomResource {

    @Autowired
    public SomeRandomService someRandomService;

    @RequestMapping(value = "/hello-world", method = GET)
    public String getRandomCacheableQuote(@RequestParam(value = "id", defaultValue = "0") String id) {
        log.info("getting some random quote with id={}", id);
        return someRandomService.getRandomQuoteById(id);
    }
}
