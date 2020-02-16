package com.YanVkhv.service.subscribers;

import com.YanVkhv.IntegrationTest;
import com.YanVkhv.domain.genders.Gender;
import com.YanVkhv.domain.subscribers.Subscriber;
import com.YanVkhv.domain.subscribers.SubscriberRepository;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SubscriberServiceIntegrationTest extends IntegrationTest {
    @Inject
    private SubscriberService subscriberService;

    @Inject
    private SubscriberRepository subscriberRepository;

    @Test
    void createSubscriber() {
        Subscriber subscriberToCreate = Subscriber.builder()
                .firstname("Yannick")
                .lastname("Vankerkhove")
                .birthdate(LocalDate.of(1990, 3, 20))
                .gender(Gender.MALE)
                .nationalRegisterNumber("123456789")
                .build();

        Subscriber createdSubscriber = subscriberService.createSubscriber(subscriberToCreate);

        assertThat(subscriberRepository.get(subscriberToCreate.getId()))
                .isEqualToComparingFieldByField(subscriberToCreate)
                .isEqualToComparingFieldByField(createdSubscriber);
    }

    @Test
    void updateSubscriber() {
        Subscriber createdSubscriber = subscriberService.createSubscriber(Subscriber.builder()
                .firstname("Yannick")
                .lastname("Vankerkhove")
                .birthdate(LocalDate.of(1990, 3, 20))
                .gender(Gender.MALE)
                .nationalRegisterNumber("123456789")
                .build());

        Subscriber updatedSubscriber = subscriberService.updateSubscriber(createdSubscriber.getId(), Subscriber.builder()
                .id(createdSubscriber.getId())
                .firstname("Yan")
                .lastname("Vkhv")
                .birthdate(LocalDate.of(1990, 3, 20))
                .gender(Gender.MALE)
                .nationalRegisterNumber("123456789")
                .build());

        assertThat(updatedSubscriber.getId()).isEqualTo(createdSubscriber.getId());
        assertThat(updatedSubscriber.getFirstname()).isEqualTo("Yan");
        assertThat(updatedSubscriber.getLastname()).isEqualTo("Vkhv");
    }

    @Test
    void getAllSubscribers() {
        Subscriber subscriber1 = subscriberService.createSubscriber(Subscriber.builder()
                .firstname("Yannick")
                .lastname("Vankerkhove")
                .birthdate(LocalDate.of(1990, 3, 20))
                .gender(Gender.MALE)
                .nationalRegisterNumber("123456789")
                .build());
        Subscriber subscriber2 = subscriberService.createSubscriber(Subscriber.builder()
                .firstname("Sarah")
                .lastname("Hsieh")
                .birthdate(LocalDate.of(1992, 10, 1))
                .gender(Gender.FEMALE)
                .nationalRegisterNumber("987654321")
                .build());
        Subscriber subscriber3 = subscriberService.createSubscriber(Subscriber.builder()
                .firstname("Jane")
                .lastname("Doe")
                .birthdate(LocalDate.of(1850, 6, 23))
                .gender(Gender.FEMALE)
                .nationalRegisterNumber("159487263")
                .build());

        List<Subscriber> allSubscribers = subscriberService.getAllSubscribers();

        assertThat(allSubscribers).containsExactlyInAnyOrder(subscriber1, subscriber2, subscriber3);
    }

    @Test
    void getSubscriber() {
        subscriberService.createSubscriber(Subscriber.builder()
                .firstname("Yannick")
                .lastname("Vankerkhove")
                .birthdate(LocalDate.of(1990, 3, 20))
                .gender(Gender.MALE)
                .nationalRegisterNumber("123456789")
                .build());
        Subscriber subscriberToFind = subscriberService.createSubscriber(Subscriber.builder()
                .firstname("Sarah")
                .lastname("Hsieh")
                .birthdate(LocalDate.of(1992, 10, 1))
                .gender(Gender.FEMALE)
                .nationalRegisterNumber("987654321")
                .build());
        subscriberService.createSubscriber(Subscriber.builder()
                .firstname("Jane")
                .lastname("Doe")
                .birthdate(LocalDate.of(1850, 6, 23))
                .gender(Gender.FEMALE)
                .nationalRegisterNumber("159487263")
                .build());

        Subscriber foundSubscriber = subscriberService.getSubscriber(subscriberToFind.getId());

        assertThat(foundSubscriber).isEqualToComparingFieldByField(subscriberToFind);
    }
}
