package com.YanVkhv.api.subscriptions;

import com.YanVkhv.domain.subscriptions.Subscription;
import com.YanVkhv.service.subscriptions.SubscriptionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(path = "/" + SubscriptionController.RESOURCE_NAME)
public class SubscriptionController {

    public static final String RESOURCE_NAME = "subscriptions";

    private final SubscriptionService subscriptionService;

    @Inject
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Subscription createSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.createSubscription(subscription);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Subscription updateSubscription(@NotNull @PathVariable Long id, @RequestBody Subscription subscription) {
        return subscriptionService.updateSubscription(id, subscription);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Subscription> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Subscription getSubscription(@PathVariable Long id) {
        return subscriptionService.getSubscription(id);
    }

}
