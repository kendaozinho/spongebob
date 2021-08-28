package com.luizalabs.spongebob.exception.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class BaseResponseError {
    private Integer code;
    private String message;
    private String details;
}
