package com.cka.app.config.security.impl;

import com.cka.app.config.security.interfaces.ClientAuthorizationINT;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientAuthorization {
    private String accessTokenUri;
    private String tokenServiceId;
    private String clientId;
    private String clientSecret;

    public ClientAuthorization() {
        this.accessTokenUri = ClientAuthorizationINT.accessTokenUri;
        this.tokenServiceId = ClientAuthorizationINT.tokenServiceId;
        this.clientId = ClientAuthorizationINT.clientId;
        this.clientSecret = ClientAuthorizationINT.clientSecret;
    }
}
