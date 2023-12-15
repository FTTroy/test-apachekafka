package com.github.FTTroy.model.input;

import lombok.Data;

import java.io.Serializable;

@Data
public class InputMessage implements Serializable{
    private Before before;
    private After after;
}
