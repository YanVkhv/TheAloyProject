package com.YanVkhv.domain.subscribers;

import com.YanVkhv.IntegrationTest;
import com.YanVkhv.domain.genders.Gender;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;

public class SubscriberRepositoryIntegrationTest extends IntegrationTest {
    @Inject
    private SubscriberRepository repository;

    @Test
    void save() {
        Subscriber subscriberToSave = createASubscriber();

        Subscriber savedSubscriber = repository.save(subscriberToSave);

        Assertions.assertThat(savedSubscriber.getId()).isNotNull();
        Assertions.assertThat(repository.get(savedSubscriber.getId()))
                .isEqualToComparingFieldByField(savedSubscriber);
    }

    @Test
    void get() {
        Subscriber savedSubscriber = repository.save(createASubscriber());

        Subscriber actualSubscriber = repository.get(savedSubscriber.getId());

        Assertions.assertThat(actualSubscriber)
                .isEqualToComparingFieldByField(savedSubscriber);
    }

    @Test
    void getAll() {
        Subscriber subscriberOne = repository.save(createASubscriber());
        Subscriber subscriberTwo = repository.save(Subscriber.builder()
                .firstname("Sarah")
                .lastname("Hsieh")
                .birthdate(LocalDate.of(1992, 10, 1))
                .gender(Gender.FEMALE)
                .nationalRegisterNumber("987654321")
                .build());

        List<Subscriber> allSubscribers = repository.getAll();

        Assertions.assertThat(allSubscribers)
                .containsExactlyInAnyOrder(subscriberOne, subscriberTwo);
    }

    private Subscriber createASubscriber() {
        return Subscriber.builder()
                .firstname("Yannick")
                .lastname("Vankerkhove")
                .birthdate(LocalDate.of(1990, 3, 20))
                .gender(Gender.MALE)
                .nationalRegisterNumber("123456789")
                .build();
    }
}
