package com.YanVkhv.api.subscribers;

import com.YanVkhv.ControllerIntegrationTest;
import com.YanVkhv.domain.genders.Gender;
import com.YanVkhv.domain.subscribers.Subscriber;
import com.YanVkhv.domain.subscribers.SubscriberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import javax.inject.Inject;
import java.time.LocalDate;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

public class SubscriberControllerIntegrationTest extends ControllerIntegrationTest {
    private static final String HTTP_LOCALHOST = "http://localhost";

    @Inject
    private SubscriberRepository subscriberRepository;

    @Override
    public void clearDatabase() {
        subscriberRepository.getEntityManager().createQuery("DELETE FROM Subscriber").executeUpdate();
    }

    @Test
    void createSubscriber() {
        Subscriber createdSubscriber = new TestRestTemplate()
                .postForObject(format(HTTP_LOCALHOST + ":%s/%s", getPort(), SubscriberController.RESOURCE_NAME), createASubscriber(), Subscriber.class);

        assertSubscriberIsEqualIgnoringId(createASubscriber(), createdSubscriber);
    }

    @Test
    void updateSubscriber() {
        Subscriber alreadyExistingSubscriber = subscriberRepository.save(createASubscriber());
        Subscriber subscriberToUpdate = Subscriber.builder()
                .id(alreadyExistingSubscriber.getId())
                .addressId((long) 1)
                .firstname("Yan")
                .lastname("Vkhv")
                .birthdate(LocalDate.of(1990, 3, 20))
                .gender(Gender.MALE)
                .nationalRegisterNumber("123456789")
                .build();

        ResponseEntity<Subscriber> result = new TestRestTemplate()
                .exchange(format(HTTP_LOCALHOST + ":%s/%s/%s", getPort(), SubscriberController.RESOURCE_NAME, alreadyExistingSubscriber.getId()),
                        HttpMethod.PUT,
                        new HttpEntity<>(subscriberToUpdate),
                        Subscriber.class);

        assertThat(result.getBody()).usingRecursiveComparison().isEqualTo(subscriberToUpdate);
    }

    @Test
    void getAllSubscribers_given2CreatedSubscribers_whenGetAllSubscribers_thenReturnAllSubscribers() {
        new TestRestTemplate()
                .postForObject(format(HTTP_LOCALHOST + ":%s/%s", getPort(), SubscriberController.RESOURCE_NAME),
                        createASubscriber(), Subscriber.class);
        new TestRestTemplate()
                .postForObject(format(HTTP_LOCALHOST + ":%s/%s", getPort(), SubscriberController.RESOURCE_NAME),
                        createASubscriber(), Subscriber.class);

        Subscriber[] allSubscribers = new TestRestTemplate()
                .getForObject(format(HTTP_LOCALHOST + ":%s/%s", getPort(), SubscriberController.RESOURCE_NAME), Subscriber[].class);

        assertThat(allSubscribers).hasSize(2);
    }

    @Test
    void getAllSubscribers__assertResultIsCorrectlyReturned() {
        Subscriber subscriberInDb = new TestRestTemplate()
                .postForObject(format(HTTP_LOCALHOST + ":%s/%s", getPort(), SubscriberController.RESOURCE_NAME),
                        createASubscriber(), Subscriber.class);

        Subscriber[] allSubscribers = new TestRestTemplate()
                .getForObject(format(HTTP_LOCALHOST + ":%s/%s", getPort(), SubscriberController.RESOURCE_NAME), Subscriber[].class);

        assertThat(allSubscribers).hasSize(1);
        assertThat(allSubscribers[0])
                .usingRecursiveComparison()
                .isEqualTo(subscriberInDb);
    }

    @Test
    void getSubscriber_given3CreatedSubscribers_whenGetSpecificSubscriber_thenReturnOnlyThatSubscriber() {
        new TestRestTemplate()
                .postForObject(format(HTTP_LOCALHOST + ":%s/%s", getPort(), SubscriberController.RESOURCE_NAME),
                        createASubscriber(), Subscriber.class);
        Subscriber subscriberToFind = new TestRestTemplate()
                .postForObject(format(HTTP_LOCALHOST + ":%s/%s", getPort(), SubscriberController.RESOURCE_NAME),
                        createASubscriber(), Subscriber.class);
        new TestRestTemplate()
                .postForObject(format(HTTP_LOCALHOST + ":%s/%s", getPort(), SubscriberController.RESOURCE_NAME),
                        createASubscriber(), Subscriber.class);

        Subscriber foundSubscriber = new TestRestTemplate()
                .getForObject(format(HTTP_LOCALHOST + ":%s/%s/%s", getPort(), SubscriberController.RESOURCE_NAME, subscriberToFind.getId()), Subscriber.class);

        assertThat(foundSubscriber)
                .usingRecursiveComparison()
                .isEqualTo(subscriberToFind);
    }

    private Subscriber createASubscriber() {
        return Subscriber.builder()
                .addressId((long) 1)
                .firstname("Yannick")
                .lastname("Vankerkhove")
                .birthdate(LocalDate.of(1990, 3, 20))
                .gender(Gender.MALE)
                .nationalRegisterNumber("123456789")
                .build();
    }

    private void assertSubscriberIsEqualIgnoringId(Subscriber subscriberToCreate, Subscriber createdSubscriber) {
        assertThat(createdSubscriber.getId()).isNotNull();
        assertThat(createdSubscriber.getFirstname()).isEqualTo(subscriberToCreate.getFirstname());
        assertThat(createdSubscriber.getLastname()).isEqualTo(subscriberToCreate.getLastname());
        assertThat(createdSubscriber.getBirthdate()).isEqualTo(subscriberToCreate.getBirthdate());
        assertThat(createdSubscriber.getGender()).isEqualTo(subscriberToCreate.getGender());
        assertThat(createdSubscriber.getNationalRegisterNumber()).isEqualTo(subscriberToCreate.getNationalRegisterNumber());
    }
}
