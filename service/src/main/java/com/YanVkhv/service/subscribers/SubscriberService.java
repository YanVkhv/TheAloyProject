package com.YanVkhv.service.subscribers;

import com.YanVkhv.domain.subscribers.Subscriber;
import com.YanVkhv.domain.subscribers.SubscriberRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class SubscriberService {

    private final SubscriberRepository subscriberRepository;

    @Inject
    public SubscriberService(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Subscriber createSubscriber(Subscriber subscriber) {
        return subscriberRepository.save(subscriber);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Subscriber> getAllSubscribers() {
        return subscriberRepository.getAll();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public Subscriber getSubscriber(Long id) {
        return subscriberRepository.get(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Subscriber updateSubscriber(Long id, Subscriber subscriber) {
        if (!subscriber.getId().equals(id)) {
            throw new IllegalArgumentException("When updating a subscriber, the provided ID in the path should match the ID in the body: " +
                    "ID in path = " + id + ", ID in body = " + subscriber.getId());
        }
        return subscriberRepository.update(subscriber);
    }
}
