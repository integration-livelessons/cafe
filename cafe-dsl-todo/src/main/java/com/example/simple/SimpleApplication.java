package com.example.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.integration.dsl.support.GenericHandler;
import org.springframework.messaging.MessageChannel;

import java.util.Map;

@SpringBootApplication
public class SimpleApplication {


    @Bean
    MessageChannel orderChannel() {
        return MessageChannels.direct().get();
    }

    public static class DrinkOrder {}

    @Bean
    IntegrationFlow orderFlow (){
        return IntegrationFlows
                .from(orderChannel())
                .split()
                .handle((GenericHandler<DrinkOrder>) (drinkOrder, headers) -> {
                    // todo make a drink
                    return null;
                })
                .get();
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleApplication.class, args);
    }
}
