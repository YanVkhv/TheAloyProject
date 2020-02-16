package com.YanVkhv.api.subscriptions;

import com.YanVkhv.ControllerIntegrationTest;
import com.YanVkhv.domain.subscriptions.Magazine;
import com.YanVkhv.domain.subscriptions.Subscription;
import com.YanVkhv.domain.subscriptions.SubscriptionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import javax.inject.Inject;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

public class SubscriptionControllerIntegrationTest extends ControllerIntegrationTest {
    private static final String HTTP_LOCALHOST = "http://localhost";

    @Inject
    private SubscriptionRepository subscriptionRepository;

    @Override
    public void clearDatabase() {
        subscriptionRepository.getEntityManager().createQuery("DELETE FROM Subscription").executeUpdate();
    }

    @Test
    void createSubscription() {
        Subscription createdSubscription = new TestRestTemplate()
                .postForObject(format(HTTP_LOCALHOST + ":%s/%s", getPort(), SubscriptionController.RESOURCE_NAME), createASubscription(), Subscription.class);

        assertSubscriptionIsEqualIgnoringId(createASubscription(), createdSubscription);
    }

    @Test
    void updateSubscription() {
        Subscription alreadyExistingSubscription = subscriptionRepository.save(createASubscription());
        Subscription subscriptionToUpdate = Subscription.builder()
                .id(alreadyExistingSubscription.getId())
                .subscriptionNumber("987654321")
                .magazine(Magazine.VISIE)
                .numberOfCopies("1")
                .editionId((long) 1)
                .isPublished(false)
                .build();

        ResponseEntity<Subscription> result = new TestRestTemplate()
                .exchange(format(HTTP_LOCALHOST + ":%s/%s/%s", getPort(), SubscriptionController.RESOURCE_NAME, alreadyExistingSubscription.getId()),
                        HttpMethod.PUT,
                        new HttpEntity<>(subscriptionToUpdate),
                        Subscription.class);

        assertThat(result.getBody()).usingRecursiveComparison().isEqualTo(subscriptionToUpdate);
    }

    @Test
    void getAllSubscriptions_given2CreatedSubscriptions_whenGetAllSubscriptions_thenReturnAllSubscriptions() {
        new TestRestTemplate()
                .postForObject(format(HTTP_LOCALHOST + ":%s/%s", getPort(), SubscriptionController.RESOURCE_NAME),
                        createASubscription(), Subscription.class);
        new TestRestTemplate()
                .postForObject(format(HTTP_LOCALHOST + ":%s/%s", getPort(), SubscriptionController.RESOURCE_NAME),
                        createASubscription(), Subscription.class);

        Subscription[] allSubscriptions = new TestRestTemplate()
                .getForObject(format(HTTP_LOCALHOST + ":%s/%s", getPort(), SubscriptionController.RESOURCE_NAME), Subscription[].class);

        assertThat(allSubscriptions).hasSize(2);
    }

    @Test
    void getAllSubscriptions__assertResultIsCorrectlyReturned() {
        Subscription subscriptionInDb = new TestRestTemplate()
                .postForObject(format(HTTP_LOCALHOST + ":%s/%s", getPort(), SubscriptionController.RESOURCE_NAME),
                        createASubscription(), Subscription.class);

        Subscription[] allSubscriptions = new TestRestTemplate()
                .getForObject(format(HTTP_LOCALHOST + ":%s/%s", getPort(), SubscriptionController.RESOURCE_NAME), Subscription[].class);

        assertThat(allSubscriptions).hasSize(1);
        assertThat(allSubscriptions[0])
                .usingRecursiveComparison()
                .isEqualTo(subscriptionInDb);
    }

    @Test
    void getSubscription_given3CreatedSubscriptions_whenGetSpecificSubscription_thenReturnOnlyThatSubscription() {
        new TestRestTemplate()
                .postForObject(format(HTTP_LOCALHOST + ":%s/%s", getPort(), SubscriptionController.RESOURCE_NAME),
                        createASubscription(), Subscription.class);
        Subscription subscriptionToFind = new TestRestTemplate()
                .postForObject(format(HTTP_LOCALHOST + ":%s/%s", getPort(), SubscriptionController.RESOURCE_NAME),
                        createASubscription(), Subscription.class);
        new TestRestTemplate()
                .postForObject(format(HTTP_LOCALHOST + ":%s/%s", getPort(), SubscriptionController.RESOURCE_NAME),
                        createASubscription(), Subscription.class);

        Subscription foundSubscription = new TestRestTemplate()
                .getForObject(format(HTTP_LOCALHOST + ":%s/%s/%s", getPort(), SubscriptionController.RESOURCE_NAME, subscriptionToFind.getId()), Subscription.class);

        assertThat(foundSubscription)
                .usingRecursiveComparison()
                .isEqualTo(subscriptionToFind);
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

    private void assertSubscriptionIsEqualIgnoringId(Subscription subscriptionToCreate, Subscription createdSubscription) {
        assertThat(createdSubscription.getId()).isNotNull();
        assertThat(createdSubscription.getSubscriptionNumber()).isEqualTo(subscriptionToCreate.getSubscriptionNumber());
        assertThat(createdSubscription.getMagazine()).isEqualTo(subscriptionToCreate.getMagazine());
        assertThat(createdSubscription.getNumberOfCopies()).isEqualTo(subscriptionToCreate.getNumberOfCopies());
        assertThat(createdSubscription.getEditionId()).isEqualTo(subscriptionToCreate.getEditionId());
        assertThat(createdSubscription.isPublished()).isEqualTo(subscriptionToCreate.isPublished());
    }
}
