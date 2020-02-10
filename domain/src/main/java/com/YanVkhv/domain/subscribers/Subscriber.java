package com.YanVkhv.domain.subscribers;

import com.YanVkhv.domain.BaseEntity;
import com.YanVkhv.domain.addresses.Address;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Builder
@Getter
@Entity
@Table(name = "SUBSCRIBER")
public class Subscriber extends BaseEntity {

    @Column(name = "FIRSTNAME")
    private final String firstname;

    @Column(name = "LASTNAME")
    private final String lastname;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "streetName", column = @Column(name = "ADDRESS_STREET_NAME")),
            @AttributeOverride(name = "houseNumber", column = @Column(name = "ADDRESS_HOUSE_NUMBER")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "ADDRESS_POSTAL_CODE")),
            @AttributeOverride(name = "country", column = @Column(name = "ADDRESS_COUNTRY"))
    })
    private final Address address;

    protected Subscriber() {
        this.firstname = null;
        this.lastname = null;
        this.address = null;
    }
}
