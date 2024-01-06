package com.iffat.springboot.webclient.client;

import reactor.core.publisher.Flux;

public interface BeerClient {
    Flux<String> listBeers();
}
