package com.YanVkhv.domain.institutions;

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
@Table(name = "INSTITUTION")
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "SUBSCRIPTION_ID", nullable = false)
    private Long subscriptionId;

    @Column(name = "NAME", nullable = false)
    private String name;

}
