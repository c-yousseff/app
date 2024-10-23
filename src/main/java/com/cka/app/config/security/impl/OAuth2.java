package com.cka.app.config.security.impl;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class OAuth2 {
    @NotNull
    private List<String> audience = new ArrayList<>();
}
