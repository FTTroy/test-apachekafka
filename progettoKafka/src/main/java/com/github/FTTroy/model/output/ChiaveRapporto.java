package com.github.FTTroy.model.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ChiaveRapporto {
    @NonNull
    private String abi;

    @NonNull
    private String servizio;

    @NonNull
    private String categoria;

    @NonNull
    private String filiale;

    @NonNull
    @JsonProperty("codice_rapporto")
    private String codiceRapporto;

    @JsonProperty("codice_sottorapporto")
    private String codiceSottorapporto;
}
