package com.YanVkhv.domain.subscribers;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SubscriberType {
    DEFAULT(0),
    INSTITUTION(1),
    OTHER(2);

    private final int subscriberTypeCode;
}
