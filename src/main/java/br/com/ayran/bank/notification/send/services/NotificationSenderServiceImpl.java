package br.com.ayran.bank.notification.send.services;

import br.com.ayran.bank.customer.create.models.Customer;
import br.com.ayran.bank.notification.send.exceptions.NotificationNotSentException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Map;

@Service
public class NotificationSenderServiceImpl implements NotificationSenderService {
    @Value("${notification.url}")
    private String url;

    @Override
    @Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000))
    public void sendNotification(Customer customer) {
        WebClient
                .create()
                .get()
                .uri(this.url)
                .retrieve()
                .bodyToFlux(convertToMap())
                .map(NotificationSenderServiceImpl::extractPayload)
                .map(Boolean::parseBoolean)
                .filter(v -> v)
                .switchIfEmpty(throwErrorIfEmpty());
    }

    private ParameterizedTypeReference<Map<String, String>> convertToMap() {
        return new ParameterizedTypeReference<>() {};
    }

    private static String extractPayload(Map<String, String> r) {
        return r.getOrDefault("messageSent", "true");
    }

    private Flux<Boolean> throwErrorIfEmpty() {
        return Flux.error(new NotificationNotSentException());
    }
}
