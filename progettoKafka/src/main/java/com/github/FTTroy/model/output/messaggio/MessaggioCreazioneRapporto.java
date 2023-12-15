package com.github.FTTroy.model.output.messaggio;

import com.github.FTTroy.model.output.CreazioneRapportoValue;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class MessaggioCreazioneRapporto implements Serializable {
    private CreazioneRapportoValue value;
}
