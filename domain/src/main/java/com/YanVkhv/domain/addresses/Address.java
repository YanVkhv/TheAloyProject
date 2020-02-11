package com.YanVkhv.domain.addresses;

import com.YanVkhv.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Builder
@Entity
@Table(name = "ADDRESS")
public class Address extends BaseEntity {

    @Column(name = "STREET")
    private final String street;

    @Column(name = "STREET_NIS")
    private final String streetNis;

    @Column(name = "HOUSE_NUMBER")
    private final String houseNumber;

    @Column(name = "HOUSE_INDEX")
    private final String houseIndex;

    @Column(name = "POSTAL_CODE")
    private final String postalCode;

    @Column(name = "LOCALITY")
    private final String locality;

    @Column(name = "LOCALITY_NIS")
    private final String localityNis;

    @Column(name = "ADDRESS_TYPE_ID")
    private final String addressTypeId;

    @Column(name = "SUBSCRIBER_ID")
    private final UUID subscriberId;

    @Column(name = "SUMO_STATUS")
    private final String sumoStatus;

    protected Address() {
        street = null;
        streetNis = null;
        houseNumber = null;
        houseIndex = null;
        postalCode = null;
        locality = null;
        localityNis = null;
        addressTypeId = null;
        subscriberId = null;
        sumoStatus = null;
    }

}
