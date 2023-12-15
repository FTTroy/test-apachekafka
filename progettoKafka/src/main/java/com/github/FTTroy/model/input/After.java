package com.github.FTTroy.model.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class After {
    @JsonProperty("Value")
    Map<String, Map<String, Object>> value;
}

