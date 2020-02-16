package com.YanVkhv.domain.addresses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "STREET", nullable = false)
    private String street;

    @Column(name = "HOUSE_NUMBER", nullable = false)
    private String houseNumber;

    @Column(name = "HOUSE_INDEX")
    private String houseIndex = null;

    @Column(name = "HOUSE_BOX")
    private String houseBox = null;

    @Column(name = "POSTAL_CODE", nullable = false)
    private String postalCode;

    @Column(name = "LOCALITY", nullable = false)
    private String locality;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "ADDRESS_TYPE", nullable = false)
    private AddressType addressType;

}
