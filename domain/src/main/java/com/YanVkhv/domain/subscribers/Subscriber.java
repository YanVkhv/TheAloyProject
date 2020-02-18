package com.YanVkhv.domain.subscribers;

import com.YanVkhv.domain.addresses.Address;
import com.YanVkhv.domain.genders.Gender;
import com.YanVkhv.domain.subscriptions.Subscription;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID", nullable = false)
    private Address address;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "subscriber", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Subscription> subscriptions = new ArrayList<>();

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
