package com.YanVkhv.service.subscriptions;

import com.YanVkhv.domain.subscriptions.Subscription;
import com.YanVkhv.domain.subscriptions.SubscriptionRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    @Inject
    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Subscription createSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.getAll();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public Subscription getSubscription(Long id) {
        return subscriptionRepository.get(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Subscription updateSubscription(Long id, Subscription subscription) {
        if (!subscription.getId().equals(id)) {
            throw new IllegalArgumentException("When updating a subscription, the provided ID in the path should match the ID in the body: " +
                    "ID in path = " + id + ", ID in body = " + subscription.getId());
        }
        return subscriptionRepository.update(subscription);
    }
}
