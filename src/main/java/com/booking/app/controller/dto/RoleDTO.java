package com.booking.app.controller.dto;

import com.booking.app.enums.EnumRole;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Valid
public class RoleDTO {
    private int id;
    @NotNull
    private EnumRole role;

}
