package com.YanVkhv.domain.others;

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
@Table(name = "OTHER")
public class Other {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "SUBSCRIPTION_ID", nullable = false)
    private Long subscriptionId;

    @Column(name = "FIRSTNAME")
    private String firstname = null;

    @Column(name = "NAME", nullable = false)
    private String name;

}
