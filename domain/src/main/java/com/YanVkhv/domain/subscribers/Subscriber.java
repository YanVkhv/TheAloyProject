package com.YanVkhv.domain.subscribers;

import com.YanVkhv.domain.BaseEntity;
import com.YanVkhv.domain.genders.Gender;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
@Table(name = "SUBSCRIBER")
public class Subscriber extends BaseEntity {

    @Column(name = "SUBSCRIPTION_ID")
    private final Long subscriptionId;

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

    @Column(name = "CM_MEMBER_IND")
    private final boolean isCmMember;

    @Column(name = "M_NUMBER")
    private final String mNumber;

    @Column(name = "ACV_MEMBER_IND")
    private final boolean isAcvMember;

    @Column(name = "ACV_UUID")
    private final String acvUuid;

    protected Subscriber() {
        this.subscriptionId = null;
        this.firstname = null;
        this.lastname = null;
        this.birthdate = null;
        this.deathdate = null;
        this.gender = null;
        this.nationalRegisterNumber = null;
        this.isCmMember = false;
        this.mNumber = null;
        this.isAcvMember = false;
        this.acvUuid = null;
    }
}
