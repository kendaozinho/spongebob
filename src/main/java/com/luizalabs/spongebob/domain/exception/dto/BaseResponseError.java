package com.luizalabs.spongebob.domain.exception.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BaseResponseError {
    private Integer code;
    private String message;
    private String details;
}
