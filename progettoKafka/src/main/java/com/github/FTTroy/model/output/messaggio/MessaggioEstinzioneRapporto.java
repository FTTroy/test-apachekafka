package com.github.FTTroy.model.output.messaggio;

import com.github.FTTroy.model.output.EstinzioneRapportoValue;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class MessaggioEstinzioneRapporto implements Serializable {
    private EstinzioneRapportoValue value;
}
