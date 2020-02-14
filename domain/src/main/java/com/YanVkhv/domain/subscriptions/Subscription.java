package com.YanVkhv.domain.subscriptions;

import com.YanVkhv.domain.BaseEntity;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
@Table(name = "SUBSCRIPTION")
public class Subscription extends BaseEntity {

    @Column(name = "SUBSCRIPTION_NUMBER")
    private final String subscriptionNumber;

    @Column(name = "START_DATE")
    private final LocalDate startDate;

    @Column(name = "END_DATE")
    private final LocalDate endDate;

    @Column(name = "SEND_PHYSICAL_IND")
    private final boolean sendPhysical;

    @Column(name = "SEND_DIGITAL_IND")
    private final boolean sendDigital;

    @Column(name = "VALIDATION_ERROR_ID")
    private final Long validationErrorId;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "MAGAZINE")
    private final Magazine magazine;

    @Column(name = "NUMBER_OF_COPIES")
    private final String numberOfCopies;

    @Column(name = "EDITION_ID")
    private final Long editionId;

    @Column(name = "PUBLISHED_IND")
    private final boolean isPublished;

    protected Subscription() {
        this.subscriptionNumber = null;
        this.startDate = null;
        this.endDate = null;
        this.sendPhysical = false;
        this.sendDigital = false;
        this.validationErrorId = null;
        this.magazine = null;
        this.numberOfCopies = null;
        this.editionId = null;
        this.isPublished = false;
    }
}
