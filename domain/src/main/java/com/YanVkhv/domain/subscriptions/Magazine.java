package com.YanVkhv.domain.subscriptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Magazine {
    VISIE("Visie"),
    LEEF("Leef"),
    EN_MARCHE("En Marche");

    private final String label;
}
