package io.github.hossensyedriadh.reactivekafkaconsumer.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public final class Country implements Serializable {
    @Serial
    private static final long serialVersionUID = -5419364034388087276L;

    private String country;

    private String countryCode;

    private String capital;

    private String currency;
}
