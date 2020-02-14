package com.YanVkhv.domain.institutions;

import com.YanVkhv.domain.BaseEntity;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "INSTITUTION")
public class Institution extends BaseEntity {

    @Column(name = "SUBSCRIPTION_ID")
    private final Long subscriptionId;

    @Column(name = "NAME")
    private final String name;

    protected Institution() {
        this.subscriptionId = null;
        this.name = null;
    }
}
