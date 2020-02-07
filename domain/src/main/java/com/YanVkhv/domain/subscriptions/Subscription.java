package com.YanVkhv.domain.subscriptions;

import com.YanVkhv.domain.BaseEntity;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Builder
@NoArgsConstructor
@Entity
@Table(name = "SUBSCRIPTION")
public class Subscription extends BaseEntity {
}
