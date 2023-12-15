package com.github.FTTroy.model.output;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class Intestatario {

    @NonNull
    private String abi;

    @NonNull
    private String ndg;
}
