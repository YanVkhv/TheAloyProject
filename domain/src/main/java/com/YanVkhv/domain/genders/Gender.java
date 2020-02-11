package com.YanVkhv.domain.genders;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
    MALE(1),
    FEMALE(2);

    private final int genderCode;

}
