package com.YanVkhv.domain.others;

import com.YanVkhv.domain.BaseEntity;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "OTHER")
public class Other extends BaseEntity {

    @Column(name = "SUBSCRIPTION_ID")
    private final Long subscriptionId;

    @Column(name = "FIRSTNAME")
    private final String firstname;

    @Column(name = "LASTNAME")
    private final String lastname;

    protected Other() {
        this.subscriptionId = null;
        this.firstname = null;
        this.lastname = null;
    }
}
