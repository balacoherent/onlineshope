package com.example.E_commerce.BaseReponse;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {

    @Builder.Default
    private int statusCode = 200;

    @Builder.Default
    private String statusMessage = "success";

    private T data;

}
