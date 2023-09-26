package com.booking.app.controllers.dto;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ResponseDTO <T> {

    private final T data;


}
