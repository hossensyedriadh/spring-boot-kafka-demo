package io.github.hossensyedriadh.kafkaproducer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public final class Country implements Serializable {
    @Serial
    private static final long serialVersionUID = -5927377157696585085L;

    private String country;

    private String countryCode;

    private String capital;

    private String currency;
}
