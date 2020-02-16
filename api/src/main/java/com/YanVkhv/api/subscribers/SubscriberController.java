package com.YanVkhv.api.subscribers;

import com.YanVkhv.domain.subscribers.Subscriber;
import com.YanVkhv.service.subscribers.SubscriberService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(path = "/" + SubscriberController.RESOURCE_NAME)
public class SubscriberController {
    public static final String RESOURCE_NAME = "subscribers";

    private final SubscriberService subscriberService;

    @Inject
    public SubscriberController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Subscriber createSubscriber(@RequestBody Subscriber subscriber) {
        return subscriberService.createSubscriber(subscriber);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Subscriber updateSubscriber(@NotNull @PathVariable Long id, @RequestBody Subscriber subscriber) {
        return subscriberService.updateSubscriber(id, subscriber);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Subscriber> getAllSubscribers() {
        return subscriberService.getAllSubscribers();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Subscriber getSubscriber(@PathVariable Long id) {
        return subscriberService.getSubscriber(id);
    }
}
