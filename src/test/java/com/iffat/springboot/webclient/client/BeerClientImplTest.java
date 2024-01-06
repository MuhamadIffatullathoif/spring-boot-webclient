package com.iffat.springboot.webclient.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerClientImplTest {

    @Autowired
    BeerClient beerClient;

    @Test
    void testGetMap() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        beerClient.listBeersMap().subscribe(beerClient -> {
            System.out.println(beerClient);
            atomicBoolean.set(true);
        });

        await().untilTrue(atomicBoolean);
    }

    @Test
    void listBeers() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        beerClient.listBeers().subscribe(beers -> {
            System.out.println(beers);
            atomicBoolean.set(true);
        });

        await().untilTrue(atomicBoolean);
    }
}