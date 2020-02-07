package com.YanVkhv.domain.subscribers;

import com.YanVkhv.domain.BaseEntity;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Builder
@NoArgsConstructor
@Entity
@Table(name = "SUBSCRIBER")
public class Subscriber extends BaseEntity {
}
