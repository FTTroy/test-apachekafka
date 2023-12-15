package com.github.FTTroy.model.output;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class EstinzioneRapportoValue {

    @NonNull
    public Testata testata;

    @NonNull
    public ChiaveRapporto chiaveRapporto;
}
