package io.github.hossensyedriadh.reactivekafkaproducer.model;

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
    private static final long serialVersionUID = 2591443643059181185L;

    private String country;

    private String countryCode;

    private String capital;

    private String currency;
}
