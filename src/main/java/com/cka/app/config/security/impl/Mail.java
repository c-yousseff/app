package com.cka.app.config.security.impl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mail {
    private boolean enabled = false;
    private String from = "";
    private String baseUrl = "";
}
