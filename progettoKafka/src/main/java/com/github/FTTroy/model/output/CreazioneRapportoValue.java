package com.github.FTTroy.model.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class CreazioneRapportoValue {

    @NonNull
    public Testata testata;

    @NonNull
    public ChiaveRapporto chiaveRapporto;

    @NonNull
    public Intestatario intestatario;

    @NonNull
    @JsonProperty("saldo_contabile")
    private String saldoContabile;

    @NonNull
    private String durata;

    @NonNull
    @JsonProperty("data_inizio_vincolo")
    private String dataInizioVincolo;

    @NonNull
    @JsonProperty("data_fine_vincolo")
    private String dataFineVincolo;

    @NonNull
    @JsonProperty("codice_titolo")
    private String codiceTitolo;
}
