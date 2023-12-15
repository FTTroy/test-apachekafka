package com.github.FTTroy.model.output;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.sql.Timestamp;

@Data
@Builder
public class Testata {

    @NonNull
    private String timestamp;

    @NonNull
    private String origine;

    @NonNull
    @JsonProperty("id_evento")
    private String idEvento;

    @NonNull
    @JsonProperty("tipo_evento")
    private String tipoEvento;

    @NonNull
    @JsonProperty("id_correlazione")
    private String idCorrelazione;
}
