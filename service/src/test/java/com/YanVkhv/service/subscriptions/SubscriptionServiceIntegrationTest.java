package com.YanVkhv.service.subscriptions;

import com.YanVkhv.IntegrationTest;
import com.YanVkhv.domain.subscriptions.Magazine;
import com.YanVkhv.domain.subscriptions.Subscription;
import com.YanVkhv.domain.subscriptions.SubscriptionRepository;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SubscriptionServiceIntegrationTest extends IntegrationTest {
    @Inject
    private SubscriptionService subscriptionService;

    @Inject
    private SubscriptionRepository subscriptionRepository;

    @Test
    void createSubscription() {
        Subscription subscriptionToCreate = Subscription.builder()
                .subscriptionNumber("123456789")
                .magazine(Magazine.LEEF)
                .numberOfCopies("1")
                .editionId((long) 1)
                .isPublished(false)
                .build();

        Subscription createdSubscription = subscriptionService.createSubscription(subscriptionToCreate);

        assertThat(subscriptionRepository.get(subscriptionToCreate.getId()))
                .isEqualToComparingFieldByField(subscriptionToCreate)
                .isEqualToComparingFieldByField(createdSubscription);
    }

    @Test
    void updateSubscription() {
        Subscription createdSubscription = subscriptionService.createSubscription(Subscription.builder()
                .subscriptionNumber("123456789")
                .magazine(Magazine.LEEF)
                .numberOfCopies("1")
                .editionId((long) 1)
                .isPublished(false)
                .build());

        Subscription updatedSubscription = subscriptionService.updateSubscription(createdSubscription.getId(), Subscription.builder()
                .id(createdSubscription.getId())
                .subscriptionNumber("987654321")
                .magazine(Magazine.LEEF)
                .numberOfCopies("1")
                .editionId((long) 1)
                .isPublished(true)
                .build());

        assertThat(updatedSubscription.getId()).isEqualTo(createdSubscription.getId());
        assertThat(updatedSubscription.getSubscriptionNumber()).isEqualTo("987654321");
        assertThat(updatedSubscription.isPublished()).isTrue();
    }

    @Test
    void getAllSubscriptions() {
        Subscription subscription1 = subscriptionService.createSubscription(Subscription.builder()
                .subscriptionNumber("123456789")
                .magazine(Magazine.LEEF)
                .numberOfCopies("1")
                .editionId((long) 1)
                .isPublished(false)
                .build());
        Subscription subscription2 = subscriptionService.createSubscription(Subscription.builder()
                .subscriptionNumber("987654321")
                .magazine(Magazine.VISIE)
                .numberOfCopies("1")
                .editionId((long) 1)
                .isPublished(false)
                .build());
        Subscription subscription3 = subscriptionService.createSubscription(Subscription.builder()
                .subscriptionNumber("159487263")
                .magazine(Magazine.EN_MARCHE)
                .numberOfCopies("1")
                .editionId((long) 1)
                .isPublished(false)
                .build());

        List<Subscription> allSubscriptions = subscriptionService.getAllSubscriptions();

        assertThat(allSubscriptions).containsExactlyInAnyOrder(subscription1, subscription2, subscription3);
    }

    @Test
    void getSubscription() {
        subscriptionService.createSubscription(Subscription.builder()
                .subscriptionNumber("123456789")
                .magazine(Magazine.LEEF)
                .numberOfCopies("1")
                .editionId((long) 1)
                .isPublished(false)
                .build());
        Subscription subscriptionToFind = subscriptionService.createSubscription(Subscription.builder()
                .subscriptionNumber("987654321")
                .magazine(Magazine.VISIE)
                .numberOfCopies("1")
                .editionId((long) 1)
                .isPublished(false)
                .build());
        subscriptionService.createSubscription(Subscription.builder()
                .subscriptionNumber("159487263")
                .magazine(Magazine.EN_MARCHE)
                .numberOfCopies("1")
                .editionId((long) 1)
                .isPublished(false)
                .build());

        Subscription foundSubscription = subscriptionService.getSubscription(subscriptionToFind.getId());

        assertThat(foundSubscription).isEqualToComparingFieldByField(subscriptionToFind);
    }
}
