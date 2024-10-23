package com.cka.app.web.rest.vm;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * View Model object for storing a user's credentials.
 */
@Setter
@Getter
@ToString
public class LoginVM {

    @NotNull
    @Size(min = 1, max = 50)
    private String username;

    @NotNull
    @Size(min = 4, max = 100)
    private String password;

    private boolean rememberMe;
}
