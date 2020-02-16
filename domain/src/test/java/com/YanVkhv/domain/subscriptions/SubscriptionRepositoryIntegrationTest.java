package com.YanVkhv.domain.subscriptions;

import com.YanVkhv.IntegrationTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

public class SubscriptionRepositoryIntegrationTest extends IntegrationTest {
    @Inject
    private SubscriptionRepository repository;

    @Test
    void save() {
        Subscription subscriptionToSave = createASubscription();

        Subscription savedSubscription = repository.save(subscriptionToSave);

        Assertions.assertThat(savedSubscription.getId()).isNotNull();
        Assertions.assertThat(repository.get(savedSubscription.getId()))
                .isEqualToComparingFieldByField(savedSubscription);
    }

    @Test
    void get() {
        Subscription savedSubscription = repository.save(createASubscription());

        Subscription actualSubscription = repository.get(savedSubscription.getId());

        Assertions.assertThat(actualSubscription)
                .isEqualToComparingFieldByField(savedSubscription);
    }

    @Test
    void getAll() {
        Subscription subscriptionOne = repository.save(createASubscription());
        Subscription subscriptionTwo = repository.save(Subscription.builder()
                .subscriptionNumber("987654321")
                .magazine(Magazine.VISIE)
                .numberOfCopies("1")
                .editionId((long) 1)
                .isPublished(false)
                .build());

        List<Subscription> allSubscriptions = repository.getAll();

        Assertions.assertThat(allSubscriptions)
                .containsExactlyInAnyOrder(subscriptionOne, subscriptionTwo);
    }

    private Subscription createASubscription() {
        return Subscription.builder()
                .subscriptionNumber("123456789")
                .magazine(Magazine.LEEF)
                .numberOfCopies("1")
                .editionId((long) 1)
                .isPublished(false)
                .build();
    }
}
