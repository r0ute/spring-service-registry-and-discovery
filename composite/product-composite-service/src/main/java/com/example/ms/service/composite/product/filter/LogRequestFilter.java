package com.example.ms.service.composite.product.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import reactor.core.publisher.Mono;

@Component
public class LogRequestFilter implements ExchangeFilterFunction {

    private static final Logger logger = LoggerFactory.getLogger(LogRequestFilter.class);

    @Override
    public Mono<ClientResponse> filter(ClientRequest request, ExchangeFunction next) {
        logger.debug("{} {} {}", request.method(), request.url(), request.attributes());

        return next.exchange(request);
    }
}
