package com.YanVkhv.domain.addresses;

import com.YanVkhv.domain.subscribers.Subscriber;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@EqualsAndHashCode
@Setter
@Getter
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
    private String houseIndex = "";

    @Column(name = "HOUSE_BOX")
    private String houseBox = "";

    @Column(name = "POSTAL_CODE", nullable = false)
    private String postalCode;

    @Column(name = "LOCALITY", nullable = false)
    private String locality;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "address", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Subscriber> subscribers = new ArrayList<>();

    @Override
    public String toString() {
        return String.format("%s %s %s %s, %s %s", street, houseNumber, houseIndex, houseBox, postalCode, locality);
    }
}
