package com.YanVkhv.service.subscribers;

import com.YanVkhv.domain.genders.Gender;
import com.YanVkhv.domain.subscribers.Subscriber;
import com.YanVkhv.domain.subscribers.SubscriberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

public class SubscriberServiceTest {
    private SubscriberService subscriberService;
    private SubscriberRepository subscriberRepositoryMock;

    @BeforeEach
    void setupService() {
        subscriberRepositoryMock = Mockito.mock(SubscriberRepository.class);
        subscriberService = new SubscriberService(subscriberRepositoryMock);
    }

    @Test
    void createSubscriber_happyPath() {
        Subscriber subscriber = Subscriber.builder()
                .addressId((long) 1)
                .firstname("Yannick")
                .lastname("Vankerkhove")
                .birthdate(LocalDate.of(1990, 3, 20))
                .gender(Gender.MALE)
                .nationalRegisterNumber("123456789")
                .build();
        Mockito.when(subscriberRepositoryMock.save(subscriber)).thenReturn(subscriber);

        Subscriber createdSubscriber = subscriberService.createSubscriber(subscriber);

        Assertions.assertThat(createdSubscriber).isNotNull();
    }

}
