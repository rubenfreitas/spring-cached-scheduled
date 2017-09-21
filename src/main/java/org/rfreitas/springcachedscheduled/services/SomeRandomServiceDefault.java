package org.rfreitas.springcachedscheduled.services;

import lombok.extern.slf4j.Slf4j;
import org.rfreitas.springcachedscheduled.entities.Quote;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class SomeRandomServiceDefault implements SomeRandomService {

    @Override
    @Cacheable("quotes")
    public String getRandomQuoteById(String id) {
        Quote quote = new RestTemplate().getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        log.info(quote.toString());

        return quote.getValue().getQuote();
    }
}
