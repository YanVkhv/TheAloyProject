package com.YanVkhv.domain.subscribers;

import com.YanVkhv.domain.genders.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SUBSCRIBER")
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "SUBSCRIPTION_ID")
    private Long subscriptionId;

    @Column(name = "ADDRESS_ID", nullable = false)
    private Long addressId;

    @Column(name = "FIRSTNAME", nullable = false)
    private String firstname;

    @Column(name = "LASTNAME", nullable = false)
    private String lastname;

    @Column(name = "BIRTHDATE", nullable = false)
    private LocalDate birthdate;

    @Column(name = "DEATHDATE")
    private LocalDate deathdate = null;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENDER", nullable = false)
    private Gender gender;

    @Column(name = "NATIONAL_REGISTER_NUMBER", nullable = false)
    private String nationalRegisterNumber;

    @Column(name = "CM_MEMBER_IND")
    private boolean isCmMember = false;

    @Column(name = "M_NUMBER")
    private String mNumber = null;

    @Column(name = "ACV_MEMBER_IND")
    private boolean isAcvMember = false;

    @Column(name = "ACV_UUID")
    private String acvUuid = null;

}
