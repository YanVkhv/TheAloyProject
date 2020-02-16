package com.YanVkhv.service.subscriptions;

import com.YanVkhv.domain.subscriptions.Magazine;
import com.YanVkhv.domain.subscriptions.Subscription;
import com.YanVkhv.domain.subscriptions.SubscriptionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SubscriptionServiceTest {
    private SubscriptionService subscriptionService;
    private SubscriptionRepository subscriptionRepositoryMock;

    @BeforeEach
    void setupService() {
        subscriptionRepositoryMock = Mockito.mock(SubscriptionRepository.class);
        subscriptionService = new SubscriptionService(subscriptionRepositoryMock);
    }

    @Test
    void createSubscription_happyPath() {
        Subscription subscription = Subscription.builder()
                .subscriptionNumber("123456789")
                .magazine(Magazine.LEEF)
                .numberOfCopies("1")
                .editionId((long) 1)
                .isPublished(false)
                .build();
        Mockito.when(subscriptionRepositoryMock.save(subscription)).thenReturn(subscription);

        Subscription createdSubscription = subscriptionService.createSubscription(subscription);

        Assertions.assertThat(createdSubscription).isNotNull();
    }
}
