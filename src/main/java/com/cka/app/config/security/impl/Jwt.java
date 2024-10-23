package com.cka.app.config.security.impl;

import com.cka.app.config.security.interfaces.JwtINT;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Jwt {
    private String secret;
    private String base64Secret;
    private long tokenValidityInSeconds;
    private long tokenValidityInSecondsForRememberMe;

    public Jwt() {
        this.secret = JwtINT.secret;
        this.base64Secret = JwtINT.base64Secret;
        this.tokenValidityInSeconds = JwtINT.tokenValidityInSeconds;
        this.tokenValidityInSecondsForRememberMe = JwtINT.tokenValidityInSecondsForRememberMe;
    }
}
