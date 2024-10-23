package com.cka.app.web.rest.vm;

import com.cka.app.service.dto.AdminUserDTO;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * View Model extending the AdminUserDTO, which is meant to be used in the user management UI.
 */
@Getter
@Setter
public class ManagedUserVM extends AdminUserDTO {

    public static final int PASSWORD_MIN_LENGTH = 4;

    public static final int PASSWORD_MAX_LENGTH = 100;

    @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH)
    private String password;

    public ManagedUserVM() {
        // Empty constructor needed for Jackson.
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ManagedUserVM{" + super.toString() + "} ";
    }
}