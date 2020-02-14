package com.YanVkhv.domain.addresses;

import com.YanVkhv.domain.BaseEntity;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "ADDRESS")
public class Address extends BaseEntity {

    @Column(name = "SUBSCRIBER_ID")
    private final Long subscriberId;

    @Column(name = "STREET")
    private final String street;

    @Column(name = "HOUSE_NUMBER")
    private final String houseNumber;

    @Column(name = "HOUSE_INDEX")
    private final String houseIndex;

    @Column(name = "HOUSE_BOX")
    private final String houseBox;

    @Column(name = "POSTAL_CODE")
    private final String postalCode;

    @Column(name = "LOCALITY")
    private final String locality;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "ADDRESS_TYPE")
    private final AddressType addressType;

    protected Address() {
        subscriberId = null;
        street = null;
        houseNumber = null;
        houseIndex = null;
        houseBox = null;
        postalCode = null;
        locality = null;
        addressType = null;
    }

}
