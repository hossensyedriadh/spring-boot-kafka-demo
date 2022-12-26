package io.github.hossensyedriadh.kafkaconsumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public final class Country implements Serializable {
    @Serial
    private static final long serialVersionUID = 8456823332720516492L;

    private String country;

    private String countryCode;

    private String capital;

    private String currency;
}
