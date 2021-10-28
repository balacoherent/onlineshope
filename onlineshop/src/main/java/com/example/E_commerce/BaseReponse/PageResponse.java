package com.example.E_commerce.BaseReponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageResponse<T>{
    Integer recordCount;T response;

}
