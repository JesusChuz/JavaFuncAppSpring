package com.example;

import com.example.model.Greeting;
import com.example.model.User;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.core.ConsoleAppender;


import java.util.function.Function;

@Component
public class Hello implements Function<Mono<User>, Mono<Greeting>> {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    public Mono<Greeting> apply(Mono<User> mono) {
        MDC.clear();
        MDC.put("CD1", "CD1.1");
        MDC.put("CD2", "CD2.2");
        logger.info("STARTTT");
        return mono.map(user -> new Greeting("Hello, " + user.getName() + "!\n"));
    }
}