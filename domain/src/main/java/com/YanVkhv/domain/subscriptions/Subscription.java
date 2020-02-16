package com.YanVkhv.domain.subscriptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "SUBSCRIPTION")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

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

}
