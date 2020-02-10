package com.YanVkhv.domain.addresses;

import com.YanVkhv.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Builder
@Embeddable
@Entity
@Table(name = "ADDRESS")
public class Address extends BaseEntity {

    private final String streetName;
    private final String houseNumber;
    private final String postalCode;
    private final String country;

    protected Address() {
        streetName = null;
        houseNumber = null;
        postalCode = null;
        country = null;
    }

    @Override
    public String toString() {
        return "Address{" + "streetName='" + streetName + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
