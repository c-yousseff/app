package com.cka.app.config.security.impl;

import com.cka.app.config.security.interfaces.RememberMeINT;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RememberMe {
    private @NotNull String key;
    public RememberMe() {
        this.key = RememberMeINT.key;
    }
}
