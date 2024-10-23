package com.cka.app.config.security.interfaces;

public interface JwtINT {
    String secret = null;
    String base64Secret = null;
    long tokenValidityInSeconds = 1800L;
    long tokenValidityInSecondsForRememberMe = 2592000L;
}
