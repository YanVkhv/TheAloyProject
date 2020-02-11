package com.YanVkhv.domain.subscribers;

import com.YanVkhv.domain.BaseEntity;
import com.YanVkhv.domain.genders.Gender;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Getter
@Entity
@Table(name = "SUBSCRIBER")
public class Subscriber extends BaseEntity {

    @Column(name = "FIRSTNAME")
    private final String firstname;

    @Column(name = "LASTNAME")
    private final String lastname;

    @Column(name = "BIRTHDATE")
    private final LocalDate birthdate;

    @Column(name = "DEATHDATE")
    private final LocalDate deathdate;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENDER")
    private final Gender gender;

    @Column(name = "NATIONAL_REGISTER_NUMBER")
    private final String nationalRegisterNumber;

    @Column(name = "FEDERATION")
    private final String federation;

    @Column(name = "CM_MEMBER_IND")
    private final boolean isCmMember;

    @Column(name = "M_NUMBER")
    private final String mNumber;

    @Column(name = "ACV_MEMBER_IND")
    private final boolean isAcvMember;

    @Column(name = "ACV_UUID")
    private final String acvUuid;

    @Column(name = "PHONE_NUMBER")
    private final String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "SUBSCRIBER_TYPE_ID")
    private final SubscriberType subscriberType;

    protected Subscriber() {
        this.firstname = null;
        this.lastname = null;
        this.birthdate = null;
        this.deathdate = null;
        this.gender = null;
        this.nationalRegisterNumber = null;
        this.federation = null;
        this.isCmMember = false;
        this.mNumber = null;
        this.isAcvMember = false;
        this.acvUuid = null;
        this.phoneNumber = null;
        this.subscriberType = null;
    }
}
