package com.YanVkhv.domain.subscriptions;

import com.YanVkhv.domain.subscribers.Subscriber;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@EqualsAndHashCode
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SUBSCRIPTION")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBSCRIBER_ID", nullable = false)
    private Subscriber subscriber;

    @Column(name = "SUBSCRIPTION_NUMBER", updatable = false, nullable = false)
    private String subscriptionNumber;

    @Column(name = "START_DATE")
    private LocalDate startDate = null;

    @Column(name = "END_DATE")
    private LocalDate endDate = null;

    @Column(name = "SEND_PHYSICAL_IND", nullable = false)
    private boolean sendPhysical = false;

    @Column(name = "SEND_DIGITAL_IND", nullable = false)
    private boolean sendDigital = false;

    @Column(name = "VALIDATION_ERROR_ID")
    private Long validationErrorId = null;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "MAGAZINE", updatable = false, nullable = false)
    private Magazine magazine;

    @Column(name = "NUMBER_OF_COPIES", nullable = false)
    private String numberOfCopies = "1";

    @Column(name = "EDITION_ID", updatable = false, nullable = false)
    private Long editionId;

    @Column(name = "PUBLISHED_IND", nullable = false)
    private boolean isPublished = false;

    @Override
    public String toString() {
        return String.format("%s: %s", magazine.getLabel(), subscriptionNumber);
    }
}
