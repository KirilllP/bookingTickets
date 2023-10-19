package com.booking.app.controller.dto;

import com.github.ankurpathak.password.bean.constraints.ContainDigit;
import com.github.ankurpathak.password.bean.constraints.ContainSpecial;
import com.github.ankurpathak.password.bean.constraints.NotContainWhitespace;
import com.github.ankurpathak.password.bean.constraints.PasswordMatches;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@PasswordMatches
public class PasswordDTO {
    @Size(min = 8, max = 30)
    @NotContainWhitespace
    @ContainSpecial
    @ContainDigit
    private String password;
    @NotBlank
    private String confirmPassword;
}
